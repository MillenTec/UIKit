package com.millentec.compose.uikit.symbols

object UIKitSymbols: UIKitSymbolPool() {
    operator fun get(key: String): UIKitSymbol {
        return this.entries.get(key, this) ?: UIKitEmptySymbol
    }
}

class UIKitSystemUISymbols internal constructor() {
    val filled = UIKitSystemUIFilledSymbols()

    class UIKitSystemUIFilledSymbols internal constructor()
}

class UIKitMediaSymbols internal constructor() {
    val filled = UIKitMediaFilledSymbols()

    class UIKitMediaFilledSymbols internal constructor()
}

class UIKitGraphicSymbols internal constructor() {
    val filled = UIKitGraphicFilledSymbols()

    class UIKitGraphicFilledSymbols internal constructor()
}

class UIKitLayoutSymbols internal constructor()

class UIKitLanguageSymbols internal constructor()

class UIKitArrowSymbols internal constructor()

class UIKitAcademicSymbols internal constructor()

class UIKitObjectsSymbols internal constructor()