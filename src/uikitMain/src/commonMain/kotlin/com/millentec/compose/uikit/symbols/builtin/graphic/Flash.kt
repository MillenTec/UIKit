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

val UIKitGraphicSymbols.Flash: UIKitSymbol
    get() {
        if (_Flash != null)
            return _Flash!!
        _Flash = object : UIKitSymbol(
            name = "Flash",
            uid = "ic.graphic.flash",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("flash") {
                    addGroup(
                        id = "flash",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(7.21f, 2.5f)
                        horizontalLineToRelative(5.25f)
                        curveToRelative(0.39f, 0f, 0.66f, 0.38f, 0.53f, 0.75f)
                        lineToRelative(-1.45f, 4.12f)
                        curveToRelative(-0.02f, 0.07f, 0.03f, 0.13f, 0.09f, 0.13f)
                        horizontalLineToRelative(3.15f)
                        curveToRelative(0.5f, 0f, 0.75f, 0.6f, 0.4f, 0.95f)
                        lineToRelative(-8.7f, 8.88f)
                        curveToRelative(-0.4f, 0.41f, -1.08f, 0.03f, -0.94f, -0.53f)
                        lineToRelative(1.3f, -5.18f)
                        curveToRelative(0.02f, -0.06f, -0.03f, -0.12f, -0.1f, -0.12f)
                        horizontalLineToRelative(-1.78f)
                        curveToRelative(-0.37f, 0f, -0.64f, -0.36f, -0.54f, -0.71f)
                        lineToRelative(2.25f, -7.88f)
                        curveToRelative(0.07f, -0.24f, 0.29f, -0.41f, 0.54f, -0.41f)
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
                    "Flash", "Motion", "Lightning", "Electricity",  "Fast", "Quick", "Swift"
                )
            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "flash", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "flash", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().yellowThemedBrush), 1f)
                        )
                    ),
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree {
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

            override fun disappearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree {
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

        return _Flash!!
    }

@Suppress("ObjectPropertyName")
private var _Flash: UIKitSymbol? = null