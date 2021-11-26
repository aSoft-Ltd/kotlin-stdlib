package theme

import org.jetbrains.compose.web.css.cssRem

data class Typography(
    val name: String = "Basic",
    val h1: TextStyle = TextStyle(fontSize = 2.cssRem),
    val h2: TextStyle = TextStyle(fontSize = 1.5.cssRem),
    val h3: TextStyle = TextStyle(fontSize = 1.17.cssRem),
    val h4: TextStyle = TextStyle(fontSize = 1.0.cssRem),
    val h5: TextStyle = TextStyle(fontSize = 0.83.cssRem),
    val h6: TextStyle = TextStyle(fontSize = 0.67.cssRem),
    val subtitle1: TextStyle = TextStyle(fontSize = 1.25.cssRem),
    val subtitle2: TextStyle = TextStyle(fontSize = 1.15.cssRem),
    val body1: TextStyle = TextStyle(fontSize = 1.0.cssRem),
    val body2: TextStyle = TextStyle(fontSize = 1.0.cssRem),
    val button: TextStyle = TextStyle(fontSize = 1.0.cssRem),
    val caption: TextStyle = TextStyle(fontSize = 0.9.cssRem),
    val overline: TextStyle = TextStyle(fontSize = 0.9.cssRem)
)