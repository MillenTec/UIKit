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

fun UIKitRegularSymbols.arrowShuffle(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowShuffle",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ArrowShuffle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(15.854f, 4.146f)
                    curveTo(15.658f, 3.951f, 15.342f, 3.951f, 15.146f, 4.146f)
                    curveTo(14.951f, 4.342f, 14.951f, 4.658f, 15.146f, 4.854f)
                    lineTo(16.295f, 6.002f)
                    curveTo(12.973f, 6.075f, 11.013f, 7.904f, 9.191f, 9.605f)
                    lineTo(9.159f, 9.635f)
                    curveTo(7.277f, 11.391f, 5.533f, 13f, 2.5f, 13f)
                    curveTo(2.224f, 13f, 2f, 13.224f, 2f, 13.5f)
                    curveTo(2f, 13.776f, 2.224f, 14f, 2.5f, 14f)
                    curveTo(5.947f, 14f, 7.95f, 12.131f, 9.809f, 10.395f)
                    lineTo(9.841f, 10.366f)
                    curveTo(11.679f, 8.65f, 13.386f, 7.075f, 16.29f, 7.003f)
                    lineTo(15.146f, 8.147f)
                    curveTo(14.951f, 8.342f, 14.951f, 8.658f, 15.146f, 8.854f)
                    curveTo(15.342f, 9.049f, 15.658f, 9.049f, 15.854f, 8.854f)
                    lineTo(17.854f, 6.854f)
                    curveTo(18.049f, 6.658f, 18.049f, 6.342f, 17.854f, 6.146f)
                    lineTo(15.854f, 4.146f)
                    close()
                    moveTo(2.5f, 6f)
                    curveTo(5.311f, 6f, 7.161f, 7.243f, 8.756f, 8.642f)
                    lineTo(8.477f, 8.903f)
                    curveTo(8.322f, 9.048f, 8.17f, 9.19f, 8.019f, 9.328f)
                    curveTo(6.517f, 8.023f, 4.918f, 7f, 2.5f, 7f)
                    curveTo(2.224f, 7f, 2f, 6.776f, 2f, 6.5f)
                    curveTo(2f, 6.224f, 2.224f, 6f, 2.5f, 6f)
                    close()
                    moveTo(16.295f, 13.998f)
                    curveTo(13.599f, 13.939f, 11.8f, 12.723f, 10.244f, 11.358f)
                    lineTo(10.524f, 11.097f)
                    curveTo(10.678f, 10.952f, 10.83f, 10.811f, 10.981f, 10.672f)
                    curveTo(12.439f, 11.939f, 13.989f, 12.94f, 16.29f, 12.997f)
                    lineTo(15.146f, 11.854f)
                    curveTo(14.951f, 11.658f, 14.951f, 11.342f, 15.146f, 11.146f)
                    curveTo(15.342f, 10.951f, 15.658f, 10.951f, 15.854f, 11.146f)
                    lineTo(17.854f, 13.146f)
                    curveTo(18.049f, 13.342f, 18.049f, 13.658f, 17.854f, 13.854f)
                    lineTo(15.854f, 15.854f)
                    curveTo(15.658f, 16.049f, 15.342f, 16.049f, 15.146f, 15.854f)
                    curveTo(14.951f, 15.658f, 14.951f, 15.342f, 15.146f, 15.146f)
                    lineTo(16.295f, 13.998f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowShuffle(
    color: Color
) = arrowShuffle(
    SolidColor(color)
)