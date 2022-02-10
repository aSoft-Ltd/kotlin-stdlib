package viewmodel

import live.watch

fun <S> ViewModel<*, S>.asFlow() = ui.watch()