/*
 * This is a generated document
 * author of the generator: https://github.com/andylamax
 */
@file:JsExport
@file:Suppress("unused","WRONG_EXPORTED_DECLARATION")

package kash

import kotlin.jvm.JvmSynthetic
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

@Serializable(with = CurrencySerializer::class)
sealed class Currency(val name: String, val symbol: String, val details: String,val lowestDenomination: Short) {
    override fun toString() = name
    companion object {
        val values = arrayOf(AED,AFN,ALL,AMD,ANG,AOA,ARS,AUD,AWG,AZN,BAM,BBD,BDT,BGN,BHD,BIF,BMD,BND,BOB,BRL,BSD,BTN,BWP,BYR,BZD,CAD,CDF,CHF,CLP,CNY,COP,CRC,CUC,CVE,CZK,DJF,DKK,DOP,DZD,EEK,EGP,ERN,ETB,EUR,FJD,FKP,GBP,GEL,GHS,GIP,GMD,GNF,GQE,GTQ,GYD,HKD,HNL,HRK,HTG,HUF,IDR,ILS,INR,IQD,IRR,ISK,JMD,JOD,JPY,KES,KGS,KHR,KMF,KPW,KRW,KWD,KYD,KZT,LAK,LBP,LKR,LRD,LSL,LTL,LVL,LYD,MAD,MDL,MGA,MKD,MMK,MNT,MOP,MRO,MUR,MVR,MWK,MXN,MYR,MZM,NAD,NGN,NIO,NOK,NPR,NZD,OMR,PAB,PEN,PGK,PHP,PKR,PLN,PYG,QAR,RON,RSD,RUB,SAR,SBD,SCR,SDG,SEK,SGD,SHP,SLL,SOS,SRD,SYP,SZL,THB,TJS,TMT,TND,TRY,TTD,TWD,TZS,UAH,UGX,USD,UYU,UZS,VEB,VND,VUV,WST,XAF,XCD,XDR,XOF,XPF,YER,ZAR,ZMK,ZWR)
        fun valueOf(currency: String) = values.first{ it.name == currency }
    }            
	/**UAE dirham*/
	object AED : Currency("AED","د.إ;","UAE dirham",100)

	/**Afghan afghani*/
	object AFN : Currency("AFN","Afs","Afghan afghani",100)

	/**Albanian lek*/
	object ALL : Currency("ALL","L","Albanian lek",100)

	/**Armenian dram*/
	object AMD : Currency("AMD","AMD","Armenian dram",100)

	/**Netherlands Antillean gulden*/
	object ANG : Currency("ANG","NAƒ","Netherlands Antillean gulden",100)

	/**Angolan kwanza*/
	object AOA : Currency("AOA","Kz","Angolan kwanza",100)

	/**Argentine peso*/
	object ARS : Currency("ARS","$","Argentine peso",100)

	/**Australian dollar*/
	object AUD : Currency("AUD","$","Australian dollar",100)

	/**Aruban florin*/
	object AWG : Currency("AWG","ƒ","Aruban florin",100)

	/**Azerbaijani manat*/
	object AZN : Currency("AZN","AZN","Azerbaijani manat",100)

	/**Bosnia and Herzegovina konvertibilna marka*/
	object BAM : Currency("BAM","KM","Bosnia and Herzegovina konvertibilna marka",100)

	/**Barbadian dollar*/
	object BBD : Currency("BBD","Bds$","Barbadian dollar",100)

	/**Bangladeshi taka*/
	object BDT : Currency("BDT","৳","Bangladeshi taka",100)

	/**Bulgarian lev*/
	object BGN : Currency("BGN","BGN","Bulgarian lev",100)

	/**Bahraini dinar*/
	object BHD : Currency("BHD",".د.ب","Bahraini dinar",100)

	/**Burundi franc*/
	object BIF : Currency("BIF","FBu","Burundi franc",100)

	/**Bermudian dollar*/
	object BMD : Currency("BMD","BD$","Bermudian dollar",100)

	/**Brunei dollar*/
	object BND : Currency("BND","B$","Brunei dollar",100)

	/**Bolivian boliviano*/
	object BOB : Currency("BOB","Bs.","Bolivian boliviano",100)

	/**Brazilian real*/
	object BRL : Currency("BRL","R$","Brazilian real",100)

	/**Bahamian dollar*/
	object BSD : Currency("BSD","B$","Bahamian dollar",100)

	/**Bhutanese ngultrum*/
	object BTN : Currency("BTN","Nu.","Bhutanese ngultrum",100)

	/**Botswana pula*/
	object BWP : Currency("BWP","P","Botswana pula",100)

	/**Belarusian ruble*/
	object BYR : Currency("BYR","Br","Belarusian ruble",100)

	/**Belize dollar*/
	object BZD : Currency("BZD","BZ$","Belize dollar",100)

	/**Canadian dollar*/
	object CAD : Currency("CAD","$","Canadian dollar",100)

	/**Congolese franc*/
	object CDF : Currency("CDF","F","Congolese franc",100)

	/**Swiss franc*/
	object CHF : Currency("CHF","Fr.","Swiss franc",100)

	/**Chilean peso*/
	object CLP : Currency("CLP","$","Chilean peso",100)

	/**Chinese/Yuan renminbi*/
	object CNY : Currency("CNY","¥","Chinese/Yuan renminbi",100)

	/**Colombian peso*/
	object COP : Currency("COP","Col$","Colombian peso",100)

	/**Costa Rican colon*/
	object CRC : Currency("CRC","₡","Costa Rican colon",100)

	/**Cuban peso*/
	object CUC : Currency("CUC","$","Cuban peso",100)

	/**Cape Verdean escudo*/
	object CVE : Currency("CVE","Esc","Cape Verdean escudo",100)

	/**Czech koruna*/
	object CZK : Currency("CZK","Kč","Czech koruna",100)

	/**Djiboutian franc*/
	object DJF : Currency("DJF","Fdj","Djiboutian franc",100)

	/**Danish krone*/
	object DKK : Currency("DKK","Kr","Danish krone",100)

	/**Dominican peso*/
	object DOP : Currency("DOP","RD$","Dominican peso",100)

	/**Algerian dinar*/
	object DZD : Currency("DZD","د.ج","Algerian dinar",100)

	/**Estonian kroon*/
	object EEK : Currency("EEK","KR","Estonian kroon",100)

	/**Egyptian pound*/
	object EGP : Currency("EGP","£","Egyptian pound",100)

	/**Eritrean nakfa*/
	object ERN : Currency("ERN","Nfa","Eritrean nakfa",100)

	/**Ethiopian birr*/
	object ETB : Currency("ETB","Br","Ethiopian birr",100)

	/**European Euro*/
	object EUR : Currency("EUR","€","European Euro",100)

	/**Fijian dollar*/
	object FJD : Currency("FJD","FJ$","Fijian dollar",100)

	/**Falkland Islands pound*/
	object FKP : Currency("FKP","£","Falkland Islands pound",100)

	/**British pound*/
	object GBP : Currency("GBP","£","British pound",100)

	/**Georgian lari*/
	object GEL : Currency("GEL","GEL","Georgian lari",100)

	/**Ghanaian cedi*/
	object GHS : Currency("GHS","GH₵","Ghanaian cedi",100)

	/**Gibraltar pound*/
	object GIP : Currency("GIP","£","Gibraltar pound",100)

	/**Gambian dalasi*/
	object GMD : Currency("GMD","D","Gambian dalasi",100)

	/**Guinean franc*/
	object GNF : Currency("GNF","FG","Guinean franc",100)

	/**Central African CFA franc*/
	object GQE : Currency("GQE","CFA","Central African CFA franc",100)

	/**Guatemalan quetzal*/
	object GTQ : Currency("GTQ","Q","Guatemalan quetzal",100)

	/**Guyanese dollar*/
	object GYD : Currency("GYD","GY$","Guyanese dollar",100)

	/**Hong Kong dollar*/
	object HKD : Currency("HKD","HK$","Hong Kong dollar",100)

	/**Honduran lempira*/
	object HNL : Currency("HNL","L","Honduran lempira",100)

	/**Croatian kuna*/
	object HRK : Currency("HRK","kn","Croatian kuna",100)

	/**Haitian gourde*/
	object HTG : Currency("HTG","G","Haitian gourde",100)

	/**Hungarian forint*/
	object HUF : Currency("HUF","Ft","Hungarian forint",100)

	/**Indonesian rupiah*/
	object IDR : Currency("IDR","Rp","Indonesian rupiah",100)

	/**Israeli new sheqel*/
	object ILS : Currency("ILS","₪","Israeli new sheqel",100)

	/**Indian rupee*/
	object INR : Currency("INR","₹","Indian rupee",100)

	/**Iraqi dinar*/
	object IQD : Currency("IQD","د.ع","Iraqi dinar",100)

	/**Iranian rial*/
	object IRR : Currency("IRR","IRR","Iranian rial",100)

	/**Icelandic króna*/
	object ISK : Currency("ISK","kr","Icelandic króna",100)

	/**Jamaican dollar*/
	object JMD : Currency("JMD","J$","Jamaican dollar",100)

	/**Jordanian dinar*/
	object JOD : Currency("JOD","JOD","Jordanian dinar",100)

	/**Japanese yen*/
	object JPY : Currency("JPY","¥","Japanese yen",100)

	/**Kenyan shilling*/
	object KES : Currency("KES","KSh","Kenyan shilling",100)

	/**Kyrgyzstani som*/
	object KGS : Currency("KGS","сом","Kyrgyzstani som",100)

	/**Cambodian riel*/
	object KHR : Currency("KHR","៛","Cambodian riel",100)

	/**Comorian franc*/
	object KMF : Currency("KMF","KMF","Comorian franc",100)

	/**North Korean won*/
	object KPW : Currency("KPW","W","North Korean won",100)

	/**South Korean won*/
	object KRW : Currency("KRW","W","South Korean won",100)

	/**Kuwaiti dinar*/
	object KWD : Currency("KWD","KWD","Kuwaiti dinar",100)

	/**Cayman Islands dollar*/
	object KYD : Currency("KYD","KY$","Cayman Islands dollar",100)

	/**Kazakhstani tenge*/
	object KZT : Currency("KZT","T","Kazakhstani tenge",100)

	/**Lao kip*/
	object LAK : Currency("LAK","KN","Lao kip",100)

	/**Lebanese lira*/
	object LBP : Currency("LBP","£","Lebanese lira",100)

	/**Sri Lankan rupee*/
	object LKR : Currency("LKR","Rs","Sri Lankan rupee",100)

	/**Liberian dollar*/
	object LRD : Currency("LRD","L$","Liberian dollar",100)

	/**Lesotho loti*/
	object LSL : Currency("LSL","M","Lesotho loti",100)

	/**Lithuanian litas*/
	object LTL : Currency("LTL","Lt","Lithuanian litas",100)

	/**Latvian lats*/
	object LVL : Currency("LVL","Ls","Latvian lats",100)

	/**Libyan dinar*/
	object LYD : Currency("LYD","LD","Libyan dinar",100)

	/**Moroccan dirham*/
	object MAD : Currency("MAD","MAD","Moroccan dirham",100)

	/**Moldovan leu*/
	object MDL : Currency("MDL","MDL","Moldovan leu",100)

	/**Malagasy ariary*/
	object MGA : Currency("MGA","FMG","Malagasy ariary",100)

	/**Macedonian denar*/
	object MKD : Currency("MKD","MKD","Macedonian denar",100)

	/**Myanma kyat*/
	object MMK : Currency("MMK","K","Myanma kyat",100)

	/**Mongolian tugrik*/
	object MNT : Currency("MNT","₮","Mongolian tugrik",100)

	/**Macanese pataca*/
	object MOP : Currency("MOP","P","Macanese pataca",100)

	/**Mauritanian ouguiya*/
	object MRO : Currency("MRO","UM","Mauritanian ouguiya",100)

	/**Mauritian rupee*/
	object MUR : Currency("MUR","Rs","Mauritian rupee",100)

	/**Maldivian rufiyaa*/
	object MVR : Currency("MVR","Rf","Maldivian rufiyaa",100)

	/**Malawian kwacha*/
	object MWK : Currency("MWK","MK","Malawian kwacha",100)

	/**Mexican peso*/
	object MXN : Currency("MXN","$","Mexican peso",100)

	/**Malaysian ringgit*/
	object MYR : Currency("MYR","RM","Malaysian ringgit",100)

	/**Mozambican metical*/
	object MZM : Currency("MZM","MTn","Mozambican metical",100)

	/**Namibian dollar*/
	object NAD : Currency("NAD","N$","Namibian dollar",100)

	/**Nigerian naira*/
	object NGN : Currency("NGN","₦","Nigerian naira",100)

	/**Nicaraguan córdoba*/
	object NIO : Currency("NIO","C$","Nicaraguan córdoba",100)

	/**Norwegian krone*/
	object NOK : Currency("NOK","kr","Norwegian krone",100)

	/**Nepalese rupee*/
	object NPR : Currency("NPR","NRs","Nepalese rupee",100)

	/**New Zealand dollar*/
	object NZD : Currency("NZD","NZ$","New Zealand dollar",100)

	/**Omani rial*/
	object OMR : Currency("OMR","OMR","Omani rial",100)

	/**Panamanian balboa*/
	object PAB : Currency("PAB","B./","Panamanian balboa",100)

	/**Peruvian nuevo sol*/
	object PEN : Currency("PEN","S/.","Peruvian nuevo sol",100)

	/**Papua New Guinean kina*/
	object PGK : Currency("PGK","K","Papua New Guinean kina",100)

	/**Philippine peso*/
	object PHP : Currency("PHP","₱","Philippine peso",100)

	/**Pakistani rupee*/
	object PKR : Currency("PKR","Rs.","Pakistani rupee",100)

	/**Polish zloty*/
	object PLN : Currency("PLN","zł","Polish zloty",100)

	/**Paraguayan guarani*/
	object PYG : Currency("PYG","₲","Paraguayan guarani",100)

	/**Qatari riyal*/
	object QAR : Currency("QAR","QR","Qatari riyal",100)

	/**Romanian leu*/
	object RON : Currency("RON","L","Romanian leu",100)

	/**Serbian dinar*/
	object RSD : Currency("RSD","din.","Serbian dinar",100)

	/**Russian ruble*/
	object RUB : Currency("RUB","R","Russian ruble",100)

	/**Saudi riyal*/
	object SAR : Currency("SAR","SR","Saudi riyal",100)

	/**Solomon Islands dollar*/
	object SBD : Currency("SBD","SI$","Solomon Islands dollar",100)

	/**Seychellois rupee*/
	object SCR : Currency("SCR","SR","Seychellois rupee",100)

	/**Sudanese pound*/
	object SDG : Currency("SDG","SDG","Sudanese pound",100)

	/**Swedish krona*/
	object SEK : Currency("SEK","kr","Swedish krona",100)

	/**Singapore dollar*/
	object SGD : Currency("SGD","S$","Singapore dollar",100)

	/**Saint Helena pound*/
	object SHP : Currency("SHP","£","Saint Helena pound",100)

	/**Sierra Leonean leone*/
	object SLL : Currency("SLL","Le","Sierra Leonean leone",100)

	/**Somali shilling*/
	object SOS : Currency("SOS","Sh.","Somali shilling",100)

	/**Surinamese dollar*/
	object SRD : Currency("SRD","$","Surinamese dollar",100)

	/**Syrian pound*/
	object SYP : Currency("SYP","LS","Syrian pound",100)

	/**Swazi lilangeni*/
	object SZL : Currency("SZL","E","Swazi lilangeni",100)

	/**Thai baht*/
	object THB : Currency("THB","฿","Thai baht",100)

	/**Tajikistani somoni*/
	object TJS : Currency("TJS","TJS","Tajikistani somoni",100)

	/**Turkmen manat*/
	object TMT : Currency("TMT","m","Turkmen manat",100)

	/**Tunisian dinar*/
	object TND : Currency("TND","DT","Tunisian dinar",100)

	/**Turkish new lira*/
	object TRY : Currency("TRY","TRY","Turkish new lira",100)

	/**Trinidad and Tobago dollar*/
	object TTD : Currency("TTD","TT$","Trinidad and Tobago dollar",100)

	/**New Taiwan dollar*/
	object TWD : Currency("TWD","NT$","New Taiwan dollar",100)

	/**Tanzanian shilling*/
	object TZS : Currency("TZS","TZS","Tanzanian shilling",100)

	/**Ukrainian hryvnia*/
	object UAH : Currency("UAH","UAH","Ukrainian hryvnia",100)

	/**Ugandan shilling*/
	object UGX : Currency("UGX","USh","Ugandan shilling",100)

	/**United States dollar*/
	object USD : Currency("USD","US$","United States dollar",100)

	/**Uruguayan peso*/
	object UYU : Currency("UYU","${"$"}U","Uruguayan peso",100)

	/**Uzbekistani som*/
	object UZS : Currency("UZS","UZS","Uzbekistani som",100)

	/**Venezuelan bolivar*/
	object VEB : Currency("VEB","Bs","Venezuelan bolivar",100)

	/**Vietnamese dong*/
	object VND : Currency("VND","₫","Vietnamese dong",100)

	/**Vanuatu vatu*/
	object VUV : Currency("VUV","VT","Vanuatu vatu",100)

	/**Samoan tala*/
	object WST : Currency("WST","WS$","Samoan tala",100)

	/**Central African CFA franc*/
	object XAF : Currency("XAF","CFA","Central African CFA franc",100)

	/**East Caribbean dollar*/
	object XCD : Currency("XCD","EC$","East Caribbean dollar",100)

	/**Special Drawing Rights*/
	object XDR : Currency("XDR","SDR","Special Drawing Rights",100)

	/**West African CFA franc*/
	object XOF : Currency("XOF","CFA","West African CFA franc",100)

	/**CFP franc*/
	object XPF : Currency("XPF","F","CFP franc",100)

	/**Yemeni rial*/
	object YER : Currency("YER","YER","Yemeni rial",100)

	/**South African rand*/
	object ZAR : Currency("ZAR","R","South African rand",100)

	/**Zambian kwacha*/
	object ZMK : Currency("ZMK","ZK","Zambian kwacha",100)

	/**Zimbabwean dollar*/
	object ZWR : Currency("ZWR","Z$","Zimbabwean dollar",100)

    @JsName("ofUIntValue")
    fun of(amount: UInt) = Money((amount.toDouble() * lowestDenomination).toInt(), this)
    @JsName("ofULongValue")
    fun of(amount: ULong) = Money((amount.toDouble() * lowestDenomination).toInt(), this)
    @JsName("ofDoubleValue")
    fun of(amount: Double) = Money((amount.toDouble() * lowestDenomination).toInt(), this)
    @JvmSynthetic
    @JsName("ofIntValue")
    fun of(amount: Int) = Money((amount.toDouble() * lowestDenomination).toInt(), this)
    @JvmSynthetic
    @JsName("ofLongValue")
    fun of(amount: Long) = Money((amount.toDouble() * lowestDenomination).toInt(), this)
}