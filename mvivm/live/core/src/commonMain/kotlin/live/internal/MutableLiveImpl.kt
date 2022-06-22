package live.internal

import koncurrent.Executor
import koncurrent.Executors
import live.*

internal class MutableLiveImpl<S>(state: S) : AbstractLive<S>(), MutableLive<S> {
    override var value: S = state
        set(value) {
            field = value
            for (watcher in watchers) watcher.execute(value)
        }

    private val watchers = mutableListOf<WatcherImpl<S>>()

    override fun stopAll() = watchers.clear()

    override fun watch(callback: (state: S) -> Unit, mode: WatchMode?, executor: Executor?): Watcher {
        val m = mode ?: WatchMode.Default
        val e = executor ?: SynchronousExecutor.Default
        val watcher = WatcherImpl(watchers, e, callback)
        watchers.add(watcher)
        if (m == WatchMode.Eagerly) watcher.execute(value)
        return watcher
    }
}