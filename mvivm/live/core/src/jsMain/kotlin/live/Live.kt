@file:JsExport

package live

actual class Live<S> actual constructor(state: S) {
    actual var value: S = state
        set(value) {
            field = value
            for (watcher in watchers) watcher.callable(value)
        }

    private val watchers = mutableListOf<Watcher<S>>()

    @JsName("watchImmediateFirstValue")
    actual fun watch(ignoreImmediateValue: Boolean, callable: (state: S) -> Unit): Watcher<S> = watch(ignoreImmediateValue, watchers, callable)

    fun watch(callable: (state: S) -> Unit): Watcher<S> = watch(ignoreImmediateValue = false, watchers, callable)

    actual fun stop(watcher: Watcher<S>) = watchers.remove(watcher)

    actual fun stopAll() = watchers.clear()
}