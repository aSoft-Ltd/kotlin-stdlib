@file:JsExport

package kash

import kash.MoneyFormatterOptions.Companion.DEFAULT_ABBREVIATE
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMALS_ABBREVIATED
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMALS_UNABBREVIATED
import kash.MoneyFormatterOptions.Companion.DEFAULT_DECIMAL_SEPARATOR
import kash.MoneyFormatterOptions.Companion.DEFAULT_PREFIX
import kash.MoneyFormatterOptions.Companion.DEFAULT_THOUSAND_SEPERATOR
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic
import kotlin.math.pow
import kotlin.math.round

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

    private fun beautify(amount: Double): String {
        if (amount.toString().endsWith(".0")) {
            return amount.toInt().toString()
        }
        return amount.toString()
    }

    private fun processPrefix(prefix: String) = when (prefix) {
        PREFIX.CURRENCY_LOCAL_SYMBOL -> currency.localSymbol
        PREFIX.CURRENCY_GLOBAL_SYMBOL -> currency.globalSymbol
        PREFIX.CURRENCY_NAME -> currency.name
        else -> prefix
    }

    fun toFormattedString(): String = toFormattedString(MoneyFormatterOptions())

    @JsName("_ignore_toFormattedString")
    fun toFormattedString(
        abbreviate: Boolean = DEFAULT_ABBREVIATE,
        prefix: String = DEFAULT_PREFIX,
        decimals: Int? = null,
        decimalSeparator: String = DEFAULT_DECIMAL_SEPARATOR,
        thousandsSeparator: String = DEFAULT_THOUSAND_SEPERATOR
    ) = toFormattedString(
        MoneyFormatterOptions(
            abbreviate,
            prefix,
            decimals = decimals ?: if (abbreviate) DEFAULT_DECIMALS_ABBREVIATED else DEFAULT_DECIMALS_UNABBREVIATED,
            decimalSeparator,
            thousandsSeparator
        )
    )

    @JsName("toFormattedStringWith")
    fun toFormattedString(options: MoneyFormatterRawOptions): String = if (options.abbreviate == true) {
        val opt = options.toFormatterOptions().copy(
            decimals = options.decimals ?: DEFAULT_DECIMALS_ABBREVIATED
        )
        val value = amount.toDouble() / currency.lowestDenomination
        val (postfix, divider) = when {
            value < 1_000 -> "" to 1
            value >= 1_000 && value < 1_000_000 -> "K" to 1_000
            value >= 1_000_000 && value < 1_000_000_000 -> "M" to 1_000_000
            else -> "B" to 1_000_000_000
        }
        val rounded = round(value * opt.rounder / divider) / opt.rounder
        "${processPrefix(opt.prefix)} ${beautify(rounded)}$postfix"
    } else {
        val opt = options.toFormatterOptions().copy(
            decimals = options.decimals ?: DEFAULT_DECIMALS_UNABBREVIATED
        )
        val value = round(amount.toDouble() * opt.rounder / currency.lowestDenomination) / opt.rounder
        val splits = value.toString().split('.')
        var characteristic = splits[0]
        var mantisa = splits.getOrElse(1) { "0" }
        mantisa = if (mantisa.toDouble() == 0.0) "" else mantisa
        characteristic = characteristic.toCharArray().toList().reversed()
            .chunked(3).reversed().joinToString(separator = opt.thousandsSeparator.toString()) {
                it.reversed().joinToString(separator = "")
            }
        if (mantisa == "") {
            "${processPrefix(opt.prefix)} $characteristic"
        } else {
            "${processPrefix(opt.prefix)} $characteristic${opt.decimalSeparator}$mantisa"
        }
    }
}