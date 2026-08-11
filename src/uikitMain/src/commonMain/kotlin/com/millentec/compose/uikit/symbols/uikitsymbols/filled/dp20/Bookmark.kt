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

fun UIKitFilledSymbols.bookmark(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Bookmark",
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
                name = "Bookmark",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4f, 4.5f)
                    curveTo(4f, 3.119f, 5.119f, 2f, 6.5f, 2f)
                    horizontalLineTo(13.5f)
                    curveTo(14.881f, 2f, 16f, 3.119f, 16f, 4.5f)
                    verticalLineTo(17.5f)
                    curveTo(16f, 17.688f, 15.894f, 17.86f, 15.727f, 17.946f)
                    curveTo(15.559f, 18.031f, 15.358f, 18.015f, 15.206f, 17.904f)
                    lineTo(10f, 14.118f)
                    lineTo(4.794f, 17.904f)
                    curveTo(4.642f, 18.015f, 4.441f, 18.031f, 4.273f, 17.946f)
                    curveTo(4.106f, 17.86f, 4f, 17.688f, 4f, 17.5f)
                    verticalLineTo(4.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.bookmark(
    color: Color
) = bookmark(
    SolidColor(color)
)