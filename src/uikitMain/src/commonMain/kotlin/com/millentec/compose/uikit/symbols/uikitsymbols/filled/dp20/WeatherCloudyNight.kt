package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.weatherCloudyNight(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "WeatherCloudyNight",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(11f, 7f)
            curveToRelative(2.46f, 0f, 3.86f, 1.57f, 4.07f, 3.47f)
            horizontalLineToRelative(0.06f)
            curveToRelative(1.59f, 0f, 2.87f, 1.24f, 2.87f, 2.76f)
            reflectiveCurveToRelative(-1.29f, 2.76f, -2.87f, 2.76f)
            horizontalLineTo(6.87f)
            curveToRelative(-1.59f, 0f, -2.87f, -1.24f, -2.87f, -2.76f)
            reflectiveCurveToRelative(1.19f, -2.67f, 2.7f, -2.76f)
            horizontalLineToRelative(0.24f)
            curveToRelative(0.2f, -1.92f, 1.6f, -3.48f, 4.07f, -3.48f)
            close()
        }
        path(fill = secondary) {
            moveTo(5.84f, 3f)
            curveToRelative(0.67f, 0.04f, 1.31f, 0.23f, 1.9f, 0.56f)
            curveToRelative(1.01f, 0.59f, 1.7f, 1.53f, 1.98f, 2.57f)
            curveToRelative(-1.72f, 0.38f, -2.96f, 1.54f, -3.47f, 3.14f)
            lineToRelative(-0.06f, 0.22f)
            lineToRelative(-0.05f, 0.19f)
            lineToRelative(-0.17f, 0.03f)
            curveToRelative(-0.89f, 0.18f, -1.66f, 0.68f, -2.2f, 1.36f)
            curveToRelative(-0.1f, -0.04f, -0.19f, -0.09f, -0.29f, -0.15f)
            curveToRelative(-0.55f, -0.32f, -1.02f, -0.75f, -1.38f, -1.27f)
            curveToRelative(-0.23f, -0.34f, -0.08f, -0.81f, 0.31f, -0.95f)
            curveToRelative(1.38f, -0.49f, 2.12f, -1.05f, 2.54f, -1.86f)
            curveToRelative(0.46f, -0.88f, 0.55f, -1.82f, 0.24f, -3.08f)
            curveToRelative(-0.1f, -0.41f, 0.22f, -0.8f, 0.64f, -0.78f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.weatherCloudyNight(): ImageVector {
    return weatherCloudyNight(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.weatherCloudyNight(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return weatherCloudyNight(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
