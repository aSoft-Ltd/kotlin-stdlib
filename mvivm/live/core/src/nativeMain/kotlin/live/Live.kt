package live

actual interface Live<out S> {
    actual companion object {
        actual operator fun <S> invoke(value: S): Live<S> = MutableLive(value)
    }

    actual val value: S
    actual fun watch(ignoreImmediateValue: Boolean, callable: (state: S) -> Unit): Watcher<*>
    actual fun watch(callable: (state: S) -> Unit): Watcher<*>
    actual fun stopAll()
}