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

fun UIKitRegularSymbols.chevronArrowDown(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ChevronArrowDown",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ChevronArrowDown",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(15.854f, 7.646f)
                    curveTo(16.049f, 7.841f, 16.05f, 8.157f, 15.855f, 8.353f)
                    lineTo(10.39f, 13.837f)
                    curveTo(10.175f, 14.053f, 9.826f, 14.053f, 9.611f, 13.837f)
                    lineTo(4.146f, 8.353f)
                    curveTo(3.951f, 8.157f, 3.951f, 7.841f, 4.147f, 7.646f)
                    curveTo(4.343f, 7.451f, 4.659f, 7.451f, 4.854f, 7.647f)
                    lineTo(10f, 12.812f)
                    lineTo(15.147f, 7.647f)
                    curveTo(15.342f, 7.451f, 15.658f, 7.451f, 15.854f, 7.646f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.chevronArrowDown(
    color: Color
) = chevronArrowDown(
    SolidColor(color)
)