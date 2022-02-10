package live

actual interface Live<out S> {

    companion object {
        @JvmStatic
        fun <S> of(value: S): Live<S> = MutableLiveImpl(value)
    }

    actual val value: S

    @JvmSynthetic
    actual fun watch(mode: WatchMode, callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    fun watch(mode: WatchMode, callback: Callback<@UnsafeVariance S>): Watcher<@UnsafeVariance S>

    fun watch(callback: Callback<@UnsafeVariance S>): Watcher<@UnsafeVariance S> = watch(WatchMode.DEFAULT, callback)

    actual fun stopAll()
}