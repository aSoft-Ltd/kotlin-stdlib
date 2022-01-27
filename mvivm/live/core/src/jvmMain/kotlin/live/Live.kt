package live

actual interface Live<out S> {

    actual companion object {
        @JvmSynthetic
        actual operator fun <S> invoke(value: S): Live<S> = MutableLive(value)

        @JvmStatic
        fun <S> of(value: S) = invoke(value)
    }

    actual val value: S

    @JvmSynthetic
    actual fun watch(ignoreImmediateValue: Boolean, callable: (state: S) -> Unit): Watcher<*>

    fun watch(
        ignoreImmediateValue: Boolean,
        callable: Callback<@UnsafeVariance S>
    ): Watcher<*>

    @JvmSynthetic
    actual fun watch(callable: (state: S) -> Unit): Watcher<*>

    fun watch(callable: Callback<@UnsafeVariance S>): Watcher<*>

    actual fun stopAll()
}