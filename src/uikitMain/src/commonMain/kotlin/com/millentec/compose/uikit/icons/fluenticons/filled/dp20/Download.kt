package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.download(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "Download",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(10.004f, 2f)
            curveTo(10.383f, 2f, 10.697f, 2.282f, 10.747f, 2.648f)
            lineTo(10.754f, 2.75f)
            lineTo(10.753f, 12.943f)
            lineTo(13.719f, 9.972f)
            curveTo(13.985f, 9.706f, 14.402f, 9.681f, 14.696f, 9.899f)
            lineTo(14.78f, 9.971f)
            curveTo(15.046f, 10.238f, 15.071f, 10.654f, 14.853f, 10.948f)
            lineTo(14.781f, 11.032f)
            lineTo(10.538f, 15.283f)
            lineTo(10.467f, 15.345f)
            lineTo(10.376f, 15.404f)
            lineTo(10.34f, 15.425f)
            lineTo(10.249f, 15.463f)
            lineTo(10.128f, 15.493f)
            lineTo(10.059f, 15.501f)
            lineTo(9.999f, 15.503f)
            curveTo(9.949f, 15.503f, 9.898f, 15.497f, 9.848f, 15.487f)
            lineTo(9.767f, 15.464f)
            curveTo(9.671f, 15.433f, 9.584f, 15.382f, 9.51f, 15.318f)
            lineTo(5.221f, 11.033f)
            curveTo(4.927f, 10.74f, 4.927f, 10.265f, 5.22f, 9.972f)
            curveTo(5.486f, 9.706f, 5.903f, 9.681f, 6.196f, 9.899f)
            lineTo(6.28f, 9.972f)
            lineTo(9.253f, 12.939f)
            lineTo(9.254f, 2.75f)
            curveTo(9.254f, 2.336f, 9.589f, 2f, 10.004f, 2f)
            close()
        }
        path(fill = secondary) {
            moveTo(15.245f, 16.498f)
            curveTo(15.659f, 16.498f, 15.995f, 16.834f, 15.995f, 17.248f)
            curveTo(15.995f, 17.628f, 15.712f, 17.942f, 15.346f, 17.991f)
            lineTo(15.245f, 17.998f)
            horizontalLineTo(4.75f)
            curveTo(4.336f, 17.998f, 4f, 17.662f, 4f, 17.248f)
            curveTo(4f, 16.868f, 4.282f, 16.555f, 4.648f, 16.505f)
            lineTo(4.75f, 16.498f)
            horizontalLineTo(15.245f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.download(): ImageVector {
    return download(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.download(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return download(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}