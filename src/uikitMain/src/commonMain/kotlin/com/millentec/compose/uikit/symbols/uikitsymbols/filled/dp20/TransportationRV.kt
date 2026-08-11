package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitFilledSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitFilledSymbols.transportationRV(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationRV",
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
                name = "TransportationRV",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(16f, 3f)
                    curveTo(17.105f, 3f, 18f, 3.895f, 18f, 5f)
                    verticalLineTo(6f)
                    curveTo(18f, 6.552f, 17.552f, 7f, 17f, 7f)
                    horizontalLineTo(16.222f)
                    lineTo(17.358f, 10.034f)
                    curveTo(18.292f, 10.203f, 19f, 11.018f, 19f, 12f)
                    verticalLineTo(13f)
                    curveTo(19f, 14.105f, 18.105f, 15f, 17f, 15f)
                    horizontalLineTo(16.95f)
                    curveTo(16.719f, 16.141f, 15.71f, 17f, 14.5f, 17f)
                    curveTo(13.29f, 17f, 12.281f, 16.141f, 12.05f, 15f)
                    horizontalLineTo(8.95f)
                    curveTo(8.719f, 16.141f, 7.709f, 17f, 6.5f, 17f)
                    curveTo(5.291f, 17f, 4.281f, 16.141f, 4.05f, 15f)
                    horizontalLineTo(4f)
                    curveTo(2.895f, 15f, 2f, 14.105f, 2f, 13f)
                    verticalLineTo(5f)
                    curveTo(2f, 3.895f, 2.895f, 3f, 4f, 3f)
                    horizontalLineTo(16f)
                    close()
                    moveTo(6.5f, 13f)
                    curveTo(5.672f, 13f, 5f, 13.672f, 5f, 14.5f)
                    curveTo(5f, 15.328f, 5.672f, 16f, 6.5f, 16f)
                    curveTo(7.328f, 16f, 8f, 15.328f, 8f, 14.5f)
                    curveTo(8f, 13.672f, 7.328f, 13f, 6.5f, 13f)
                    close()
                    moveTo(14.5f, 13f)
                    curveTo(13.672f, 13f, 13f, 13.672f, 13f, 14.5f)
                    curveTo(13f, 15.328f, 13.672f, 16f, 14.5f, 16f)
                    curveTo(15.328f, 16f, 16f, 15.328f, 16f, 14.5f)
                    curveTo(16f, 13.672f, 15.328f, 13f, 14.5f, 13f)
                    close()
                    moveTo(5f, 6f)
                    curveTo(4.448f, 6f, 4f, 6.448f, 4f, 7f)
                    verticalLineTo(9f)
                    lineTo(4.005f, 9.103f)
                    curveTo(4.056f, 9.607f, 4.482f, 10f, 5f, 10f)
                    horizontalLineTo(8f)
                    curveTo(8.552f, 10f, 9f, 9.552f, 9f, 9f)
                    verticalLineTo(7f)
                    curveTo(9f, 6.448f, 8.552f, 6f, 8f, 6f)
                    horizontalLineTo(5f)
                    close()
                    moveTo(13f, 7f)
                    curveTo(12.448f, 7f, 12f, 7.448f, 12f, 8f)
                    verticalLineTo(10f)
                    horizontalLineTo(16.278f)
                    lineTo(15.153f, 7f)
                    horizontalLineTo(13f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.transportationRV(
    color: Color
) = transportationRV(
    SolidColor(color)
)