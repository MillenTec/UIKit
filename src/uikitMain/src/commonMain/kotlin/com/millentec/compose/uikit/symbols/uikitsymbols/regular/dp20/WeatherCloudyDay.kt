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

fun UIKitRegularSymbols.weatherCloudyDay(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "WeatherCloudyDay",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "WeatherCloudyDay",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(15.13f, 10.47f)
                    horizontalLineToRelative(-0.06f)
                    curveToRelative(-0.2f, -1.9f, -1.6f, -3.47f, -4.07f, -3.47f)
                    reflectiveCurveToRelative(-3.86f, 1.56f, -4.07f, 3.47f)
                    horizontalLineToRelative(-0.06f)
                    curveToRelative(-1.59f, 0f, -2.87f, 1.24f, -2.87f, 2.76f)
                    reflectiveCurveToRelative(1.29f, 2.76f, 2.87f, 2.76f)
                    horizontalLineToRelative(8.26f)
                    curveToRelative(1.59f, 0f, 2.87f, -1.24f, 2.87f, -2.76f)
                    reflectiveCurveToRelative(-1.29f, -2.76f, -2.87f, -2.76f)
                    close()
                    moveTo(15.18f, 15f)
                    horizontalLineTo(6.82f)
                    curveToRelative(-1f, 0f, -1.82f, -0.78f, -1.82f, -1.74f)
                    reflectiveCurveToRelative(0.81f, -1.74f, 1.82f, -1.74f)
                    horizontalLineToRelative(0.55f)
                    curveToRelative(0.29f, 0f, 0.54f, -0.22f, 0.54f, -0.5f)
                    curveToRelative(0f, -1.75f, 1.44f, -3.02f, 3.09f, -3.02f)
                    reflectiveCurveToRelative(3.09f, 1.25f, 3.09f, 3.02f)
                    curveToRelative(0f, 0.28f, 0.25f, 0.5f, 0.54f, 0.5f)
                    horizontalLineToRelative(0.55f)
                    curveToRelative(1f, 0f, 1.82f, 0.78f, 1.82f, 1.74f)
                    reflectiveCurveToRelative(-0.81f, 1.74f, -1.82f, 1.74f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(3.8f, 9.7f)
                    curveToRelative(0.08f, 0.23f, -0.02f, 0.48f, -0.23f, 0.6f)
                    lineToRelative(-0.08f, 0.04f)
                    lineToRelative(-0.8f, 0.28f)
                    curveToRelative(-0.26f, 0.09f, -0.55f, -0.05f, -0.64f, -0.31f)
                    curveToRelative(-0.08f, -0.23f, 0.02f, -0.48f, 0.23f, -0.6f)
                    lineToRelative(0.08f, -0.04f)
                    lineToRelative(0.8f, -0.28f)
                    curveToRelative(0.26f, -0.09f, 0.55f, 0.05f, 0.64f, 0.31f)
                    close()
                    moveTo(8.92f, 5.5f)
                    curveToRelative(0.33f, 0.16f, 0.63f, 0.37f, 0.87f, 0.62f)
                    curveToRelative(-0.41f, 0.08f, -0.79f, 0.21f, -1.14f, 0.37f)
                    curveToRelative(-0.06f, -0.03f, -0.11f, -0.07f, -0.18f, -0.1f)
                    curveToRelative(-1.13f, -0.55f, -2.5f, -0.08f, -3.05f, 1.05f)
                    curveToRelative(-0.38f, 0.79f, -0.27f, 1.69f, 0.21f, 2.35f)
                    curveToRelative(-0.33f, 0.1f, -0.64f, 0.24f, -0.92f, 0.42f)
                    curveToRelative(-0.6f, -0.93f, -0.71f, -2.14f, -0.19f, -3.21f)
                    curveToRelative(0.79f, -1.63f, 2.76f, -2.3f, 4.39f, -1.51f)
                    close()
                    moveTo(2.92f, 5.67f)
                    lineToRelative(0.08f, 0.03f)
                    lineToRelative(0.76f, 0.37f)
                    curveToRelative(0.25f, 0.12f, 0.35f, 0.42f, 0.23f, 0.67f)
                    curveToRelative(-0.11f, 0.22f, -0.36f, 0.33f, -0.58f, 0.26f)
                    lineToRelative(-0.08f, -0.03f)
                    lineToRelative(-0.76f, -0.37f)
                    curveToRelative(-0.25f, -0.12f, -0.35f, -0.42f, -0.23f, -0.67f)
                    curveToRelative(0.11f, -0.22f, 0.36f, -0.33f, 0.58f, -0.26f)
                    close()
                    moveTo(9.99f, 3.3f)
                    curveToRelative(0.22f, 0.11f, 0.33f, 0.36f, 0.26f, 0.58f)
                    lineToRelative(-0.03f, 0.08f)
                    lineToRelative(-0.37f, 0.76f)
                    curveToRelative(-0.12f, 0.25f, -0.42f, 0.35f, -0.67f, 0.23f)
                    curveToRelative(-0.22f, -0.11f, -0.33f, -0.36f, -0.26f, -0.58f)
                    lineToRelative(0.03f, -0.08f)
                    lineToRelative(0.37f, -0.76f)
                    curveToRelative(0.12f, -0.25f, 0.42f, -0.35f, 0.67f, -0.23f)
                    close()
                    moveTo(6.2f, 3.26f)
                    lineToRelative(0.04f, 0.08f)
                    lineToRelative(0.28f, 0.8f)
                    curveToRelative(0.09f, 0.26f, -0.05f, 0.55f, -0.31f, 0.64f)
                    curveToRelative(-0.23f, 0.08f, -0.48f, -0.02f, -0.6f, -0.23f)
                    lineToRelative(-0.04f, -0.08f)
                    lineToRelative(-0.28f, -0.8f)
                    curveToRelative(-0.09f, -0.26f, 0.05f, -0.55f, 0.31f, -0.64f)
                    curveToRelative(0.23f, -0.08f, 0.48f, 0.02f, 0.6f, 0.23f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.weatherCloudyDay(
    color: Color,
    layered: Boolean = false
) = weatherCloudyDay(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)