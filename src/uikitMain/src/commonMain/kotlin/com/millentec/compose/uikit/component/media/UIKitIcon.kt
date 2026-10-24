package com.millentec.compose.uikit.component.media

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitAnimateBrush
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolEffect
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolEffectNode
import com.millentec.compose.uikit.symbols.animate.visibleEffect
import com.millentec.compose.uikit.symbols.builtin.systemui.Bluetooth
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
@Preview
private fun Preview() {
    UIKitIcon(
//        modifier = Modifier
//            .size(100.dp),
        symbol = UIKitSymbols.systemUI.Bluetooth,
        contentDescription = "AddCircle",
        symbolStyle = UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush)
    )
}

@Composable
@Preview
private fun Preview2() {
    Icon(
        imageVector = UIKitSymbols.systemUI.Bluetooth.toComposeVector(Color.White),
        contentDescription = "AddCircle",
        tint = Color.White,
    )
}

@Composable
private fun UIKitIconSample() {
    UIKitIcon(
        modifier = Modifier
            .size(32.dp),
        symbol = UIKitSymbols.systemUI.Bluetooth,
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
    val animStates = remember(symbol) {
        symbol.groups.map {
            Pair(
                it.key, UIKitSymbolAnimState(
                    initialScale = it.value.defaultState.scale,
                    initialAlpha = it.value.defaultState.alpha,
                    initialPathTrimStart = it.value.defaultState.pathTrimStart,
                    initialPathTrimEnd = it.value.defaultState.pathTrimEnd,
                    initialScaleCenter = it.value.defaultState.scaleCenter,
                    initialRotate = it.value.defaultState.rotate,
                    initialRotateCenter = it.value.defaultState.rotateCenter,
                    initialTranslate = it.value.defaultState.translate,
                )
            )
        }.toMutableStateMap()
    }
    val colorSet by rememberUpdatedState(
        symbol.colorSet(
            symbolStyle,
            animStates.map { Pair(it.key, it.value.snapshot()) }.toMap()
        )
    )
    val colorsAnimated = remember {
        colorSet.map {
            Pair(it.key, UIKitAnimateBrush(it.value.brush))
        }.toMutableStateMap()
    }
    val alphasAnimated = remember {
        colorSet.map {
            Pair(it.key, Animatable(it.value.alpha))
        }.toMutableStateMap()
    }
    val builtPaths = remember(symbol) { mutableStateOf(symbol.builtPaths) }
    val cacheSymbolStyle = remember { mutableStateOf<UIKitSymbolStyle?>(null) }

    LaunchedEffect(colorSet) {
        colorsAnimated.clear()
        colorsAnimated.putAll(colorSet.map {
            Pair(it.key, UIKitAnimateBrush(it.value.brush))
        })
        alphasAnimated.clear()
        alphasAnimated.putAll(colorSet.map {
            Pair(it.key, Animatable(it.value.alpha))
        })
    }

    LaunchedEffect(symbolStyle) {
        if (symbolStyle != cacheSymbolStyle.value) {
            coroutineScope {
                colorsAnimated.forEach { color ->
                    launch {
                        color.value.snapTo(colorSet[color.key]?.brush ?: color.value.value)
                    }
                }

                alphasAnimated.forEach { alpha ->
                    launch {
                        alpha.value.snapTo(colorSet[alpha.key]?.alpha ?: alpha.value.value)
                    }
                }
            }
        }

        cacheSymbolStyle.value = symbolStyle
    }

    LaunchedEffect(colorSet) {
        coroutineScope {
            colorsAnimated.forEach { color ->
                launch {
                    val colorCurrent = colorSet[color.key]?.brush ?: color.value.value

                    if (colorCurrent != color.value.value) {
                        color.value.animateTo(
                            colorCurrent,
                            200,
                            easing = LinearEasing
                        )
                    }
                }
            }

            alphasAnimated.forEach { alpha ->
                launch {
                    val alphaCurrent = colorSet[alpha.key]?.alpha ?: alpha.value.value

                    if (alphaCurrent != alpha.value.value) {
                        alpha.value.animateTo(
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

    symbolEffect.effects.forEach { effect ->
        when (effect) {
            is UIKitSymbolEffectNode.UIKitDiscreteEffectNode<*> -> {
                val isInitialized = remember(effect.uuid) { mutableStateOf(false) }

                LaunchedEffect(effect.uuid, effect.triggerCurrent) {
                    if (!isInitialized.value) {
                        isInitialized.value = true
                        if (effect.initializable) {
                            effect.initialize?.invoke(symbol, animStates)
                        }
                    } else {
                        repeat(effect.repeat) {
                            effect.execute(symbol, animStates)
                        }
                    }
                }
            }

            is UIKitSymbolEffectNode.UIKitInfiniteEffectNode -> {
                LaunchedEffect(effect.isActive) {
                    if (effect.isActive) {
                        val isSupported = effect.start(symbol, animStates)
                        if (isSupported) {
                            while (true) {
                                effect.execute(symbol, animStates)
                                withFrameNanos { }
                            }
                        }
                    } else {
                        effect.reset(symbol, animStates)
                    }
                }
            }

            UIKitSymbolEffectNode.UIKitEmptyEffectNode -> {}
        }
    }

    Canvas(
        modifier = modifier.then(
            Modifier
                .aspectRatio(symbol.defaultSize.width / symbol.defaultSize.height)
                .size(symbol.defaultSize.width, symbol.defaultSize.height)
                .semantics {
                    this.contentDescription = contentDescription ?: return@semantics
                    this.role = Role.Image
                }
        )
    ) {
        var saveCount = 0
        val scaleX = size.width / symbol.viewportSize.width
        val scaleY = size.height / symbol.viewportSize.height
        scale(
            scaleX = scaleX,
            scaleY = scaleY,
            pivot = Offset(0f, 0f)
        ) {
            if (symbol.groups.any {
                    it.value.drawType is UIKitPathDrawType.MaskFilled || it.value.drawType is UIKitPathDrawType.MaskStroke
                }) {
                drawContext.canvas.saveLayer(
                    bounds = Rect(
                        Offset.Zero,
                        symbol.viewportSize,
                    ),
                    paint = Paint()
                )
                saveCount++
            }

            symbol.groupsOrdered.forEach { group ->
                val brush = colorsAnimated.entries.firstOrNull {
                    (it.key.symbol == group.first.symbol || it.key.symbol == null)
                            && (it.key.layer == group.first.layer || it.key.layer == null)
                            && (it.key.group == group.first.group || it.key.group == null)
                }?.value?.value ?: UIKitBrush.solid(Color.Transparent)
                val alpha = alphasAnimated.entries.firstOrNull {
                    (it.key.symbol == group.first.symbol || it.key.symbol == null)
                            && (it.key.layer == group.first.layer || it.key.layer == null)
                            && (it.key.group == group.first.group || it.key.group == null)
                }?.value?.value ?: 0f

                val animateState = animStates[group.first]
                val path = builtPaths.value[group.first] ?: Path()

                val isRender = animateState != null && animateState.visible

                if (isRender) {
                    val brushScaled = brush.copy(
                        start = Offset(
                            brush.start.x.coerceIn(0f..symbol.viewportSize.width) * 2,
                            brush.start.y.coerceIn(0f..symbol.viewportSize.height) * 2
                        ),
                        end = Offset(
                            brush.end.x.coerceIn(0f..symbol.viewportSize.width) * 2,
                            brush.end.y.coerceIn(0f..symbol.viewportSize.height) * 2
                        )
                    )

                    scale(
                        scale = animateState.scaleState.value,
                        pivot = Offset(
                            x = animateState.scaleCenterXState.value,
                            y = animateState.scaleCenterYState.value,
                        )
                    ) {
                        scale(
                            scale = animateState.scaleAdditionState.value,
                            pivot = Offset(
                                x = animateState.scaleAdditionCenterX.value,
                                y = animateState.scaleAdditionCenterY.value
                            )
                        ) {
                            translate(
                                left = animateState.translateXState.value,
                                top = animateState.translateYState.value,
                            ) {
                                rotate(
                                    degrees = animateState.rotateState.value,
                                    pivot = Offset(
                                        x = animateState.rotateCenterXState.value,
                                        y = animateState.rotateCenterYState.value
                                    )
                                ) {
                                    when (val drawType = group.second.drawType) {
                                        UIKitPathDrawType.Fill -> {
                                            drawPath(
                                                path = path,
                                                brush = brushScaled.asComposeBrush(),
                                                alpha = alpha * animateState.alphaState.value * animateState.alphaAdditionState.value,
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
                                                brush = brushScaled.asComposeBrush(),
                                                alpha = alpha * animateState.alphaState.value * animateState.alphaAdditionState.value,
                                                style = Stroke(
                                                    width = drawType.lineWidth,
                                                    cap = drawType.cap,
                                                    join = drawType.join,
                                                )
                                            )
                                        }

                                        UIKitPathDrawType.MaskFilled -> {
                                            drawPath(
                                                path = path,
                                                color = Color.Transparent,
                                                alpha = alpha * animateState.alphaState.value * animateState.alphaAdditionState.value,
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
                                                alpha = alpha * animateState.alphaState.value * animateState.alphaAdditionState.value,
                                                style = Stroke(
                                                    width = drawType.lineWidth,
                                                    cap = drawType.cap,
                                                    join = drawType.join,
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
    val defaultStates = remember(symbol) { symbol.groups.map { Pair(it.key, it.value.defaultState) }.toMutableStateMap() }
    val colorSet by rememberUpdatedState(symbol.colorSet(symbolStyle, defaultStates))
    val builtPaths = remember(symbol) { mutableStateOf(symbol.builtPaths) }

    Canvas(
        modifier = modifier.then(
            Modifier
                .aspectRatio(symbol.defaultSize.width / symbol.defaultSize.height)
                .size(symbol.defaultSize.width, symbol.defaultSize.height)
                .semantics {
                    this.contentDescription = contentDescription ?: return@semantics
                    this.role = Role.Image
                }
        )
    ) {
        var saveCount = 0
        scale(
            scaleX = size.width / symbol.viewportSize.width,
            scaleY = size.height / symbol.viewportSize.height,
            pivot = Offset(0f, 0f)
        ) {
            if (symbol.groups.any {
                    it.value.drawType is UIKitPathDrawType.MaskFilled || it.value.drawType is UIKitPathDrawType.MaskStroke
                }) {
                drawContext.canvas.saveLayer(
                    bounds = Rect(
                        Offset.Zero,
                        symbol.viewportSize,
                    ),
                    paint = Paint()
                )
                saveCount++
            }

            symbol.groupsOrdered.forEach { group ->
                val brush = colorSet.entries.firstOrNull {
                    (it.key.symbol == group.first.symbol || it.key.symbol == null)
                            && (it.key.layer == group.first.layer || it.key.layer == null)
                            && (it.key.group == group.first.group || it.key.group == null)
                }?.value?.brush ?: UIKitBrush.solid(Color.Transparent)
                val alpha = colorSet.entries.firstOrNull {
                    (it.key.symbol == group.first.symbol || it.key.symbol == null)
                            && (it.key.layer == group.first.layer || it.key.layer == null)
                            && (it.key.group == group.first.group || it.key.group == null)
                }?.value?.alpha ?: 0f

                val path = builtPaths.value[group.first] ?: Path()
                val isRender = group.second.defaultState.visible

                if (isRender) {
                    val brushScaled = brush.copy(
                        start = Offset(
                            brush.start.x.coerceIn(0f..symbol.viewportSize.width) * 2,
                            brush.start.y.coerceIn(0f..symbol.viewportSize.height) * 2
                        ),
                        end = Offset(
                            brush.end.x.coerceIn(0f..symbol.viewportSize.width) * 2,
                            brush.end.y.coerceIn(0f..symbol.viewportSize.height) * 2
                        )
                    )

                    scale(
                        scale = group.second.defaultState.scale,
                        pivot = Offset(
                            x = symbol.viewportSize.width / 2,
                            y = symbol.viewportSize.height / 2,
                        )
                    ) {
                        when (val drawType = group.second.drawType) {
                            UIKitPathDrawType.Fill -> {
                                drawPath(
                                    path = path,
                                    brush = brushScaled.asComposeBrush(),
                                    alpha = alpha * group.second.defaultState.alpha,
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
                                    group.second.defaultState.pathTrimStart * length,
                                    group.second.defaultState.pathTrimEnd * length,
                                    trimmedPath,
                                    true
                                )

                                drawPath(
                                    path = trimmedPath,
                                    brush = brushScaled.asComposeBrush(),
                                    alpha = alpha * group.second.defaultState.alpha,
                                    style = Stroke(
                                        width = drawType.lineWidth,
                                        cap = drawType.cap,
                                        join = drawType.join,
                                    )
                                )
                            }

                            UIKitPathDrawType.MaskFilled -> {
                                drawPath(
                                    path = path,
                                    color = Color.Transparent,
                                    alpha = alpha * group.second.defaultState.alpha,
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
                                    group.second.defaultState.pathTrimStart * length,
                                    group.second.defaultState.pathTrimEnd * length,
                                    trimmedPath,
                                    true
                                )

                                drawPath(
                                    path = trimmedPath,
                                    color = Color.Transparent,
                                    alpha = alpha * group.second.defaultState.alpha,
                                    style = Stroke(
                                        width = drawType.lineWidth,
                                        cap = drawType.cap,
                                        join = drawType.join,
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