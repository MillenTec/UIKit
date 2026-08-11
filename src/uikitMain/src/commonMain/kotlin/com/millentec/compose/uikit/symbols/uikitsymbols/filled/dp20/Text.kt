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

fun UIKitFilledSymbols.text(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Text",
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
                name = "Text",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4f, 3.75f)
                    curveTo(4f, 3.336f, 4.336f, 3f, 4.75f, 3f)
                    horizontalLineTo(14.75f)
                    curveTo(15.164f, 3f, 15.5f, 3.336f, 15.5f, 3.75f)
                    verticalLineTo(5.25f)
                    curveTo(15.5f, 5.664f, 15.164f, 6f, 14.75f, 6f)
                    curveTo(14.336f, 6f, 14f, 5.664f, 14f, 5.25f)
                    verticalLineTo(4.5f)
                    horizontalLineTo(10.5f)
                    verticalLineTo(15.5f)
                    horizontalLineTo(11.75f)
                    curveTo(12.164f, 15.5f, 12.5f, 15.836f, 12.5f, 16.25f)
                    curveTo(12.5f, 16.664f, 12.164f, 17f, 11.75f, 17f)
                    horizontalLineTo(7.75f)
                    curveTo(7.336f, 17f, 7f, 16.664f, 7f, 16.25f)
                    curveTo(7f, 15.836f, 7.336f, 15.5f, 7.75f, 15.5f)
                    horizontalLineTo(9f)
                    verticalLineTo(4.5f)
                    horizontalLineTo(5.5f)
                    verticalLineTo(5.25f)
                    curveTo(5.5f, 5.664f, 5.164f, 6f, 4.75f, 6f)
                    curveTo(4.336f, 6f, 4f, 5.664f, 4f, 5.25f)
                    verticalLineTo(3.75f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.text(
    color: Color
) = text(
    SolidColor(color)
)