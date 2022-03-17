package kash

import kotlin.jvm.JvmField
import kotlin.math.pow

data class MoneyFormatterOptions(
    override val abbreviate: Boolean = DEFAULT_ABBREVIATE,
    override val prefix: String = DEFAULT_PREFIX,
    override val decimals: Int = DEFAULT_DECIMALS_ABBREVIATED,
    override val decimalSeparator: String = DEFAULT_DECIMAL_SEPARATOR,
    override val thousandsSeparator: String = DEFAULT_THOUSAND_SEPERATOR
) : MoneyFormatterRawOptions {

    val rounder by lazy { 10.0.pow(decimals) }

    companion object {
        @JvmField
        val DEFAULT_ABBREVIATE = true

        @JvmField
        val DEFAULT_PREFIX = PREFIX.CURRENCY_GLOBAL_SYMBOL

        @JvmField
        val DEFAULT_DECIMALS_ABBREVIATED = 1

        @JvmField
        val DEFAULT_DECIMALS_UNABBREVIATED = 2

        @JvmField
        val DEFAULT_DECIMAL_SEPARATOR = "."

        @JvmField
        val DEFAULT_THOUSAND_SEPERATOR = ","
    }
}