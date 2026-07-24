package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.usbOff(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "UsbOff",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(17.85f, 17.15f)
            lineTo(2.85f, 2.15f)
            curveToRelative(-0.19f, -0.2f, -0.51f, -0.2f, -0.7f, 0f)
            curveToRelative(-0.2f, 0.19f, -0.2f, 0.51f, 0f, 0.7f)
            lineToRelative(2.44f, 2.45f)
            lineToRelative(0.71f, 0.71f)
            lineToRelative(5.2f, 5.2f)
            lineToRelative(0.09f, 0.09f)
            lineToRelative(0.71f, 0.71f)
            lineToRelative(1.65f, 1.65f)
            lineToRelative(4.2f, 4.19f)
            curveToRelative(0.19f, 0.2f, 0.51f, 0.2f, 0.7f, 0f)
            curveToRelative(0.2f, -0.19f, 0.2f, -0.51f, 0f, -0.7f)
            close()
        }
        path(fill = secondary) {
            moveTo(12f, 17f)
            curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f)
            reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f)
            curveToRelative(0f, -0.93f, 0.63f, -1.71f, 1.49f, -1.93f)
            curveToRelative(-0.02f, -0.25f, -0.14f, -0.48f, -0.33f, -0.64f)
            lineToRelative(-3.49f, -3.11f)
            curveToRelative(-0.43f, -0.38f, -0.67f, -0.92f, -0.67f, -1.49f)
            verticalLineToRelative(-0.92f)
            curveToRelative(-0.58f, -0.2f, -1f, -0.76f, -1f, -1.41f)
            curveToRelative(0f, -0.76f, 0.56f, -1.38f, 1.3f, -1.49f)
            lineToRelative(1.69f, 1.69f)
            curveToRelative(-0.08f, 0.57f, -0.47f, 1.03f, -0.99f, 1.21f)
            verticalLineToRelative(0.92f)
            curveToRelative(0f, 0.28f, 0.12f, 0.55f, 0.34f, 0.74f)
            lineToRelative(3.16f, 2.82f)
            verticalLineToRelative(-3.18f)
            lineToRelative(1f, 1f)
            verticalLineToRelative(0.18f)
            lineToRelative(0.09f, -0.09f)
            lineToRelative(0.71f, 0.71f)
            lineToRelative(-0.46f, 0.42f)
            curveToRelative(-0.22f, 0.19f, -0.34f, 0.46f, -0.34f, 0.74f)
            verticalLineToRelative(1.9f)
            curveToRelative(0.86f, 0.22f, 1.5f, 1f, 1.5f, 1.93f)
            close()
            moveTo(13.5f, 4f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            verticalLineToRelative(2f)
            curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(0.5f)
            verticalLineToRelative(0.83f)
            curveToRelative(0f, 0.29f, -0.12f, 0.56f, -0.34f, 0.75f)
            lineToRelative(-1.57f, 1.4f)
            lineToRelative(0.71f, 0.71f)
            lineToRelative(1.53f, -1.36f)
            curveToRelative(0.43f, -0.38f, 0.67f, -0.92f, 0.67f, -1.5f)
            verticalLineToRelative(-0.83f)
            horizontalLineToRelative(0.5f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            verticalLineToRelative(-2f)
            curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
            horizontalLineToRelative(-2f)
            close()
            moveTo(8.33f, 3.24f)
            curveToRelative(-0.21f, 0.33f, 0.03f, 0.76f, 0.42f, 0.76f)
            horizontalLineToRelative(0.75f)
            verticalLineToRelative(3.38f)
            lineToRelative(1f, 1f)
            verticalLineToRelative(-4.37f)
            horizontalLineToRelative(0.75f)
            curveToRelative(0.39f, 0f, 0.63f, -0.43f, 0.42f, -0.76f)
            lineToRelative(-1.25f, -2f)
            curveToRelative(-0.2f, -0.31f, -0.65f, -0.31f, -0.85f, 0f)
            lineToRelative(-1.25f, 2f)
            close()
        }
    }.build()
}

fun FluentIcons.usbOff(): ImageVector {
    return usbOff(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.usbOff(
    color: Color,
    layered: Boolean = false,
): ImageVector {
    return usbOff(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}