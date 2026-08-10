package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.write(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Write",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(10.5f, 4f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            horizontalLineToRelative(-4.5f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(7f)
            curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
            horizontalLineToRelative(7f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineToRelative(-4.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(4.5f)
            curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f)
            horizontalLineToRelative(-7f)
            curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f)
            verticalLineToRelative(-7f)
            curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f)
            horizontalLineToRelative(4.5f)
            close()
        }
        path(fill = primary) {
            moveTo(16.15f, 3.15f)
            curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
            curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
            lineToRelative(-7.79f, 7.79f)
            lineToRelative(-1.06f, 0.35f)
            lineToRelative(0.35f, -1.06f)
            lineToRelative(7.79f, -7.79f)
            close()
        }
    }.build()
}

fun UIKitSymbols.write(): ImageVector {
    return write(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.write(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return write(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
