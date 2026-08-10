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

fun UIKitFilledSymbols.transportationTruck(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationTruck",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "TransportationTruck",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(2.042f, 4.75f)
                    curveTo(2.042f, 3.783f, 2.826f, 3f, 3.792f, 3f)
                    horizontalLineTo(12.25f)
                    curveTo(13.217f, 3f, 14f, 3.783f, 14f, 4.75f)
                    verticalLineTo(6f)
                    lineTo(14.882f, 6f)
                    curveTo(15.451f, 6f, 15.97f, 6.321f, 16.224f, 6.829f)
                    lineTo(17.842f, 10.065f)
                    curveTo(17.946f, 10.273f, 18.001f, 10.503f, 18.001f, 10.736f)
                    verticalLineTo(14.5f)
                    curveTo(18.001f, 15.328f, 17.329f, 16f, 16.501f, 16f)
                    horizontalLineTo(14.95f)
                    curveTo(14.719f, 17.141f, 13.71f, 18f, 12.5f, 18f)
                    curveTo(11.291f, 18f, 10.282f, 17.141f, 10.05f, 16f)
                    horizontalLineTo(8.95f)
                    curveTo(8.719f, 17.141f, 7.71f, 18f, 6.5f, 18f)
                    curveTo(5.291f, 18f, 4.282f, 17.141f, 4.05f, 16f)
                    horizontalLineTo(3.792f)
                    curveTo(2.826f, 16f, 2.042f, 15.217f, 2.042f, 14.25f)
                    verticalLineTo(4.75f)
                    close()
                    moveTo(14f, 7f)
                    verticalLineTo(10f)
                    horizontalLineTo(16.692f)
                    lineTo(15.33f, 7.276f)
                    curveTo(15.245f, 7.107f, 15.072f, 7f, 14.882f, 7f)
                    lineTo(14f, 7f)
                    close()
                    moveTo(6.5f, 14f)
                    curveTo(5.672f, 14f, 5f, 14.672f, 5f, 15.5f)
                    curveTo(5f, 16.328f, 5.672f, 17f, 6.5f, 17f)
                    curveTo(7.329f, 17f, 8f, 16.328f, 8f, 15.5f)
                    curveTo(8f, 14.672f, 7.329f, 14f, 6.5f, 14f)
                    close()
                    moveTo(11f, 15.5f)
                    curveTo(11f, 16.328f, 11.672f, 17f, 12.5f, 17f)
                    curveTo(13.329f, 17f, 14f, 16.328f, 14f, 15.5f)
                    curveTo(14f, 14.672f, 13.329f, 14f, 12.5f, 14f)
                    curveTo(11.672f, 14f, 11f, 14.672f, 11f, 15.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.transportationTruck(
    color: Color
) = transportationTruck(
    SolidColor(color)
)