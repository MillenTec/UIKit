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

fun UIKitRegularSymbols.add(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Add",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Add",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 2.5f)
                    curveTo(10.276f, 2.5f, 10.5f, 2.724f, 10.5f, 3f)
                    verticalLineTo(9.5f)
                    horizontalLineTo(17f)
                    curveTo(17.276f, 9.5f, 17.5f, 9.724f, 17.5f, 10f)
                    curveTo(17.5f, 10.276f, 17.276f, 10.5f, 17f, 10.5f)
                    horizontalLineTo(10.5f)
                    verticalLineTo(17f)
                    curveTo(10.5f, 17.276f, 10.276f, 17.5f, 10f, 17.5f)
                    curveTo(9.724f, 17.5f, 9.5f, 17.276f, 9.5f, 17f)
                    verticalLineTo(10.5f)
                    horizontalLineTo(3f)
                    curveTo(2.724f, 10.5f, 2.5f, 10.276f, 2.5f, 10f)
                    curveTo(2.5f, 9.724f, 2.724f, 9.5f, 3f, 9.5f)
                    horizontalLineTo(9.5f)
                    verticalLineTo(3f)
                    curveTo(9.5f, 2.724f, 9.724f, 2.5f, 10f, 2.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.add(
    color: Color
) = add(
    SolidColor(color)
)