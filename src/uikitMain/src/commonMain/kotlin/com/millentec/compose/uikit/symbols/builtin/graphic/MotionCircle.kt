package com.millentec.compose.uikit.symbols.builtin.graphic

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitGraphicSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitGraphicSymbols.MotionCircle: UIKitSymbol
    get() {
        if (_MotionCircle != null)
            return _MotionCircle!!
        _MotionCircle = object : UIKitSymbol(
            name = "MotionCircle",
            uid = "ic.graphic.motion.circle",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("l0", 2) {
                    addGroup(
                        id = "l0",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(18f, 10f)
                        curveToRelative(0f, 1.66f, -0.67f, 3.16f, -1.76f, 4.24f)
                        reflectiveCurveToRelative(-2.59f, 1.76f, -4.24f, 1.76f)
                        reflectiveCurveToRelative(-3.16f, -0.67f, -4.24f, -1.76f)
                        reflectiveCurveToRelative(-1.76f, -2.59f, -1.76f, -4.24f)
                        reflectiveCurveToRelative(0.67f, -3.16f, 1.76f, -4.24f)
                        reflectiveCurveToRelative(2.59f, -1.76f, 4.24f, -1.76f)
                        reflectiveCurveToRelative(3.16f, 0.67f, 4.24f, 1.76f)
                        reflectiveCurveToRelative(1.76f, 2.59f, 1.76f, 4.24f)
                        close()
                    }
                }
                addLayer("l1", 1) {
                    addGroup(
                        id = "l1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(6.19f, 15.5f)
                        curveToRelative(-1.36f, -1.43f, -2.19f, -3.37f, -2.19f, -5.5f)
                        reflectiveCurveToRelative(0.83f, -4.07f, 2.19f, -5.5f)
                    }
                }
                addLayer("l2", 0) {
                    addGroup(
                        id = "l2",
                        drawType = UIKitPathDrawType.Dashed(1f, 0f, 1.5f)
                    ) {
                        moveTo(3.34f, 15f)
                        curveToRelative(-0.85f, -1.47f, -1.34f, -3.18f, -1.34f, -5f)
                        reflectiveCurveToRelative(0.49f, -3.53f, 1.34f, -5f)
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
                    "Motion", "Animate", "Layer", "Move"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "l0", null), 1f),
                        Pair(UIKitSymbolSelector(null, "l1", null), 0.75f),
                        Pair(UIKitSymbolSelector(null, "l2", null), 0.6f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "l0", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "l1", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "l2", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _MotionCircle!!
    }

@Suppress("ObjectPropertyName")
private var _MotionCircle: UIKitSymbol? = null