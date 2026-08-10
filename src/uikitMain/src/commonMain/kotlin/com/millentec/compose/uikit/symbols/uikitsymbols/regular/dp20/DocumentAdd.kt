package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.documentAdd(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "DocumentAdd",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(15.56f, 6.35f)
            lineToRelative(-3.91f, -3.91f)
            curveToRelative(-0.28f, -0.28f, -0.66f, -0.44f, -1.06f, -0.44f)
            horizontalLineToRelative(-4.59f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(5.21f)
            curveToRelative(0.32f, -0.09f, 0.66f, -0.15f, 1f, -0.18f)
            verticalLineToRelative(-5.02f)
            curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
            horizontalLineToRelative(4f)
            verticalLineToRelative(3.5f)
            curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
            horizontalLineToRelative(3.5f)
            verticalLineToRelative(8f)
            curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
            horizontalLineToRelative(-3.6f)
            curveToRelative(-0.18f, 0.36f, -0.4f, 0.69f, -0.66f, 1f)
            horizontalLineToRelative(4.26f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineTo(7.41f)
            curveToRelative(0f, -0.4f, -0.16f, -0.78f, -0.44f, -1.06f)
            close()
            moveTo(11.5f, 7f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-3.29f)
            lineToRelative(3.79f, 3.79f)
            horizontalLineToRelative(-3.29f)
            close()
        }
        path(fill = primary) {
            moveTo(5.5f, 10f)
            curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
            reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
            reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
            reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
            close()
            moveTo(7.5f, 15f)
            horizontalLineToRelative(-1.5f)
            verticalLineToRelative(1.5f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-1.5f)
            horizontalLineToRelative(-1.5f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(1.5f)
            verticalLineToRelative(-1.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(1.5f)
            horizontalLineToRelative(1.5f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            close()
        }
    }.build()
}

fun UIKitSymbols.documentAdd(): ImageVector {
    return documentAdd(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.documentAdd(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return documentAdd(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
