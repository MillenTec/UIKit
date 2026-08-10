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

fun UIKitFilledSymbols.home(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Home",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Home",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(11.002f, 2.388f)
                    curveTo(10.432f, 1.876f, 9.568f, 1.876f, 8.998f, 2.388f)
                    lineTo(3.497f, 7.33f)
                    curveTo(3.181f, 7.614f, 3f, 8.02f, 3f, 8.445f)
                    verticalLineTo(15.5f)
                    curveTo(3f, 16.328f, 3.672f, 17f, 4.5f, 17f)
                    horizontalLineTo(6.5f)
                    curveTo(7.328f, 17f, 8f, 16.328f, 8f, 15.5f)
                    verticalLineTo(11.5f)
                    curveTo(8f, 11.223f, 8.224f, 11f, 8.5f, 11f)
                    horizontalLineTo(11.5f)
                    curveTo(11.776f, 11f, 12f, 11.223f, 12f, 11.5f)
                    verticalLineTo(15.5f)
                    curveTo(12f, 16.328f, 12.672f, 17f, 13.5f, 17f)
                    horizontalLineTo(15.5f)
                    curveTo(16.328f, 17f, 17f, 16.328f, 17f, 15.5f)
                    verticalLineTo(8.445f)
                    curveTo(17f, 8.02f, 16.819f, 7.614f, 16.503f, 7.33f)
                    lineTo(11.002f, 2.388f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.home(
    color: Color
) = home(
    SolidColor(color)
)