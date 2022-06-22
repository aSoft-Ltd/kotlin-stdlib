package live.internal

import koncurrent.Executor
import live.Watcher
import kotlin.js.JsExport
import kotlin.jvm.JvmSynthetic

internal class WatcherImpl<in L> internal constructor(
    private val container: MutableList<WatcherImpl<L>>,
    private val executor: Executor,
    private val callable: (L) -> Unit
) : Watcher {
    fun execute(value: L) = executor.execute { callable(value) }
    override fun stop() {
        container.remove(this)
    }
}