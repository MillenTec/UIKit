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

fun UIKitFilledSymbols.flash(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Flash",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Flash",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7.212f, 2f)
                    curveTo(6.738f, 2f, 6.321f, 2.314f, 6.191f, 2.771f)
                    lineTo(3.941f, 10.644f)
                    curveTo(3.747f, 11.323f, 4.257f, 11.998f, 4.963f, 11.998f)
                    horizontalLineTo(6.23f)
                    lineTo(5.06f, 16.677f)
                    curveTo(4.796f, 17.733f, 6.101f, 18.455f, 6.856f, 17.673f)
                    lineTo(15.532f, 8.815f)
                    lineTo(15.536f, 8.811f)
                    curveTo(16.176f, 8.144f, 15.715f, 7f, 14.769f, 7f)
                    horizontalLineTo(12.205f)
                    lineTo(13.467f, 3.406f)
                    lineTo(13.469f, 3.398f)
                    curveTo(13.699f, 2.71f, 13.186f, 2f, 12.461f, 2f)
                    horizontalLineTo(7.212f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.flash(
    color: Color
) = flash(
    SolidColor(color)
)