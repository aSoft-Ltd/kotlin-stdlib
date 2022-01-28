import live.Live

external interface IndexTest {
    fun <S> consumeLive(live: Live<S>)
    fun <S> canWatchALive(live: Live<S>)
    fun <S> canPeekALive(live: Live<S>)
    fun <S> canChangeValueFromJs(live: Live<S>)
}