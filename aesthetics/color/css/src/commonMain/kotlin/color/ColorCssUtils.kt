@file:Suppress("NOTHING_TO_INLINE")

package color

import color.css.invoke

@Deprecated("In favor of color.css.invoke")
inline operator fun Color.invoke() = this.invoke()