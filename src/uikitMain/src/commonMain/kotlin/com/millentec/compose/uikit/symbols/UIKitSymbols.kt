package com.millentec.compose.uikit.symbols

object UIKitSymbols: UIKitSymbolPool()

class UIKitSystemUISymbols internal constructor(
    internal val pool: UIKitSymbolPool
) {
    val filled = UIKitSystemUIFilledSymbols()

    class UIKitSystemUIFilledSymbols internal constructor()
}

class UIKitMediaSymbols internal constructor(
    internal val pool: UIKitSymbolPool
) {
    val filled = UIKitMediaFilledSymbols(pool)

    class UIKitMediaFilledSymbols internal constructor(
        internal val pool: UIKitSymbolPool
    )
}
class UIKitGraphicSymbols internal constructor(
    internal val pool: UIKitSymbolPool
) {
    val filled = UIKitGraphicFilledSymbols(pool)

    class UIKitGraphicFilledSymbols internal constructor(
        internal val pool: UIKitSymbolPool
    )
}
class UIKitLayoutSymbols internal constructor(
    internal val pool: UIKitSymbolPool
)
class UIKitLanguageSymbols internal constructor(
    internal val pool: UIKitSymbolPool
)
class UIKitArrowSymbols internal constructor(
    internal val pool: UIKitSymbolPool
)
class UIKitAcademicSymbols internal constructor(
    internal val pool: UIKitSymbolPool
)