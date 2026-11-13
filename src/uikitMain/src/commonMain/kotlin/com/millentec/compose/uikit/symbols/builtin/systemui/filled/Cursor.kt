package com.millentec.compose.uikit.symbols.builtin.systemui.filled

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

val UIKitSystemUISymbols.UIKitSystemUIFilledSymbols.Cursor: UIKitSymbol
    get() {
        if (_Cursor != null)
            return _Cursor!!
        _Cursor = object : UIKitSymbol(
            name = "Cursor",
            uid = "ic.sys.cursor.filled",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("cursor") {
                    addGroup(
                        id = "cursor",
                        zIndex = 0,
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(6.636f, 2.287f)
                        curveTo(5.983f, 1.749f, 5f, 2.213f, 5f, 3.059f)
                        verticalLineTo(17.057f)
                        curveTo(5f, 17.983f, 6.15f, 18.412f, 6.756f, 17.712f)
                        lineTo(10.28f, 13.639f)
                        curveTo(10.565f, 13.31f, 10.979f, 13.121f, 11.414f, 13.121f)
                        lineTo(17.006f, 13.121f)
                        curveTo(17.944f, 13.121f, 18.366f, 11.945f, 17.642f, 11.349f)
                        lineTo(6.636f, 2.287f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce
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
                        Pair(UIKitSymbolSelector(null, "cursor", null), 1f)
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