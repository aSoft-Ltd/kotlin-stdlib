package live

actual interface Live<out S> {
    actual val value: S
    actual fun peek(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>
    actual fun watch(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>
    actual fun stopAll()
}