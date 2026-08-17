package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.materials.UIKitAnimateBrush
import com.millentec.compose.uikit.foundation.materials.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolEffect
import com.millentec.compose.uikit.symbols.animate.visibleEffect
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitPathNode
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.symbols.regular.AddCircle
import com.millentec.compose.uikit.symbols.regular.Speaker
import com.millentec.compose.uikit.theme.getUIKitColors
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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
private fun UIKitIconSample() {
    UIKitIcon(
        modifier = Modifier
            .size(32.dp),
        symbol = UIKitSymbols.regular.Speaker,
        contentDescription = "Volume",
        symbolStyle = UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush),
        symbolEffect = UIKitSymbolEffect()
            .visibleEffect(true)
    )
}

@Composable
private fun UIKitAnimatableIcon(
    modifier: Modifier = Modifier,
    symbol: UIKitSymbol,
    contentDescription: String?,
    symbolStyle: UIKitSymbolStyle,
    symbolEffect: UIKitSymbolEffect,
) {
    val animStates = remember(symbol) { symbol.groups.map {
        UIKitSymbolAnimState(
            id = it.id,
            initialScale = it.defaultState.scale,
            initialAlpha = it.defaultState.alpha,
            initialPathTrimStart = it.defaultState.pathTrimStart,
            initialPathTrimEnd = it.defaultState.pathTrimEnd,
        )
    } }
    val colorSet by rememberUpdatedState(symbol.colorSet(symbolStyle, animStates.map { Pair(it.id, it.snapshot()) }))
    val colorsAnimated = remember { colorSet.map {
        Pair(it.selector, UIKitAnimateBrush(it.brush))
    }.toMutableStateList() }
    val alphasAnimated = remember { colorSet.map {
        Pair(it.selector, Animatable(it.alpha))
    }.toMutableStateList() }
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
    val cacheSymbolStyle = remember { mutableStateOf<UIKitSymbolStyle?>(null) }
    val animationScope = rememberCoroutineScope()

    LaunchedEffect(colorSet.size) {
        colorsAnimated.clear()
        colorsAnimated.addAll(colorSet.map {
            Pair(it.selector, UIKitAnimateBrush(it.brush))
        })
        alphasAnimated.clear()
        alphasAnimated.addAll(colorSet.map {
            Pair(it.selector, Animatable(it.alpha))
        })
    }

    LaunchedEffect(symbolStyle) {
        if (symbolStyle != cacheSymbolStyle.value) {
            coroutineScope {
                colorsAnimated.forEachIndexed { index, color ->
                    launch {
                        color.second.snapTo(colorSet.getOrNull(index)?.brush ?: color.second.value,)
                    }
                }

                alphasAnimated.forEachIndexed { index, alpha ->
                    launch {
                        alpha.second.snapTo(colorSet.getOrNull(index)?.alpha ?: alpha.second.value)
                    }
                }
            }
        }

        cacheSymbolStyle.value = symbolStyle
    }

    LaunchedEffect(colorSet) {
        coroutineScope {
            colorsAnimated.forEachIndexed { index, color ->
                launch {
                    val colorCurrent = colorSet.getOrNull(index)?.brush ?: color.second.value

                    if (colorCurrent != color.second.value) {
                        color.second.animateTo(
                            colorCurrent,
                            200,
                            LinearEasing
                        )
                    }
                }
            }

            alphasAnimated.forEachIndexed { index, alpha ->
                launch {
                    val alphaCurrent = colorSet.getOrNull(index)?.alpha ?: alpha.second.value

                    if (alphaCurrent != alpha.second.value) {
                        alpha.second.animateTo(
                            alphaCurrent,
                            animationSpec = tween(
                                200,
                                easing = LinearEasing
                            )
                        )
                    }
                }
            }
        }
    }

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

    LaunchedEffect(symbolEffect) {
        symbolEffect.effects.forEachIndexed { index, effect ->
            val preTrigger = symbolEffectTriggers.getOrElse(index) {
                symbolEffectTriggers.add(null)
                null
            }
            symbolEffectTriggers[index] = effect.triggerCurrent

            if (preTrigger == null && effect.initializable) {
                animationScope.launch {
                    effect.initialize(symbol, animStates)
                }
            } else if (preTrigger != effect.triggerCurrent && preTrigger != null) {
                animationScope.launch {
                    effect.execute(symbol, animStates)
                }
            }
        }
    }

    Canvas(
        modifier = modifier
            .size(symbol.defaultSize.width, symbol.defaultSize.height)
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
                val brush = colorsAnimated.firstOrNull { it.first == layer.id }?.second?.value ?: UIKitBrush.solid(Color.Transparent)
                val alpha = alphasAnimated.firstOrNull { it.first == layer.id }?.second?.value ?: 0f

                layer.groups.forEach { group ->
                    val animateState = animStates.firstOrNull {
                        it.id == group.id
                    }

                    val path = builtPaths.value.firstOrNull {
                        it.first == group.id
                    }?.second ?: Path()

                    val isRender = animateState != null && animateState.visible

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
                                        brush = brush.asComposeBrush(),
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
                                        brush = brush.asComposeBrush(),
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

@Composable
private fun UIKitStaticIcon(
    modifier: Modifier = Modifier,
    symbol: UIKitSymbol,
    contentDescription: String?,
    symbolStyle: UIKitSymbolStyle
) {
    val defaultStates = remember { symbol.groups.map { Pair(it.id, it.defaultState) } }
    val colorSet by rememberUpdatedState(symbol.colorSet(symbolStyle, defaultStates))
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

    Canvas(
        modifier = modifier
            .size(symbol.defaultSize.width, symbol.defaultSize.height)
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
                val brush = colorSet.firstOrNull { it.selector == layer.id }?.brush ?: UIKitBrush.solid(Color.Transparent)
                val alpha = colorSet.firstOrNull { it.selector == layer.id }?.alpha ?: 0f

                layer.groups.forEach { group ->

                    val path = builtPaths.value.firstOrNull {
                        it.first == group.id
                    }?.second ?: Path()

                    val isRender = group.defaultState.visible

                    if (isRender) {
                        scale(
                            scale = group.defaultState.scale,
                            pivot = Offset(
                                x = symbol.viewportSize.width / 2,
                                y = symbol.viewportSize.height / 2,
                            )
                        ) {
                            when (group.drawType) {
                                UIKitPathDrawType.Fill -> {
                                    drawPath(
                                        path = path,
                                        brush = brush.asComposeBrush(),
                                        alpha = alpha * group.defaultState.alpha,
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
                                        group.defaultState.pathTrimStart * length,
                                        group.defaultState.pathTrimEnd * length,
                                        trimmedPath,
                                        true
                                    )

                                    drawPath(
                                        path = trimmedPath,
                                        brush = brush.asComposeBrush(),
                                        alpha = alpha * group.defaultState.alpha,
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
                                        alpha = alpha * group.defaultState.alpha,
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
                                        group.defaultState.pathTrimStart * length,
                                        group.defaultState.pathTrimEnd * length,
                                        trimmedPath,
                                        true
                                    )

                                    drawPath(
                                        path = trimmedPath,
                                        color = Color.Transparent,
                                        alpha = alpha * group.defaultState.alpha,
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

@Composable
private fun UIKitImageVectorIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String?,
    tint: Color,
) {
    Icon(
        modifier = modifier,
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint,
    )
}

/**
 * 用于渲染 UIKitSymbol 的可组合项
 * @param modifier 作用于绘制图标的 Canvas 的修改器, 你可以通过 size 属性改变图标的尺寸
 * @param symbol 绘制的图标源
 * @param contentDescription 用于无障碍功能的图标语义信息, 传入 null 则不包含语义信息
 * @param symbolStyle 图标的着色模式
 * @param symbolEffect 图标动态效果, 传入 null 则无动态效果, 按图标的默认配置渲染
 * @sample UIKitIconSample
 */
@Composable
fun UIKitIcon(
    modifier: Modifier = Modifier,
    symbol: UIKitSymbol,
    contentDescription: String?,
    symbolStyle: UIKitSymbolStyle = UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush),
    symbolEffect: UIKitSymbolEffect? = null,
) {
    if (symbol is UIKitImageVectorSymbol) {
        val tint = when (symbolStyle) {
            is UIKitSymbolStyle.Monochrome -> symbolStyle.brush.colorStops.getOrNull(0)?.second ?: Color.Unspecified
            else -> Color.Unspecified
        }

        UIKitImageVectorIcon(
            modifier = modifier,
            imageVector = symbol.imageVector,
            contentDescription = contentDescription,
            tint = tint,
        )
    } else if (symbolEffect == null || symbolEffect.effects.isEmpty()) {
        UIKitStaticIcon(
            modifier = modifier,
            symbol = symbol,
            contentDescription = contentDescription,
            symbolStyle = symbolStyle,
        )
    } else {
        UIKitAnimatableIcon(
            modifier = modifier,
            symbol = symbol,
            contentDescription = contentDescription,
            symbolStyle = symbolStyle,
            symbolEffect = symbolEffect,
        )
    }
}