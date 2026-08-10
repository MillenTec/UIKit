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

fun UIKitRegularSymbols.text(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Text",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
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
                    moveTo(4f, 3.5f)
                    curveTo(4f, 3.224f, 4.224f, 3f, 4.5f, 3f)
                    horizontalLineTo(14.5f)
                    curveTo(14.776f, 3f, 15f, 3.224f, 15f, 3.5f)
                    verticalLineTo(5.5f)
                    curveTo(15f, 5.776f, 14.776f, 6f, 14.5f, 6f)
                    curveTo(14.224f, 6f, 14f, 5.776f, 14f, 5.5f)
                    verticalLineTo(4f)
                    horizontalLineTo(10f)
                    verticalLineTo(16f)
                    horizontalLineTo(11.5f)
                    curveTo(11.776f, 16f, 12f, 16.224f, 12f, 16.5f)
                    curveTo(12f, 16.776f, 11.776f, 17f, 11.5f, 17f)
                    horizontalLineTo(7.5f)
                    curveTo(7.224f, 17f, 7f, 16.776f, 7f, 16.5f)
                    curveTo(7f, 16.224f, 7.224f, 16f, 7.5f, 16f)
                    horizontalLineTo(9f)
                    verticalLineTo(4f)
                    horizontalLineTo(5f)
                    verticalLineTo(5.5f)
                    curveTo(5f, 5.776f, 4.776f, 6f, 4.5f, 6f)
                    curveTo(4.224f, 6f, 4f, 5.776f, 4f, 5.5f)
                    verticalLineTo(3.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.text(
    color: Color
) = text(
    SolidColor(color)
)