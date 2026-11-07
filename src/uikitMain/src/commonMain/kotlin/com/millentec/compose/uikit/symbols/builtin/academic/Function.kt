package com.millentec.compose.uikit.symbols.builtin.academic

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitAcademicSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitAcademicSymbols.Function: UIKitSymbol
    get() {
        if (_Function != null)
            return _Function!!
        _Function = object : UIKitSymbol(
            name = "Function",
            uid = "ic.academic.math.func",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("function") {
                    addGroup(
                        id = "stroke0",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4.5f, 7.47f)
                        lineTo(9.5f, 7.47f)
                    }
                    addGroup(
                        id = "stroke1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(10.5f, 2.87f)
                        curveToRelative(-0.21f, -0.3f, -3.3f, -1.18f, -3.59f, 2.31f)
                        curveToRelative(-0.25f, 3.74f, -0.51f, 8.69f, -0.51f, 8.69f)
                        curveToRelative(-0.07f, 1.33f, -0.42f, 4.53f, -3.9f, 3.2f)
                    }
                    addGroup(
                        id = "stroke2",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(9.6f, 10.12f)
                        curveToRelative(0.19f, -0.23f, 0.97f, -1.28f, 1.72f, -0.12f)
                        reflectiveCurveToRelative(3.49f, 6.13f, 3.49f, 6.13f)
                        curveToRelative(0f, 0f, 0.78f, 1.15f, 1.68f, -0.2f)
                    }
                    addGroup(
                        id = "stroke3",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(9.5f, 16.47f)
                        lineTo(16.5f, 9.47f)
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
                    "Function", "Formula", "Math", "f(x)"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "function", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "function", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    ),
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 1f,
                        animateSpec = tween(800, easing = FastOutSlowInEasing)
                    ))
            }

            override fun disappearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 1f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 1f,
                        animateSpec = tween(600, easing = FastOutLinearInEasing)
                    ))
            }
        }

        return _Function!!
    }

@Suppress("ObjectPropertyName")
private var _Function: UIKitSymbol? = null