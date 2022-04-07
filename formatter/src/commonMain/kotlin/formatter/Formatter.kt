package formatter

import kotlin.js.JsExport

@JsExport
interface Formatter<T> {
    fun format(o: T): String
}