@file:JsExport
@file:Suppress("WRONG_EXPORTED_DECLARATION")

package live

import kotlin.js.JsExport

actual interface Live<out S> {
    actual companion object {
        @JsName("_init_")
        actual operator fun <S> invoke(value: S): Live<S> = MutableLive(value)
    }

    actual fun getValue(): S

    actual fun peek(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    actual fun watch(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    actual fun stopAll()
}