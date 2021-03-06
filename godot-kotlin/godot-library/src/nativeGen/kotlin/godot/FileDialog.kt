// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot

import godot.FileDialog
import godot.core.PoolStringArray
import godot.core.Signal1
import godot.core.signal
import godot.icalls._icall_Boolean
import godot.icalls._icall_LineEdit
import godot.icalls._icall_Long
import godot.icalls._icall_PoolStringArray
import godot.icalls._icall_String
import godot.icalls._icall_Unit
import godot.icalls._icall_Unit_Boolean
import godot.icalls._icall_Unit_Long
import godot.icalls._icall_Unit_PoolStringArray
import godot.icalls._icall_Unit_String
import godot.icalls._icall_VBoxContainer
import godot.internal.utils.getMethodBind
import godot.internal.utils.invokeConstructor
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.cinterop.COpaquePointer

open class FileDialog : ConfirmationDialog() {
  val dirSelected: Signal1<String> by signal("dir")

  val fileSelected: Signal1<String> by signal("path")

  val filesSelected: Signal1<PoolStringArray> by signal("paths")

  open var access: Long
    get() {
      val mb = getMethodBind("FileDialog","get_access")
      return _icall_Long(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_access")
      _icall_Unit_Long(mb, this.ptr, value)
    }

  open var currentDir: String
    get() {
      val mb = getMethodBind("FileDialog","get_current_dir")
      return _icall_String(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_current_dir")
      _icall_Unit_String(mb, this.ptr, value)
    }

  open var currentFile: String
    get() {
      val mb = getMethodBind("FileDialog","get_current_file")
      return _icall_String(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_current_file")
      _icall_Unit_String(mb, this.ptr, value)
    }

  open var currentPath: String
    get() {
      val mb = getMethodBind("FileDialog","get_current_path")
      return _icall_String(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_current_path")
      _icall_Unit_String(mb, this.ptr, value)
    }

  open var filters: PoolStringArray
    get() {
      val mb = getMethodBind("FileDialog","get_filters")
      return _icall_PoolStringArray(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_filters")
      _icall_Unit_PoolStringArray(mb, this.ptr, value)
    }

  open var mode: Long
    get() {
      val mb = getMethodBind("FileDialog","get_mode")
      return _icall_Long(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_mode")
      _icall_Unit_Long(mb, this.ptr, value)
    }

  open var modeOverridesTitle: Boolean
    get() {
      val mb = getMethodBind("FileDialog","is_mode_overriding_title")
      return _icall_Boolean(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_mode_overrides_title")
      _icall_Unit_Boolean(mb, this.ptr, value)
    }

  open var showHiddenFiles: Boolean
    get() {
      val mb = getMethodBind("FileDialog","is_showing_hidden_files")
      return _icall_Boolean(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("FileDialog","set_show_hidden_files")
      _icall_Unit_Boolean(mb, this.ptr, value)
    }

  override fun __new(): COpaquePointer = invokeConstructor("FileDialog", "FileDialog")

  open fun _actionPressed() {
  }

  open fun _cancelPressed() {
  }

  open fun _dirEntered(arg0: String) {
  }

  open fun _fileEntered(arg0: String) {
  }

  open fun _filterSelected(arg0: Long) {
  }

  open fun _goUp() {
  }

  open fun _makeDir() {
  }

  open fun _makeDirConfirm() {
  }

  open fun _saveConfirmPressed() {
  }

  open fun _selectDrive(arg0: Long) {
  }

  open fun _treeItemActivated() {
  }

  open fun _treeMultiSelected(
    arg0: Object,
    arg1: Long,
    arg2: Boolean
  ) {
  }

  open fun _treeSelected() {
  }

  override fun _unhandledInput(arg0: InputEvent) {
  }

  open fun _updateDir() {
  }

  open fun _updateFileList() {
  }

  open fun _updateFileName() {
  }

  open fun addFilter(filter: String) {
    val mb = getMethodBind("FileDialog","add_filter")
    _icall_Unit_String( mb, this.ptr, filter)
  }

  open fun clearFilters() {
    val mb = getMethodBind("FileDialog","clear_filters")
    _icall_Unit( mb, this.ptr)
  }

  open fun deselectItems() {
    val mb = getMethodBind("FileDialog","deselect_items")
    _icall_Unit( mb, this.ptr)
  }

  open fun getAccess(): FileDialog.Access {
    val mb = getMethodBind("FileDialog","get_access")
    return FileDialog.Access.from( _icall_Long( mb, this.ptr))
  }

  open fun getCurrentDir(): String {
    val mb = getMethodBind("FileDialog","get_current_dir")
    return _icall_String( mb, this.ptr)
  }

  open fun getCurrentFile(): String {
    val mb = getMethodBind("FileDialog","get_current_file")
    return _icall_String( mb, this.ptr)
  }

  open fun getCurrentPath(): String {
    val mb = getMethodBind("FileDialog","get_current_path")
    return _icall_String( mb, this.ptr)
  }

  open fun getFilters(): PoolStringArray {
    val mb = getMethodBind("FileDialog","get_filters")
    return _icall_PoolStringArray( mb, this.ptr)
  }

  open fun getLineEdit(): LineEdit {
    val mb = getMethodBind("FileDialog","get_line_edit")
    return _icall_LineEdit( mb, this.ptr)
  }

  open fun getMode(): FileDialog.Mode {
    val mb = getMethodBind("FileDialog","get_mode")
    return FileDialog.Mode.from( _icall_Long( mb, this.ptr))
  }

  open fun getVbox(): VBoxContainer {
    val mb = getMethodBind("FileDialog","get_vbox")
    return _icall_VBoxContainer( mb, this.ptr)
  }

  open fun invalidate() {
    val mb = getMethodBind("FileDialog","invalidate")
    _icall_Unit( mb, this.ptr)
  }

  open fun isModeOverridingTitle(): Boolean {
    val mb = getMethodBind("FileDialog","is_mode_overriding_title")
    return _icall_Boolean( mb, this.ptr)
  }

  open fun isShowingHiddenFiles(): Boolean {
    val mb = getMethodBind("FileDialog","is_showing_hidden_files")
    return _icall_Boolean( mb, this.ptr)
  }

  open fun setAccess(access: Long) {
    val mb = getMethodBind("FileDialog","set_access")
    _icall_Unit_Long( mb, this.ptr, access)
  }

  open fun setCurrentDir(dir: String) {
    val mb = getMethodBind("FileDialog","set_current_dir")
    _icall_Unit_String( mb, this.ptr, dir)
  }

  open fun setCurrentFile(file: String) {
    val mb = getMethodBind("FileDialog","set_current_file")
    _icall_Unit_String( mb, this.ptr, file)
  }

  open fun setCurrentPath(path: String) {
    val mb = getMethodBind("FileDialog","set_current_path")
    _icall_Unit_String( mb, this.ptr, path)
  }

  open fun setFilters(filters: PoolStringArray) {
    val mb = getMethodBind("FileDialog","set_filters")
    _icall_Unit_PoolStringArray( mb, this.ptr, filters)
  }

  open fun setMode(mode: Long) {
    val mb = getMethodBind("FileDialog","set_mode")
    _icall_Unit_Long( mb, this.ptr, mode)
  }

  open fun setModeOverridesTitle(override: Boolean) {
    val mb = getMethodBind("FileDialog","set_mode_overrides_title")
    _icall_Unit_Boolean( mb, this.ptr, override)
  }

  open fun setShowHiddenFiles(show: Boolean) {
    val mb = getMethodBind("FileDialog","set_show_hidden_files")
    _icall_Unit_Boolean( mb, this.ptr, show)
  }

  enum class Mode(
    id: Long
  ) {
    MODE_OPEN_FILE(0),

    MODE_OPEN_FILES(1),

    MODE_OPEN_DIR(2),

    MODE_OPEN_ANY(3),

    MODE_SAVE_FILE(4);

    val id: Long
    init {
      this.id = id
    }

    companion object {
      fun from(value: Long) = values().single { it.id == value }
    }
  }

  enum class Access(
    id: Long
  ) {
    ACCESS_RESOURCES(0),

    ACCESS_USERDATA(1),

    ACCESS_FILESYSTEM(2);

    val id: Long
    init {
      this.id = id
    }

    companion object {
      fun from(value: Long) = values().single { it.id == value }
    }
  }

  companion object
}
