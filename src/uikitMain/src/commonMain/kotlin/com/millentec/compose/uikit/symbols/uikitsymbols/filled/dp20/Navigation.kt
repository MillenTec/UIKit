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

fun UIKitFilledSymbols.navigation(
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
                    moveTo(2f, 4.75f)
                    curveTo(2f, 4.336f, 2.336f, 4f, 2.75f, 4f)
                    horizontalLineTo(17.25f)
                    curveTo(17.664f, 4f, 18f, 4.336f, 18f, 4.75f)
                    curveTo(18f, 5.164f, 17.664f, 5.5f, 17.25f, 5.5f)
                    horizontalLineTo(2.75f)
                    curveTo(2.336f, 5.5f, 2f, 5.164f, 2f, 4.75f)
                    close()
                    moveTo(2f, 9.75f)
                    curveTo(2f, 9.336f, 2.336f, 9f, 2.75f, 9f)
                    horizontalLineTo(17.25f)
                    curveTo(17.664f, 9f, 18f, 9.336f, 18f, 9.75f)
                    curveTo(18f, 10.164f, 17.664f, 10.5f, 17.25f, 10.5f)
                    horizontalLineTo(2.75f)
                    curveTo(2.336f, 10.5f, 2f, 10.164f, 2f, 9.75f)
                    close()
                    moveTo(2.75f, 14f)
                    curveTo(2.336f, 14f, 2f, 14.336f, 2f, 14.75f)
                    curveTo(2f, 15.164f, 2.336f, 15.5f, 2.75f, 15.5f)
                    horizontalLineTo(17.25f)
                    curveTo(17.664f, 15.5f, 18f, 15.164f, 18f, 14.75f)
                    curveTo(18f, 14.336f, 17.664f, 14f, 17.25f, 14f)
                    horizontalLineTo(2.75f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.navigation(
    color: Color
) = navigation(
    SolidColor(color)
)