package color

import color.compose.invoke

@Suppress("NOTHING_TO_INLINE")
actual inline fun Color.toComposeColor() = ComposeColor(this())