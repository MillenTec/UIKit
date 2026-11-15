package com.millentec.compose.uikit.symbols.builtin.arrow

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitArrowSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitArrowSymbols.ArrowCircle: UIKitSymbol
    get() {
        if (_ArrowCircle != null)
            return _ArrowCircle!!
        _ArrowCircle = object : UIKitSymbol(
            name = "ArrowCircle",
            uid = "ic.arrow.circle",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("arrow") {
                    addGroup(
                        id = "arrow",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(10f, 6.5f)
                        lineTo(10f, 13.5f)
                        moveTo(7f, 9.5f)
                        lineTo(10f, 6.5f)
                        lineTo(13f, 9.5f)
                    }
                }
                addLayer("arrow_mask") {
                    addGroup(
                        id = "mask",
                        drawType = UIKitPathDrawType.MaskFilled
                    ) {
                        moveTo(0f, 0f)
                        verticalLineToRelative(20f)
                        horizontalLineToRelative(20f)
                        verticalLineTo(0f)
                        horizontalLineTo(0f)
                        close()
                        moveTo(15.3f, 15.3f)
                        curveToRelative(-1.36f, 1.36f, -3.23f, 2.2f, -5.3f, 2.2f)
                        reflectiveCurveToRelative(-3.95f, -0.84f, -5.3f, -2.2f)
                        reflectiveCurveToRelative(-2.2f, -3.23f, -2.2f, -5.3f)
                        reflectiveCurveToRelative(0.84f, -3.95f, 2.2f, -5.3f)
                        reflectiveCurveToRelative(3.23f, -2.2f, 5.3f, -2.2f)
                        reflectiveCurveToRelative(3.95f, 0.84f, 5.3f, 2.2f)
                        reflectiveCurveToRelative(2.2f, 3.23f, 2.2f, 5.3f)
                        reflectiveCurveToRelative(-0.84f, 3.95f, -2.2f, 5.3f)
                        close()
                    }
                }
                addLayer("circle_inactive") {
                    addGroup(
                        id = "circle",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(10f, 2.5f)
                        curveToRelative(2.07f, 0f, 3.95f, 0.84f, 5.3f, 2.2f)
                        reflectiveCurveToRelative(2.2f, 3.23f, 2.2f, 5.3f)
                        reflectiveCurveToRelative(-0.84f, 3.95f, -2.2f, 5.3f)
                        reflectiveCurveToRelative(-3.23f, 2.2f, -5.3f, 2.2f)
                        reflectiveCurveToRelative(-3.95f, -0.84f, -5.3f, -2.2f)
                        reflectiveCurveToRelative(-2.2f, -3.23f, -2.2f, -5.3f)
                        reflectiveCurveToRelative(0.84f, -3.95f, 2.2f, -5.3f)
                        reflectiveCurveToRelative(3.23f, -2.2f, 5.3f, -2.2f)
                        close()
                    }
                }
                addLayer("circle_active") {
                    addGroup(
                        id = "circle",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(10f, 2.5f)
                        curveToRelative(2.07f, 0f, 3.95f, 0.84f, 5.3f, 2.2f)
                        reflectiveCurveToRelative(2.2f, 3.23f, 2.2f, 5.3f)
                        reflectiveCurveToRelative(-0.84f, 3.95f, -2.2f, 5.3f)
                        reflectiveCurveToRelative(-3.23f, 2.2f, -5.3f, 2.2f)
                        reflectiveCurveToRelative(-3.95f, -0.84f, -5.3f, -2.2f)
                        reflectiveCurveToRelative(-2.2f, -3.23f, -2.2f, -5.3f)
                        reflectiveCurveToRelative(0.84f, -3.95f, 2.2f, -5.3f)
                        reflectiveCurveToRelative(3.23f, -2.2f, 5.3f, -2.2f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce,
                    UIKitSymbolAbility.Progressable,
                    UIKitSymbolAbility.Rotatable,
                    UIKitSymbolAbility.VariableWeight
                )

            override val tags: List<String>
                get() = listOf(
                    "Arrow", "Direction"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return if (style is UIKitSymbolStyle.Monochrome)
                    mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "arrow", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "circle_active", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "circle_inactive", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 0f)
                        )
                    )
                else
                    UIKitSymbolColorSet(
                        style = style,
                        layerInfo = mapOf(
                            Pair(UIKitSymbolSelector(null, "arrow", null), 1f),
                            Pair(UIKitSymbolSelector(null, "circle_active", null), 1f),
                            Pair(UIKitSymbolSelector(null, "circle_inactive", null), 0.3f)
                        ),
                        multiColor = mapOf(
                            Pair(
                                UIKitSymbolSelector(null, "arrow", null),
                                UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                            ),
                            Pair(
                                UIKitSymbolSelector(null, "circle_active", null),
                                UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                            ),
                            Pair(
                                UIKitSymbolSelector(null, "circle_inactive", null),
                                UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().lineFillColorDisabledBrush), 1f)
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
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "circle_active", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "circle_active", null),
                        targetValue = progress,
                        animateSpec = null))
            }

            override fun bounceEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
                coefficient: Float
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addSequential(UIKitSymbolAnimNode.translateYTo(
                        selector = UIKitSymbolSelector(this, "arrow", null),
                        targetValue = -11.5f,
                        animateSpec = tween(200, easing = FastOutLinearInEasing)))
                    .addSequential(UIKitSymbolAnimNode.translateYTo(
                        selector = UIKitSymbolSelector(this, "arrow", null),
                        targetValue = 11.5f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.translateYTo(
                        selector = UIKitSymbolSelector(this, "arrow", null),
                        targetValue = 0f,
                        animateSpec = tween(400, easing = LinearOutSlowInEasing)))
            }

            override fun rotateEffect(
                angle: Float,
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.rotateTo(
                        selector = UIKitSymbolSelector(this, "arrow", null),
                        targetValue = angle,
                        animateSpec = null
                    ))
            }
        }

        return _ArrowCircle!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowCircle: UIKitSymbol? = null