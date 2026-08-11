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

fun UIKitFilledSymbols.bug(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Bug",
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
                name = "Bug",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9f, 2.5f)
                    curveTo(9f, 2.224f, 8.776f, 2f, 8.5f, 2f)
                    curveTo(8.224f, 2f, 8f, 2.224f, 8f, 2.5f)
                    verticalLineTo(3f)
                    curveTo(8f, 3.397f, 8.116f, 3.767f, 8.315f, 4.078f)
                    curveTo(6.988f, 4.388f, 6f, 5.579f, 6f, 7f)
                    horizontalLineTo(5.5f)
                    curveTo(4.672f, 7f, 4f, 6.328f, 4f, 5.5f)
                    verticalLineTo(3.5f)
                    curveTo(4f, 3.224f, 3.776f, 3f, 3.5f, 3f)
                    curveTo(3.224f, 3f, 3f, 3.224f, 3f, 3.5f)
                    verticalLineTo(5.5f)
                    curveTo(3f, 6.881f, 4.119f, 8f, 5.5f, 8f)
                    horizontalLineTo(6f)
                    verticalLineTo(9.5f)
                    horizontalLineTo(2.5f)
                    curveTo(2.224f, 9.5f, 2f, 9.724f, 2f, 10f)
                    curveTo(2f, 10.276f, 2.224f, 10.5f, 2.5f, 10.5f)
                    horizontalLineTo(6f)
                    verticalLineTo(12f)
                    horizontalLineTo(5.5f)
                    curveTo(4.119f, 12f, 3f, 13.119f, 3f, 14.5f)
                    verticalLineTo(16.5f)
                    curveTo(3f, 16.776f, 3.224f, 17f, 3.5f, 17f)
                    curveTo(3.776f, 17f, 4f, 16.776f, 4f, 16.5f)
                    verticalLineTo(14.5f)
                    curveTo(4f, 13.672f, 4.672f, 13f, 5.5f, 13f)
                    horizontalLineTo(6f)
                    curveTo(6f, 15.209f, 7.791f, 17f, 10f, 17f)
                    curveTo(12.209f, 17f, 14f, 15.209f, 14f, 13f)
                    horizontalLineTo(14.5f)
                    curveTo(15.328f, 13f, 16f, 13.672f, 16f, 14.5f)
                    verticalLineTo(16.5f)
                    curveTo(16f, 16.776f, 16.224f, 17f, 16.5f, 17f)
                    curveTo(16.776f, 17f, 17f, 16.776f, 17f, 16.5f)
                    verticalLineTo(14.5f)
                    curveTo(17f, 13.119f, 15.881f, 12f, 14.5f, 12f)
                    horizontalLineTo(14f)
                    verticalLineTo(10.5f)
                    horizontalLineTo(17.5f)
                    curveTo(17.776f, 10.5f, 18f, 10.276f, 18f, 10f)
                    curveTo(18f, 9.724f, 17.776f, 9.5f, 17.5f, 9.5f)
                    horizontalLineTo(14f)
                    verticalLineTo(8f)
                    horizontalLineTo(14.5f)
                    curveTo(15.881f, 8f, 17f, 6.881f, 17f, 5.5f)
                    verticalLineTo(3.5f)
                    curveTo(17f, 3.224f, 16.776f, 3f, 16.5f, 3f)
                    curveTo(16.224f, 3f, 16f, 3.224f, 16f, 3.5f)
                    verticalLineTo(5.5f)
                    curveTo(16f, 6.328f, 15.328f, 7f, 14.5f, 7f)
                    horizontalLineTo(14f)
                    curveTo(14f, 5.579f, 13.012f, 4.388f, 11.685f, 4.078f)
                    curveTo(11.884f, 3.767f, 12f, 3.397f, 12f, 3f)
                    verticalLineTo(2.5f)
                    curveTo(12f, 2.224f, 11.776f, 2f, 11.5f, 2f)
                    curveTo(11.224f, 2f, 11f, 2.224f, 11f, 2.5f)
                    verticalLineTo(3f)
                    curveTo(11f, 3.552f, 10.552f, 4f, 10f, 4f)
                    curveTo(9.448f, 4f, 9f, 3.552f, 9f, 3f)
                    verticalLineTo(2.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.bug(
    color: Color
) = bug(
    SolidColor(color)
)