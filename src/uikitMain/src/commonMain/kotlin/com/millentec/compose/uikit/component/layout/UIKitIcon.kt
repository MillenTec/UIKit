package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.SolidColor
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
    val animState = remember { mutableStateListOf<Pair<Int, UIKitSymbolAnimState>>() }
    val colorSet = symbol.colorSet(symbolStyle)
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

    LaunchedEffect(symbol) {
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

    LaunchedEffect(symbol) {
        animState.clear()
        symbol.groups.forEach {
            animState.add(Pair(it.id, UIKitSymbolAnimState()))
        }
    }

    LaunchedEffect(symbolEffect) {
        symbolEffect?.Execute(symbol, animState)
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
        scale(
            scaleX = size.width / symbol.viewportSize.width,
            scaleY = size.height / symbol.viewportSize.height,
            pivot = Offset(0f, 0f)
        ) {
            symbol.layers.forEachIndexed { index, layer ->
                layer.groups.forEach { group ->
                    val animateState = animState.firstOrNull {
                        it.first == group.id
                    }?.second
                    val brush = colorSet.getOrNull(index)?.first ?: SolidColor(Color.Transparent)
                    val alpha = colorSet.getOrNull(index)?.second ?: 0f

                    scale(
                        scale = animateState?.scaleState?.value ?: 1f,
                        pivot = Offset(
                            x = symbol.viewportSize.width / 2,
                            y = symbol.viewportSize.height / 2,
                        )
                    ) {
                        when (group.drawType) {
                            UIKitPathDrawType.Fill -> {
                                drawPath(
                                    path = builtPaths.value.firstOrNull { it.first == group.id }?.second ?: Path(),
                                    brush = brush,
                                    alpha = alpha * (animateState?.alphaState?.value ?: 1f),
                                    style = Fill
                                )
                            }

                            is UIKitPathDrawType.Stroke -> {
                                val pathMeasure = PathMeasure()
                                pathMeasure.setPath(
                                    path = builtPaths.value.firstOrNull { it.first == group.id }?.second ?: Path(),
                                    forceClosed = false
                                )

                                val length = pathMeasure.length

                                val trimmedPath = Path()
                                pathMeasure.getSegment(0f * length, 1f * length, trimmedPath, true)

                                drawPath(
                                    path = trimmedPath,
                                    brush = brush,
                                    alpha = alpha * (animateState?.alphaState?.value ?: 1f),
                                    style = Stroke(
                                        width = 1f,
                                        cap = group.drawType.cap,
                                        join = group.drawType.join,
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}