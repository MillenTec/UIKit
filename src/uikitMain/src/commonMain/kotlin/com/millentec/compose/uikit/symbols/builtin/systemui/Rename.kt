package com.millentec.compose.uikit.symbols.builtin.systemui

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

val UIKitSystemUISymbols.Rename: UIKitSymbol
    get() {
        if (_Rename != null)
            return _Rename!!
        _Rename = object : UIKitSymbol(
            name = "Rename",
            uid = "ic.sys.rename",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("border", 0) {
                    addGroup(
                        id = "border",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(5f, 4.5f)
                        horizontalLineToRelative(10f)
                        curveToRelative(0.69f, 0f, 1.32f, 0.28f, 1.77f, 0.73f)
                        reflectiveCurveToRelative(0.73f, 1.08f, 0.73f, 1.77f)
                        verticalLineToRelative(6f)
                        curveToRelative(0f, 0.69f, -0.28f, 1.32f, -0.73f, 1.77f)
                        reflectiveCurveToRelative(-1.08f, 0.73f, -1.77f, 0.73f)
                        horizontalLineTo(5f)
                        curveToRelative(-0.69f, 0f, -1.32f, -0.28f, -1.77f, -0.73f)
                        reflectiveCurveToRelative(-0.73f, -1.08f, -0.73f, -1.77f)
                        verticalLineToRelative(-6f)
                        curveToRelative(0f, -0.69f, 0.28f, -1.32f, 0.73f, -1.77f)
                        reflectiveCurveToRelative(1.08f, -0.73f, 1.77f, -0.73f)
                        close()
                    }
                }
                addLayer("letter", 1) {
                    addGroup(
                        id = "letter",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(5.67f, 10.5f)
                        horizontalLineToRelative(3.67f)
                        moveTo(4.75f, 12.5f)
                        lineToRelative(2.75f, -6f)
                        lineToRelative(2.75f, 6f)
                    }
                }
                addLayer("cursor", 2) {
                    addGroup(
                        id = "mask",
                        drawType = UIKitPathDrawType.MaskStroke(3f)
                    ) {
                        moveTo(12.5f, 2.5f)
                        lineTo(12.5f, 17.5f)
                    }
                    addGroup(
                        id = "cursor",
                        zIndex = 1,
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(10.5f, 2.5f)
                        horizontalLineToRelative(4f)
                        moveTo(12.5f, 2.5f)
                        verticalLineToRelative(15f)
                        moveTo(10.5f, 17.5f)
                        horizontalLineToRelative(4f)
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
                    "Rename", "Name", "Modifier", "Edit", "Compose"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "border", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "letter", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "cursor", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "border", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "letter", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "cursor", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun bounceEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
                coefficient: Float
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.translateXTo(
                        selector = UIKitSymbolSelector(this, "cursor", null),
                        targetValue = -7.75f,
                        animateSpec = tween(300, easing = FastOutSlowInEasing)))
                    .addSequential(UIKitSymbolAnimNode.translateXTo(
                        selector = UIKitSymbolSelector(this, "cursor", null),
                        targetValue = 0f,
                        animateSpec = tween(400, delayMillis = 200, easing = FastOutSlowInEasing)))
            }
        }

        return _Rename!!
    }

@Suppress("ObjectPropertyName")
private var _Rename: UIKitSymbol? = null