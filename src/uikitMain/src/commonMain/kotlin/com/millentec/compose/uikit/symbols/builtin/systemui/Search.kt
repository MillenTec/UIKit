package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.keyframes
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

val UIKitSystemUISymbols.Search: UIKitSymbol
    get() {
        if (_Search != null)
            return _Search!!
        _Search = object : UIKitSymbol(
            name = "Search",
            uid = "ic.sys.search",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("magnifying_glass_handle") {
                    addGroup(
                        id = "handle",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(13.74f, 13.74f)
                        lineTo(17.5f, 17.5f)
                    }
                }
                addLayer("magnifying_glass_lens") {
                    addGroup(
                        id = "mask",
                        drawType = UIKitPathDrawType.MaskFilled
                    ) {
                        moveTo(15.5f, 9.5f)
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
                    addGroup(
                        id = "lens",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(15.5f, 9.5f)
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
                    "Search", "Magnifying Glass", "Inquire", "Find", "Zoom"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "magnifying_glass_handle", null), 1f),
                        Pair(UIKitSymbolSelector(null, "magnifying_glass_lens", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "magnifying_glass_handle", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "magnifying_glass_lens", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun bounceEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
                coefficient: Float
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.scaleCenterXTo(
                        selector = UIKitSymbolSelector(this, "magnifying_glass_lens", null),
                        targetValue = viewportSize.width / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                        selector = UIKitSymbolSelector(this, "magnifying_glass_lens", null),
                        targetValue = viewportSize.height / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleTo(
                        selector = UIKitSymbolSelector(this, "magnifying_glass_lens", null),
                        targetValue = 1f,
                        animateSpec = keyframes {
                            durationMillis = 575

                            1f + 0.1f * coefficient at 200 using CubicBezierEasing(0f, 0f,0.382f, 1f)
                            1f - 0.05f * coefficient at 400 using CubicBezierEasing(0.382f, 1f, 0f, 0f)
                            1f at 500 using CubicBezierEasing(0f, 0f,0.382f, 1f)
                        }
                    ))
            }
        }

        return _Search!!
    }

@Suppress("ObjectPropertyName")
private var _Search: UIKitSymbol? = null