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

fun UIKitFilledSymbols.chevronArrowUp(
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
                    moveTo(4.207f, 12.267f)
                    curveTo(3.921f, 11.967f, 3.933f, 11.492f, 4.233f, 11.206f)
                    lineTo(9.483f, 6.205f)
                    curveTo(9.773f, 5.929f, 10.228f, 5.929f, 10.518f, 6.205f)
                    lineTo(15.768f, 11.206f)
                    curveTo(16.068f, 11.492f, 16.08f, 11.967f, 15.794f, 12.267f)
                    curveTo(15.508f, 12.567f, 15.034f, 12.578f, 14.734f, 12.292f)
                    lineTo(10f, 7.784f)
                    lineTo(5.267f, 12.292f)
                    curveTo(4.967f, 12.578f, 4.493f, 12.567f, 4.207f, 12.267f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.chevronArrowUp(
    color: Color
) = chevronArrowUp(
    SolidColor(color)
)