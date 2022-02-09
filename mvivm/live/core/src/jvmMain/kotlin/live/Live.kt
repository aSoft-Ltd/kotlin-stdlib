package live

actual interface Live<out S> {

    companion object {
        @JvmStatic
        fun <S> of(value: S): Live<S> = MutableLiveImpl(value)
    }

    actual val value: S

    @JvmSynthetic
    actual fun peek(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    fun peek(callback: Callback<@UnsafeVariance S>): Watcher<@UnsafeVariance S>

    @JvmSynthetic
    actual fun watch(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    fun watch(callback: Callback<@UnsafeVariance S>): Watcher<@UnsafeVariance S>

    actual fun stopAll()
}