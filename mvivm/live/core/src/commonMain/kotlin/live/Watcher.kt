@file:JsExport

package live

import kotlin.js.JsExport
import kotlin.jvm.JvmSynthetic

class Watcher<in L> internal constructor(
    @JvmSynthetic
    internal val callable: (L) -> Unit,
    private val container: MutableList<Watcher<L>>
) {
    fun stop() = container.remove(this)
}