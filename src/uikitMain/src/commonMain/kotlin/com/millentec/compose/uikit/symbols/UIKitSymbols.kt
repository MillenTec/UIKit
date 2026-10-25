package com.millentec.compose.uikit.symbols

object UIKitSymbols {
    val media = UIKitMediaSymbols()
    val systemUI = UIKitSystemUISymbols()
    val graphic = UIKitGraphicSymbols()
    val layout = UIKitLayoutSymbols()
    val language = UIKitLanguageSymbols()
    val arrow = UIKitArrowSymbols()
}

class UIKitSystemUISymbols {
    internal constructor()
    val filled = UIKitSystemUIFilledSymbols()

    class UIKitSystemUIFilledSymbols {
        internal constructor()
    }
}
class UIKitMediaSymbols { internal constructor() }
class UIKitGraphicSymbols { internal constructor() }
class UIKitLayoutSymbols { internal constructor() }
class UIKitLanguageSymbols { internal constructor() }
class UIKitArrowSymbols { internal constructor() }