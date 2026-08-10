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

fun UIKitFilledSymbols.arrowUndo(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowUndo",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "ArrowUndo",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6.862f, 6.5f)
                    horizontalLineTo(9.25f)
                    curveTo(9.664f, 6.5f, 10f, 6.836f, 10f, 7.25f)
                    curveTo(10f, 7.664f, 9.664f, 8f, 9.25f, 8f)
                    horizontalLineTo(4.85f)
                    curveTo(4.381f, 8f, 4f, 7.619f, 4f, 7.15f)
                    verticalLineTo(2.75f)
                    curveTo(4f, 2.336f, 4.336f, 2f, 4.75f, 2f)
                    curveTo(5.164f, 2f, 5.5f, 2.336f, 5.5f, 2.75f)
                    verticalLineTo(5.697f)
                    lineTo(8.559f, 3.038f)
                    curveTo(10.747f, 1.136f, 14.063f, 1.367f, 15.965f, 3.556f)
                    curveTo(17.868f, 5.744f, 17.636f, 9.06f, 15.447f, 10.962f)
                    lineTo(7.275f, 18.066f)
                    curveTo(6.963f, 18.338f, 6.489f, 18.305f, 6.217f, 17.992f)
                    curveTo(5.946f, 17.679f, 5.979f, 17.206f, 6.291f, 16.934f)
                    lineTo(14.463f, 9.83f)
                    curveTo(16.026f, 8.472f, 16.192f, 6.103f, 14.833f, 4.54f)
                    curveTo(13.474f, 2.977f, 11.106f, 2.811f, 9.543f, 4.17f)
                    lineTo(6.862f, 6.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.arrowUndo(
    color: Color
) = arrowUndo(
    SolidColor(color)
)