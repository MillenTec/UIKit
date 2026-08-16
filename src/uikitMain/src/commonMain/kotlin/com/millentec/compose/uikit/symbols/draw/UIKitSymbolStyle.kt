package com.millentec.compose.uikit.symbols.draw

import androidx.compose.ui.graphics.Color
import com.millentec.compose.uikit.foundation.materials.UIKitBrush

sealed class UIKitSymbolStyle {
    data class Monochrome(
        val brush: UIKitBrush,
    ): UIKitSymbolStyle() {
        constructor(color: Color): this(UIKitBrush.solid(color))
    }

    data class Hierarchical(
        val brush: UIKitBrush,
    ): UIKitSymbolStyle() {
        constructor(color: Color): this(UIKitBrush.solid(color))
    }

    object MultiColor: UIKitSymbolStyle()

    data class Palette(
        val brushes: List<UIKitBrush>,
    ): UIKitSymbolStyle()
}