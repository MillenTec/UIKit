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

fun UIKitRegularSymbols.search(
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
                    moveTo(13.729f, 14.436f)
                    curveTo(12.592f, 15.411f, 11.115f, 16f, 9.5f, 16f)
                    curveTo(5.91f, 16f, 3f, 13.09f, 3f, 9.5f)
                    curveTo(3f, 5.91f, 5.91f, 3f, 9.5f, 3f)
                    curveTo(13.09f, 3f, 16f, 5.91f, 16f, 9.5f)
                    curveTo(16f, 11.115f, 15.411f, 12.592f, 14.436f, 13.729f)
                    lineTo(17.854f, 17.146f)
                    curveTo(18.049f, 17.342f, 18.049f, 17.658f, 17.854f, 17.854f)
                    curveTo(17.68f, 18.027f, 17.41f, 18.046f, 17.216f, 17.911f)
                    lineTo(17.146f, 17.854f)
                    lineTo(13.729f, 14.436f)
                    close()
                    moveTo(13.02f, 13.727f)
                    curveTo(13.276f, 13.513f, 13.513f, 13.276f, 13.726f, 13.02f)
                    curveTo(14.522f, 12.066f, 15f, 10.839f, 15f, 9.5f)
                    curveTo(15f, 6.462f, 12.538f, 4f, 9.5f, 4f)
                    curveTo(6.462f, 4f, 4f, 6.462f, 4f, 9.5f)
                    curveTo(4f, 12.538f, 6.462f, 15f, 9.5f, 15f)
                    curveTo(10.839f, 15f, 12.066f, 14.522f, 13.02f, 13.727f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.search(
    color: Color
) = search(
    SolidColor(color)
)