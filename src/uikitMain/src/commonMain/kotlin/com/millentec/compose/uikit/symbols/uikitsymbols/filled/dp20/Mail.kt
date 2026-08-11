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

fun UIKitFilledSymbols.mail(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Mail",
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
                name = "Mail",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(18f, 7.373f)
                    verticalLineTo(14.5f)
                    curveTo(18f, 15.881f, 16.881f, 17f, 15.5f, 17f)
                    horizontalLineTo(4.5f)
                    curveTo(3.119f, 17f, 2f, 15.881f, 2f, 14.5f)
                    verticalLineTo(7.373f)
                    lineTo(9.746f, 11.931f)
                    curveTo(9.903f, 12.023f, 10.097f, 12.023f, 10.253f, 11.931f)
                    lineTo(18f, 7.373f)
                    close()
                    moveTo(15.5f, 4f)
                    curveTo(16.787f, 4f, 17.847f, 4.973f, 17.985f, 6.223f)
                    lineTo(10f, 10.92f)
                    lineTo(2.015f, 6.223f)
                    curveTo(2.153f, 4.973f, 3.213f, 4f, 4.5f, 4f)
                    horizontalLineTo(15.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.mail(
    color: Color
) = mail(
    SolidColor(color)
)