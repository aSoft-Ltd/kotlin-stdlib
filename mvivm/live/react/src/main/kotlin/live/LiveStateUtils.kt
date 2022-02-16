package live

import useLive

inline fun <S> Live<S>.watchAsState() = useLive(this)