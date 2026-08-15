package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolEffect
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitPathNode
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.symbols.regular.AddCircle
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
@Preview
private fun Preview() {
    UIKitIcon(
        modifier = Modifier
            .size(100.dp),
        symbol = UIKitSymbols.regular.AddCircle,
        contentDescription = "AddCircle",
        symbolStyle = UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush)
    )
}

@Composable
@Preview
private fun Preview2() {
    Icon(
        imageVector = UIKitSymbols.regular.AddCircle.toComposeVector(Color.White),
        contentDescription = "AddCircle",
        tint = Color.White,
    )
}

@Composable
fun UIKitIcon(
    modifier: Modifier = Modifier,
    symbol: UIKitSymbol,
    contentDescription: String?,
    symbolStyle: UIKitSymbolStyle = UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush),
    symbolEffect: UIKitSymbolEffect? = null,
) {
    val animStates = remember(symbol) { symbol.groups.map {
        UIKitSymbolAnimState(it.id)
    } }
    val colorSet by rememberUpdatedState(symbol.colorSet(symbolStyle))
    val symbolEffectTriggers = remember { mutableListOf<Any?>() }
    val builtPaths = remember { mutableStateOf(symbol.groups.map { group ->
        Pair(group.id, Path().apply {
            group.path.nodes.forEach { node ->
                when (node) {
                    UIKitPathNode.Close -> close()
                    is UIKitPathNode.CurveTo -> cubicTo(
                        node.x1,
                        node.y1,
                        node.x2,
                        node.y2,
                        node.x3,
                        node.y3,
                    )

                    is UIKitPathNode.LineTo -> lineTo(node.x, node.y)
                    is UIKitPathNode.MoveTo -> moveTo(node.x, node.y)
                }
            }
        })
    }) }

    LaunchedEffect(symbol.layers) {
        builtPaths.value = symbol.groups.map { group ->
            Pair(group.id, Path().apply {
                group.path.nodes.forEach { node ->
                    when (node) {
                        UIKitPathNode.Close -> close()
                        is UIKitPathNode.CurveTo -> cubicTo(
                            node.x1,
                            node.y1,
                            node.x2,
                            node.y2,
                            node.x3,
                            node.y3,
                        )

                        is UIKitPathNode.LineTo -> lineTo(node.x, node.y)
                        is UIKitPathNode.MoveTo -> moveTo(node.x, node.y)
                    }
                }
            })
        }
    }

    LaunchedEffect(symbolEffect) {
        symbolEffect?.effects?.forEachIndexed { index, effect ->
            val preTrigger = symbolEffectTriggers.getOrElse(index) {
                symbolEffectTriggers.add(null)
                null
            }
            symbolEffectTriggers[index] = effect.triggerCurrent

            if (preTrigger == null && effect.initializable) {
                effect.initialize(symbol, animStates)
            } else if (preTrigger != effect.triggerCurrent) {
                effect.execute(symbol, animStates)
            }
        }
    }

    Canvas(
        modifier = Modifier
            .defaultMinSize(symbol.defaultSize.width, symbol.defaultSize.height)
            .then(modifier)
            .semantics {
                this.contentDescription = contentDescription ?: return@semantics
                this.role = Role.Image
            }
    ) {
        var saveCount = 0
        scale(
            scaleX = size.width / symbol.viewportSize.width,
            scaleY = size.height / symbol.viewportSize.height,
            pivot = Offset(0f, 0f)
        ) {
            drawContext.canvas.saveLayer(
                bounds = Rect(
                    Offset.Zero,
                    symbol.viewportSize,
                ),
                paint = Paint()
            )
            saveCount++

            symbol.layers.forEach { layer ->
                val brush = colorSet.firstOrNull { it.selector == layer.id }?.brush ?: SolidColor(Color.Transparent)
                val alpha = colorSet.firstOrNull { it.selector == layer.id }?.alpha ?: 0f

                layer.groups.forEach { group ->
                    val animateState = animStates.firstOrNull {
                        it.id == group.id
                    }

                    val path = builtPaths.value.firstOrNull {
                        it.first == group.id
                    }?.second ?: Path()

                    val isRender = animateState != null && (animateState.alphaState.value > 0f
                            && animateState.scaleState.value > 0f
                            && animateState.pathTrimStartState.value - animateState.pathTrimEndState.value != 0f)

                    if (isRender) {
                        scale(
                            scale = animateState.scaleState.value,
                            pivot = Offset(
                                x = symbol.viewportSize.width / 2,
                                y = symbol.viewportSize.height / 2,
                            )
                        ) {
                            when (group.drawType) {
                                UIKitPathDrawType.Fill -> {
                                    drawPath(
                                        path = path,
                                        brush = brush,
                                        alpha = alpha * (animateState.alphaState.value),
                                        style = Fill
                                    )
                                }

                                is UIKitPathDrawType.Stroke -> {
                                    val pathMeasure = PathMeasure()
                                    pathMeasure.setPath(
                                        path = path,
                                        forceClosed = false
                                    )

                                    val length = pathMeasure.length

                                    val trimmedPath = Path()
                                    pathMeasure.getSegment(
                                        animateState.pathTrimStartState.value * length,
                                        animateState.pathTrimEndState.value * length,
                                        trimmedPath,
                                        true
                                    )

                                    drawPath(
                                        path = trimmedPath,
                                        brush = brush,
                                        alpha = alpha * animateState.alphaState.value,
                                        style = Stroke(
                                            width = group.drawType.lineWidth,
                                            cap = group.drawType.cap,
                                            join = group.drawType.join,
                                        )
                                    )
                                }

                                UIKitPathDrawType.MaskFilled -> {
                                    drawPath(
                                        path = path,
                                        color = Color.Transparent,
                                        alpha = alpha * animateState.alphaState.value,
                                        style = Fill,
                                        blendMode = BlendMode.DstIn
                                    )

                                    drawContext.canvas.saveLayer(
                                        bounds = Rect(
                                            Offset.Zero,
                                            symbol.viewportSize,
                                        ),
                                        paint = Paint()
                                    )
                                    saveCount++
                                }

                                is UIKitPathDrawType.MaskStroke -> {
                                    val pathMeasure = PathMeasure()
                                    pathMeasure.setPath(
                                        path = path,
                                        forceClosed = false
                                    )

                                    val length = pathMeasure.length

                                    val trimmedPath = Path()
                                    pathMeasure.getSegment(
                                        animateState.pathTrimStartState.value * length,
                                        animateState.pathTrimEndState.value * length,
                                        trimmedPath,
                                        true
                                    )

                                    drawPath(
                                        path = trimmedPath,
                                        color = Color.Transparent,
                                        alpha = alpha * animateState.alphaState.value,
                                        style = Stroke(
                                            width = group.drawType.lineWidth,
                                            cap = group.drawType.cap,
                                            join = group.drawType.join,
                                        ),
                                        blendMode = BlendMode.DstIn
                                    )

                                    drawContext.canvas.saveLayer(
                                        bounds = Rect(
                                            Offset.Zero,
                                            symbol.viewportSize,
                                        ),
                                        paint = Paint()
                                    )
                                    saveCount++
                                }
                            }
                        }
                    }
                }
            }
        }

        repeat(saveCount) {
            drawContext.canvas.restore()
        }
    }
}