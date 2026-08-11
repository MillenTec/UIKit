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

fun UIKitRegularSymbols.transportationMotorcycle(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationMotorcycle",
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
                name = "TransportationMotorcycle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9.5f, 3f)
                    curveTo(9.224f, 3f, 9f, 3.224f, 9f, 3.5f)
                    curveTo(9f, 3.776f, 9.224f, 4f, 9.5f, 4f)
                    horizontalLineTo(10.632f)
                    curveTo(10.821f, 4f, 10.995f, 4.107f, 11.079f, 4.276f)
                    lineTo(12.469f, 7.055f)
                    curveTo(12.318f, 7.019f, 12.161f, 7f, 12f, 7f)
                    horizontalLineTo(9.854f)
                    curveTo(8.528f, 7f, 7.316f, 7.749f, 6.724f, 8.935f)
                    lineTo(6.191f, 10f)
                    horizontalLineTo(4f)
                    curveTo(2.343f, 10f, 1f, 11.343f, 1f, 13f)
                    curveTo(1f, 14.657f, 2.343f, 16f, 4f, 16f)
                    curveTo(5.306f, 16f, 6.417f, 15.165f, 6.829f, 14f)
                    horizontalLineTo(8.764f)
                    curveTo(9.711f, 14f, 10.576f, 13.465f, 11f, 12.618f)
                    lineTo(11.809f, 11f)
                    horizontalLineTo(12f)
                    curveTo(12.823f, 11f, 13.53f, 10.503f, 13.837f, 9.792f)
                    lineTo(14.23f, 10.578f)
                    curveTo(13.484f, 11.123f, 13f, 12.005f, 13f, 13f)
                    curveTo(13f, 14.657f, 14.343f, 16f, 16f, 16f)
                    curveTo(17.657f, 16f, 19f, 14.657f, 19f, 13f)
                    curveTo(19f, 11.343f, 17.657f, 10f, 16f, 10f)
                    curveTo(15.695f, 10f, 15.401f, 10.045f, 15.124f, 10.13f)
                    lineTo(14.531f, 8.945f)
                    curveTo(14.682f, 8.981f, 14.839f, 9f, 15f, 9f)
                    horizontalLineTo(16.5f)
                    curveTo(16.776f, 9f, 17f, 8.776f, 17f, 8.5f)
                    verticalLineTo(5.5f)
                    curveTo(17f, 5.224f, 16.776f, 5f, 16.5f, 5f)
                    horizontalLineTo(15f)
                    curveTo(14.177f, 5f, 13.47f, 5.497f, 13.163f, 6.208f)
                    lineTo(11.974f, 3.829f)
                    curveTo(11.719f, 3.321f, 11.2f, 3f, 10.632f, 3f)
                    horizontalLineTo(9.5f)
                    close()
                    moveTo(14.687f, 11.491f)
                    lineTo(15.553f, 13.224f)
                    curveTo(15.676f, 13.471f, 15.977f, 13.571f, 16.224f, 13.447f)
                    curveTo(16.471f, 13.324f, 16.571f, 13.023f, 16.447f, 12.776f)
                    lineTo(15.581f, 11.044f)
                    curveTo(15.716f, 11.015f, 15.856f, 11f, 16f, 11f)
                    curveTo(17.105f, 11f, 18f, 11.895f, 18f, 13f)
                    curveTo(18f, 14.105f, 17.105f, 15f, 16f, 15f)
                    curveTo(14.895f, 15f, 14f, 14.105f, 14f, 13f)
                    curveTo(14f, 12.398f, 14.266f, 11.858f, 14.687f, 11.491f)
                    close()
                    moveTo(15f, 6f)
                    horizontalLineTo(16f)
                    verticalLineTo(8f)
                    horizontalLineTo(15f)
                    curveTo(14.448f, 8f, 14f, 7.552f, 14f, 7f)
                    curveTo(14f, 6.448f, 14.448f, 6f, 15f, 6f)
                    close()
                    moveTo(6.236f, 11f)
                    horizontalLineTo(10.691f)
                    lineTo(10.106f, 12.171f)
                    curveTo(9.851f, 12.679f, 9.332f, 13f, 8.764f, 13f)
                    horizontalLineTo(7f)
                    curveTo(7f, 12.232f, 6.711f, 11.531f, 6.236f, 11f)
                    close()
                    moveTo(11.511f, 10f)
                    curveTo(11.504f, 10f, 11.497f, 10f, 11.49f, 10f)
                    horizontalLineTo(7.309f)
                    lineTo(7.618f, 9.382f)
                    curveTo(8.042f, 8.535f, 8.907f, 8f, 9.854f, 8f)
                    horizontalLineTo(12f)
                    curveTo(12.552f, 8f, 13f, 8.448f, 13f, 9f)
                    curveTo(13f, 9.552f, 12.552f, 10f, 12f, 10f)
                    horizontalLineTo(11.511f)
                    close()
                    moveTo(4f, 11f)
                    curveTo(5.105f, 11f, 6f, 11.895f, 6f, 13f)
                    curveTo(6f, 14.105f, 5.105f, 15f, 4f, 15f)
                    curveTo(2.895f, 15f, 2f, 14.105f, 2f, 13f)
                    curveTo(2f, 11.895f, 2.895f, 11f, 4f, 11f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.transportationMotorcycle(
    color: Color
) = transportationMotorcycle(
    SolidColor(color)
)