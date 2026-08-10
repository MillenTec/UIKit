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

fun UIKitRegularSymbols.navigation(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Navigation",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Navigation",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(2f, 4.5f)
                    curveTo(2f, 4.224f, 2.224f, 4f, 2.5f, 4f)
                    horizontalLineTo(17.5f)
                    curveTo(17.776f, 4f, 18f, 4.224f, 18f, 4.5f)
                    curveTo(18f, 4.776f, 17.776f, 5f, 17.5f, 5f)
                    horizontalLineTo(2.5f)
                    curveTo(2.224f, 5f, 2f, 4.776f, 2f, 4.5f)
                    close()
                    moveTo(2f, 9.5f)
                    curveTo(2f, 9.224f, 2.224f, 9f, 2.5f, 9f)
                    horizontalLineTo(17.5f)
                    curveTo(17.776f, 9f, 18f, 9.224f, 18f, 9.5f)
                    curveTo(18f, 9.776f, 17.776f, 10f, 17.5f, 10f)
                    horizontalLineTo(2.5f)
                    curveTo(2.224f, 10f, 2f, 9.776f, 2f, 9.5f)
                    close()
                    moveTo(2.5f, 14f)
                    curveTo(2.224f, 14f, 2f, 14.224f, 2f, 14.5f)
                    curveTo(2f, 14.776f, 2.224f, 15f, 2.5f, 15f)
                    horizontalLineTo(17.5f)
                    curveTo(17.776f, 15f, 18f, 14.776f, 18f, 14.5f)
                    curveTo(18f, 14.224f, 17.776f, 14f, 17.5f, 14f)
                    horizontalLineTo(2.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.navigation(
    color: Color
) = navigation(
    SolidColor(color)
)