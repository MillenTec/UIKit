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

fun UIKitRegularSymbols.download(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Download",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.6f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Download",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 2.002f)
                    curveTo(10.246f, 2.002f, 10.45f, 2.179f, 10.492f, 2.412f)
                    lineTo(10.5f, 2.502f)
                    lineTo(10.496f, 14.296f)
                    lineTo(14.141f, 10.648f)
                    curveTo(14.315f, 10.474f, 14.584f, 10.454f, 14.779f, 10.589f)
                    lineTo(14.849f, 10.647f)
                    curveTo(15.022f, 10.82f, 15.042f, 11.09f, 14.907f, 11.285f)
                    lineTo(14.849f, 11.354f)
                    lineTo(10.357f, 15.854f)
                    curveTo(10.285f, 15.927f, 10.196f, 15.972f, 10.102f, 15.991f)
                    lineTo(9.996f, 16.001f)
                    curveTo(9.835f, 16.001f, 9.692f, 15.925f, 9.601f, 15.807f)
                    lineTo(5.144f, 11.355f)
                    curveTo(4.948f, 11.16f, 4.948f, 10.843f, 5.143f, 10.648f)
                    curveTo(5.317f, 10.474f, 5.586f, 10.454f, 5.781f, 10.589f)
                    lineTo(5.85f, 10.647f)
                    lineTo(9.496f, 14.288f)
                    lineTo(9.5f, 2.502f)
                    curveTo(9.5f, 2.226f, 9.724f, 2.002f, 10f, 2.002f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(15.5f, 17f)
                    curveTo(15.776f, 17f, 16f, 17.224f, 16f, 17.5f)
                    curveTo(16f, 17.745f, 15.823f, 17.949f, 15.59f, 17.992f)
                    lineTo(15.5f, 18f)
                    horizontalLineTo(4.5f)
                    curveTo(4.224f, 18f, 4f, 17.776f, 4f, 17.5f)
                    curveTo(4f, 17.254f, 4.177f, 17.05f, 4.41f, 17.008f)
                    lineTo(4.5f, 17f)
                    horizontalLineTo(15.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.download(
    color: Color,
    layered: Boolean = false
) = download(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)