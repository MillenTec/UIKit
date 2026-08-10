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

fun UIKitRegularSymbols.chevronArrowLeft(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ChevronArrowLeft",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ChevronArrowLeft",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(12.353f, 15.854f)
                    curveTo(12.158f, 16.049f, 11.842f, 16.05f, 11.646f, 15.855f)
                    lineTo(6.162f, 10.39f)
                    curveTo(5.946f, 10.175f, 5.946f, 9.826f, 6.162f, 9.611f)
                    lineTo(11.646f, 4.146f)
                    curveTo(11.842f, 3.951f, 12.158f, 3.951f, 12.353f, 4.147f)
                    curveTo(12.548f, 4.343f, 12.548f, 4.659f, 12.352f, 4.854f)
                    lineTo(7.188f, 10f)
                    lineTo(12.352f, 15.147f)
                    curveTo(12.548f, 15.342f, 12.548f, 15.658f, 12.353f, 15.854f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.chevronArrowLeft(
    color: Color
) = chevronArrowLeft(
    SolidColor(color)
)