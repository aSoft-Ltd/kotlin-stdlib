@file:JsExport
@file:Suppress("WRONG_EXPORTED_DECLARATION")

package live

import kotlin.js.JsExport
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic

interface MutableLive<S> : Live<S> {
    override var value: S

    companion object {
        @JvmSynthetic
        operator fun <S> invoke(value: S): MutableLive<S> = MutableLiveImpl(value)

        @JvmStatic
        fun <S> of(value: S): MutableLive<S> = invoke(value)
    }
}