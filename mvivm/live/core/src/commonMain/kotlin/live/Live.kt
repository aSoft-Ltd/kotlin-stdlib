package live

/**
 * A wrapper around a value that can be watched as it changes
 */
expect interface Live<out S> {

    companion object {
        operator fun <S> invoke(value: S): Live<S>
    }

    /**
     * @return the value of type [S] that is being [watch]ed/[peek]ed [Live]
     */
    fun getValue(): S

    /**
     * Watch upcoming values while ignoring the current one be updated via a [callback] about its change
     *
     * @return a [Watcher]
     */
    fun peek(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    /**
     * Watch the value as it changes and be updated via a [callback]
     *
     * @return a [Watcher]
     */
    fun watch(callback: (state: S) -> Unit): Watcher<@UnsafeVariance S>

    /**
     * Stops all [Watcher]s from watching this [Live] value
     */
    fun stopAll()
}