package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitRegularSymbols.cut(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Cut",
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
                name = "Cut",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(5.919f, 2.228f)
                    curveTo(5.769f, 1.996f, 5.459f, 1.93f, 5.228f, 2.081f)
                    curveTo(4.996f, 2.231f, 4.93f, 2.541f, 5.081f, 2.772f)
                    lineTo(9.404f, 9.429f)
                    lineTo(7.481f, 12.39f)
                    curveTo(7.044f, 12.142f, 6.539f, 12f, 6f, 12f)
                    curveTo(4.343f, 12f, 3f, 13.343f, 3f, 15f)
                    curveTo(3f, 16.657f, 4.343f, 18f, 6f, 18f)
                    curveTo(7.657f, 18f, 9f, 16.657f, 9f, 15f)
                    curveTo(9f, 14.245f, 8.721f, 13.554f, 8.26f, 13.027f)
                    lineTo(10f, 10.347f)
                    lineTo(11.74f, 13.027f)
                    curveTo(11.279f, 13.554f, 11f, 14.245f, 11f, 15f)
                    curveTo(11f, 16.657f, 12.343f, 18f, 14f, 18f)
                    curveTo(15.657f, 18f, 17f, 16.657f, 17f, 15f)
                    curveTo(17f, 13.343f, 15.657f, 12f, 14f, 12f)
                    curveTo(13.461f, 12f, 12.956f, 12.142f, 12.519f, 12.39f)
                    lineTo(5.919f, 2.228f)
                    close()
                    moveTo(14f, 17f)
                    curveTo(12.895f, 17f, 12f, 16.105f, 12f, 15f)
                    curveTo(12f, 13.895f, 12.895f, 13f, 14f, 13f)
                    curveTo(15.105f, 13f, 16f, 13.895f, 16f, 15f)
                    curveTo(16f, 16.105f, 15.105f, 17f, 14f, 17f)
                    close()
                    moveTo(4f, 15f)
                    curveTo(4f, 13.895f, 4.895f, 13f, 6f, 13f)
                    curveTo(7.105f, 13f, 8f, 13.895f, 8f, 15f)
                    curveTo(8f, 16.105f, 7.105f, 17f, 6f, 17f)
                    curveTo(4.895f, 17f, 4f, 16.105f, 4f, 15f)
                    close()
                    moveTo(11.192f, 8.511f)
                    lineTo(10.596f, 7.593f)
                    lineTo(14.081f, 2.228f)
                    curveTo(14.231f, 1.996f, 14.541f, 1.93f, 14.772f, 2.081f)
                    curveTo(15.004f, 2.231f, 15.07f, 2.541f, 14.919f, 2.772f)
                    lineTo(11.192f, 8.511f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.cut(
    color: Color
) = cut(
    SolidColor(color)
)