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

fun UIKitFilledSymbols.moon(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Moon",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Moon",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(16.359f, 13.997f)
                    curveTo(14.155f, 17.814f, 9.274f, 19.122f, 5.457f, 16.918f)
                    curveTo(4.417f, 16.318f, 3.542f, 15.506f, 2.875f, 14.538f)
                    curveTo(2.653f, 14.214f, 2.797f, 13.767f, 3.167f, 13.635f)
                    curveTo(6.173f, 12.559f, 7.783f, 11.312f, 8.718f, 9.528f)
                    curveTo(9.701f, 7.651f, 9.955f, 5.594f, 9.267f, 2.775f)
                    curveTo(9.172f, 2.385f, 9.48f, 2.014f, 9.881f, 2.035f)
                    curveTo(11.123f, 2.102f, 12.337f, 2.459f, 13.438f, 3.094f)
                    curveTo(17.255f, 5.298f, 18.563f, 10.179f, 16.359f, 13.997f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.moon(
    color: Color
) = moon(
    SolidColor(color)
)