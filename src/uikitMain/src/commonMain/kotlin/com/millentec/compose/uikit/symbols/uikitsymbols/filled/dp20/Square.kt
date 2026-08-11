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

fun UIKitFilledSymbols.square(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Square",
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
                name = "Square",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(3f, 6f)
                    curveTo(3f, 4.343f, 4.343f, 3f, 6f, 3f)
                    horizontalLineTo(14f)
                    curveTo(15.657f, 3f, 17f, 4.343f, 17f, 6f)
                    verticalLineTo(14f)
                    curveTo(17f, 15.657f, 15.657f, 17f, 14f, 17f)
                    horizontalLineTo(6f)
                    curveTo(4.343f, 17f, 3f, 15.657f, 3f, 14f)
                    verticalLineTo(6f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.square(
    color: Color
) = square(
    SolidColor(color)
)