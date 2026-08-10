package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.layerDiagonal(
    primary: Brush,
    secondary: Brush,
    tertiary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "LayerDiagonal",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = tertiary) {
            moveTo(9.447f, 2.107f)
            curveTo(10.402f, 1.728f, 11.436f, 2.4f, 11.497f, 3.408f)
            lineTo(5.421f, 5.814f)
            curveTo(4.563f, 6.154f, 4f, 6.983f, 4f, 7.906f)
            verticalLineTo(13.912f)
            curveTo(3.03f, 14.257f, 2f, 13.538f, 2f, 12.498f)
            verticalLineTo(6.755f)
            curveTo(2f, 5.73f, 2.626f, 4.808f, 3.579f, 4.431f)
            lineTo(9.447f, 2.107f)
            close()
        }
        path(fill = secondary) {
            moveTo(12.447f, 4.107f)
            curveTo(13.432f, 3.717f, 14.499f, 4.443f, 14.499f, 5.502f)
            verticalLineTo(5.604f)
            lineTo(9.264f, 7.678f)
            curveTo(8.501f, 7.98f, 8f, 8.717f, 8f, 9.538f)
            verticalLineTo(15.517f)
            lineTo(7.053f, 15.893f)
            curveTo(6.068f, 16.283f, 5f, 15.557f, 5f, 14.498f)
            verticalLineTo(8.416f)
            curveTo(5f, 7.596f, 5.501f, 6.858f, 6.264f, 6.556f)
            lineTo(12.447f, 4.107f)
            close()
        }
        path(fill = primary) {
            moveTo(18f, 7.501f)
            verticalLineTo(14.124f)
            curveTo(18f, 14.739f, 17.624f, 15.292f, 17.052f, 15.519f)
            lineTo(11.052f, 17.895f)
            curveTo(10.068f, 18.285f, 9f, 17.56f, 9f, 16.5f)
            verticalLineTo(9.877f)
            curveTo(9f, 9.262f, 9.376f, 8.709f, 9.948f, 8.483f)
            lineTo(15.948f, 6.106f)
            curveTo(16.932f, 5.716f, 18f, 6.442f, 18f, 7.501f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.layerDiagonal(): ImageVector {
    return layerDiagonal(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
    )
}

fun UIKitSymbols.Filled.layerDiagonal(
    color: Color,
    layered: Boolean
): ImageVector {
    return layerDiagonal(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
