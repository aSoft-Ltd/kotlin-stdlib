import expect.expect
import kash.MXN
import kash.Money
import kash.PREFIX
import kash.TZS
import kotlin.test.Test

class MoneyRepresentationTest {

    @Test
    fun should_easily_abbreviate_thousands() {
        expect(5000.TZS.toShortString()).toBe("TZS 5K")
    }

    @Test
    fun should_easily_abbreviate_hubndreds_of_thousands() {
        expect(450_000.TZS.toShortString()).toBe("TZS 450K")
    }

    @Test
    fun should_easily_abbreviate_thousands_in_mexican_peso() {
        expect(3000.MXN.toShortString()).toBe("$ 3K")
        expect(4200.MXN.toShortString(PREFIX.NAME)).toBe("MXN 4.2K")
    }

    @Test
    fun should_easily_millions() {
        expect(2_000_000.MXN.toShortString()).toBe("$ 2M")
    }

    @Test
    fun should_easily_abbreviate_decimals_too() {
        expect(2_160_000.MXN.toShortString()).toBe("$ 2.16M")
    }

    @Test
    fun should_easily_display_commas_in_thousands() {
        expect(4500.TZS.toLongString()).toBe("TZS 4,500")
    }

    @Test
    fun should_easily_display_commas_with_decimals_too() {
        expect(6700.05.TZS.toLongString()).toBe("TZS 6,700.05")
    }
}