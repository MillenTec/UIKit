package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.bluetoothDisabled(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "BluetoothDisabled",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(13.83f, 6.88f)
            lineToRelative(-2.58f, 2.25f)
            lineToRelative(-0.71f, -0.71f)
            lineToRelative(2.22f, -1.95f)
            lineToRelative(-2.77f, -2.77f)
            verticalLineToRelative(4.17f)
            lineToRelative(-1f, -1f)
            verticalLineTo(2.5f)
            curveToRelative(0f, -0.2f, 0.12f, -0.38f, 0.31f, -0.46f)
            curveToRelative(0.19f, -0.08f, 0.4f, -0.03f, 0.54f, 0.11f)
            lineToRelative(4f, 4f)
            curveToRelative(0.1f, 0.1f, 0.15f, 0.23f, 0.15f, 0.37f)
            curveToRelative(0f, 0.14f, -0.07f, 0.27f, -0.17f, 0.36f)
            close()
        }
        path(fill = primary) {
            moveTo(17.85f, 17.15f)
            lineTo(2.85f, 2.15f)
            curveToRelative(-0.19f, -0.2f, -0.51f, -0.2f, -0.7f, 0f)
            curveToRelative(-0.2f, 0.19f, -0.2f, 0.51f, 0f, 0.7f)
            lineToRelative(6.61f, 6.62f)
            lineToRelative(0.24f, 0.24f)
            lineToRelative(4.5f, 4.5f)
            lineToRelative(0.61f, 0.6f)
            lineToRelative(3.04f, 3.04f)
            curveToRelative(0.19f, 0.2f, 0.51f, 0.2f, 0.7f, 0f)
            curveToRelative(0.2f, -0.19f, 0.2f, -0.51f, 0f, -0.7f)
            close()
        }
        path(fill = secondary) {
            moveTo(9f, 9.71f)
            verticalLineToRelative(0.06f)
            lineToRelative(-3.83f, 3.35f)
            curveToRelative(-0.21f, 0.19f, -0.23f, 0.5f, -0.05f, 0.71f)
            curveToRelative(0.19f, 0.21f, 0.5f, 0.23f, 0.71f, 0.05f)
            lineToRelative(3.17f, -2.78f)
            verticalLineToRelative(6.4f)
            curveToRelative(0f, 0.2f, 0.12f, 0.38f, 0.31f, 0.46f)
            curveToRelative(0.19f, 0.08f, 0.4f, 0.04f, 0.54f, -0.11f)
            lineToRelative(3.65f, -3.64f)
            lineToRelative(-4.5f, -4.5f)
            close()
            moveTo(10f, 11.1f)
            lineToRelative(2.77f, 2.42f)
            lineToRelative(-2.77f, 2.77f)
            verticalLineToRelative(-5.19f)
            close()
        }
    }.build()
}

fun UIKitSymbols.bluetoothDisabled(): ImageVector {
    return bluetoothDisabled(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.bluetoothDisabled(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return bluetoothDisabled(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}