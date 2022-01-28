package live

inline val <S> Live<S>.value get() = getValue()

inline var <S> MutableLive<S>.value: S
    inline get() = getValue()
    inline set(value) = setValue(value)