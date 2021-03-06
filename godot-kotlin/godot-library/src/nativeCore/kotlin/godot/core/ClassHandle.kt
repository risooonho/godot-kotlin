package godot.core

import godot.MultiplayerAPI.RPCMode
import godot.Object
import godot.gdnative.*
import godot.internal.type.nullSafe
import kotlinx.cinterop.*

@PublishedApi
internal class ClassHandle<T : Object>(
    private val nativescriptHandle: COpaquePointer,
    private val className: String,
    private val parentClassName: String,
    private val factory: () -> T,
    private val isTool: Boolean
) {
    private val disposables = mutableListOf<COpaquePointer>()

    fun wrap(instance: COpaquePointer): T {
        return Godot.instantiateWith(instance, factory)
    }

    fun init() {
        memScoped {
            val methodData = StableRef.create(this@ClassHandle).asCPointer()
            // register constructor and destructor
            val create = cValue<godot_instance_create_func> {
                create_func = staticCFunction(::createInstance)
                free_func = staticCFunction(::disposeClassHandle)
                method_data = methodData
            }
            val destroy = cValue<godot_instance_destroy_func> {
                destroy_func = staticCFunction(::destroyInstance)
                method_data = methodData
            }
            val registerMethod = if (isTool) {
                Godot.nativescript.godot_nativescript_register_tool_class
            } else {
                Godot.nativescript.godot_nativescript_register_class
            }
            nullSafe(registerMethod)(
                nativescriptHandle,
                className.cstr.ptr,
                parentClassName.cstr.ptr,
                create,
                destroy
            )
        }
    }

    fun registerFunction(methodName: String, methodRef: COpaquePointer, rpcMode: RPCMode) {
        disposables.add(methodRef)
        memScoped {
            val attribs = cValue<godot_method_attributes> {
                rpc_type = toGodotRpcMode(rpcMode)
            }

            val instanceMethod = cValue<godot_instance_method> {
                method_data = methodRef
                this.method = staticCFunction(::invokeMethod)
            }

            nullSafe(Godot.nativescript.godot_nativescript_register_method)(
                nativescriptHandle,
                className.cstr.ptr,
                methodName.camelToSnakeCase().cstr.ptr, //not using `camelcaseToUnderscore` to prevent a call to godot for each function
                attribs,
                instanceMethod
            )
        }
    }

    private fun toGodotRpcMode(rpcMode: RPCMode): godot_method_rpc_mode {
        return when (rpcMode) {
            RPCMode.DISABLED -> GODOT_METHOD_RPC_MODE_DISABLED
            RPCMode.REMOTE -> GODOT_METHOD_RPC_MODE_REMOTE
            RPCMode.MASTER -> GODOT_METHOD_RPC_MODE_MASTER
            RPCMode.PUPPET -> GODOT_METHOD_RPC_MODE_PUPPET
            RPCMode.REMOTESYNC -> GODOT_METHOD_RPC_MODE_REMOTESYNC
            RPCMode.MASTERSYNC -> GODOT_METHOD_RPC_MODE_MASTERSYNC
            RPCMode.PUPPETSYNC -> GODOT_METHOD_RPC_MODE_PUPPETSYNC
            RPCMode.SLAVE -> throw IllegalArgumentException("RPCMode.SLAVE is deprecated in godot! Use RPCMode.PUPPET instead")
            RPCMode.SYNC -> throw IllegalArgumentException("RPCMode.SYNC is deprecated in godot! Use one of the other sync enums instead")
        }
    }

    @ExperimentalUnsignedTypes
    fun registerSignal(signalName: String, parameters: Map<String, Variant.Type>) {
        memScoped {
            val gdSignal = alloc<godot_signal> {
                val argInfos = allocArray<godot_signal_argument>(parameters.size)
                parameters.keys.forEachIndexed { index, key ->
                    val argInfo = argInfos[index]
                    val value = parameters.getValue(key)
                    // argument name
                    nullSafe(Godot.gdnative.godot_string_parse_utf8)(argInfo.name.ptr, key.cstr.ptr)
                    // argument type
                    argInfo.type = value.value.toInt()
                }
                args = argInfos.getPointer(this@memScoped)
                nullSafe(Godot.gdnative.godot_string_parse_utf8)(name.ptr, signalName.removePrefix("signal").decapitalize().camelToSnakeCase().cstr.ptr) //not using `camelcaseToUnderscore` to prevent a call to godot for each signal
                num_args = parameters.size
            }
            nullSafe(Godot.nativescript.godot_nativescript_register_signal)(
                nativescriptHandle,
                className.cstr.ptr,
                gdSignal.ptr
            )
        }
    }

    @ExperimentalUnsignedTypes
    fun registerProperty(
        propertyName: String,
        propertyHandleRef: COpaquePointer,
        propertyType: Variant.Type,
        default: Variant?,
        isVisibleInEditor: Boolean,
        rpcMode: RPCMode,
        hintType: godot_property_hint,
        hintString: String
    ) {
        disposables.add(propertyHandleRef)
        memScoped {
            val usageFlags = if (isVisibleInEditor) {
                GODOT_PROPERTY_USAGE_DEFAULT
            } else {
                GODOT_PROPERTY_USAGE_NOEDITOR
            }
            val attribs = alloc<godot_property_attributes> {
                rset_type = toGodotRpcMode(rpcMode)
                usage = usageFlags
                type = propertyType.value.toInt()
                this.hint = hintType
                nullSafe(Godot.gdnative.godot_string_parse_utf8)(hint_string.ptr, hintString.cstr.ptr)
                if (default != null) {
                    nullSafe(Godot.gdnative.godot_variant_new_copy)(default_value.ptr, default._handle.ptr)
                }
            }

            val getter = cValue<godot_property_get_func> {
                method_data = propertyHandleRef
                get_func = staticCFunction(::getProperty)
            }

            val setter = cValue<godot_property_set_func> {
                method_data = propertyHandleRef
                set_func = staticCFunction(::setProperty)
            }

            nullSafe(Godot.nativescript.godot_nativescript_register_property)(
                nativescriptHandle,
                className.cstr.ptr,
                propertyName.camelToSnakeCase().cstr.ptr, //not using `camelcaseToUnderscore` to prevent a call to godot for each property
                attribs.ptr,
                setter,
                getter
            )
        }
    }

    fun dispose() {
        disposables.forEach { it.asStableRef<Any>().dispose() }
    }
}
