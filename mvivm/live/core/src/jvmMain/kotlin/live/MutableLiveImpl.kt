package live

internal actual class MutableLiveImpl<S> actual constructor(state: S) : MutableLive<S> {
    private var mValue: S = state
        set(value) {
            field = value
            for (watcher in watchers) watcher.callable(value)
        }

    override fun setValue(value: S) {
        mValue = value
    }

    override fun getValue(): S = mValue

    private val watchers = mutableListOf<Watcher<S>>()

    override fun peek(callback: (state: S) -> Unit) = watch(ignoreImmediateValue = true, watchers, callback)

    override fun peek(callback: Callback<S>) = watch(ignoreImmediateValue = true, watchers, callback::execute)

    override fun watch(callback: Callback<S>) = watch(ignoreImmediateValue = true, watchers, callback::execute)

    override fun watch(callback: (state: S) -> Unit) = watch(DEFAULT_WATCH_IGNORE_IMMEDIATE_VALUE, watchers, callback)

    override fun stopAll() = watchers.clear()
}