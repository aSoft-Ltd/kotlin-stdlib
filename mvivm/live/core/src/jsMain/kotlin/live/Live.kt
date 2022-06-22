@file:JsExport
@file:Suppress("WRONG_EXPORTED_DECLARATION")

package live

import kotlin.js.JsExport

actual external interface Live<out S> {

    actual val value: S

    actual fun watch(mode: WatchMode, callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    actual fun stopAll()
}