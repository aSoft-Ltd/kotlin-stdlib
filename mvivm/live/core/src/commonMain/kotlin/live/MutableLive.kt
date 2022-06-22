@file:JsExport
@file:Suppress("WRONG_EXPORTED_DECLARATION", "NON_EXPORTABLE_TYPE")

package live

import live.internal.MutableLiveImpl
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic

interface MutableLive<S> : Live<S> {
    override var value: S

    companion object {
        @JvmStatic
        fun <S> of(value: S): MutableLive<S> = MutableLiveImpl(value)
    }
}