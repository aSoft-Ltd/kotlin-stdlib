@file:JsExport
@file:Suppress("WRONG_EXPORTED_DECLARATION")

package live

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic

interface MutableLive<S> : Live<S> {
    fun setValue(value: S)

    companion object {
        @JvmSynthetic
        @JsName("_init_one")
        operator fun <S> invoke(value: S): MutableLive<S> = MutableLiveImpl(value)

        @JvmStatic
        @JsName("_init_two")
        fun <S> of(value: S): MutableLive<S> = MutableLiveImpl(value)
    }
}