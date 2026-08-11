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

fun UIKitFilledSymbols.usb(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Usb",
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
                name = "Usb",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9.368f, 0.851f)
                    curveTo(9.662f, 0.383f, 10.346f, 0.383f, 10.64f, 0.851f)
                    lineTo(11.889f, 2.847f)
                    curveTo(12.201f, 3.346f, 11.842f, 3.994f, 11.253f, 3.994f)
                    horizontalLineTo(10.75f)
                    verticalLineTo(11.321f)
                    lineTo(13.583f, 8.787f)
                    curveTo(13.848f, 8.55f, 14f, 8.211f, 14f, 7.855f)
                    verticalLineTo(7.5f)
                    horizontalLineTo(13.75f)
                    curveTo(13.336f, 7.5f, 13f, 7.164f, 13f, 6.75f)
                    verticalLineTo(4.75f)
                    curveTo(13f, 4.336f, 13.336f, 4f, 13.75f, 4f)
                    horizontalLineTo(15.75f)
                    curveTo(16.164f, 4f, 16.5f, 4.336f, 16.5f, 4.75f)
                    verticalLineTo(6.75f)
                    curveTo(16.5f, 7.164f, 16.164f, 7.5f, 15.75f, 7.5f)
                    horizontalLineTo(15.5f)
                    verticalLineTo(7.855f)
                    curveTo(15.5f, 8.638f, 15.167f, 9.384f, 14.584f, 9.905f)
                    lineTo(11.167f, 12.963f)
                    curveTo(10.902f, 13.2f, 10.75f, 13.539f, 10.75f, 13.894f)
                    verticalLineTo(15.146f)
                    curveTo(11.483f, 15.443f, 12f, 16.161f, 12f, 17f)
                    curveTo(12f, 18.104f, 11.105f, 19f, 10f, 19f)
                    curveTo(8.895f, 19f, 8f, 18.104f, 8f, 17f)
                    curveTo(8f, 16.236f, 8.429f, 15.571f, 9.059f, 15.234f)
                    curveTo(8.997f, 15.135f, 8.922f, 15.042f, 8.833f, 14.963f)
                    lineTo(5.416f, 11.905f)
                    curveTo(4.833f, 11.384f, 4.5f, 10.638f, 4.5f, 9.855f)
                    verticalLineTo(9.329f)
                    curveTo(3.909f, 9.048f, 3.5f, 8.448f, 3.5f, 7.75f)
                    curveTo(3.5f, 6.783f, 4.284f, 6f, 5.25f, 6f)
                    curveTo(6.216f, 6f, 7f, 6.783f, 7f, 7.75f)
                    curveTo(7f, 8.448f, 6.591f, 9.048f, 6f, 9.329f)
                    verticalLineTo(9.855f)
                    curveTo(6f, 10.211f, 6.152f, 10.55f, 6.417f, 10.787f)
                    lineTo(9.25f, 13.321f)
                    verticalLineTo(3.994f)
                    horizontalLineTo(8.755f)
                    curveTo(8.166f, 3.994f, 7.807f, 3.346f, 8.119f, 2.847f)
                    lineTo(9.368f, 0.851f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.usb(
    color: Color
) = usb(
    SolidColor(color)
)