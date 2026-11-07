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

val UIKitGraphicSymbols.Shapes: UIKitSymbol
    get() {
        if (_Shapes != null)
            return _Shapes!!
        _Shapes = object : UIKitSymbol(
            name = "Shapes",
            uid = "ic.graphic.shapes",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("shapes_circle") {
                    addGroup(
                        id = "circle",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(11.04f, 11.04f)
                        curveToRelative(-0.9f, 0.9f, -2.15f, 1.46f, -3.54f, 1.46f)
                        reflectiveCurveToRelative(-2.63f, -0.56f, -3.54f, -1.46f)
                        reflectiveCurveToRelative(-1.46f, -2.15f, -1.46f, -3.54f)
                        reflectiveCurveToRelative(0.56f, -2.63f, 1.46f, -3.54f)
                        reflectiveCurveToRelative(2.15f, -1.46f, 3.54f, -1.46f)
                        reflectiveCurveToRelative(2.63f, 0.56f, 3.54f, 1.46f)
                        reflectiveCurveToRelative(1.46f, 2.15f, 1.46f, 3.54f)
                        reflectiveCurveToRelative(-0.56f, 2.63f, -1.46f, 3.54f)
                        close()
                    }
                }

                addLayer(
                    id = "shapes_rect",
                    zIndex = 1,
                ) {
                    val path: UIKitPath.() -> Unit = {
                        moveTo(15.5f, 17.5f)
                        horizontalLineToRelative(-5f)
                        curveToRelative(-0.55f, 0f, -1.05f, -0.22f, -1.41f, -0.59f)
                        reflectiveCurveToRelative(-0.59f, -0.86f, -0.59f, -1.41f)
                        verticalLineToRelative(-5f)
                        curveToRelative(0f, -0.55f, 0.22f, -1.05f, 0.59f, -1.41f)
                        reflectiveCurveToRelative(0.86f, -0.59f, 1.41f, -0.59f)
                        horizontalLineToRelative(5f)
                        curveToRelative(0.55f, 0f, 1.05f, 0.22f, 1.41f, 0.59f)
                        reflectiveCurveToRelative(0.59f, 0.86f, 0.59f, 1.41f)
                        verticalLineToRelative(5f)
                        curveToRelative(0f, 0.55f, -0.22f, 1.05f, -0.59f, 1.41f)
                        reflectiveCurveToRelative(-0.86f, 0.59f, -1.41f, 0.59f)
                        close()
                    }

                    addGroup(
                        id = "rect_mask_border",
                        drawType = UIKitPathDrawType.MaskStroke(3f)
                    ) {
                        path()
                    }
                    addGroup(
                        id = "rect_mask",
                        drawType = UIKitPathDrawType.MaskFilled
                    ) {
                        path()
                    }
                    addGroup(
                        id = "rect",
                        zIndex = 1,
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        path()
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
                    "Shapes", "Graphic", "Geometry", "Circle", "Rectangle"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "shapes_circle", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "shapes_rect", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "shapes_circle", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "shapes_rect", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    ),
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                        selector = UIKitSymbolSelector(this, "shapes_rect", "rect_mask"),
                        targetValue = 1f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, null, null),
                        targetValue = 0f,
                        animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "shapes_rect", null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        selector = UIKitSymbolSelector(this, "shapes_circle", null),
                        targetValue = 1f,
                        animateSpec = tween(500, 120, easing = FastOutLinearInEasing)))
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
                        selector = UIKitSymbolSelector(this, "shapes_circle", null),
                        targetValue = 1f,
                        animateSpec = tween(500, easing = FastOutLinearInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                        selector = UIKitSymbolSelector(this, "shapes_rect", null),
                        targetValue = 1f,
                        animateSpec = tween(500, 120, easing = FastOutLinearInEasing)))
                    .addSequential(UIKitSymbolAnimNode.alphaAdditionTo(
                        selector = UIKitSymbolSelector(this, "shapes_rect", "rect_mask"),
                        targetValue = 0f,
                        animateSpec = null))
            }
        }

        return _Shapes!!
    }

@Suppress("ObjectPropertyName")
private var _Shapes: UIKitSymbol? = null