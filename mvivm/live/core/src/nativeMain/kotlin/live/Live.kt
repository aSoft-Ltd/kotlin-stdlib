package live

actual interface Live<out S> {
    actual companion object {
        actual operator fun <S> invoke(value: S): Live<S> = MutableLive(value)
    }

    actual fun getValue(): S
    actual fun peek(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>
    actual fun watch(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>
    actual fun stopAll()
}