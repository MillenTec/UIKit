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

fun UIKitFilledSymbols.transportationSubway(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationSubway",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "TransportationSubway",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(8.5f, 5f)
                    curveTo(8.224f, 5f, 8f, 5.224f, 8f, 5.5f)
                    curveTo(8f, 5.776f, 8.224f, 6f, 8.5f, 6f)
                    horizontalLineTo(11.5f)
                    curveTo(11.776f, 6f, 12f, 5.776f, 12f, 5.5f)
                    curveTo(12f, 5.224f, 11.776f, 5f, 11.5f, 5f)
                    horizontalLineTo(8.5f)
                    close()
                    moveTo(3f, 6f)
                    curveTo(3f, 4.343f, 4.343f, 3f, 6f, 3f)
                    horizontalLineTo(14f)
                    curveTo(15.657f, 3f, 17f, 4.343f, 17f, 6f)
                    verticalLineTo(14f)
                    curveTo(17f, 15.549f, 15.826f, 16.824f, 14.319f, 16.983f)
                    lineTo(16.703f, 18.043f)
                    curveTo(16.956f, 18.155f, 17.069f, 18.451f, 16.957f, 18.703f)
                    curveTo(16.845f, 18.955f, 16.55f, 19.069f, 16.297f, 18.957f)
                    lineTo(11.894f, 17f)
                    horizontalLineTo(8.106f)
                    lineTo(3.703f, 18.957f)
                    curveTo(3.451f, 19.069f, 3.155f, 18.955f, 3.043f, 18.703f)
                    curveTo(2.931f, 18.451f, 3.045f, 18.155f, 3.297f, 18.043f)
                    lineTo(5.682f, 16.983f)
                    curveTo(4.175f, 16.824f, 3f, 15.549f, 3f, 14f)
                    verticalLineTo(6f)
                    close()
                    moveTo(4f, 6f)
                    verticalLineTo(11f)
                    horizontalLineTo(16f)
                    verticalLineTo(6f)
                    curveTo(16f, 4.895f, 15.105f, 4f, 14f, 4f)
                    horizontalLineTo(6f)
                    curveTo(4.896f, 4f, 4f, 4.895f, 4f, 6f)
                    close()
                    moveTo(8f, 14f)
                    curveTo(8f, 13.448f, 7.553f, 13f, 7f, 13f)
                    curveTo(6.448f, 13f, 6f, 13.448f, 6f, 14f)
                    curveTo(6f, 14.552f, 6.448f, 15f, 7f, 15f)
                    curveTo(7.553f, 15f, 8f, 14.552f, 8f, 14f)
                    close()
                    moveTo(13f, 15f)
                    curveTo(13.552f, 15f, 14f, 14.552f, 14f, 14f)
                    curveTo(14f, 13.448f, 13.552f, 13f, 13f, 13f)
                    curveTo(12.448f, 13f, 12f, 13.448f, 12f, 14f)
                    curveTo(12f, 14.552f, 12.448f, 15f, 13f, 15f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.transportationSubway(
    color: Color
) = transportationSubway(
    SolidColor(color)
)