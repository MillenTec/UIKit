package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol

fun UIKitRegularSymbols.timerOff(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TimerOff",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "TimerOff",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.85f, 17.15f)
                    lineTo(2.85f, 2.15f)
                    curveToRelative(-0.19f, -0.2f, -0.51f, -0.2f, -0.7f, 0f)
                    curveToRelative(-0.2f, 0.19f, -0.2f, 0.51f, 0f, 0.7f)
                    lineToRelative(2.26f, 2.26f)
                    lineToRelative(0.55f, 0.56f)
                    lineToRelative(0.71f, 0.71f)
                    lineToRelative(8.45f, 8.45f)
                    lineToRelative(0.71f, 0.71f)
                    lineToRelative(0.93f, 0.93f)
                    lineToRelative(1.39f, 1.38f)
                    curveToRelative(0.19f, 0.2f, 0.51f, 0.2f, 0.7f, 0f)
                    curveToRelative(0.2f, -0.19f, 0.2f, -0.51f, 0f, -0.7f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(14.83f, 15.54f)
                    curveToRelative(-1.28f, 1.5f, -3.2f, 2.46f, -5.33f, 2.46f)
                    curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f)
                    curveToRelative(0f, -2.13f, 0.96f, -4.05f, 2.46f, -5.33f)
                    lineToRelative(0.71f, 0.71f)
                    curveToRelative(-1.32f, 1.1f, -2.17f, 2.76f, -2.17f, 4.62f)
                    curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f)
                    curveToRelative(1.86f, 0f, 3.52f, -0.85f, 4.62f, -2.17f)
                    lineToRelative(0.71f, 0.71f)
                    close()
                    moveTo(9.5f, 6f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(1.38f)
                    lineToRelative(-1f, -1f)
                    verticalLineToRelative(-0.38f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                    moveTo(9.5f, 5f)
                    curveToRelative(-0.71f, 0f, -1.39f, 0.12f, -2.03f, 0.35f)
                    lineToRelative(-0.77f, -0.77f)
                    curveToRelative(0.86f, -0.37f, 1.8f, -0.58f, 2.8f, -0.58f)
                    curveToRelative(3.87f, 0f, 7f, 3.13f, 7f, 7f)
                    curveToRelative(0f, 0.99f, -0.21f, 1.94f, -0.58f, 2.8f)
                    lineToRelative(-0.77f, -0.77f)
                    curveToRelative(0.23f, -0.63f, 0.35f, -1.32f, 0.35f, -2.03f)
                    curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f)
                    close()
                    moveTo(11.5f, 2f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
                    horizontalLineToRelative(-4f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(4f)
                    close()
                    moveTo(16.57f, 5.34f)
                    curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
                    curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
                    lineToRelative(-1.41f, -1.41f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    lineToRelative(1.41f, 1.41f)
                    close()
                    moveTo(9f, 9.71f)
                    verticalLineToRelative(1.79f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-0.79f)
                    lineToRelative(-1f, -1f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.timerOff(
    color: Color,
    layered: Boolean = false
) = timerOff(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)