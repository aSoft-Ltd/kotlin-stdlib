package reakt

import react.RBuilder
import react.ReactElement
import react.createElement
import react.router.RouteProps

open class WebPage(
    val route: String, val builder: RBuilder.(RouteProps) -> Unit
) {
    val render: (RouteProps) -> ReactElement? = {
        createElement { builder(it) }
    }
}