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

fun UIKitFilledSymbols.settings(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Settings",
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
                name = "Settings",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(1.911f, 7.383f)
                    curveTo(2.28f, 6.241f, 2.889f, 5.192f, 3.691f, 4.304f)
                    curveTo(3.827f, 4.153f, 4.04f, 4.1f, 4.231f, 4.168f)
                    lineTo(6.149f, 4.854f)
                    curveTo(6.669f, 5.04f, 7.241f, 4.769f, 7.427f, 4.249f)
                    curveTo(7.445f, 4.198f, 7.46f, 4.145f, 7.469f, 4.092f)
                    lineTo(7.835f, 2.086f)
                    curveTo(7.871f, 1.886f, 8.024f, 1.729f, 8.223f, 1.686f)
                    curveTo(8.803f, 1.563f, 9.398f, 1.5f, 10f, 1.5f)
                    curveTo(10.603f, 1.5f, 11.197f, 1.563f, 11.777f, 1.686f)
                    curveTo(11.975f, 1.728f, 12.128f, 1.886f, 12.165f, 2.085f)
                    lineTo(12.531f, 4.092f)
                    curveTo(12.63f, 4.635f, 13.151f, 4.995f, 13.694f, 4.896f)
                    curveTo(13.748f, 4.886f, 13.8f, 4.872f, 13.851f, 4.854f)
                    lineTo(15.77f, 4.168f)
                    curveTo(15.96f, 4.1f, 16.173f, 4.153f, 16.309f, 4.304f)
                    curveTo(17.112f, 5.192f, 17.72f, 6.241f, 18.09f, 7.383f)
                    curveTo(18.152f, 7.575f, 18.092f, 7.787f, 17.937f, 7.918f)
                    lineTo(16.382f, 9.238f)
                    curveTo(15.962f, 9.595f, 15.91f, 10.226f, 16.267f, 10.647f)
                    curveTo(16.303f, 10.689f, 16.341f, 10.727f, 16.382f, 10.762f)
                    lineTo(17.937f, 12.082f)
                    curveTo(18.092f, 12.213f, 18.152f, 12.425f, 18.09f, 12.617f)
                    curveTo(17.72f, 13.759f, 17.112f, 14.808f, 16.309f, 15.696f)
                    curveTo(16.173f, 15.847f, 15.96f, 15.9f, 15.77f, 15.832f)
                    lineTo(13.851f, 15.146f)
                    curveTo(13.332f, 14.96f, 12.759f, 15.231f, 12.573f, 15.751f)
                    curveTo(12.555f, 15.802f, 12.541f, 15.855f, 12.531f, 15.908f)
                    lineTo(12.165f, 17.915f)
                    curveTo(12.128f, 18.114f, 11.975f, 18.272f, 11.777f, 18.314f)
                    curveTo(11.197f, 18.437f, 10.603f, 18.5f, 10f, 18.5f)
                    curveTo(9.398f, 18.5f, 8.803f, 18.437f, 8.223f, 18.314f)
                    curveTo(8.024f, 18.271f, 7.871f, 18.114f, 7.835f, 17.914f)
                    lineTo(7.469f, 15.908f)
                    curveTo(7.37f, 15.365f, 6.849f, 15.005f, 6.306f, 15.104f)
                    curveTo(6.253f, 15.114f, 6.2f, 15.128f, 6.149f, 15.146f)
                    lineTo(4.231f, 15.832f)
                    curveTo(4.04f, 15.9f, 3.827f, 15.847f, 3.691f, 15.696f)
                    curveTo(2.889f, 14.808f, 2.28f, 13.759f, 1.911f, 12.617f)
                    curveTo(1.849f, 12.425f, 1.909f, 12.213f, 2.063f, 12.082f)
                    lineTo(3.618f, 10.762f)
                    curveTo(4.039f, 10.405f, 4.09f, 9.774f, 3.733f, 9.353f)
                    curveTo(3.698f, 9.311f, 3.659f, 9.273f, 3.618f, 9.238f)
                    lineTo(2.063f, 7.918f)
                    curveTo(1.909f, 7.787f, 1.849f, 7.575f, 1.911f, 7.383f)
                    close()
                    moveTo(8f, 10f)
                    curveTo(8f, 11.105f, 8.896f, 12f, 10f, 12f)
                    curveTo(11.105f, 12f, 12f, 11.105f, 12f, 10f)
                    curveTo(12f, 8.895f, 11.105f, 8f, 10f, 8f)
                    curveTo(8.896f, 8f, 8f, 8.895f, 8f, 10f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.settings(
    color: Color
) = settings(
    SolidColor(color)
)