package com.millentec.compose.uikit.symbols.draw

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor

sealed class UIKitSymbolStyle {
    data class Monochrome(
        val brush: Brush,
    ): UIKitSymbolStyle() {
        constructor(color: Color): this(SolidColor(color))
    }

    data class Hierarchical(
        val brush: Brush,
    ): UIKitSymbolStyle() {
        constructor(color: Color): this(SolidColor(color))
    }

    object MultiColor: UIKitSymbolStyle()

    data class Palette(
        val brushes: List<Brush>,
    ): UIKitSymbolStyle()
}