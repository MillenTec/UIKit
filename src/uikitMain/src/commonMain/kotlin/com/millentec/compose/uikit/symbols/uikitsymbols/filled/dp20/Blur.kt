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

fun UIKitFilledSymbols.blur(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Blur",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Blur",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 2f)
                    curveTo(5.582f, 2f, 2f, 5.582f, 2f, 10f)
                    curveTo(2f, 14.418f, 5.582f, 18f, 10f, 18f)
                    curveTo(12.029f, 18f, 13.881f, 17.245f, 15.292f, 16f)
                    horizontalLineTo(10f)
                    verticalLineTo(15f)
                    horizontalLineTo(16.245f)
                    curveTo(16.498f, 14.685f, 16.727f, 14.351f, 16.93f, 14f)
                    horizontalLineTo(10f)
                    verticalLineTo(13f)
                    horizontalLineTo(17.419f)
                    curveTo(17.549f, 12.677f, 17.66f, 12.343f, 17.748f, 12f)
                    horizontalLineTo(10f)
                    verticalLineTo(11f)
                    horizontalLineTo(17.938f)
                    curveTo(17.979f, 10.672f, 18f, 10.339f, 18f, 10f)
                    horizontalLineTo(10f)
                    verticalLineTo(9f)
                    horizontalLineTo(17.938f)
                    curveTo(17.896f, 8.66f, 17.832f, 8.326f, 17.748f, 8f)
                    horizontalLineTo(10f)
                    verticalLineTo(7f)
                    horizontalLineTo(17.419f)
                    curveTo(17.278f, 6.654f, 17.115f, 6.32f, 16.93f, 6f)
                    horizontalLineTo(10f)
                    verticalLineTo(5f)
                    horizontalLineTo(16.245f)
                    curveTo(15.957f, 4.64f, 15.637f, 4.305f, 15.292f, 4f)
                    horizontalLineTo(10f)
                    verticalLineTo(3f)
                    horizontalLineTo(13.876f)
                    curveTo(12.728f, 2.363f, 11.406f, 2f, 10f, 2f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.blur(
    color: Color
) = blur(
    SolidColor(color)
)