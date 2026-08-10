package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.usbOff(
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
            lineToRelative(2.31f, 2.32f)
            lineToRelative(0.83f, 0.83f)
            lineToRelative(7.89f, 7.89f)
            lineToRelative(3.97f, 3.96f)
            curveToRelative(0.19f, 0.2f, 0.51f, 0.2f, 0.7f, 0f)
            curveToRelative(0.2f, -0.19f, 0.2f, -0.51f, 0f, -0.7f)
            close()
        }
        path(fill = secondary) {
            moveTo(12f, 17f)
            curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f)
            reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f)
            curveToRelative(0f, -0.76f, 0.43f, -1.43f, 1.06f, -1.77f)
            curveToRelative(-0.06f, -0.09f, -0.14f, -0.19f, -0.23f, -0.27f)
            lineToRelative(-3.41f, -3.05f)
            curveToRelative(-0.59f, -0.53f, -0.92f, -1.27f, -0.92f, -2.05f)
            verticalLineToRelative(-0.53f)
            curveToRelative(-0.59f, -0.28f, -1f, -0.88f, -1f, -1.58f)
            curveToRelative(0f, -0.97f, 0.78f, -1.75f, 1.75f, -1.75f)
            horizontalLineToRelative(0.04f)
            lineToRelative(1.71f, 1.71f)
            verticalLineToRelative(0.04f)
            curveToRelative(0f, 0.7f, -0.41f, 1.3f, -1f, 1.58f)
            verticalLineToRelative(0.53f)
            curveToRelative(0f, 0.35f, 0.15f, 0.69f, 0.42f, 0.93f)
            lineToRelative(2.83f, 2.53f)
            verticalLineToRelative(-3.36f)
            lineToRelative(2.49f, 2.49f)
            lineToRelative(-0.57f, 0.51f)
            curveToRelative(-0.27f, 0.24f, -0.42f, 0.58f, -0.42f, 0.93f)
            verticalLineToRelative(1.26f)
            curveToRelative(0.73f, 0.29f, 1.25f, 1.01f, 1.25f, 1.85f)
            close()
            moveTo(13.75f, 4f)
            curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
            verticalLineToRelative(2f)
            curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f)
            horizontalLineToRelative(0.25f)
            verticalLineToRelative(0.36f)
            curveToRelative(0f, 0.36f, -0.15f, 0.69f, -0.42f, 0.93f)
            lineToRelative(-1.41f, 1.26f)
            lineToRelative(1.06f, 1.06f)
            lineToRelative(1.35f, -1.21f)
            curveToRelative(0.58f, -0.52f, 0.92f, -1.27f, 0.92f, -2.05f)
            verticalLineToRelative(-0.36f)
            horizontalLineToRelative(0.25f)
            curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
            verticalLineToRelative(-2f)
            curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f)
            horizontalLineToRelative(-2f)
            close()
            moveTo(8.12f, 2.85f)
            curveToRelative(-0.31f, 0.5f, 0.05f, 1.15f, 0.64f, 1.15f)
            horizontalLineToRelative(0.5f)
            verticalLineToRelative(3.13f)
            lineToRelative(1.5f, 1.5f)
            verticalLineTo(3.99f)
            horizontalLineToRelative(0.5f)
            curveToRelative(0.59f, 0f, 0.95f, -0.65f, 0.64f, -1.15f)
            lineToRelative(-1.25f, -2f)
            curveToRelative(-0.29f, -0.47f, -0.98f, -0.47f, -1.27f, 0f)
            lineToRelative(-1.25f, 2f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.usbOff(): ImageVector {
    return usbOff(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.usbOff(
    color: Color,
    layered: Boolean = false,
): ImageVector {
    return usbOff(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}