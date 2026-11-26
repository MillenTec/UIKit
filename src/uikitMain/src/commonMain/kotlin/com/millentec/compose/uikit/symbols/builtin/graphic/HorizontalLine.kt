package com.millentec.compose.uikit.symbols.builtin.graphic

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitGraphicSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitGraphicSymbols.HorizontalLine: UIKitSymbol
    get() {
        if (_HorizontalLine != null)
            return _HorizontalLine!!
        _HorizontalLine = object : UIKitSymbol(
            name = "HorizontalLine",
            uid = "ic.graphic.line.h",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("h_line") {
                    addGroup(
                        id = "h_line",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4f, 10f)
                        lineTo(16f, 10f)
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
                    "Line", "Horizontal", "Minimize"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "h_line", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "h_line", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 0.5f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 0.5f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 0f,
                        animateSpec = tween(500, easing = FastOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutSlowInEasing)))
            }

            override fun disappearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 1f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 0.5f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "h_line", null),
                        targetValue = 0.5f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
            }
        }

        return _HorizontalLine!!
    }

@Suppress("ObjectPropertyName")
private var _HorizontalLine: UIKitSymbol? = null