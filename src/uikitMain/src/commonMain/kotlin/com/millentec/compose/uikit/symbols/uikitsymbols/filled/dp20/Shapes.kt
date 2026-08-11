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

fun UIKitFilledSymbols.shapes(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Shapes",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.6f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Shapes",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10.5f, 8f)
                    curveTo(9.119f, 8f, 8f, 9.119f, 8f, 10.5f)
                    verticalLineTo(15.5f)
                    curveTo(8f, 16.881f, 9.119f, 18f, 10.5f, 18f)
                    horizontalLineTo(15.5f)
                    curveTo(16.881f, 18f, 18f, 16.881f, 18f, 15.5f)
                    verticalLineTo(10.5f)
                    curveTo(18f, 9.119f, 16.881f, 8f, 15.5f, 8f)
                    horizontalLineTo(10.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(2f, 7.5f)
                    curveTo(2f, 4.462f, 4.462f, 2f, 7.5f, 2f)
                    curveTo(10.369f, 2f, 12.725f, 4.197f, 12.978f, 7f)
                    horizontalLineTo(10.5f)
                    curveTo(8.567f, 7f, 7f, 8.567f, 7f, 10.5f)
                    verticalLineTo(12.978f)
                    curveTo(4.197f, 12.725f, 2f, 10.369f, 2f, 7.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.shapes(
    color: Color,
    layered: Boolean = false
) = shapes(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)