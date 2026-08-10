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

fun UIKitFilledSymbols.wrench(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Wrench",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Wrench",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.5f, 2f)
                    curveTo(11.015f, 2f, 9f, 4.015f, 9f, 6.5f)
                    curveTo(9f, 6.793f, 9.029f, 7.081f, 9.083f, 7.359f)
                    lineTo(2.657f, 14.018f)
                    curveTo(1.693f, 15.018f, 1.797f, 16.63f, 2.882f, 17.497f)
                    curveTo(3.825f, 18.25f, 5.184f, 18.17f, 6.031f, 17.311f)
                    lineTo(12.396f, 10.863f)
                    curveTo(12.75f, 10.953f, 13.12f, 11f, 13.5f, 11f)
                    curveTo(15.986f, 11f, 18f, 8.985f, 18f, 6.5f)
                    curveTo(18f, 6.153f, 17.961f, 5.815f, 17.886f, 5.489f)
                    curveTo(17.846f, 5.312f, 17.712f, 5.171f, 17.537f, 5.121f)
                    curveTo(17.362f, 5.07f, 17.174f, 5.119f, 17.045f, 5.248f)
                    lineTo(14.5f, 7.793f)
                    lineTo(12.208f, 5.5f)
                    lineTo(14.753f, 2.955f)
                    curveTo(14.882f, 2.826f, 14.93f, 2.638f, 14.88f, 2.463f)
                    curveTo(14.83f, 2.289f, 14.689f, 2.155f, 14.511f, 2.114f)
                    curveTo(14.186f, 2.039f, 13.847f, 2f, 13.5f, 2f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.wrench(
    color: Color
) = wrench(
    SolidColor(color)
)