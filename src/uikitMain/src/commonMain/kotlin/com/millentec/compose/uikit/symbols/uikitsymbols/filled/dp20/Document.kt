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

fun UIKitFilledSymbols.document(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Document",
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
                name = "Document",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 2f)
                    verticalLineTo(6.5f)
                    curveTo(10f, 7.328f, 10.672f, 8f, 11.5f, 8f)
                    horizontalLineTo(16f)
                    verticalLineTo(16.5f)
                    curveTo(16f, 17.328f, 15.328f, 18f, 14.5f, 18f)
                    horizontalLineTo(5.5f)
                    curveTo(4.672f, 18f, 4f, 17.328f, 4f, 16.5f)
                    verticalLineTo(3.5f)
                    curveTo(4f, 2.672f, 4.672f, 2f, 5.5f, 2f)
                    horizontalLineTo(10f)
                    close()
                    moveTo(11f, 2.25f)
                    verticalLineTo(6.5f)
                    curveTo(11f, 6.776f, 11.224f, 7f, 11.5f, 7f)
                    horizontalLineTo(15.75f)
                    lineTo(11f, 2.25f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.document(
    color: Color
) = document(
    SolidColor(color)
)