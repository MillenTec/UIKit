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

fun UIKitRegularSymbols.chevronArrowUp(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ChevronArrowUp",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ChevronArrowUp",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4.147f, 12.353f)
                    curveTo(3.951f, 12.158f, 3.951f, 11.842f, 4.146f, 11.646f)
                    lineTo(9.611f, 6.162f)
                    curveTo(9.826f, 5.946f, 10.175f, 5.946f, 10.39f, 6.162f)
                    lineTo(15.855f, 11.646f)
                    curveTo(16.05f, 11.842f, 16.049f, 12.158f, 15.854f, 12.353f)
                    curveTo(15.658f, 12.548f, 15.342f, 12.548f, 15.147f, 12.352f)
                    lineTo(10f, 7.188f)
                    lineTo(4.854f, 12.352f)
                    curveTo(4.659f, 12.548f, 4.343f, 12.548f, 4.147f, 12.353f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.chevronArrowUp(
    color: Color
) = chevronArrowUp(
    SolidColor(color)
)