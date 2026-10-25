package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors
import kotlin.math.abs

val UIKitSystemUISymbols.Battery: UIKitSymbol
    get() {
        if (_Battery != null)
            return _Battery!!
        _Battery = object : UIKitSymbol(
            name = "Battery",
            uid = "ic.sys.battery",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("battery_remain") {
                    addGroup(
                        id = "remain",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(16f, 7f)
                        curveToRelative(0.28f, 0f, 0.53f, 0.11f, 0.71f, 0.29f)
                        reflectiveCurveToRelative(0.29f, 0.43f, 0.29f, 0.71f)
                        verticalLineToRelative(4f)
                        curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f)
                        reflectiveCurveToRelative(-0.43f, 0.29f, -0.71f, 0.29f)
                        horizontalLineTo(3f)
                        curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f)
                        reflectiveCurveToRelative(-0.29f, -0.43f, -0.29f, -0.71f)
                        verticalLineToRelative(-4f)
                        curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f)
                        reflectiveCurveToRelative(0.43f, -0.29f, 0.71f, -0.29f)
                        horizontalLineToRelative(13f)
                        close()
                    }
                    addGroup(
                        id = "remain_mask",
                        drawType = UIKitPathDrawType.MaskFilled
                    ) {
                        moveTo(0f, 0f)
                        verticalLineToRelative(20f)
                        horizontalLineToRelative(20f)
                        verticalLineTo(0f)
                        horizontalLineTo(0f)
                        close()
                        moveTo(17f, 12f)
                        curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                        horizontalLineTo(3f)
                        curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                        verticalLineToRelative(-4f)
                        curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
                        horizontalLineToRelative(13f)
                        curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
                        verticalLineToRelative(4f)
                        close()
                    }
                }
                addLayer("battery_border") {
                    addGroup(
                        id = "border",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(19f, 8f)
                        curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f)
                        horizontalLineTo(3f)
                        curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f)
                        verticalLineToRelative(4f)
                        curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f)
                        horizontalLineToRelative(13f)
                        curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f)
                        curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
                        verticalLineToRelative(-2f)
                        curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f)
                        close()
                        moveTo(18f, 12f)
                        curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f)
                        horizontalLineTo(3f)
                        curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f)
                        verticalLineToRelative(-4f)
                        curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                        horizontalLineToRelative(13f)
                        curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
                        verticalLineToRelative(4f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Progressable
                )

            override val tags: List<String>
                get() = listOf(
                    "Battery", "Power", "Charge"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                val remain = 1f - abs((states[UIKitSymbolSelector(this, "battery_remain", "remain")]?.translate?.x ?: 0f) / 15f)

                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "battery_remain", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "battery_border", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "battery_remain", null),
                            UIKitSymbolColor(UIKitBrush.solid(
                                when(remain) {
                                    in 0f..<0.1f -> getUIKitColors().errorRedColorPrimaryBrush
                                    in 0.1f..<0.3f -> getUIKitColors().warningYellowColorPrimaryBrush
                                    in 0.3f..1f -> getUIKitColors().successGreenColorPrimaryBrush
                                    else -> getUIKitColors().textFillColorPrimaryBrush
                                }
                            ), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "battery_border", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun progressibleEffect(
                progress: Float,
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                val progress = progress.coerceIn(0f, 1f)
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.translateXTo(
                        selector = UIKitSymbolSelector(this, "battery_remain", "remain"),
                        targetValue = -15f * (1f - progress),
                        animateSpec = null))
                    .addParallel(if (progress <= 0f) UIKitSymbolAnimNode.alphaTo(
                        selector = UIKitSymbolSelector(this, "battery_remain", "remain"),
                        targetValue = 0f,
                        animateSpec = null)
                    else UIKitSymbolAnimNode.alphaTo(
                        selector = UIKitSymbolSelector(this, "battery_remain", "remain"),
                        targetValue = 1f,
                        animateSpec = null))
            }

            override fun bounceEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
                coefficient: Float
            ): UIKitSymbolAnimTree? = null
        }

        return _Battery!!
    }

@Suppress("ObjectPropertyName")
private var _Battery: UIKitSymbol? = null