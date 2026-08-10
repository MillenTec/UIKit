package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.copy(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Copy",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(8f, 2f)
            lineTo(14f, 2f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 4f)
            lineTo(16f, 14f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 16f)
            lineTo(8f, 16f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6f, 14f)
            lineTo(6f, 4f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 2f)
            close()
        }
        path(fill = secondary) {
            moveTo(4f, 6f)
            curveToRelative(0f, -0.74f, 0.4f, -1.39f, 1f, -1.73f)
            verticalLineToRelative(10.23f)
            curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f)
            horizontalLineToRelative(6.23f)
            curveToRelative(-0.35f, 0.6f, -0.99f, 1f, -1.73f, 1f)
            horizontalLineToRelative(-4.5f)
            curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f)
            verticalLineTo(6f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.copy(): ImageVector {
    return copy(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.copy(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return copy(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
