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
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitFilledSymbols.chevronArrowRight(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ChevronArrowRight",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush),
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            )
        )
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ChevronArrowRight",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7.733f, 4.207f)
                    curveTo(8.033f, 3.921f, 8.507f, 3.933f, 8.793f, 4.233f)
                    lineTo(13.794f, 9.483f)
                    curveTo(14.07f, 9.773f, 14.07f, 10.228f, 13.794f, 10.518f)
                    lineTo(8.793f, 15.768f)
                    curveTo(8.507f, 16.068f, 8.033f, 16.08f, 7.733f, 15.794f)
                    curveTo(7.433f, 15.508f, 7.421f, 15.034f, 7.707f, 14.734f)
                    lineTo(12.215f, 10f)
                    lineTo(7.707f, 5.267f)
                    curveTo(7.421f, 4.967f, 7.433f, 4.493f, 7.733f, 4.207f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.chevronArrowRight(
    color: Color
) = chevronArrowRight(
    SolidColor(color)
)