package live

/**
 * A wrapper around a [value] that can be watched as it changes
 */
expect interface Live<out S> {

    val value: S

    /**
     * Watch the value as it changes and be updated via a [callback]
     *
     * [mode] of how you would like to watch this value. It can be [EAGERLY] ro [CASUALLY]
     *
     * @return a [Watcher]
     */
    fun watch(mode: WatchMode = WatchMode.DEFAULT, callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    /**
     * Stops all [Watcher]s from watching this [Live] [value]
     */
    fun stopAll()
}