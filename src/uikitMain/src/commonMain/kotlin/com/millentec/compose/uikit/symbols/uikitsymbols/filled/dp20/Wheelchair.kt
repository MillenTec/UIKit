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

fun UIKitFilledSymbols.wheelchair(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Wheelchair",
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
                name = "Wheelchair",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7.25f, 9.5f)
                    curveTo(7.457f, 9.5f, 7.661f, 9.515f, 7.86f, 9.544f)
                    curveTo(9.672f, 9.805f, 11.113f, 11.208f, 11.433f, 13f)
                    curveTo(11.476f, 13.243f, 11.5f, 13.494f, 11.5f, 13.75f)
                    curveTo(11.5f, 16.097f, 9.597f, 18f, 7.25f, 18f)
                    curveTo(4.903f, 18f, 3f, 16.097f, 3f, 13.75f)
                    curveTo(3f, 11.403f, 4.903f, 9.5f, 7.25f, 9.5f)
                    close()
                    moveTo(7.266f, 4.238f)
                    curveTo(7.672f, 3.943f, 8.221f, 3.918f, 8.654f, 4.185f)
                    lineTo(12.045f, 6.269f)
                    lineTo(12.936f, 6.8f)
                    curveTo(13.25f, 6.987f, 13.466f, 7.303f, 13.527f, 7.664f)
                    curveTo(13.589f, 8.025f, 13.489f, 8.394f, 13.254f, 8.675f)
                    lineTo(11.727f, 10.5f)
                    horizontalLineTo(15.251f)
                    curveTo(15.63f, 10.5f, 15.988f, 10.672f, 16.226f, 10.968f)
                    curveTo(16.463f, 11.263f, 16.554f, 11.651f, 16.472f, 12.021f)
                    lineTo(15.472f, 16.524f)
                    curveTo(15.322f, 17.198f, 14.654f, 17.623f, 13.981f, 17.474f)
                    curveTo(13.307f, 17.324f, 12.881f, 16.656f, 13.03f, 15.982f)
                    lineTo(13.692f, 13f)
                    horizontalLineTo(12.445f)
                    curveTo(12.146f, 10.91f, 10.618f, 9.218f, 8.616f, 8.68f)
                    lineTo(9.505f, 7.642f)
                    lineTo(8.121f, 6.792f)
                    lineTo(7.063f, 7.699f)
                    curveTo(6.539f, 8.148f, 5.75f, 8.088f, 5.301f, 7.563f)
                    curveTo(4.852f, 7.039f, 4.912f, 6.25f, 5.437f, 5.801f)
                    lineTo(7.187f, 4.301f)
                    lineTo(7.266f, 4.238f)
                    close()
                    moveTo(14f, 2f)
                    curveTo(15.105f, 2f, 16f, 2.895f, 16f, 4f)
                    curveTo(16f, 5.105f, 15.105f, 6f, 14f, 6f)
                    curveTo(12.895f, 6f, 12f, 5.105f, 12f, 4f)
                    curveTo(12f, 2.895f, 12.895f, 2f, 14f, 2f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.wheelchair(
    color: Color
) = wheelchair(
    SolidColor(color)
)