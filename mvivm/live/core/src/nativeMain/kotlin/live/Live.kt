package live

actual interface Live<out S> {
    actual val value: S
    actual fun watch(mode: WatchMode, callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>
    actual fun stopAll()
}