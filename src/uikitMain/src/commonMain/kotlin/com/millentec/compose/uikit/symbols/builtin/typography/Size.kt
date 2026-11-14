package com.millentec.compose.uikit.symbols.builtin.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitTypographySymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitTypographySymbols.Size: UIKitSymbol
    get() {
        if (_Size != null)
            return _Size!!
        _Size = object : UIKitSymbol(
            name = "Size",
            uid = "ic.typography.size",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("size") {
                    addGroup(
                        id = "size",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(3.5f, 6.5f)
                        verticalLineToRelative(-1f)
                        curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                        horizontalLineToRelative(1f)
                        moveTo(3.5f, 13.25f)
                        verticalLineToRelative(1.25f)
                        curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                        horizontalLineToRelative(1.25f)
                        moveTo(13.5f, 16.5f)
                        horizontalLineToRelative(1f)
                        curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                        verticalLineToRelative(-1f)
                        moveTo(16.5f, 6.5f)
                        verticalLineToRelative(-1f)
                        curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
                        horizontalLineToRelative(-1f)
                    }
                }
                addLayer("rect") {
                    addGroup(
                        id = "rect",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(13.5f, 14.5f)
                        horizontalLineToRelative(-7f)
                        curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f)
                        reflectiveCurveToRelative(-0.29f, -0.43f, -0.29f, -0.71f)
                        verticalLineToRelative(-7f)
                        curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f)
                        reflectiveCurveToRelative(0.43f, -0.29f, 0.71f, -0.29f)
                        horizontalLineToRelative(7f)
                        curveToRelative(0.28f, 0f, 0.53f, 0.11f, 0.71f, 0.29f)
                        reflectiveCurveToRelative(0.29f, 0.43f, 0.29f, 0.71f)
                        verticalLineToRelative(7f)
                        curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f)
                        reflectiveCurveToRelative(-0.43f, 0.29f, -0.71f, 0.29f)
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
                    "Size", "Resize", "Rectangle"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "size", null), 1f),
                        Pair(UIKitSymbolSelector(null, "rect", null), 1f),
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "size", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "rect", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Size!!
    }

@Suppress("ObjectPropertyName")
private var _Size: UIKitSymbol? = null