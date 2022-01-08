@file:JsExport

package live

import kotlin.js.JsExport

class Watcher<T> internal constructor(
    internal val callable: (T) -> Unit, private val container: MutableList<Watcher<T>>
) {
    fun stop() = container.remove(this)
}