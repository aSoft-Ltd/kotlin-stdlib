package live

import useLive

fun <S> Live<S>.asState() = useLive(this)