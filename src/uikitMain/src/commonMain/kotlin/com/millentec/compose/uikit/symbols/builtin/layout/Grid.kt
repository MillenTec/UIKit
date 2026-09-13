package com.millentec.compose.uikit.symbols.builtin.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitLayoutSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitLayoutSymbols.Grid: UIKitSymbol
    get() {
        if (_Grid != null)
            return _Grid!!
        _Grid = object : UIKitSymbol(
            name = "Grid",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("element0").apply {
                    group("element0", UIKitPathDrawType.Fill) {
                        moveTo(7.5f, 3f)
                        horizontalLineTo(3.5f)
                        curveTo(3.224f, 3f, 3f, 3.224f, 3f, 3.5f)
                        verticalLineTo(7.5f)
                        curveTo(3f, 7.776f, 3.224f, 8f, 3.5f, 8f)
                        horizontalLineTo(7.5f)
                        curveTo(7.776f, 8f, 8f, 7.776f, 8f, 7.5f)
                        verticalLineTo(3.5f)
                        curveTo(8f, 3.224f, 7.776f, 3f, 7.5f, 3f)
                        close()
                        moveTo(7.5f, 2f)
                        curveTo(8.328f, 2f, 9f, 2.672f, 9f, 3.5f)
                        verticalLineTo(7.5f)
                        curveTo(9f, 8.328f, 8.328f, 9f, 7.5f, 9f)
                        horizontalLineTo(3.5f)
                        curveTo(2.672f, 9f, 2f, 8.328f, 2f, 7.5f)
                        verticalLineTo(3.5f)
                        curveTo(2f, 2.672f, 2.672f, 2f, 3.5f, 2f)
                        horizontalLineTo(7.5f)
                        close()
                    }
                },
                UIKitSymbolLayer("element1").apply {
                    group("element1", UIKitPathDrawType.Fill) {
                        moveTo(16.5f, 2f)
                        curveTo(17.328f, 2f, 18f, 2.672f, 18f, 3.5f)
                        verticalLineTo(7.5f)
                        curveTo(18f, 8.328f, 17.328f, 9f, 16.5f, 9f)
                        horizontalLineTo(12.5f)
                        curveTo(11.672f, 9f, 11f, 8.328f, 11f, 7.5f)
                        verticalLineTo(3.5f)
                        curveTo(11f, 2.672f, 11.672f, 2f, 12.5f, 2f)
                        horizontalLineTo(16.5f)
                        close()
                        moveTo(16.5f, 3f)
                        horizontalLineTo(12.5f)
                        curveTo(12.224f, 3f, 12f, 3.224f, 12f, 3.5f)
                        verticalLineTo(7.5f)
                        curveTo(12f, 7.776f, 12.224f, 8f, 12.5f, 8f)
                        horizontalLineTo(16.5f)
                        curveTo(16.776f, 8f, 17f, 7.776f, 17f, 7.5f)
                        verticalLineTo(3.5f)
                        curveTo(17f, 3.224f, 16.776f, 3f, 16.5f, 3f)
                        close()
                    }
                },
                UIKitSymbolLayer("element2").apply {
                    group("element2", UIKitPathDrawType.Fill) {
                        moveTo(7.5f, 12f)
                        horizontalLineTo(3.5f)
                        curveTo(3.224f, 12f, 3f, 12.224f, 3f, 12.5f)
                        verticalLineTo(16.5f)
                        curveTo(3f, 16.776f, 3.224f, 17f, 3.5f, 17f)
                        horizontalLineTo(7.5f)
                        curveTo(7.776f, 17f, 8f, 16.776f, 8f, 16.5f)
                        verticalLineTo(12.5f)
                        curveTo(8f, 12.224f, 7.776f, 12f, 7.5f, 12f)
                        close()
                        moveTo(7.5f, 11f)
                        curveTo(8.328f, 11f, 9f, 11.672f, 9f, 12.5f)
                        verticalLineTo(16.5f)
                        curveTo(9f, 17.328f, 8.328f, 18f, 7.5f, 18f)
                        horizontalLineTo(3.5f)
                        curveTo(2.672f, 18f, 2f, 17.328f, 2f, 16.5f)
                        verticalLineTo(12.5f)
                        curveTo(2f, 11.672f, 2.672f, 11f, 3.5f, 11f)
                        horizontalLineTo(7.5f)
                        close()
                    }
                },
                UIKitSymbolLayer("element3").apply {
                    group("element3", UIKitPathDrawType.Fill) {
                        moveTo(16.5f, 11f)
                        curveTo(17.328f, 11f, 18f, 11.672f, 18f, 12.5f)
                        verticalLineTo(16.5f)
                        curveTo(18f, 17.328f, 17.328f, 18f, 16.5f, 18f)
                        horizontalLineTo(12.5f)
                        curveTo(11.672f, 18f, 11f, 17.328f, 11f, 16.5f)
                        verticalLineTo(12.5f)
                        curveTo(11f, 11.672f, 11.672f, 11f, 12.5f, 11f)
                        horizontalLineTo(16.5f)
                        close()
                        moveTo(16.5f, 12f)
                        horizontalLineTo(12.5f)
                        curveTo(12.224f, 12f, 12f, 12.224f, 12f, 12.5f)
                        verticalLineTo(16.5f)
                        curveTo(12f, 16.776f, 12.224f, 17f, 12.5f, 17f)
                        horizontalLineTo(16.5f)
                        curveTo(16.776f, 17f, 17f, 16.776f, 17f, 16.5f)
                        verticalLineTo(12.5f)
                        curveTo(17f, 12.224f, 16.776f, 12f, 16.5f, 12f)
                        close()
                    }
                }
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce
            )

            override val tags: List<String> = listOf(
                "Grid", "Layout", "Structure", "Menu", "All"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layers = layers,
                    layerInfo = layers.map { Pair(it.id, 1f) },
                    multiColor = layers.map { UIKitSymbolColor(it.id, UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f) }
                )
            }
        }

        return _Grid!!
    }

@Suppress("ObjectPropertyName")
private var _Grid: UIKitSymbol? = null