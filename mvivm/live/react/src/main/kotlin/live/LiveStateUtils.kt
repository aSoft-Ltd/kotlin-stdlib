package live

import useLive

inline fun <S> Live<S>.asState() = useLive(this)