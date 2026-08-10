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

fun UIKitRegularSymbols.arrowMove(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowMove",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ArrowMove",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10.354f, 2.146f)
                    curveTo(10.26f, 2.053f, 10.133f, 2f, 10f, 2f)
                    curveTo(9.867f, 2f, 9.74f, 2.053f, 9.646f, 2.146f)
                    lineTo(7.146f, 4.646f)
                    curveTo(6.951f, 4.842f, 6.951f, 5.158f, 7.146f, 5.354f)
                    curveTo(7.342f, 5.549f, 7.658f, 5.549f, 7.854f, 5.354f)
                    lineTo(9.5f, 3.707f)
                    verticalLineTo(7.5f)
                    curveTo(9.5f, 7.776f, 9.724f, 8f, 10f, 8f)
                    curveTo(10.276f, 8f, 10.5f, 7.776f, 10.5f, 7.5f)
                    verticalLineTo(3.707f)
                    lineTo(12.146f, 5.354f)
                    curveTo(12.342f, 5.549f, 12.658f, 5.549f, 12.854f, 5.354f)
                    curveTo(13.049f, 5.158f, 13.049f, 4.842f, 12.854f, 4.646f)
                    lineTo(10.354f, 2.146f)
                    close()
                    moveTo(2.146f, 9.646f)
                    curveTo(2.053f, 9.74f, 2f, 9.867f, 2f, 10f)
                    curveTo(2f, 10.133f, 2.053f, 10.26f, 2.146f, 10.354f)
                    lineTo(4.646f, 12.854f)
                    curveTo(4.842f, 13.049f, 5.158f, 13.049f, 5.354f, 12.854f)
                    curveTo(5.549f, 12.658f, 5.549f, 12.342f, 5.354f, 12.146f)
                    lineTo(3.707f, 10.5f)
                    horizontalLineTo(7.5f)
                    curveTo(7.776f, 10.5f, 8f, 10.276f, 8f, 10f)
                    curveTo(8f, 9.724f, 7.776f, 9.5f, 7.5f, 9.5f)
                    horizontalLineTo(3.707f)
                    lineTo(5.354f, 7.854f)
                    curveTo(5.549f, 7.658f, 5.549f, 7.342f, 5.354f, 7.146f)
                    curveTo(5.158f, 6.951f, 4.842f, 6.951f, 4.646f, 7.146f)
                    lineTo(2.146f, 9.646f)
                    close()
                    moveTo(10f, 18f)
                    curveTo(9.867f, 18f, 9.74f, 17.947f, 9.646f, 17.854f)
                    lineTo(7.146f, 15.354f)
                    curveTo(6.951f, 15.158f, 6.951f, 14.842f, 7.146f, 14.646f)
                    curveTo(7.342f, 14.451f, 7.658f, 14.451f, 7.854f, 14.646f)
                    lineTo(9.5f, 16.293f)
                    lineTo(9.5f, 12.5f)
                    curveTo(9.5f, 12.224f, 9.724f, 12f, 10f, 12f)
                    curveTo(10.276f, 12f, 10.5f, 12.224f, 10.5f, 12.5f)
                    verticalLineTo(16.293f)
                    lineTo(12.146f, 14.646f)
                    curveTo(12.342f, 14.451f, 12.658f, 14.451f, 12.854f, 14.646f)
                    curveTo(13.049f, 14.842f, 13.049f, 15.158f, 12.854f, 15.354f)
                    lineTo(10.354f, 17.854f)
                    curveTo(10.26f, 17.947f, 10.133f, 18f, 10f, 18f)
                    close()
                    moveTo(17.854f, 10.354f)
                    curveTo(17.947f, 10.26f, 18f, 10.133f, 18f, 10f)
                    curveTo(18f, 9.867f, 17.947f, 9.74f, 17.854f, 9.646f)
                    lineTo(15.354f, 7.146f)
                    curveTo(15.158f, 6.951f, 14.842f, 6.951f, 14.646f, 7.146f)
                    curveTo(14.451f, 7.342f, 14.451f, 7.658f, 14.646f, 7.854f)
                    lineTo(16.293f, 9.5f)
                    lineTo(12.5f, 9.5f)
                    curveTo(12.224f, 9.5f, 12f, 9.724f, 12f, 10f)
                    curveTo(12f, 10.276f, 12.224f, 10.5f, 12.5f, 10.5f)
                    lineTo(16.293f, 10.5f)
                    lineTo(14.646f, 12.146f)
                    curveTo(14.451f, 12.342f, 14.451f, 12.658f, 14.646f, 12.854f)
                    curveTo(14.842f, 13.049f, 15.158f, 13.049f, 15.354f, 12.854f)
                    lineTo(17.854f, 10.354f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowMove(
    color: Color
) = arrowMove(
    SolidColor(color)
)