package com.millentec.compose.uikit.symbols.builtin.language

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitLanguageSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitLanguageSymbols.Japanese: UIKitSymbol
    get() {
        if (_Japanese != null)
            return _Japanese!!
        _Japanese = object : UIKitSymbol(
            name = "Bluetooth",
            uid = "ic.lang.jajp",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("text_a") {
                    addGroup(
                        id = "stroke0",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(8.7f, 3.76f)
                        reflectiveCurveToRelative(-1.11f, 7.91f, 0.42f, 10.96f)
                    }
                    addGroup(
                        id = "stroke1",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(14.08f, 5.1f)
                        curveToRelative(-4.6f, 0.99f, -9.07f, 0.53f, -9.07f, 0.53f)
                    }
                    addGroup(
                        id = "stroke2",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(11.22f, 15.39f)
                        curveToRelative(3.43f, -0.41f, 5.64f, -4.16f, 3.06f, -6.23f)
                        curveToRelative(-4.62f, -3.71f, -12.02f, 3.02f, -9.1f, 5.2f)
                        curveToRelative(1.38f, 1.03f, 5.93f, -1.46f, 7.45f, -7.3f)
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
                    "Japanese", "Language", "Text", "A", "Hiragana"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(this, "text_a", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(this, "text_a", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun appearEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "text_a", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "text_a", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "text_a", null),
                        targetValue = 1f,
                        animateSpec = tween(800, easing = FastOutSlowInEasing)))
            }

            override fun disappearEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "text_a", null),
                        targetValue = 1f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "text_a", null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "text_a", null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
            }
        }

        return _Japanese!!
    }

@Suppress("ObjectPropertyName")
private var _Japanese: UIKitSymbol? = null