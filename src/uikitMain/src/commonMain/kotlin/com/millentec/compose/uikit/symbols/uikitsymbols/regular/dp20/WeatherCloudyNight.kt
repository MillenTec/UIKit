package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.weatherCloudyNight(
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
            moveTo(15.13f, 10.47f)
            horizontalLineToRelative(-0.06f)
            curveToRelative(-0.2f, -1.9f, -1.6f, -3.47f, -4.07f, -3.47f)
            reflectiveCurveToRelative(-3.86f, 1.56f, -4.07f, 3.47f)
            horizontalLineToRelative(-0.24f)
            curveToRelative(-1.5f, 0.09f, -2.7f, 1.29f, -2.7f, 2.76f)
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
        path(fill = secondary) {
            moveTo(5.84f, 3f)
            curveToRelative(0.67f, 0.04f, 1.31f, 0.23f, 1.9f, 0.56f)
            curveToRelative(1.01f, 0.59f, 1.7f, 1.53f, 1.98f, 2.57f)
            curveToRelative(-0.38f, 0.08f, -0.74f, 0.21f, -1.07f, 0.36f)
            curveToRelative(-0.18f, -0.87f, -0.73f, -1.66f, -1.64f, -2.13f)
            curveToRelative(-0.19f, -0.09f, -0.34f, -0.17f, -0.54f, -0.25f)
            curveToRelative(0.09f, 1.23f, -0.04f, 2.48f, -0.63f, 3.44f)
            curveToRelative(-0.58f, 0.85f, -1.33f, 1.42f, -2.56f, 1.9f)
            curveToRelative(0.14f, 0.12f, 0.29f, 0.24f, 0.45f, 0.34f)
            curveToRelative(0.31f, 0.2f, 0.62f, 0.35f, 0.92f, 0.46f)
            curveToRelative(-0.34f, 0.22f, -0.63f, 0.5f, -0.88f, 0.81f)
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

fun UIKitSymbols.weatherCloudyNight(): ImageVector {
    return weatherCloudyNight(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.weatherCloudyNight(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return weatherCloudyNight(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
