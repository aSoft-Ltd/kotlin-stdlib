package reakt

import react.Props
import react.RBuilder
import react.ReactElement
import react.buildElement
import react.router.RouterProps

abstract class AbstractModuleRoute(
    val permits: List<String>, val path: String, val scope: String, val render: (props: RouterProps) -> ReactElement<*>?
)

fun <T : Props> ModuleRoute(
    path: String, permits: List<String>, scope: String, builder: RBuilder.(props: RouterProps) -> Unit
): AbstractModuleRoute {
    val render: (RouterProps) -> ReactElement<*>? = {
        buildElement { builder(it) }
    }
    return object : AbstractModuleRoute(
        permits = permits, path = path, scope = scope, render = render
    ) {}
}