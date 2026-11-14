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

val UIKitGraphicSymbols.MotionRectangle: UIKitSymbol
    get() {
        if (_MotionRectangle != null)
            return _MotionRectangle!!
        _MotionRectangle = object : UIKitSymbol(
            name = "MotionRectangle",
            uid = "ic.graphic.motion.rect",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("l0", 2) {
                    addGroup(
                        id = "l0",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(3.73f, 7.08f)
                        lineToRelative(5.51f, -3.22f)
                        curveToRelative(0.47f, -0.27f, 1.05f, -0.27f, 1.51f, 0f)
                        lineToRelative(5.51f, 3.22f)
                        curveToRelative(0.33f, 0.19f, 0.33f, 0.67f, 0f, 0.86f)
                        lineToRelative(-5.51f, 3.21f)
                        curveToRelative(-0.47f, 0.27f, -1.04f, 0.27f, -1.51f, 0f)
                        lineToRelative(-5.51f, -3.21f)
                        curveToRelative(-0.33f, -0.19f, -0.33f, -0.67f, 0f, -0.86f)
                        close()
                    }
                }
                addLayer("l1", 1) {
                    addGroup(
                        id = "l1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(16.52f, 10.29f)
                        lineToRelative(-5.76f, 3.36f)
                        curveToRelative(-0.47f, 0.27f, -1.04f, 0.27f, -1.51f, 0f)
                        lineToRelative(-5.75f, -3.35f)
                    }
                }
                addLayer("l2", 0) {
                    addGroup(
                        id = "l2",
                        drawType = UIKitPathDrawType.Dashed(1f, 0f, 1.5f)
                    ) {
                        moveTo(16.52f, 12.79f)
                        lineToRelative(-6.01f, 3.5f)
                        curveToRelative(-0.31f, 0.18f, -0.7f, 0.18f, -1.01f, 0f)
                        lineToRelative(-6.01f, -3.5f)
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

        return _MotionRectangle!!
    }

@Suppress("ObjectPropertyName")
private var _MotionRectangle: UIKitSymbol? = null