package theme

import org.jetbrains.compose.web.css.CSSRulesHolder

inline val ComposeTheme.primaryColor get() = color.primary
inline val ComposeTheme.primaryVariantColor get() = color.primaryVariant
inline val ComposeTheme.onPrimaryColor get() = color.onPrimary
inline val ComposeTheme.secondaryColor get() = color.secondary
inline val ComposeTheme.secondaryVariantColor get() = color.secondaryVariant
inline val ComposeTheme.onSecondaryColor get() = color.onSecondary
inline val ComposeTheme.backgroundColor get() = color.background
inline val ComposeTheme.onBackgroundColor get() = color.onBackground
inline val ComposeTheme.backgroundVariantColor get() = color.backgroundVariant
inline val ComposeTheme.onBackgroundVariantColor get() = color.onBackgroundVariant
inline val ComposeTheme.surfaceColor get() = color.surface
inline val ComposeTheme.onSurfaceColor get() = color.onSurface
inline val ComposeTheme.errorColor get() = color.error
inline val ComposeTheme.onErrorColor get() = color.onError

//inline val TextStyle.clazz: CSSRulesHolder
//    get() = {
//        this@clazz.color?.let { color = it }
//        this@clazz.fontSize?.let { fontSize = it }
//        this@clazz.fontWeight?.let { fontWeight = it }
//        this@clazz.fontStyle?.let { fontStyle = it }
//        this@clazz.fontFamily?.let { fontFamily = it }
//        this@clazz.letterSpacing?.let { letterSpacing = it }
//        this@clazz.background?.let { backgroundColor = it }
//        this@clazz.textAlign?.let { textAlign = it }
//        this@clazz.lineHeight?.let { lineHeight = it }
//    }
//
//inline val ComposeTheme.dropdown_clazz: RuleSet
//    get() = {
//        outline = Outline.none
//        color = CSSColor.inherit
//        child("option") {
//            backgroundColor = this@dropdown_clazz.backgroundColor
//            color = onBackgroundColor
//            hover {
//                backgroundColor = this@dropdown_clazz.primaryColor
//                color = onPrimaryColor
//            }
//        }
//    }
