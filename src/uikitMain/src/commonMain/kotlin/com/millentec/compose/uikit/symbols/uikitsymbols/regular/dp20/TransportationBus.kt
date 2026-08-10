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

fun UIKitRegularSymbols.transportationBus(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationBus",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "TransportationBus",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9f, 4f)
                    curveTo(8.724f, 4f, 8.5f, 4.224f, 8.5f, 4.5f)
                    curveTo(8.5f, 4.776f, 8.724f, 5f, 9f, 5f)
                    horizontalLineTo(11f)
                    curveTo(11.276f, 5f, 11.5f, 4.776f, 11.5f, 4.5f)
                    curveTo(11.5f, 4.224f, 11.276f, 4f, 11f, 4f)
                    horizontalLineTo(9f)
                    close()
                    moveTo(8f, 13f)
                    curveTo(8f, 13.552f, 7.552f, 14f, 7f, 14f)
                    curveTo(6.448f, 14f, 6f, 13.552f, 6f, 13f)
                    curveTo(6f, 12.448f, 6.448f, 12f, 7f, 12f)
                    curveTo(7.552f, 12f, 8f, 12.448f, 8f, 13f)
                    close()
                    moveTo(13f, 14f)
                    curveTo(13.552f, 14f, 14f, 13.552f, 14f, 13f)
                    curveTo(14f, 12.448f, 13.552f, 12f, 13f, 12f)
                    curveTo(12.448f, 12f, 12f, 12.448f, 12f, 13f)
                    curveTo(12f, 13.552f, 12.448f, 14f, 13f, 14f)
                    close()
                    moveTo(3f, 5.5f)
                    curveTo(3f, 3.567f, 4.567f, 2f, 6.5f, 2f)
                    horizontalLineTo(13.5f)
                    curveTo(15.433f, 2f, 17f, 3.567f, 17f, 5.5f)
                    verticalLineTo(8f)
                    horizontalLineTo(18f)
                    curveTo(18.276f, 8f, 18.5f, 8.224f, 18.5f, 8.5f)
                    curveTo(18.5f, 8.776f, 18.276f, 9f, 18f, 9f)
                    horizontalLineTo(17f)
                    verticalLineTo(16.5f)
                    curveTo(17f, 17.328f, 16.328f, 18f, 15.5f, 18f)
                    horizontalLineTo(14.5f)
                    curveTo(13.672f, 18f, 13f, 17.328f, 13f, 16.5f)
                    verticalLineTo(16f)
                    horizontalLineTo(7f)
                    verticalLineTo(16.5f)
                    curveTo(7f, 17.328f, 6.328f, 18f, 5.5f, 18f)
                    horizontalLineTo(4.5f)
                    curveTo(3.672f, 18f, 3f, 17.328f, 3f, 16.5f)
                    verticalLineTo(9f)
                    horizontalLineTo(2f)
                    curveTo(1.724f, 9f, 1.5f, 8.776f, 1.5f, 8.5f)
                    curveTo(1.5f, 8.224f, 1.724f, 8f, 2f, 8f)
                    horizontalLineTo(3f)
                    verticalLineTo(5.5f)
                    close()
                    moveTo(16f, 5.5f)
                    curveTo(16f, 4.119f, 14.881f, 3f, 13.5f, 3f)
                    horizontalLineTo(6.5f)
                    curveTo(5.119f, 3f, 4f, 4.119f, 4f, 5.5f)
                    verticalLineTo(10f)
                    horizontalLineTo(16f)
                    verticalLineTo(5.5f)
                    close()
                    moveTo(14f, 16f)
                    verticalLineTo(16.5f)
                    curveTo(14f, 16.776f, 14.224f, 17f, 14.5f, 17f)
                    horizontalLineTo(15.5f)
                    curveTo(15.776f, 17f, 16f, 16.776f, 16f, 16.5f)
                    verticalLineTo(16f)
                    horizontalLineTo(14f)
                    close()
                    moveTo(4f, 16f)
                    verticalLineTo(16.5f)
                    curveTo(4f, 16.776f, 4.224f, 17f, 4.5f, 17f)
                    horizontalLineTo(5.5f)
                    curveTo(5.776f, 17f, 6f, 16.776f, 6f, 16.5f)
                    verticalLineTo(16f)
                    horizontalLineTo(4f)
                    close()
                    moveTo(4f, 15f)
                    horizontalLineTo(16f)
                    verticalLineTo(11f)
                    horizontalLineTo(4f)
                    verticalLineTo(15f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.transportationBus(
    color: Color
) = transportationBus(
    SolidColor(color)
)