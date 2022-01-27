@file:JsExport
@file:Suppress("WRONG_EXPORTED_DECLARATION")

package live

import kotlin.js.JsExport

actual interface Live<out S> {
    actual companion object {
        actual operator fun <S> invoke(value: S): Live<S> = MutableLive(value)
    }

    actual val value: S

    @JsName("watchIgnoringImmediateValue")
    actual fun watch(ignoreImmediateValue: Boolean, callable: (state: S) -> Unit): Watcher<*>

    actual fun watch(callable: (state: S) -> Unit): Watcher<*>

    actual fun stopAll()
}