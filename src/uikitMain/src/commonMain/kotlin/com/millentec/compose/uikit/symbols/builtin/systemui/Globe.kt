package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.*
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

val UIKitSystemUISymbols.Globe: UIKitSymbol
    get() {
        if (_Globe != null)
            return _Globe!!
        _Globe = object : UIKitSymbol(
            name = "Globe",
            uid = "ic.sys.globe",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("globe_curves") {
                    addGroup(
                        id = "curve0",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(10f, 17.5f)
                        curveToRelative(-1.75f, 0f, -3.5f, -3.02f, -3.5f, -7.5f)
                        reflectiveCurveToRelative(1.75f, -7.5f, 3.5f, -7.5f)
                    }
                    addGroup(
                        id = "curve1",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f),
                    ) {
                        moveTo(10f, 17.5f)
                        curveToRelative(1.75f, 0f, 3.5f, -3.02f, 3.5f, -7.5f)
                        reflectiveCurveToRelative(-1.75f, -7.5f, -3.5f, -7.5f)
                    }
                }
                addLayer("globe_h_lines"){
                    addGroup(
                        id = "horizontal_line0",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(3.12f, 13f)
                        lineTo(16.88f, 13f)
                    }
                    addGroup(
                        id = "horizontal_line1",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(3.12f, 7f)
                        lineTo(16.88f, 7f)
                    }
                }
                addLayer("globe_border") {
                    addGroup(
                        id = "border",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(17.5f, 10f)
                        curveToRelative(0f, 2.07f, -0.84f, 3.95f, -2.2f, 5.3f)
                        reflectiveCurveToRelative(-3.23f, 2.2f, -5.3f, 2.2f)
                        reflectiveCurveToRelative(-3.95f, -0.84f, -5.3f, -2.2f)
                        reflectiveCurveToRelative(-2.2f, -3.23f, -2.2f, -5.3f)
                        reflectiveCurveToRelative(0.84f, -3.95f, 2.2f, -5.3f)
                        reflectiveCurveToRelative(3.23f, -2.2f, 5.3f, -2.2f)
                        reflectiveCurveToRelative(3.95f, 0.84f, 5.3f, 2.2f)
                        reflectiveCurveToRelative(2.2f, 3.23f, 2.2f, 5.3f)
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
                    "Globe", "Earth", "World", "Web", "Internet",
                    "Localization", "Internationalization", "i18n", "Language"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "globe", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "globe", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun appearEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_border", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_border", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_curves", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_curves", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 0.5f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 0.5f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_border", null),
                        targetValue = 1f,
                        animateSpec = tween(800, easing = FastOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_curves", null),
                        targetValue = 1f,
                        animateSpec = tween(800, easing = FastOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 0f,
                        animateSpec = tween(800, easing = FastOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 1f,
                        animateSpec = tween(800, easing = FastOutSlowInEasing)))
            }

            override fun disappearEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_border", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_border", null),
                        targetValue = 1f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_curves", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_curves", null),
                        targetValue = 1f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 1f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_border", null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_curves", null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 0.5f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "globe_h_lines", null),
                        targetValue = 0.5f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
            }

            override fun bounceEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
                coefficient: Float
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.scaleCenterXTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = viewportSize.width / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = viewportSize.height / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleTo(
                        selector = UIKitSymbolSelector(this, null, null),
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

        return _Globe!!
    }

@Suppress("ObjectPropertyName")
private var _Globe: UIKitSymbol? = null