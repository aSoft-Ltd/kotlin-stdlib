@file:JsExport @file:Suppress("WRONG_EXPORTED_DECLARATION")

package live

import kotlin.js.JsExport
import kotlin.jvm.JvmField

/**
 * A Mode on which one can watch a [Live] object
 */
sealed class WatchMode {
    companion object {
        @JvmField
        val CASUALLY = Casually

        @JvmField
        val EAGERLY = Eagerly

        @JvmField
        val DEFAULT: WatchMode = CASUALLY
    }

    // TODO: Go back to Objects/Enums when Js Interoperability is better
    /**
     * A mode of watching a live object without skipping even a single value
     */
    object Eagerly : WatchMode()

// TODO: Go back to Objects/Enums when Js Interoperability is better
    /**
     * A mode of watching a live object skipping the current value that is already available in the live object
     */
    object Casually : WatchMode()
}