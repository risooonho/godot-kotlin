// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot

import godot.core.Vector2
import godot.icalls._icall_Double
import godot.icalls._icall_Unit_Double
import godot.icalls._icall_Unit_Vector2
import godot.icalls._icall_Vector2
import godot.internal.utils.getMethodBind
import godot.internal.utils.invokeConstructor
import kotlin.Double
import kotlin.Unit
import kotlinx.cinterop.COpaquePointer

open class LineShape2D : Shape2D() {
  open var d: Double
    get() {
      val mb = getMethodBind("LineShape2D","get_d")
      return _icall_Double(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("LineShape2D","set_d")
      _icall_Unit_Double(mb, this.ptr, value)
    }

  open var normal: Vector2
    get() {
      val mb = getMethodBind("LineShape2D","get_normal")
      return _icall_Vector2(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("LineShape2D","set_normal")
      _icall_Unit_Vector2(mb, this.ptr, value)
    }

  override fun __new(): COpaquePointer = invokeConstructor("LineShape2D", "LineShape2D")

  open fun normal(schedule: Vector2.() -> Unit): Vector2 = normal.apply{
      schedule(this)
      normal = this
  }


  open fun getD(): Double {
    val mb = getMethodBind("LineShape2D","get_d")
    return _icall_Double( mb, this.ptr)
  }

  open fun getNormal(): Vector2 {
    val mb = getMethodBind("LineShape2D","get_normal")
    return _icall_Vector2( mb, this.ptr)
  }

  open fun setD(d: Double) {
    val mb = getMethodBind("LineShape2D","set_d")
    _icall_Unit_Double( mb, this.ptr, d)
  }

  open fun setNormal(normal: Vector2) {
    val mb = getMethodBind("LineShape2D","set_normal")
    _icall_Unit_Vector2( mb, this.ptr, normal)
  }
}
