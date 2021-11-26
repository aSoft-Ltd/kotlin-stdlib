package color.css

import color.Color
import color.to255Int
import kotlinx.css.rgba

operator fun Color.invoke() = rgba(red.to255Int(), green.to255Int(), blue.to255Int(), alpha.toDouble())
