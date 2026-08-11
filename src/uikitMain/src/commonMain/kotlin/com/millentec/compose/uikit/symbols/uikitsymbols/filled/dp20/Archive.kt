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

fun UIKitFilledSymbols.archive(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Archive",
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
                name = "Archive",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(2f, 4.25f)
                    curveTo(2f, 3.56f, 2.56f, 3f, 3.25f, 3f)
                    horizontalLineTo(16.75f)
                    curveTo(17.44f, 3f, 18f, 3.56f, 18f, 4.25f)
                    verticalLineTo(5.75f)
                    curveTo(18f, 6.44f, 17.44f, 7f, 16.75f, 7f)
                    horizontalLineTo(3.25f)
                    curveTo(2.56f, 7f, 2f, 6.44f, 2f, 5.75f)
                    verticalLineTo(4.25f)
                    close()
                    moveTo(3f, 8f)
                    horizontalLineTo(17f)
                    verticalLineTo(14f)
                    curveTo(17f, 15.657f, 15.657f, 17f, 14f, 17f)
                    horizontalLineTo(6f)
                    curveTo(4.343f, 17f, 3f, 15.657f, 3f, 14f)
                    verticalLineTo(8f)
                    close()
                    moveTo(8.5f, 10f)
                    curveTo(8.224f, 10f, 8f, 10.224f, 8f, 10.5f)
                    curveTo(8f, 10.776f, 8.224f, 11f, 8.5f, 11f)
                    horizontalLineTo(11.5f)
                    curveTo(11.776f, 11f, 12f, 10.776f, 12f, 10.5f)
                    curveTo(12f, 10.224f, 11.776f, 10f, 11.5f, 10f)
                    horizontalLineTo(8.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.archive(
    color: Color
) = archive(
    SolidColor(color)
)