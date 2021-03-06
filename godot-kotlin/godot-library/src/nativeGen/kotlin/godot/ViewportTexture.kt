// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot

import godot.core.NodePath
import godot.icalls._icall_NodePath
import godot.icalls._icall_Unit_NodePath
import godot.internal.utils.getMethodBind
import godot.internal.utils.invokeConstructor
import kotlinx.cinterop.COpaquePointer

open class ViewportTexture : Texture() {
  open var viewportPath: NodePath
    get() {
      val mb = getMethodBind("ViewportTexture","get_viewport_path_in_scene")
      return _icall_NodePath(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("ViewportTexture","set_viewport_path_in_scene")
      _icall_Unit_NodePath(mb, this.ptr, value)
    }

  override fun __new(): COpaquePointer = invokeConstructor("ViewportTexture", "ViewportTexture")

  open fun getViewportPathInScene(): NodePath {
    val mb = getMethodBind("ViewportTexture","get_viewport_path_in_scene")
    return _icall_NodePath( mb, this.ptr)
  }

  open fun setViewportPathInScene(path: NodePath) {
    val mb = getMethodBind("ViewportTexture","set_viewport_path_in_scene")
    _icall_Unit_NodePath( mb, this.ptr, path)
  }
}
