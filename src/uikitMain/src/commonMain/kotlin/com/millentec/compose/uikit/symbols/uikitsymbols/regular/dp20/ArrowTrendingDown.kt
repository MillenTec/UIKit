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

fun UIKitRegularSymbols.arrowTrendingDown(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowTrendingDown",
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
                name = "ArrowTrendingDown",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.962f, 14.691f)
                    curveTo(17.938f, 14.75f, 17.902f, 14.806f, 17.854f, 14.854f)
                    curveTo(17.806f, 14.901f, 17.75f, 14.938f, 17.691f, 14.962f)
                    curveTo(17.632f, 14.986f, 17.568f, 15f, 17.5f, 15f)
                    horizontalLineTo(11.5f)
                    curveTo(11.224f, 15f, 11f, 14.776f, 11f, 14.5f)
                    curveTo(11f, 14.224f, 11.224f, 14f, 11.5f, 14f)
                    horizontalLineTo(16.293f)
                    lineTo(10.5f, 8.207f)
                    lineTo(8.354f, 10.354f)
                    curveTo(8.158f, 10.549f, 7.842f, 10.549f, 7.646f, 10.354f)
                    lineTo(2.146f, 4.854f)
                    curveTo(1.951f, 4.658f, 1.951f, 4.342f, 2.146f, 4.146f)
                    curveTo(2.342f, 3.951f, 2.658f, 3.951f, 2.854f, 4.146f)
                    lineTo(8f, 9.293f)
                    lineTo(10.146f, 7.146f)
                    curveTo(10.342f, 6.951f, 10.658f, 6.951f, 10.854f, 7.146f)
                    lineTo(17f, 13.293f)
                    verticalLineTo(8.5f)
                    curveTo(17f, 8.224f, 17.224f, 8f, 17.5f, 8f)
                    curveTo(17.776f, 8f, 18f, 8.224f, 18f, 8.5f)
                    verticalLineTo(14.5f)
                    curveTo(18f, 14.568f, 17.986f, 14.632f, 17.962f, 14.691f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowTrendingDown(
    color: Color
) = arrowTrendingDown(
    SolidColor(color)
)