package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Cursor: UIKitSymbol
    get() {
        if (_Cursor != null)
            return _Cursor!!
        _Cursor = object : UIKitSymbol(
            name = "Cursor",
            uid = "ic.sys.cursor",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("cursor") {
                    addGroup(
                        id = "cursor",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(5.5f, 3f)
                        verticalLineToRelative(14f)
                        curveToRelative(0f, 0.46f, 0.58f, 0.68f, 0.88f, 0.33f)
                        lineToRelative(3.52f, -4.07f)
                        curveToRelative(0.38f, -0.44f, 0.93f, -0.69f, 1.51f, -0.69f)
                        horizontalLineToRelative(5.59f)
                        curveToRelative(0.47f, 0f, 0.68f, -0.59f, 0.32f, -0.89f)
                        lineTo(6.32f, 2.61f)
                        curveToRelative(-0.33f, -0.27f, -0.82f, -0.04f, -0.82f, 0.39f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce,
                    UIKitSymbolAbility.VariableWeight
                )

            override val tags: List<String>
                get() = listOf(
                    "Cursor", "Point", "Mouse"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "cursor", null), 1f),
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "cursor", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Cursor!!
    }

@Suppress("ObjectPropertyName")
private var _Cursor: UIKitSymbol? = null