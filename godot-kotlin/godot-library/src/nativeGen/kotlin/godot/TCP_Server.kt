// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot

import godot.core.GodotError
import godot.icalls._icall_Boolean
import godot.icalls._icall_Long_Long_String
import godot.icalls._icall_StreamPeerTCP
import godot.icalls._icall_Unit
import godot.internal.utils.getMethodBind
import godot.internal.utils.invokeConstructor
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.cinterop.COpaquePointer

open class TCP_Server : Reference() {
  override fun __new(): COpaquePointer = invokeConstructor("TCP_Server", "TCP_Server")

  open fun isConnectionAvailable(): Boolean {
    val mb = getMethodBind("TCP_Server","is_connection_available")
    return _icall_Boolean( mb, this.ptr)
  }

  open fun isListening(): Boolean {
    val mb = getMethodBind("TCP_Server","is_listening")
    return _icall_Boolean( mb, this.ptr)
  }

  open fun listen(port: Long, bindAddress: String = "*"): GodotError {
    val mb = getMethodBind("TCP_Server","listen")
    return GodotError.byValue( _icall_Long_Long_String( mb, this.ptr, port, bindAddress).toUInt())
  }

  open fun stop() {
    val mb = getMethodBind("TCP_Server","stop")
    _icall_Unit( mb, this.ptr)
  }

  open fun takeConnection(): StreamPeerTCP {
    val mb = getMethodBind("TCP_Server","take_connection")
    return _icall_StreamPeerTCP( mb, this.ptr)
  }
}
