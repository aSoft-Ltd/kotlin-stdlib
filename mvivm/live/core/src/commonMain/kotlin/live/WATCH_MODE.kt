@file:JsExport

package live

import kotlin.js.JsExport
import kotlin.jvm.JvmField

object WATCH_MODE {
    
    @JvmField
    val EAGERLY = WatchMode.EAGERLY

    @JvmField
    val CASUALLY = WatchMode.CASUALLY
}