package theme

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.StylePropertyValue

data class TextStyle(
    val color: CSSColorValue? = null,
    val fontSize: CSSNumeric? = null,
    val fontWeight: StylePropertyValue? = null, // can be a string or number; https://www.w3schools.com/cssref/pr_font_weight.asp
    val fontStyle: StylePropertyValue? = null, // enum of [normal|italic|oblique|initial|inherit]; https://www.w3schools.com/cssref/pr_font_font-style.asp
    val fontFamily: List<String>? = null,
    val letterSpacing: StylePropertyValue? = null, // can be a string or number
    val background: CSSColorValue? = null,
    val textDecoration: StylePropertyValue? = null, // can have constituent properties; https://developer.mozilla.org/en-US/docs/Web/CSS/text-decoration
    val textAlign: StylePropertyValue? = null, // enum of [left|right|center|justify|initial|inherit]; https://www.w3schools.com/cssref/pr_text_text-align.ASP
    val lineHeight: CSSLengthOrPercentageValue? = null //
)