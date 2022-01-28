package live

internal actual class MutableLiveImpl<S> actual constructor(state: S) : MutableLive<S> {
    private var value: S = state
        set(value) {
            field = value
            for (watcher in watchers) watcher.callable(value)
        }

    override fun getValue(): S = value
    
    override fun setValue(value: S) {
        this.value = value
    }

    private val watchers = mutableListOf<Watcher<S>>()

    override fun peek(callback: (state: S) -> Unit) = watch(ignoreImmediateValue = true, watchers, callback)

    override fun watch(callback: (state: S) -> Unit) = watch(ignoreImmediateValue = false, watchers, callback)

    override fun stopAll() = watchers.clear()
}