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

fun UIKitFilledSymbols.chevronArrowLeft(
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
                    moveTo(12.269f, 15.794f)
                    curveTo(11.969f, 16.08f, 11.494f, 16.068f, 11.208f, 15.768f)
                    lineTo(6.207f, 10.518f)
                    curveTo(5.931f, 10.228f, 5.931f, 9.773f, 6.207f, 9.483f)
                    lineTo(11.208f, 4.233f)
                    curveTo(11.494f, 3.933f, 11.969f, 3.921f, 12.269f, 4.207f)
                    curveTo(12.568f, 4.493f, 12.58f, 4.967f, 12.294f, 5.267f)
                    lineTo(7.786f, 10f)
                    lineTo(12.294f, 14.734f)
                    curveTo(12.58f, 15.034f, 12.568f, 15.508f, 12.269f, 15.794f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.chevronArrowLeft(
    color: Color
) = chevronArrowLeft(
    SolidColor(color)
)