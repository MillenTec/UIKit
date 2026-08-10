package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.wifi(
    primary: Brush,
    secondary: Brush,
    tertiary: Brush,
    fourth: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Wifi",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = fourth) {
            moveTo(16.729f, 7.563f)
            curveTo(17.133f, 7.967f, 17.513f, 8.427f, 17.845f, 8.907f)
            curveTo(18.08f, 9.248f, 17.994f, 9.715f, 17.653f, 9.951f)
            curveTo(17.312f, 10.186f, 16.845f, 10.1f, 16.61f, 9.759f)
            curveTo(16.329f, 9.352f, 16.006f, 8.962f, 15.668f, 8.624f)
            curveTo(12.557f, 5.512f, 7.512f, 5.512f, 4.4f, 8.624f)
            curveTo(4.079f, 8.945f, 3.76f, 9.335f, 3.468f, 9.756f)
            curveTo(3.232f, 10.097f, 2.764f, 10.181f, 2.424f, 9.945f)
            curveTo(2.084f, 9.709f, 1.999f, 9.241f, 2.235f, 8.901f)
            curveTo(2.576f, 8.411f, 2.951f, 7.951f, 3.34f, 7.563f)
            curveTo(7.037f, 3.866f, 13.032f, 3.866f, 16.729f, 7.563f)
            close()
        }
        path(fill = tertiary) {
            moveTo(14.59f, 9.451f)
            curveTo(15.063f, 9.924f, 15.471f, 10.496f, 15.782f, 11.104f)
            curveTo(15.971f, 11.473f, 15.825f, 11.925f, 15.456f, 12.113f)
            curveTo(15.087f, 12.302f, 14.635f, 12.156f, 14.446f, 11.787f)
            curveTo(14.205f, 11.314f, 13.888f, 10.87f, 13.529f, 10.512f)
            curveTo(11.599f, 8.582f, 8.47f, 8.582f, 6.539f, 10.512f)
            curveTo(6.164f, 10.887f, 5.86f, 11.308f, 5.625f, 11.772f)
            curveTo(5.438f, 12.142f, 4.987f, 12.29f, 4.617f, 12.103f)
            curveTo(4.248f, 11.916f, 4.1f, 11.465f, 4.287f, 11.095f)
            curveTo(4.593f, 10.49f, 4.991f, 9.939f, 5.479f, 9.451f)
            curveTo(7.995f, 6.935f, 12.074f, 6.935f, 14.59f, 9.451f)
            close()
        }
        path(fill = secondary) {
            moveTo(12.955f, 11.84f)
            curveTo(13.318f, 12.204f, 13.617f, 12.649f, 13.824f, 13.123f)
            curveTo(13.991f, 13.502f, 13.818f, 13.945f, 13.438f, 14.111f)
            curveTo(13.059f, 14.277f, 12.617f, 14.104f, 12.45f, 13.725f)
            curveTo(12.316f, 13.418f, 12.122f, 13.129f, 11.894f, 12.901f)
            curveTo(10.867f, 11.874f, 9.202f, 11.874f, 8.174f, 12.901f)
            curveTo(7.948f, 13.128f, 7.763f, 13.405f, 7.627f, 13.715f)
            curveTo(7.461f, 14.094f, 7.019f, 14.267f, 6.64f, 14.101f)
            curveTo(6.26f, 13.935f, 6.087f, 13.493f, 6.253f, 13.113f)
            curveTo(6.462f, 12.637f, 6.751f, 12.203f, 7.114f, 11.84f)
            curveTo(8.727f, 10.227f, 11.342f, 10.227f, 12.955f, 11.84f)
            close()
        }
        path(fill = primary) {
            moveTo(10.921f, 13.882f)
            curveTo(11.406f, 14.367f, 11.406f, 15.153f, 10.921f, 15.639f)
            curveTo(10.436f, 16.124f, 9.65f, 16.124f, 9.165f, 15.639f)
            curveTo(8.679f, 15.153f, 8.679f, 14.367f, 9.165f, 13.882f)
            curveTo(9.65f, 13.396f, 10.436f, 13.396f, 10.921f, 13.882f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.wifi(): ImageVector {
    return wifi(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.wifi(
    color: Color,
    layered: Boolean = false,
): ImageVector {
    return wifi(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.45f)) else SolidColor(color)
    )
}