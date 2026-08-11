package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitRegularSymbols.flash(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Flash",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush),
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            )
        )
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Flash",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6.191f, 2.771f)
                    curveTo(6.321f, 2.314f, 6.738f, 2f, 7.212f, 2f)
                    horizontalLineTo(12.461f)
                    curveTo(13.186f, 2f, 13.699f, 2.71f, 13.469f, 3.398f)
                    lineTo(13.467f, 3.406f)
                    lineTo(13.467f, 3.406f)
                    lineTo(12.205f, 7f)
                    horizontalLineTo(14.769f)
                    curveTo(15.715f, 7f, 16.176f, 8.144f, 15.536f, 8.811f)
                    lineTo(15.532f, 8.815f)
                    lineTo(15.532f, 8.815f)
                    lineTo(6.856f, 17.673f)
                    curveTo(6.101f, 18.455f, 4.796f, 17.733f, 5.06f, 16.677f)
                    lineTo(6.23f, 11.998f)
                    horizontalLineTo(4.963f)
                    curveTo(4.257f, 11.998f, 3.747f, 11.323f, 3.941f, 10.644f)
                    lineTo(6.191f, 2.771f)
                    close()
                    moveTo(7.212f, 3f)
                    curveTo(7.184f, 3f, 7.16f, 3.018f, 7.152f, 3.045f)
                    lineTo(4.903f, 10.919f)
                    curveTo(4.891f, 10.959f, 4.921f, 10.998f, 4.963f, 10.998f)
                    horizontalLineTo(6.87f)
                    curveTo(7.024f, 10.998f, 7.17f, 11.069f, 7.264f, 11.191f)
                    curveTo(7.359f, 11.312f, 7.393f, 11.47f, 7.355f, 11.62f)
                    lineTo(6.03f, 16.92f)
                    curveTo(6.026f, 16.935f, 6.027f, 16.945f, 6.027f, 16.949f)
                    curveTo(6.028f, 16.953f, 6.029f, 16.957f, 6.03f, 16.96f)
                    curveTo(6.034f, 16.968f, 6.043f, 16.98f, 6.061f, 16.99f)
                    curveTo(6.078f, 16.999f, 6.094f, 17.001f, 6.102f, 17f)
                    curveTo(6.106f, 16.999f, 6.109f, 16.998f, 6.113f, 16.996f)
                    curveTo(6.117f, 16.994f, 6.125f, 16.99f, 6.136f, 16.978f)
                    lineTo(6.14f, 16.975f)
                    lineTo(6.14f, 16.975f)
                    lineTo(14.815f, 8.118f)
                    curveTo(14.827f, 8.105f, 14.83f, 8.095f, 14.832f, 8.086f)
                    curveTo(14.834f, 8.075f, 14.833f, 8.059f, 14.825f, 8.042f)
                    curveTo(14.818f, 8.025f, 14.808f, 8.014f, 14.8f, 8.008f)
                    curveTo(14.795f, 8.004f, 14.787f, 8f, 14.769f, 8f)
                    horizontalLineTo(11.5f)
                    curveTo(11.338f, 8f, 11.186f, 7.921f, 11.092f, 7.789f)
                    curveTo(10.998f, 7.657f, 10.974f, 7.487f, 11.028f, 7.334f)
                    lineTo(12.521f, 3.08f)
                    curveTo(12.533f, 3.04f, 12.503f, 3f, 12.461f, 3f)
                    horizontalLineTo(7.212f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.flash(
    color: Color
) = flash(
    SolidColor(color)
)