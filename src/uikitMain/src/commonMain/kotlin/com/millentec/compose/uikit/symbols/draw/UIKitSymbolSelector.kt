package com.millentec.compose.uikit.symbols.draw

import com.millentec.compose.uikit.symbols.UIKitSymbol

data class UIKitSymbolSelector(
    val symbol: String?,
    val layer: String?,
    val group: String?
) {
    constructor(
        symbol: UIKitSymbol,
        layer: String?,
        group: String?
    ): this(symbol.uid, layer, group)
}
