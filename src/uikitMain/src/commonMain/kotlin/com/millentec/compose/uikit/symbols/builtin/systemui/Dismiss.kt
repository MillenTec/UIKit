package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
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

val UIKitSystemUISymbols.Dismiss: UIKitSymbol
    get() {
        if (_Dismiss != null)
            return _Dismiss!!
        _Dismiss = object : UIKitSymbol(
            name = "Dismiss",
            uid = "ic.sys.dismiss",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("dismiss") {
                    addGroup(
                        id = "line0",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4.5f, 15.5f)
                        lineTo(15.5f, 4.5f)
                    }
                    addGroup(
                        id = "line1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4.5f, 4.5f)
                        lineTo(15.5f, 15.5f)
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
                    "Dismiss", "Close", "Error", "Failure"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "dismiss", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "dismiss", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0.5f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0.5f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0f,
                        animateSpec = tween(500, easing = FastOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutSlowInEasing)))
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
                        targetValue = 0.5f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0.5f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
            }
        }

        return _Dismiss!!
    }

@Suppress("ObjectPropertyName")
private var _Dismiss: UIKitSymbol? = null