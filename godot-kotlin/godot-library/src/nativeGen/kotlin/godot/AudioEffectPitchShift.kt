// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot

import godot.AudioEffectPitchShift
import godot.icalls._icall_Double
import godot.icalls._icall_Long
import godot.icalls._icall_Unit_Double
import godot.icalls._icall_Unit_Long
import godot.internal.utils.getMethodBind
import godot.internal.utils.invokeConstructor
import kotlin.Double
import kotlin.Long
import kotlinx.cinterop.COpaquePointer

open class AudioEffectPitchShift : AudioEffect() {
  open var fftSize: Long
    get() {
      val mb = getMethodBind("AudioEffectPitchShift","get_fft_size")
      return _icall_Long(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("AudioEffectPitchShift","set_fft_size")
      _icall_Unit_Long(mb, this.ptr, value)
    }

  open var oversampling: Long
    get() {
      val mb = getMethodBind("AudioEffectPitchShift","get_oversampling")
      return _icall_Long(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("AudioEffectPitchShift","set_oversampling")
      _icall_Unit_Long(mb, this.ptr, value)
    }

  open var pitchScale: Double
    get() {
      val mb = getMethodBind("AudioEffectPitchShift","get_pitch_scale")
      return _icall_Double(mb, this.ptr)
    }
    set(value) {
      val mb = getMethodBind("AudioEffectPitchShift","set_pitch_scale")
      _icall_Unit_Double(mb, this.ptr, value)
    }

  override fun __new(): COpaquePointer = invokeConstructor("AudioEffectPitchShift",
      "AudioEffectPitchShift")

  open fun getFftSize(): AudioEffectPitchShift.FFT_Size {
    val mb = getMethodBind("AudioEffectPitchShift","get_fft_size")
    return AudioEffectPitchShift.FFT_Size.from( _icall_Long( mb, this.ptr))
  }

  open fun getOversampling(): Long {
    val mb = getMethodBind("AudioEffectPitchShift","get_oversampling")
    return _icall_Long( mb, this.ptr)
  }

  open fun getPitchScale(): Double {
    val mb = getMethodBind("AudioEffectPitchShift","get_pitch_scale")
    return _icall_Double( mb, this.ptr)
  }

  open fun setFftSize(size: Long) {
    val mb = getMethodBind("AudioEffectPitchShift","set_fft_size")
    _icall_Unit_Long( mb, this.ptr, size)
  }

  open fun setOversampling(amount: Long) {
    val mb = getMethodBind("AudioEffectPitchShift","set_oversampling")
    _icall_Unit_Long( mb, this.ptr, amount)
  }

  open fun setPitchScale(rate: Double) {
    val mb = getMethodBind("AudioEffectPitchShift","set_pitch_scale")
    _icall_Unit_Double( mb, this.ptr, rate)
  }

  enum class FFT_Size(
    id: Long
  ) {
    FFT_SIZE_256(0),

    FFT_SIZE_512(1),

    FFT_SIZE_1024(2),

    FFT_SIZE_2048(3),

    FFT_SIZE_4096(4),

    FFT_SIZE_MAX(5);

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
