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

fun UIKitFilledSymbols.checkmark(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Checkmark",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Checkmark",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7.032f, 13.907f)
                    lineTo(3.561f, 10.002f)
                    curveTo(3.285f, 9.692f, 2.811f, 9.664f, 2.502f, 9.939f)
                    curveTo(2.192f, 10.215f, 2.164f, 10.689f, 2.439f, 10.998f)
                    lineTo(6.439f, 15.498f)
                    curveTo(6.726f, 15.821f, 7.225f, 15.835f, 7.53f, 15.53f)
                    lineTo(18.03f, 5.03f)
                    curveTo(18.323f, 4.737f, 18.323f, 4.263f, 18.03f, 3.97f)
                    curveTo(17.737f, 3.677f, 17.263f, 3.677f, 16.97f, 3.97f)
                    lineTo(7.032f, 13.907f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.checkmark(
    color: Color
) = checkmark(
    SolidColor(color)
)