package com.millentec.compose.uikit.icons.fluenticons.animatable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.addCircle
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
@Preview
private fun Preview() {
    ProgressableCircleIcon(
        modifier = Modifier
            .size(100.dp),
        progress = 0.3f,
        basicIcon = FluentIcons.addCircle(
            SolidColor(getUIKitColors().highlightColorPrimaryBrush),
            SolidColor(getUIKitColors().highlightColorPrimaryBrush.copy(0.3f)),
        ),
        activeColor = getUIKitColors().highlightColorPrimaryBrush
    )
}

/**
 * 为任意图标 (一般使用 *Circle 图标) 添加进度圆环
 * @param basicIcon 基础图标, 一般需使用 *Circle 图标的 Regular 版本, 该图标的 secondary 颜色即为进度环的 inactive 颜色, 建议为图标色调的 30% 不透明度
 * @param modifier 修饰符, 可以设置图标的尺寸大小
 * @param circleRadius 进度环的半径, 需根据实际的基础图标而设置, 与圆环半径保持一致
 * @param progress 进度, 可传入范围为 0f..1f 的浮点数
 * @param lineWidth 进度环的线条宽度, 需根据实际的基础图标而设置, 与圆环宽度保持一致
 * @param activeBrush 进度环激活状态的填充色刷, 一般与基础图标色刷一致
 */
@Composable
fun ProgressableCircleIcon(
    basicIcon: ImageVector,
    modifier: Modifier = Modifier,
    circleRadius: Dp = 15.dp,
    progress: Float,
    lineWidth: Dp = 1.dp,
    activeBrush: Brush,
) {
    val vectorPainter = rememberVectorPainter(basicIcon)

    Canvas(
        modifier = modifier
            .defaultMinSize(basicIcon.defaultWidth, basicIcon.defaultHeight)
    ) {
        with(vectorPainter) {
            translate(
                top = 0f,
                left = 0f
            ) {
                draw(
                    size = size,
                )
            }
        }

        scale(
            scaleX = size.width / basicIcon.defaultWidth.toPx(),
            scaleY = size.height / basicIcon.defaultHeight.toPx()
        ) {
            // 进度圆环
            translate(
                top = size.height / 2 - circleRadius.toPx() / 2,
                left = size.width / 2 - circleRadius.toPx() / 2
            ) {
                drawArc(
                    brush = activeBrush,
                    startAngle = -90f,
                    sweepAngle = progress.coerceIn(0f..1f) * 360f,
                    useCenter = false,
                    size = Size(
                        width = circleRadius.toPx(),
                        height = circleRadius.toPx()
                    ),
                    style = Stroke(
                        width = lineWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
        }
    }
}

@Composable
fun ProgressableCircleIcon(
    basicIcon: ImageVector,
    modifier: Modifier = Modifier,
    circleRadius: Dp = 15.dp,
    progress: Float,
    lineWidth: Dp = 1.dp,
    activeColor: Color,
) = ProgressableCircleIcon(
    basicIcon = basicIcon,
    modifier = modifier,
    circleRadius = circleRadius,
    progress = progress,
    lineWidth = lineWidth,
    activeBrush = SolidColor(activeColor),
)