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

fun UIKitFilledSymbols.search(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Search",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Search",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.535f, 14.596f)
                    curveTo(12.427f, 15.475f, 11.025f, 16f, 9.5f, 16f)
                    curveTo(5.91f, 16f, 3f, 13.09f, 3f, 9.5f)
                    curveTo(3f, 5.91f, 5.91f, 3f, 9.5f, 3f)
                    curveTo(13.09f, 3f, 16f, 5.91f, 16f, 9.5f)
                    curveTo(16f, 11.025f, 15.475f, 12.427f, 14.596f, 13.535f)
                    lineTo(18.03f, 16.97f)
                    curveTo(18.323f, 17.263f, 18.323f, 17.737f, 18.03f, 18.03f)
                    curveTo(17.764f, 18.297f, 17.347f, 18.321f, 17.054f, 18.103f)
                    lineTo(16.97f, 18.03f)
                    lineTo(13.535f, 14.596f)
                    close()
                    moveTo(14.5f, 9.5f)
                    curveTo(14.5f, 6.739f, 12.261f, 4.5f, 9.5f, 4.5f)
                    curveTo(6.739f, 4.5f, 4.5f, 6.739f, 4.5f, 9.5f)
                    curveTo(4.5f, 12.261f, 6.739f, 14.5f, 9.5f, 14.5f)
                    curveTo(12.261f, 14.5f, 14.5f, 12.261f, 14.5f, 9.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.search(
    color: Color
) = search(
    SolidColor(color)
)