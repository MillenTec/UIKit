package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.chatMultiple(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "ChatMultiple",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(8.54f, 2f)
            curveToRelative(-3.59f, 0f, -6.5f, 2.91f, -6.5f, 6.5f)
            curveToRelative(0f, 1.15f, 0.3f, 2.23f, 0.83f, 3.17f)
            lineToRelative(-0.8f, 2.08f)
            curveToRelative(-0.29f, 0.77f, 0.41f, 1.54f, 1.2f, 1.32f)
            lineToRelative(2.49f, -0.7f)
            curveToRelative(0.84f, 0.4f, 1.79f, 0.62f, 2.78f, 0.62f)
            curveToRelative(3.59f, 0f, 6.5f, -2.91f, 6.5f, -6.5f)
            reflectiveCurveToRelative(-2.91f, -6.5f, -6.5f, -6.5f)
            close()
        }
        path(fill = secondary) {
            moveTo(6.57f, 15.74f)
            curveToRelative(1.19f, 1.38f, 2.96f, 2.26f, 4.93f, 2.26f)
            curveToRelative(0.99f, 0f, 1.94f, -0.22f, 2.78f, -0.62f)
            lineToRelative(2.49f, 0.7f)
            curveToRelative(0.79f, 0.22f, 1.5f, -0.55f, 1.2f, -1.32f)
            lineToRelative(-0.8f, -2.08f)
            curveToRelative(0.53f, -0.94f, 0.83f, -2.02f, 0.83f, -3.17f)
            curveToRelative(0f, -1.94f, -0.85f, -3.68f, -2.2f, -4.87f)
            curveToRelative(0.15f, 0.56f, 0.23f, 1.15f, 0.23f, 1.76f)
            curveToRelative(0.61f, 0.88f, 0.96f, 1.96f, 0.96f, 3.11f)
            curveToRelative(0f, 1.05f, -0.29f, 2.03f, -0.8f, 2.87f)
            lineToRelative(-0.13f, 0.21f)
            lineToRelative(0.97f, 2.54f)
            lineToRelative(-2.86f, -0.8f)
            lineToRelative(-0.17f, 0.09f)
            curveToRelative(-0.75f, 0.38f, -1.6f, 0.6f, -2.5f, 0.6f)
            curveToRelative(-1.18f, 0f, -2.27f, -0.37f, -3.17f, -1f)
            curveToRelative(-0.61f, -0.02f, -1.2f, -0.1f, -1.76f, -0.26f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.chatMultiple(): ImageVector {
    return chatMultiple(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.chatMultiple(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return chatMultiple(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
