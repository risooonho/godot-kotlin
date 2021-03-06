package godot.entrygenerator.generator.provider

import com.squareup.kotlinpoet.ClassName
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.resolve.BindingContext

class PlaceholderTextRegistrationValuesHandler(
    propertyDescriptor: PropertyDescriptor,
    bindingContext: BindingContext
) : RegistrationValuesHandler(propertyDescriptor, bindingContext) {

    override fun getPropertyTypeHint(): ClassName {
        return ClassName(
            "godot.gdnative.godot_property_hint",
            "GODOT_PROPERTY_HINT_PLACEHOLDER_TEXT"
        )
    }

    override fun getHintString(): String {
        return ""
    }
}
