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

fun UIKitRegularSymbols.checkmark(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Checkmark",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Checkmark",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(3.374f, 10.168f)
                    curveTo(3.19f, 9.961f, 2.874f, 9.943f, 2.668f, 10.126f)
                    curveTo(2.461f, 10.31f, 2.443f, 10.626f, 2.626f, 10.832f)
                    lineTo(6.626f, 15.332f)
                    curveTo(6.817f, 15.547f, 7.15f, 15.557f, 7.354f, 15.354f)
                    lineTo(17.854f, 4.854f)
                    curveTo(18.049f, 4.658f, 18.049f, 4.342f, 17.854f, 4.146f)
                    curveTo(17.658f, 3.951f, 17.342f, 3.951f, 17.146f, 4.146f)
                    lineTo(7.021f, 14.271f)
                    lineTo(3.374f, 10.168f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.checkmark(
    color: Color
) = checkmark(
    SolidColor(color)
)