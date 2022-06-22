package color.compose

import color.Color
import color.to255Int
import org.jetbrains.compose.web.css.rgba

operator fun Color.invoke() = rgba(red.to255Int(), green.to255Int(), blue.to255Int(), alpha.toDouble())