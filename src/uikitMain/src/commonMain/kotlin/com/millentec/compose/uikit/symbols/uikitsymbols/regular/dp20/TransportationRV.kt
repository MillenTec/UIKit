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

fun UIKitRegularSymbols.transportationRV(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationRV",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
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
                    moveTo(3f, 13f)
                    curveTo(3f, 13.552f, 3.448f, 14f, 4f, 14f)
                    horizontalLineTo(4.05f)
                    curveTo(4.281f, 12.859f, 5.291f, 12f, 6.5f, 12f)
                    curveTo(7.709f, 12f, 8.719f, 12.859f, 8.95f, 14f)
                    horizontalLineTo(12.05f)
                    curveTo(12.281f, 12.859f, 13.29f, 12f, 14.5f, 12f)
                    curveTo(15.71f, 12f, 16.719f, 12.859f, 16.95f, 14f)
                    horizontalLineTo(17f)
                    curveTo(17.552f, 14f, 18f, 13.552f, 18f, 13f)
                    verticalLineTo(12f)
                    curveTo(18f, 11.448f, 17.552f, 11f, 17f, 11f)
                    horizontalLineTo(3f)
                    verticalLineTo(13f)
                    close()
                    moveTo(4f, 4f)
                    curveTo(3.448f, 4f, 3f, 4.448f, 3f, 5f)
                    verticalLineTo(10f)
                    horizontalLineTo(11f)
                    verticalLineTo(8f)
                    curveTo(11f, 6.895f, 11.895f, 6f, 13f, 6f)
                    horizontalLineTo(17f)
                    verticalLineTo(5f)
                    curveTo(17f, 4.448f, 16.552f, 4f, 16f, 4f)
                    horizontalLineTo(4f)
                    close()
                    moveTo(13f, 7f)
                    curveTo(12.448f, 7f, 12f, 7.448f, 12f, 8f)
                    verticalLineTo(10f)
                    horizontalLineTo(16.278f)
                    lineTo(15.153f, 7f)
                    horizontalLineTo(13f)
                    close()
                    moveTo(8f, 5f)
                    curveTo(8.552f, 5f, 9f, 5.448f, 9f, 6f)
                    verticalLineTo(8f)
                    curveTo(9f, 8.552f, 8.552f, 9f, 8f, 9f)
                    horizontalLineTo(5f)
                    curveTo(4.482f, 9f, 4.056f, 8.607f, 4.005f, 8.103f)
                    lineTo(4f, 8f)
                    verticalLineTo(6f)
                    curveTo(4f, 5.448f, 4.448f, 5f, 5f, 5f)
                    horizontalLineTo(8f)
                    close()
                    moveTo(5f, 8f)
                    horizontalLineTo(8f)
                    verticalLineTo(6f)
                    horizontalLineTo(5f)
                    verticalLineTo(8f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.transportationRV(
    color: Color
) = transportationRV(
    SolidColor(color)
)