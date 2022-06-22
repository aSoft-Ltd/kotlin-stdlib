@file:JsExport

package live

import kotlin.js.JsExport
import kotlin.jvm.JvmField

/**
 * Though shall not remove this object thinking it is a duplicate of WatchMode
 * It might seem unused for now but it is here for the purpose of JS interoperability
 *
 * please be warned
 */
object WATCH_MODE {

    @JvmField
    val EAGERLY = WatchMode.EAGERLY

    @JvmField
    val CASUALLY = WatchMode.CASUALLY
}