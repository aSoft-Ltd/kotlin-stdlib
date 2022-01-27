package live

internal actual class MutableLiveImpl<S> actual constructor(state: S) : MutableLive<S> {
    override var value: S = state
        set(value) {
            field = value
            for (watcher in watchers) watcher.callable(value)
        }

    private val watchers = mutableListOf<Watcher<S>>()

    override fun watch(ignoreImmediateValue: Boolean, callable: (state: S) -> Unit): Watcher<*> = watch(ignoreImmediateValue, watchers, callable)

    override fun watch(callable: (state: S) -> Unit): Watcher<*> = watch(DEFAULT_WATCH_IGNORE_IMMEDIATE_VALUE, watchers, callable)

    override fun stopAll() = watchers.clear()
}