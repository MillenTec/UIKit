package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.chat(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Chat",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
            verticalLineToRelative(0.35f)
            reflectiveCurveToRelative(0.03f, 0.38f, 0.03f, 0.38f)
            curveToRelative(0.09f, 1.01f, 0.37f, 1.99f, 0.83f, 2.89f)
            lineToRelative(0.06f, 0.12f)
            lineToRelative(-0.91f, 3.64f)
            verticalLineToRelative(0.08f)
            reflectiveCurveToRelative(-0.01f, 0.08f, -0.01f, 0.08f)
            curveToRelative(0.02f, 0.29f, 0.31f, 0.52f, 0.62f, 0.44f)
            lineToRelative(3.64f, -0.91f)
            lineToRelative(0.12f, 0.06f)
            curveToRelative(1.11f, 0.56f, 2.34f, 0.86f, 3.61f, 0.86f)
            curveToRelative(4.42f, 0f, 8f, -3.58f, 8f, -8f)
            reflectiveCurveTo(14.42f, 2f, 10f, 2f)
            close()
            moveTo(10.59f, 11.99f)
            horizontalLineToRelative(-0.09f)
            reflectiveCurveToRelative(-3f, 0f, -3f, 0f)
            horizontalLineToRelative(-0.09f)
            curveToRelative(-0.23f, -0.05f, -0.41f, -0.25f, -0.41f, -0.5f)
            reflectiveCurveToRelative(0.18f, -0.45f, 0.41f, -0.49f)
            horizontalLineToRelative(0.09f)
            reflectiveCurveToRelative(3f, 0f, 3f, 0f)
            horizontalLineToRelative(0.09f)
            curveToRelative(0.23f, 0.05f, 0.41f, 0.25f, 0.41f, 0.5f)
            reflectiveCurveToRelative(-0.18f, 0.45f, -0.41f, 0.49f)
            close()
            moveTo(12.59f, 8.99f)
            horizontalLineToRelative(-0.09f)
            reflectiveCurveToRelative(-5f, 0f, -5f, 0f)
            horizontalLineToRelative(-0.09f)
            curveToRelative(-0.23f, -0.05f, -0.41f, -0.25f, -0.41f, -0.5f)
            reflectiveCurveToRelative(0.18f, -0.45f, 0.41f, -0.49f)
            horizontalLineToRelative(0.09f)
            reflectiveCurveToRelative(5f, 0f, 5f, 0f)
            horizontalLineToRelative(0.09f)
            curveToRelative(0.23f, 0.05f, 0.41f, 0.25f, 0.41f, 0.5f)
            reflectiveCurveToRelative(-0.18f, 0.45f, -0.41f, 0.49f)
            close()
        }
        path(fill = primary) {
            moveTo(10.5f, 11f)
            horizontalLineToRelative(-3.09f)
            curveToRelative(-0.23f, 0.05f, -0.41f, 0.25f, -0.41f, 0.5f)
            reflectiveCurveToRelative(0.18f, 0.45f, 0.41f, 0.49f)
            horizontalLineToRelative(0.09f)
            reflectiveCurveToRelative(3f, 0f, 3f, 0f)
            horizontalLineToRelative(0.09f)
            curveToRelative(0.23f, -0.05f, 0.41f, -0.25f, 0.41f, -0.5f)
            reflectiveCurveToRelative(-0.18f, -0.45f, -0.41f, -0.49f)
            horizontalLineToRelative(-0.09f)
            close()
            moveTo(12.5f, 8f)
            horizontalLineToRelative(-5.09f)
            curveToRelative(-0.23f, 0.05f, -0.41f, 0.25f, -0.41f, 0.5f)
            reflectiveCurveToRelative(0.18f, 0.45f, 0.41f, 0.49f)
            horizontalLineToRelative(0.09f)
            reflectiveCurveToRelative(5f, 0f, 5f, 0f)
            horizontalLineToRelative(0.09f)
            curveToRelative(0.23f, -0.05f, 0.41f, -0.25f, 0.41f, -0.5f)
            reflectiveCurveToRelative(-0.18f, -0.45f, -0.41f, -0.49f)
            horizontalLineToRelative(-0.09f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.chat(): ImageVector {
    return chat(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.chat(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return chat(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}
