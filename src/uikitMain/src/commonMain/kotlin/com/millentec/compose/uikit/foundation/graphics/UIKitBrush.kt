package com.millentec.compose.uikit.foundation.graphics

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.lerp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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
            start: Offset = Offset.Zero,
            end: Offset = Offset.Infinite,
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

/*
 * AIGC: 该类部分内容使用人工智能生成
 * - Time: 2026.9.6-13:02
 * - Model: MiMo V2.5
 * - Type: Agent
 * - State: Reviewed
 */
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
        Animatable(
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

    /**
     * 获取当前动画状态下的停止点列表（按位置升序排列）。
     * 用于在调整停止点数量时，从当前渐变中采样颜色。
     */
    private fun currentStops(): List<Pair<Float, Color>> {
        return colorsAnimated.mapIndexed { index, color ->
            Pair(stopPointsAnimated[index].value, color.value)
        }.sortedBy { it.first }
    }

    /**
     * 在渐变中指定位置采样颜色。
     * 遍历停止点列表，找到包含目标位置的相邻区间，
     * 使用线性插值（lerp）计算该位置的颜色值。
     * 位置超出范围时，返回最近端点的颜色。
     */
    private fun sampleColor(stops: List<Pair<Float, Color>>, position: Float): Color {
        if (stops.isEmpty()) return Color.Unspecified
        if (stops.size == 1) return stops[0].second

        // 将位置限制在停止点覆盖的范围内
        val clampedPos = position.coerceIn(stops.first().first, stops.last().first)

        // 位置在第一个停止点之前或恰好在其上
        if (clampedPos <= stops.first().first) return stops.first().second
        // 位置在最后一个停止点之后或恰好在其上
        if (clampedPos >= stops.last().first) return stops.last().second

        // 遍历相邻停止点对，找到包含目标位置的区间
        for (i in 0 until stops.size - 1) {
            val current = stops[i]
            val next = stops[i + 1]
            if (clampedPos >= current.first && clampedPos <= next.first) {
                val range = next.first - current.first
                if (range <= 0f) return current.second
                // 计算插值比例并线性插值颜色
                val fraction = (clampedPos - current.first) / range
                return lerp(current.second, next.second, fraction)
            }
        }

        return stops.last().second
    }

    /**
     * 调整内部动画列表以匹配目标停止点数量。
     *
     * 当停止点数量增加时：
     *   - 新增的停止点使用目标位置
     *   - 颜色从当前渐变中在目标位置采样，确保视觉连贯
     *
     * 当停止点数量减少时：
     *   - 直接缩减到目标数量，位置和颜色均从当前渐变采样
     *
     * 这样做的好处是：位置立即跳变到目标值，而颜色平滑过渡，
     * 避免了位置滑动导致的视觉抖动。
     */
    private fun resizeAnimatedLists(targetStops: List<Pair<Float, Color>>) {
        val currentSize = colorsAnimated.size
        val targetSize = targetStops.size
        if (currentSize == targetSize) return

        val currentStops = currentStops()

        if (targetSize > currentSize) {
            // 增加停止点：在末尾追加新的 Animatable（已有的不变，Canvas 依赖不受影响）
            repeat(targetSize - currentSize) { i ->
                val targetIndex = currentSize + i
                val targetPos = targetStops[targetIndex].first
                val sampledColor = sampleColor(currentStops, targetPos)
                stopPointsAnimated.add(Animatable(targetPos, Float.VectorConverter))
                colorsAnimated.add(Animatable(sampledColor))
            }
        } else {
            // 减少停止点：从末尾移除多余的 Animatable（保留的不变，Canvas 依赖不受影响）
            repeat(currentSize - targetSize) {
                colorsAnimated.removeAt(colorsAnimated.size - 1)
                stopPointsAnimated.removeAt(stopPointsAnimated.size - 1)
            }
        }
    }

    suspend fun snapTo(brush: UIKitBrush) {
        // 如果停止点数量不同，先调整列表大小
        if (brush.colorStops.size != colorsAnimated.size) {
            resizeAnimatedLists(brush.colorStops)
        }

        // 并行立即跳变到目标值
        coroutineScope {
            launch {
                startAnimated.snapTo(brush.start)
            }

            launch {
                endAnimated.snapTo(brush.end)
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
        }
    }

    suspend fun animateTo(
        brush: UIKitBrush,
        durationMillis: Int = 200,
        easing: Easing = FastOutSlowInEasing,
        delayMillis: Int = 0,
    ) {
        // 如果停止点数量不同，先调整列表大小
        if (brush.colorStops.size != colorsAnimated.size) {
            resizeAnimatedLists(brush.colorStops)
        }

        // 并行动画所有值到目标
        coroutineScope {
            launch {
                startAnimated.snapTo(brush.start)
            }

            launch {
                endAnimated.snapTo(brush.end)
            }

            colorsAnimated.forEachIndexed { index, color ->
                launch {
                    color.animateTo(
                        brush.colorStops.getOrNull(index)?.second ?: Color.Unspecified,
                        animationSpec = tween(
                            durationMillis = durationMillis,
                            easing = easing,
                            delayMillis = delayMillis
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
                            delayMillis = delayMillis
                        )
                    )
                }
            }
        }
    }
}
