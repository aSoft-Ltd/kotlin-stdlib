package live

actual interface Live<out S> {

    actual companion object {
        @JvmSynthetic
        actual operator fun <S> invoke(value: S): Live<S> = MutableLive(value)

        @JvmStatic
        fun <S> of(value: S) = invoke(value)
    }

    actual fun getValue(): S

    @JvmSynthetic
    actual fun peek(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    fun peek(callback: Callback<@UnsafeVariance S>): Watcher<@UnsafeVariance S>

    @JvmSynthetic
    actual fun watch(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    fun watch(callback: Callback<@UnsafeVariance S>): Watcher<@UnsafeVariance S>

    actual fun stopAll()
}