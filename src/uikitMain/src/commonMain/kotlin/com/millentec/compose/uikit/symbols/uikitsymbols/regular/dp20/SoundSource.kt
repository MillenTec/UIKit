package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.soundSource(
    primary: Brush,
    secondary: Brush,
    tertiary: Brush,
    fourth: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "SoundSource",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = fourth) {
            moveTo(3f, 10f)
            curveToRelative(0f, -3.87f, 3.13f, -7f, 7f, -7f)
            reflectiveCurveToRelative(7f, 3.13f, 7f, 7f)
            curveToRelative(0f, 1.83f, -0.71f, 3.5f, -1.86f, 4.75f)
            lineToRelative(0.65f, 0.77f)
            curveToRelative(1.37f, -1.44f, 2.21f, -3.38f, 2.21f, -5.52f)
            curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f)
            reflectiveCurveTo(2f, 5.58f, 2f, 10f)
            curveToRelative(0f, 2.14f, 0.84f, 4.08f, 2.21f, 5.52f)
            lineToRelative(0.65f, -0.77f)
            curveToRelative(-1.15f, -1.25f, -1.86f, -2.92f, -1.86f, -4.75f)
            close()
        }
        path(fill = tertiary) {
            moveTo(14.16f, 13.6f)
            curveToRelative(0.83f, -0.96f, 1.34f, -2.22f, 1.34f, -3.6f)
            curveToRelative(0f, -3.04f, -2.46f, -5.5f, -5.5f, -5.5f)
            reflectiveCurveToRelative(-5.5f, 2.46f, -5.5f, 5.5f)
            curveToRelative(0f, 1.37f, 0.5f, 2.63f, 1.34f, 3.6f)
            lineToRelative(0.66f, -0.77f)
            curveToRelative(-0.62f, -0.77f, -0.99f, -1.75f, -0.99f, -2.82f)
            curveToRelative(0f, -2.49f, 2.01f, -4.5f, 4.5f, -4.5f)
            reflectiveCurveToRelative(4.5f, 2.01f, 4.5f, 4.5f)
            curveToRelative(0f, 1.07f, -0.37f, 2.05f, -0.99f, 2.82f)
            lineToRelative(0.66f, 0.77f)
            close()
        }
        path(fill = secondary) {
            moveTo(12.51f, 11.64f)
            curveToRelative(0.31f, -0.47f, 0.49f, -1.04f, 0.49f, -1.64f)
            curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f)
            reflectiveCurveToRelative(-3f, 1.34f, -3f, 3f)
            curveToRelative(0f, 0.61f, 0.18f, 1.17f, 0.49f, 1.64f)
            lineToRelative(0.69f, -0.81f)
            curveToRelative(-0.12f, -0.25f, -0.18f, -0.53f, -0.18f, -0.83f)
            curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
            reflectiveCurveToRelative(2f, 0.9f, 2f, 2f)
            curveToRelative(0f, 0.3f, -0.06f, 0.58f, -0.18f, 0.83f)
            lineToRelative(0.69f, 0.81f)
            close()
        }
        path(fill = primary) {
            moveTo(15.88f, 17.18f)
            lineToRelative(-5.5f, -6.5f)
            curveToRelative(-0.1f, -0.11f, -0.23f, -0.18f, -0.38f, -0.18f)
            reflectiveCurveToRelative(-0.29f, 0.06f, -0.38f, 0.18f)
            lineToRelative(-5.5f, 6.5f)
            curveToRelative(-0.13f, 0.15f, -0.15f, 0.36f, -0.07f, 0.53f)
            curveToRelative(0.08f, 0.18f, 0.26f, 0.29f, 0.45f, 0.29f)
            horizontalLineToRelative(11f)
            curveToRelative(0.19f, 0f, 0.37f, -0.11f, 0.45f, -0.29f)
            curveToRelative(0.08f, -0.18f, 0.05f, -0.38f, -0.07f, -0.53f)
            close()
            moveTo(5.58f, 17f)
            lineToRelative(4.42f, -5.23f)
            lineToRelative(4.42f, 5.23f)
            horizontalLineTo(5.58f)
            close()
        }
    }.build()
}

fun UIKitSymbols.soundSource(): ImageVector {
    return soundSource(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.soundSource(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return soundSource(
        SolidColor(color),
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}