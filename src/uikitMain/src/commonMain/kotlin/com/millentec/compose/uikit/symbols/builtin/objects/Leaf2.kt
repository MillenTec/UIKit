package com.millentec.compose.uikit.symbols.builtin.objects

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitObjectsSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitObjectsSymbols.Leaf2: UIKitSymbol
    get() {
        if (_Leaf2 != null)
            return _Leaf2!!
        _Leaf2 = object : UIKitSymbol(
            name = "Leaf2",
            uid = "ic.obj.leaf.2",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("leaf0", 0) {
                    addGroup(
                        id = "leaf",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(7.88f, 12.42f)
                        curveToRelative(-0.27f, 0.05f, -0.55f, 0.08f, -0.87f, 0.08f)
                        curveToRelative(-2.21f, 0f, -4.51f, -1.69f, -4.51f, -4.51f)
                        verticalLineToRelative(-3.7f)
                        curveToRelative(0f, -0.45f, 0.36f, -0.81f, 0.81f, -0.81f)
                        horizontalLineToRelative(3.7f)
                        curveToRelative(1.83f, 0f, 3.19f, 0.97f, 3.91f, 2.26f)
                    }
                    addGroup(
                        id = "stem",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(5.5f, 6.49f)
                        lineTo(7.8f, 8.79f)
                    }
                }
                addLayer("leaf1", 1) {
                    addGroup(
                        id = "leaf_mask",
                        drawType = UIKitPathDrawType.MaskFilled
                    ) {
                        moveTo(8.98f, 14.01f)
                        curveToRelative(0.35f, 0.35f, 1.47f, 1.48f, 3.52f, 1.48f)
                        curveToRelative(2.45f, 0f, 5f, -1.88f, 5f, -5f)
                        verticalLineToRelative(-4.1f)
                        curveToRelative(0f, -0.5f, -0.4f, -0.9f, -0.9f, -0.9f)
                        horizontalLineToRelative(-4.1f)
                        curveToRelative(-3.12f, 0f, -5f, 2.55f, -5f, 5f)
                        curveToRelative(0f, 2.05f, 1.13f, 3.16f, 1.48f, 3.52f)
                        horizontalLineToRelative(0f)
                        close()
                    }
                    addGroup(
                        id = "leaf",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(8.98f, 14.01f)
                        curveToRelative(0.35f, 0.35f, 1.47f, 1.48f, 3.52f, 1.48f)
                        curveToRelative(2.45f, 0f, 5f, -1.88f, 5f, -5f)
                        verticalLineToRelative(-4.1f)
                        curveToRelative(0f, -0.5f, -0.4f, -0.9f, -0.9f, -0.9f)
                        horizontalLineToRelative(-4.1f)
                        curveToRelative(-3.12f, 0f, -5f, 2.55f, -5f, 5f)
                        curveToRelative(0f, 2.05f, 1.13f, 3.16f, 1.48f, 3.52f)
                        horizontalLineToRelative(0f)
                        close()
                    }
                    addGroup(
                        id = "stem",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(6.49f, 16.51f)
                        lineTo(12.5f, 10.49f)
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
                    "Leaf", "Environmental Protection", "Environment", "Energy Saving", "Battery",
                    "Nature", "Plant", "Ecology"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "leaf0", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "leaf1", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "leaf0", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().greenThemedBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "leaf1", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().greenThemedBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Leaf2!!
    }

@Suppress("ObjectPropertyName")
private var _Leaf2: UIKitSymbol? = null