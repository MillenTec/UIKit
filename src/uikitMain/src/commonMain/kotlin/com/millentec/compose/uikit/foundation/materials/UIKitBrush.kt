package com.millentec.compose.uikit.foundation.materials

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.sign

data class UIKitBrush(
    val colorStops: List<Pair<Float, Color>>,
    val start: Offset = Offset.Zero,
    val end: Offset = Offset.Infinite,
) {
    fun asComposeBrush(): Brush {
        return if (colorStops.isEmpty()) {
            SolidColor(Color.Unspecified)
        } else if (colorStops.size == 1) {
            SolidColor(colorStops[0].second)
        } else {
            Brush.linearGradient(
                colorStops = colorStops.toTypedArray(),
                start = start,
                end = end,
            )
        }
    }

    companion object {
        fun solid(color: Color): UIKitBrush {
            return UIKitBrush(
                colorStops = listOf(Pair(0f, color)),
                start = Offset.Zero,
                end = Offset.Infinite,
            )
        }

        fun linearGradient(
            colors: List<Color>,
            start: Offset,
            end: Offset,
        ): UIKitBrush {
            val stopStep = 1f / colors.size
            return UIKitBrush(
                colorStops = colors.mapIndexed { index, color ->
                    Pair((index * stopStep).coerceIn(0f..1f), color)
                },
                start = start,
                end = end,
            )
        }
    }
}

class UIKitAnimateBrush(
    initialBrush: UIKitBrush,
) {
    private val stopPointsAnimated = initialBrush.colorStops.map {
        Animatable(
            initialValue = it.first,
            typeConverter = Float.VectorConverter,
        )
    }.toMutableList()

    private val colorsAnimated = initialBrush.colorStops.map {
        androidx.compose.animation.Animatable(
            initialValue = it.second
        )
    }.toMutableList()

    private val startAnimated = Animatable(
        initialValue = initialBrush.start,
        typeConverter = Offset.VectorConverter,
    )

    private val endAnimated = Animatable(
        initialValue = initialBrush.end,
        typeConverter = Offset.VectorConverter,
    )

    val value: UIKitBrush
        get() = UIKitBrush(
            colorStops = colorsAnimated.mapIndexed { index, color ->
                Pair(
                    first = stopPointsAnimated.getOrNull(index)?.value ?: 0f,
                    second = color.value,
                )
            },
            start = startAnimated.value,
            end = endAnimated.value
        )

    suspend fun snapTo(brush: UIKitBrush) {
        if (brush.colorStops.size == colorsAnimated.size) {
            coroutineScope {
                colorsAnimated.forEachIndexed { index, color ->
                    launch {
                        color.snapTo(brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified)
                    }
                }

                stopPointsAnimated.forEachIndexed { index, point ->
                    launch {
                        point.snapTo(brush.colorStops.getOrNull(index)?.first ?: 0f)
                    }
                }
            }
        } else {
            val diff = brush.colorStops.size - colorsAnimated.size
            if (diff.sign == 1) {
                repeat(diff) {
                    colorsAnimated.add(colorsAnimated[colorsAnimated.size - 1])
                    stopPointsAnimated.add(stopPointsAnimated[colorsAnimated.size - 1])
                }

                coroutineScope {
                    colorsAnimated.forEachIndexed { index, color ->
                        launch {
                            color.snapTo(brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified)
                        }
                    }

                    stopPointsAnimated.forEachIndexed { index, point ->
                        launch {
                            point.snapTo(brush.colorStops.getOrNull(index)?.first ?: 0f)
                        }
                    }
                }
            } else {
                coroutineScope {
                    stopPointsAnimated.filterIndexed { index, point ->
                        stopPointsAnimated.size - index < diff
                    }.forEach {
                        launch {
                            it.snapTo(1f)
                        }
                    }

                    colorsAnimated.forEachIndexed { index, color ->
                        launch {
                            color.snapTo(brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified)
                        }
                    }

                    stopPointsAnimated.forEachIndexed { index, point ->
                        launch {
                            point.snapTo(brush.colorStops.getOrNull(index)?.first ?: 0f)
                        }
                    }

                    repeat(abs(diff)) {
                        colorsAnimated.removeAt(colorsAnimated.size - 1)
                        stopPointsAnimated.removeAt(stopPointsAnimated.size - 1)
                    }
                }
            }
        }
    }

    suspend fun animateTo(
        brush: UIKitBrush,
        durationMillis: Int,
        easing: Easing,
    ) {
        if (brush.colorStops.size == colorsAnimated.size) {
            coroutineScope {
                colorsAnimated.forEachIndexed { index, color ->
                    launch {
                        color.animateTo(
                            brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified,
                            animationSpec = tween(
                                durationMillis = durationMillis,
                                easing = easing,
                            )
                        )
                    }
                }

                stopPointsAnimated.forEachIndexed { index, point ->
                    launch {
                        point.animateTo(
                            brush.colorStops.getOrNull(index)?.first ?: 0f,
                            animationSpec = tween(
                                durationMillis = durationMillis,
                                easing = easing,
                            )
                        )
                    }
                }
            }
        } else {
            val diff = brush.colorStops.size - colorsAnimated.size
            if (diff.sign == 1) {
                repeat(diff) {
                    colorsAnimated.add(colorsAnimated[colorsAnimated.size - 1])
                    stopPointsAnimated.add(stopPointsAnimated[colorsAnimated.size - 1])
                }

                coroutineScope {
                    colorsAnimated.forEachIndexed { index, color ->
                        launch {
                            color.animateTo(
                                brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified,
                                animationSpec = tween(
                                    durationMillis = durationMillis,
                                    easing = easing,
                                )
                            )
                        }
                    }

                    stopPointsAnimated.forEachIndexed { index, point ->
                        launch {
                            point.animateTo(
                                brush.colorStops.getOrNull(index)?.first ?: 0f,
                                animationSpec = tween(
                                    durationMillis = durationMillis,
                                    easing = easing,
                                )
                            )
                        }
                    }
                }
            } else {
                coroutineScope {
                    stopPointsAnimated.filterIndexed { index, point ->
                        stopPointsAnimated.size - index < diff
                    }.forEach {
                        launch {
                            it.animateTo(
                                1f,
                                animationSpec = tween(
                                    durationMillis = durationMillis,
                                    easing = easing,
                                )
                            )
                        }
                    }

                    colorsAnimated.forEachIndexed { index, color ->
                        launch {
                            color.animateTo(
                                brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified,
                                animationSpec = tween(
                                    durationMillis = durationMillis,
                                    easing = easing,
                                )
                            )
                        }
                    }

                    stopPointsAnimated.forEachIndexed { index, point ->
                        launch {
                            point.animateTo(
                                brush.colorStops.getOrNull(index)?.first ?: 0f,
                                animationSpec = tween(
                                    durationMillis = durationMillis,
                                    easing = easing,
                                )
                            )
                        }
                    }

                    repeat(abs(diff)) {
                        colorsAnimated.removeAt(colorsAnimated.size - 1)
                        stopPointsAnimated.removeAt(stopPointsAnimated.size - 1)
                    }
                }
            }
        }
    }
}
