package com.millentec.compose.uikit.symbols.builtin.academic

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutLinearInEasing
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

val UIKitAcademicSymbols.Code: UIKitSymbol
    get() {
        if (_Code != null)
            return _Code!!
        _Code = object : UIKitSymbol(
            name = "Code",
            uid = "ic.academic.code",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("code") {
                    addGroup(
                        id = "stroke0",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(5.5f, 5.5f)
                        lineToRelative(-4f, 4.5f)
                        lineToRelative(4f, 4.5f)
                    }
                    addGroup(
                        id = "stroke1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(12.5f, 1.5f)
                        lineTo(7.5f, 18.5f)
                    }
                    addGroup(
                        id = "stroke2",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(14.5f, 5.5f)
                        lineToRelative(4f, 4.5f)
                        lineToRelative(-4f, 4.5f)
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
                    "Code", "Develop", "XML", "Mark"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "code", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "code", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    ),
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                val tree = UIKitSymbolAnimTree()

                groupsOrdered.forEachIndexed { index, group ->
                    tree.addParallel(UIKitSymbolAnimNode.scaleAdditionCenterXTo(
                        group.first,
                        targetValue = viewportSize.width / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleAdditionCenterYTo(
                        group.first,
                        targetValue = viewportSize.height / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleAdditionTo(
                        group.first,
                        targetValue = 1f,
                        animateSpec = tween(
                            280 / (groupsOrdered.size + 1) * 2,
                            easing = CubicBezierEasing(0f, 0f,0.382f, 1f),
                            delayMillis = index * 280 / (groupsOrdered.size + 1)
                        ),
                    )).addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                        group.first,
                        targetValue = 1f,
                        animateSpec = tween(
                            280 / (groupsOrdered.size + 1) * 2,
                            easing = CubicBezierEasing(0f, 0f,0.382f, 1f),
                            delayMillis = index * 280 / (groupsOrdered.size + 1)
                        )
                    ))
                }

                return tree
            }

            override fun disappearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                val tree = UIKitSymbolAnimTree()

                groupsOrdered.reversed().forEachIndexed { indexLayer, groups ->
                    tree.addParallel(UIKitSymbolAnimNode.scaleAdditionCenterXTo(
                        groups.first,
                        targetValue = viewportSize.width / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleAdditionCenterYTo(
                        groups.first,
                        targetValue = viewportSize.height / 2,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleAdditionTo(
                        groups.first,
                        targetValue = 0.8f,
                        animateSpec = tween(
                            280 / (groupsOrdered.size + 1) * 2,
                            easing = FastOutLinearInEasing,
                            delayMillis = indexLayer * 280 / (groupsOrdered.size + 1)
                        ),
                    )).addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                        groups.first,
                        targetValue = 0f,
                        animateSpec = tween(
                            280 / (groupsOrdered.size + 1) * 2,
                            easing = FastOutLinearInEasing,
                            delayMillis = indexLayer * 280 / (groupsOrdered.size + 1)
                        )
                    ))
                }

                return tree
            }
        }

        return _Code!!
    }

@Suppress("ObjectPropertyName")
private var _Code: UIKitSymbol? = null