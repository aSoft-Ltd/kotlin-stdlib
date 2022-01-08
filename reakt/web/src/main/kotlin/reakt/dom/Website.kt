package reakt

import react.RBuilder
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter

fun RBuilder.Website(pages: List<WebPage>) = BrowserRouter {
    Routes {
        for (page in pages) Route {
            attrs {
                path = page.route
//                exact = true
//                strict = true
                children = page.render(this)
            }
        }
//        Redirect { attrs.to = "/" }
    }
}

inline fun RBuilder.Website(vararg pages: WebPage) = Website(pages.toList())