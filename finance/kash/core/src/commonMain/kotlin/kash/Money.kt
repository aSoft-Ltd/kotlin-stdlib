@file:JsExport

package kash

import formatter.Formatter
import kash.MoneyFormatterOptions.Companion.DEFAULT_ABBREVIATE
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMALS_ABBREVIATED
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMALS_UNABBREVIATED
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMAL_SEPARATOR
import kash.MoneyFormatterOptions.Companion.DEFAULT_ENFORCE_DECIMALS
import kash.MoneyFormatterOptions.Companion.DEFAULT_POSTFIX
import kash.MoneyFormatterOptions.Companion.DEFAULT_PREFIX
import kash.MoneyFormatterOptions.Companion.DEFAULT_THOUSAND_SEPERATOR
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic

@Serializable
data class Money(
    /** In the lowest denomination */
    val amount: Int,
    @Serializable(with = CurrencySerializer::class)
    val currency: Currency
) {

    companion object {

        @JvmStatic
        @JsName("fromUInt")
        fun of(amount: UInt, currency: Currency) = Money((amount.toDouble() * currency.lowestDenomination).toInt(), currency)


        @JvmStatic
        @JsName("fromULong")
        fun of(amount: ULong, currency: Currency) = Money((amount.toDouble() * currency.lowestDenomination).toInt(), currency)


        @JvmStatic
        @JsName("fromDouble")
        fun of(amount: Double, currency: Currency) = Money((amount * currency.lowestDenomination).toInt(), currency)


        @JvmStatic
        @JvmSynthetic
        @JsName("fromInt")
        fun of(amount: Int, currency: Currency) = Money((amount.toDouble() * currency.lowestDenomination).toInt(), currency)


        @JvmStatic
        @JvmSynthetic
        @JsName("fromLong")
        fun of(amount: Long, currency: Currency) = Money((amount.toDouble() * currency.lowestDenomination).toInt(), currency)


        @JvmStatic
        @JvmSynthetic
        @JsName("fromNumber")
        fun of(amount: Number, currency: Currency) = Money((amount.toDouble() * currency.lowestDenomination).toInt(), currency)

    }

    operator fun plus(other: Money): Money {
        if (other.currency != currency) error("Can't add ${currency.name} to ${other.currency.name}")
        return Money(amount + other.amount, currency)
    }

    operator fun minus(other: Money): Money {
        if (other.currency != currency) error("Can't subtract ${currency.name} to ${other.currency.name}")
        return Money(amount - other.amount, currency)
    }

    operator fun times(quantity: Number) = Money((amount * quantity.toDouble()).toInt(), currency)

    operator fun div(quantity: Number) = Money((amount / quantity.toDouble()).toInt(), currency)

    @JsName("ratio")
    operator fun div(other: Money) = MoneyRatio((amount.toDouble() / other.amount), currency, other.currency)

    fun toFormattedString(): String = toFormattedString(MoneyFormatterOptions())

    fun format(formatter: Formatter<Money>) = formatter.format(this)

    @JsName("_ignore_toFormattedString")
    fun toFormattedString(
        abbreviate: Boolean = DEFAULT_ABBREVIATE,
        prefix: String = DEFAULT_PREFIX,
        postfix: String = DEFAULT_POSTFIX,
        decimals: Int? = null,
        enforceDecimals: Boolean = DEFAULT_ENFORCE_DECIMALS,
        decimalSeparator: String = DEFAULT_DECIMAL_SEPARATOR,
        thousandsSeparator: String = DEFAULT_THOUSAND_SEPERATOR
    ) = MoneyFormatter(
        abbreviate,
        prefix,
        postfix,
        decimals = decimals ?: if (abbreviate) DEFAULT_DECIMALS_ABBREVIATED else DEFAULT_DECIMALS_UNABBREVIATED,
        enforceDecimals,
        decimalSeparator,
        thousandsSeparator
    ).format(this)

    @JsName("toFormattedStringWith")
    fun toFormattedString(options: MoneyFormatterRawOptions): String = MoneyFormatter(options.toFormatterOptions()).format(this)
}