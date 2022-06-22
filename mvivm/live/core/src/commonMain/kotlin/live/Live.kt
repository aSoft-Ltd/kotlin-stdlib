@file:Suppress("NON_EXPORTABLE_TYPE")

package live

import functions.Consumer
import koncurrent.Executor
import koncurrent.Executors
import live.WatchMode.Eagerly
import live.WatchMode.Casually
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmSynthetic

/**
 * A wrapper around a [value] that can be watched as it changes
 */
@JsExport
interface Live<out S> {

    val value: S


    /**
     * Watch the value as it changes and be updated via a [consumer]
     *
     * [mode] of how you would like to watch this value. It can be [Eagerly] or [Casually]
     *
     * [executor] tells in
     *
     * @return a [Watcher]
     */
    @JsName("_ignore_java_watch_with_mode_and_executor")
    fun watch(consumer: Consumer<@UnsafeVariance S>, mode: WatchMode, executor: Executor): Watcher

    /**
     * Watch the value as it changes and be updated via a [consumer]
     *
     * [mode] of how you would like to watch this value. It can be [Eagerly] or [Casually]
     *
     * @return a [Watcher]
     */
    @JsName("_ignore_java_watch_with_mode")
    fun watch(consumer: Consumer<@UnsafeVariance S>, mode: WatchMode): Watcher

    /**
     * Watch the value as it changes and be updated via a [consumer]
     *
     * [mode] of how you would like to watch this value. It can be [Eagerly] or [Casually]
     *
     * @return a [Watcher]
     */
    @JsName("_ignore_java_watch_with_executor")
    fun watch(consumer: Consumer<@UnsafeVariance S>, executor: Executor): Watcher

    /**
     * Watch the value as it changes and be updated via a [consumer]
     *
     * [mode] of how you would like to watch this value. It can be [Eagerly] or [Casually]
     *
     * @return a [Watcher]
     */
    @JsName("_ignore_java_watch")
    fun watch(consumer: Consumer<@UnsafeVariance S>): Watcher

    /**
     * Watch the value as it changes and be updated via a [callback]
     *
     * [mode] of how you would like to watch this value. It can be [Eagerly] or [Casually]
     *
     * @return a [Watcher]
     */
    @JvmSynthetic
    fun watch(callback: (state: S) -> Unit, mode: WatchMode?, executor: Executor?): Watcher

    /**
     * Stops all [Watcher]s from watching this [Live] [value]
     */
    fun stopAll()
}