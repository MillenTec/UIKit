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

fun UIKitFilledSymbols.branchFork(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "BranchFork",
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
                name = "BranchFork",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9f, 5f)
                    curveTo(9f, 6.486f, 7.919f, 7.72f, 6.5f, 7.959f)
                    verticalLineTo(10f)
                    horizontalLineTo(12f)
                    curveTo(12.828f, 10f, 13.5f, 9.328f, 13.5f, 8.5f)
                    verticalLineTo(7.959f)
                    curveTo(12.081f, 7.72f, 11f, 6.486f, 11f, 5f)
                    curveTo(11f, 3.343f, 12.343f, 2f, 14f, 2f)
                    curveTo(15.657f, 2f, 17f, 3.343f, 17f, 5f)
                    curveTo(17f, 6.486f, 15.919f, 7.72f, 14.5f, 7.959f)
                    verticalLineTo(8.5f)
                    curveTo(14.5f, 9.881f, 13.381f, 11f, 12f, 11f)
                    horizontalLineTo(6.5f)
                    verticalLineTo(12.042f)
                    curveTo(7.919f, 12.28f, 9f, 13.514f, 9f, 15f)
                    curveTo(9f, 16.657f, 7.657f, 18f, 6f, 18f)
                    curveTo(4.343f, 18f, 3f, 16.657f, 3f, 15f)
                    curveTo(3f, 13.514f, 4.081f, 12.28f, 5.5f, 12.042f)
                    verticalLineTo(7.959f)
                    curveTo(4.081f, 7.72f, 3f, 6.486f, 3f, 5f)
                    curveTo(3f, 3.343f, 4.343f, 2f, 6f, 2f)
                    curveTo(7.657f, 2f, 9f, 3.343f, 9f, 5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.branchFork(
    color: Color
) = branchFork(
    SolidColor(color)
)