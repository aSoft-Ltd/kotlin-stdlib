@file:Suppress("WRONG_EXPORTED_DECLARATION")

package kash

import kash.MoneyFormatterOptions.Companion.DEFAULT_ABBREVIATE
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMALS_ABBREVIATED
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMAL_SEPARATOR
import kash.MoneyFormatterOptions.Companion.DEFAULT_PREFIX
import kash.MoneyFormatterOptions.Companion.DEFAULT_THOUSAND_SEPERATOR
import kotlin.js.JsExport

@JsExport
interface MoneyFormatterRawOptions {
    val abbreviate: Boolean?
    val prefix: String?
    val decimals: Int?
    val decimalSeparator: String?
    val thousandsSeparator: String?
}

fun MoneyFormatterRawOptions.toFormatterOptions() = MoneyFormatterOptions(
    abbreviate = abbreviate ?: DEFAULT_ABBREVIATE,
    prefix = prefix ?: DEFAULT_PREFIX,
    decimals = decimals ?: DEFAULT_DECIMALS_ABBREVIATED,
    decimalSeparator = decimalSeparator ?: DEFAULT_DECIMAL_SEPARATOR,
    thousandsSeparator = thousandsSeparator ?: DEFAULT_THOUSAND_SEPERATOR
)