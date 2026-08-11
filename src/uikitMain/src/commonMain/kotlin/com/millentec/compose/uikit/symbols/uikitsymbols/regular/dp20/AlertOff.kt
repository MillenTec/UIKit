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

fun UIKitRegularSymbols.alertOff(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "AlertOff",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "AlertOff",
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
                    lineToRelative(1.46f, 1.47f)
                    lineToRelative(0.97f, 0.97f)
                    lineToRelative(0.76f, 0.76f)
                    lineToRelative(7.96f, 7.96f)
                    lineToRelative(0.99f, 0.99f)
                    horizontalLineToRelative(0.01f)
                    lineToRelative(1.49f, 1.5f)
                    lineToRelative(1.36f, 1.35f)
                    curveToRelative(0.19f, 0.2f, 0.51f, 0.2f, 0.7f, 0f)
                    curveToRelative(0.2f, -0.19f, 0.2f, -0.51f, 0f, -0.7f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(13.3f, 14.01f)
                    horizontalLineTo(4f)
                    reflectiveCurveToRelative(0.96f, -2.32f, 0.96f, -2.32f)
                    lineToRelative(0.04f, -0.19f)
                    verticalLineToRelative(-3.9f)
                    lineToRelative(0.02f, -0.21f)
                    curveToRelative(0.04f, -0.47f, 0.15f, -0.92f, 0.32f, -1.34f)
                    lineToRelative(-0.76f, -0.76f)
                    curveToRelative(-0.34f, 0.69f, -0.54f, 1.46f, -0.58f, 2.28f)
                    verticalLineToRelative(3.83f)
                    lineToRelative(-0.92f, 2.22f)
                    lineToRelative(-0.05f, 0.13f)
                    lineToRelative(-0.02f, 0.13f)
                    curveToRelative(-0.05f, 0.46f, 0.19f, 0.88f, 0.6f, 1.05f)
                    lineToRelative(0.13f, 0.04f)
                    curveToRelative(0.08f, 0.02f, 0.17f, 0.03f, 0.26f, 0.03f)
                    horizontalLineToRelative(3.5f)
                    verticalLineToRelative(0.16f)
                    curveToRelative(0.09f, 1.31f, 1.17f, 2.34f, 2.5f, 2.34f)
                    reflectiveCurveToRelative(2.41f, -1.03f, 2.49f, -2.33f)
                    verticalLineToRelative(-0.17f)
                    horizontalLineToRelative(1.8f)
                    lineToRelative(-0.99f, -0.99f)
                    close()
                    moveTo(11.49f, 15.14f)
                    curveToRelative(-0.07f, 0.77f, -0.71f, 1.36f, -1.49f, 1.36f)
                    horizontalLineToRelative(-0.14f)
                    curveToRelative(-0.72f, -0.08f, -1.28f, -0.64f, -1.35f, -1.35f)
                    verticalLineToRelative(-0.15f)
                    reflectiveCurveToRelative(2.99f, 0f, 2.99f, 0f)
                    verticalLineToRelative(0.14f)
                    close()
                    moveTo(15.04f, 11.69f)
                    lineToRelative(0.87f, 2.1f)
                    lineToRelative(0.85f, 0.85f)
                    curveToRelative(0.15f, -0.17f, 0.24f, -0.4f, 0.24f, -0.64f)
                    verticalLineToRelative(-0.13f)
                    reflectiveCurveToRelative(-0.02f, -0.09f, -0.02f, -0.09f)
                    curveToRelative(-0.01f, -0.06f, -0.03f, -0.11f, -0.05f, -0.17f)
                    lineToRelative(-0.93f, -2.22f)
                    verticalLineToRelative(-3.6f)
                    reflectiveCurveToRelative(0f, -0.22f, 0f, -0.22f)
                    verticalLineToRelative(-0.22f)
                    curveToRelative(-0.25f, -3.02f, -2.85f, -5.36f, -6f, -5.36f)
                    curveToRelative(-1.64f, 0f, -3.13f, 0.63f, -4.21f, 1.66f)
                    lineToRelative(0.71f, 0.71f)
                    curveToRelative(0.9f, -0.85f, 2.14f, -1.37f, 3.51f, -1.37f)
                    curveToRelative(2.7f, 0f, 4.89f, 2.03f, 5f, 4.61f)
                    verticalLineToRelative(0.2f)
                    reflectiveCurveToRelative(0f, 3.69f, 0f, 3.69f)
                    lineToRelative(0.04f, 0.19f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.alertOff(
    color: Color,
    layered: Boolean = false
) = alertOff(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)