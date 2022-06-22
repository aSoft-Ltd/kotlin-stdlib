@file:Suppress("NOTHING_TO_INLINE")

package color.compose

import color.Color

inline operator fun Color.invoke() = androidx.compose.ui.graphics.Color(red, green, blue, alpha)