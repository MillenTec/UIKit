package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.bookmarkMultiple(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "BookmarkMultiple",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(6.27f, 3f)
            curveToRelative(0.35f, -0.6f, 0.99f, -1f, 1.73f, -1f)
            horizontalLineToRelative(4.5f)
            curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f)
            verticalLineToRelative(10f)
            curveToRelative(0f, 0.18f, -0.1f, 0.35f, -0.26f, 0.44f)
            curveToRelative(-0.16f, 0.09f, -0.36f, 0.08f, -0.51f, -0.02f)
            lineToRelative(-0.22f, -0.15f)
            verticalLineTo(5.5f)
            curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f)
            horizontalLineToRelative(-6.23f)
            close()
        }
        path(fill = primary) {
            moveTo(12f, 4f)
            horizontalLineToRelative(-6f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(11.5f)
            curveToRelative(0f, 0.18f, 0.1f, 0.35f, 0.26f, 0.44f)
            curveToRelative(0.16f, 0.09f, 0.36f, 0.08f, 0.51f, -0.02f)
            lineToRelative(4.22f, -2.82f)
            lineToRelative(4.22f, 2.82f)
            curveToRelative(0.15f, 0.1f, 0.35f, 0.11f, 0.51f, 0.02f)
            reflectiveCurveToRelative(0.26f, -0.26f, 0.26f, -0.44f)
            verticalLineTo(6f)
            curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
            close()
            moveTo(13f, 16.57f)
            lineToRelative(-3.72f, -2.48f)
            curveToRelative(-0.17f, -0.11f, -0.39f, -0.11f, -0.55f, 0f)
            lineToRelative(-3.72f, 2.48f)
            verticalLineTo(6f)
            curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
            horizontalLineToRelative(6f)
            curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
            verticalLineToRelative(10.57f)
            close()
        }
    }.build()
}

fun UIKitSymbols.bookmarkMultiple(): ImageVector {
    return bookmarkMultiple(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.bookmarkMultiple(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return bookmarkMultiple(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
