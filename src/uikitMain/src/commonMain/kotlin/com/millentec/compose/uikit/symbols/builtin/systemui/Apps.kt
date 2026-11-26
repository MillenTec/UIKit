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

val UIKitSystemUISymbols.Apps: UIKitSymbol
    get() {
        if (_Apps != null)
            return _Apps!!
        _Apps = object : UIKitSymbol(
            name = "Apps",
            uid = "ic.sys.apps",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("e0", 0) {
                    addGroup(
                        id = "e0",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(10.43f, 5.55f)
                        lineToRelative(2.62f, -2.72f)
                        curveToRelative(0.39f, -0.4f, 1.03f, -0.41f, 1.42f, -0.02f)
                        lineToRelative(2.75f, 2.72f)
                        curveToRelative(0.4f, 0.4f, 0.4f, 1.05f, -0.01f, 1.44f)
                        lineToRelative(-2.75f, 2.62f)
                        curveToRelative(-0.39f, 0.37f, -1.01f, 0.37f, -1.4f, -0.02f)
                        lineToRelative(-2.62f, -2.62f)
                        curveToRelative(-0.39f, -0.39f, -0.39f, -1.01f, -0.01f, -1.4f)
                        close()
                    }
                }
                addLayer("e1", 1) {
                    addGroup(
                        id = "e1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4.5f, 3.5f)
                        horizontalLineToRelative(4.5f)
                        curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
                        verticalLineToRelative(5.5f)
                        horizontalLineTo(3.5f)
                        verticalLineToRelative(-5.5f)
                        curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
                        close()
                    }
                }
                addLayer("e2", 2) {
                    addGroup(
                        id = "e2",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(3.5f, 15.5f)
                        verticalLineToRelative(-5.5f)
                        horizontalLineToRelative(6.5f)
                        verticalLineToRelative(6.5f)
                        horizontalLineToRelative(-5.5f)
                        curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                        close()
                    }
                }
                addLayer("e3", 3) {
                    addGroup(
                        id = "e3",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(15.5f, 10f)
                        horizontalLineToRelative(-5.5f)
                        verticalLineToRelative(6.5f)
                        horizontalLineToRelative(5.5f)
                        curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
                        verticalLineToRelative(-4.5f)
                        curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f)
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
                    "Apps", "Applications", "Multiple", "All", "Grid", "More", "Extension", "Plugin"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "e0", null), 1f),
                        Pair(UIKitSymbolSelector(null, "e1", null), 1f),
                        Pair(UIKitSymbolSelector(null, "e2", null), 1f),
                        Pair(UIKitSymbolSelector(null, "e3", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "e0", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "e1", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "e2", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "e3", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Apps!!
    }

@Suppress("ObjectPropertyName")
private var _Apps: UIKitSymbol? = null