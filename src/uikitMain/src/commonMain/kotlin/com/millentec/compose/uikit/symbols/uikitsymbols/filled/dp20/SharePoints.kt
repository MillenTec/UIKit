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

fun UIKitFilledSymbols.sharePoints(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "SharePoints",
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
                name = "SharePoints",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17f, 5.5f)
                    curveTo(17f, 6.881f, 15.881f, 8f, 14.5f, 8f)
                    curveTo(13.701f, 8f, 12.99f, 7.626f, 12.533f, 7.043f)
                    lineTo(7.915f, 9.352f)
                    curveTo(7.97f, 9.558f, 8f, 9.776f, 8f, 10f)
                    curveTo(8f, 10.224f, 7.97f, 10.442f, 7.915f, 10.649f)
                    lineTo(12.533f, 12.957f)
                    curveTo(12.99f, 12.374f, 13.701f, 12f, 14.5f, 12f)
                    curveTo(15.881f, 12f, 17f, 13.119f, 17f, 14.5f)
                    curveTo(17f, 15.881f, 15.881f, 17f, 14.5f, 17f)
                    curveTo(13.119f, 17f, 12f, 15.881f, 12f, 14.5f)
                    curveTo(12f, 14.276f, 12.03f, 14.058f, 12.085f, 13.851f)
                    lineTo(7.467f, 11.543f)
                    curveTo(7.01f, 12.126f, 6.299f, 12.5f, 5.5f, 12.5f)
                    curveTo(4.119f, 12.5f, 3f, 11.381f, 3f, 10f)
                    curveTo(3f, 8.619f, 4.119f, 7.5f, 5.5f, 7.5f)
                    curveTo(6.299f, 7.5f, 7.01f, 7.874f, 7.467f, 8.457f)
                    lineTo(12.085f, 6.149f)
                    curveTo(12.03f, 5.942f, 12f, 5.724f, 12f, 5.5f)
                    curveTo(12f, 4.119f, 13.119f, 3f, 14.5f, 3f)
                    curveTo(15.881f, 3f, 17f, 4.119f, 17f, 5.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.sharePoints(
    color: Color
) = sharePoints(
    SolidColor(color)
)