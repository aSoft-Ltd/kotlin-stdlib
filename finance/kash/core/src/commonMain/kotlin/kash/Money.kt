@file:JsExport

package kash

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.UseSerializers
import kotlinx.serialization.builtins.LongAsStringSerializer
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic

@Serializable
data class Money internal constructor(
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
        PREFIX.SYMBOL -> currency.symbol
        PREFIX.NAME -> currency.name
        else -> prefix
    }

    fun toShortString(prefix: String = PREFIX.SYMBOL): String {
        val value = amount.toDouble() / currency.lowestDenomination
        val (postfix, divider) = when {
            value < 1_000 -> "" to 1
            value >= 1_000 && value < 1_000_000 -> "K" to 1_000
            value >= 1_000_000 && value < 1_000_000_000 -> "M" to 1_000_000
            else -> "B" to 1_000_000_000
        }
        return "${processPrefix(prefix)} ${beautify(value / divider)}$postfix"
    }

    fun toLongString(prefix: String = PREFIX.SYMBOL, separator: String = ",", terminator: String = "."): String {
        val value = amount.toDouble() / currency.lowestDenomination
        val splits = value.toString().split('.')
        var characteristic = splits[0]
        var mantisa = splits.getOrElse(1) { "0" }
        mantisa = if (mantisa.toDouble() == 0.0) "" else mantisa
        characteristic = characteristic.toCharArray().toList().reversed()
            .chunked(3).reversed().joinToString(separator = separator) {
                it.reversed().joinToString(separator = "")
            }
        return if (mantisa == "") {
            "${processPrefix(prefix)} $characteristic"
        } else {
            "${processPrefix(prefix)} $characteristic$terminator$mantisa"
        }
    }
}