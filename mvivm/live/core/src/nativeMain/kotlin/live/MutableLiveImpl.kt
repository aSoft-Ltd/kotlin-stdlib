package live

internal actual class MutableLiveImpl<S> actual constructor(state: S) : MutableLive<S> {
    override var value: S = state
        set(value) {
            field = value
            for (watcher in watchers) watcher.callable(value)
        }

    private val watchers = mutableListOf<Watcher<S>>()

    override fun watch(mode: WatchMode, callback: (state: S) -> Unit) = watch(mode, watchers, callback)

    override fun stopAll() = watchers.clear()
}