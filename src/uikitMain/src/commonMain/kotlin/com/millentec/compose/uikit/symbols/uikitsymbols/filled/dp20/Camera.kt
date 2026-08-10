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

fun UIKitFilledSymbols.camera(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Camera",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Camera",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7f, 10f)
                    curveTo(7f, 8.343f, 8.343f, 7f, 10f, 7f)
                    curveTo(11.657f, 7f, 13f, 8.343f, 13f, 10f)
                    curveTo(13f, 11.657f, 11.657f, 13f, 10f, 13f)
                    curveTo(8.343f, 13f, 7f, 11.657f, 7f, 10f)
                    close()
                    moveTo(6.784f, 2.826f)
                    curveTo(7.038f, 2.32f, 7.557f, 2f, 8.124f, 2f)
                    horizontalLineTo(11.888f)
                    curveTo(12.457f, 2f, 12.976f, 2.321f, 13.23f, 2.829f)
                    lineTo(13.815f, 3.999f)
                    horizontalLineTo(15.505f)
                    curveTo(16.886f, 3.999f, 18.005f, 5.119f, 18.005f, 6.499f)
                    verticalLineTo(14.5f)
                    curveTo(18.005f, 15.881f, 16.886f, 17f, 15.505f, 17f)
                    horizontalLineTo(4.505f)
                    curveTo(3.124f, 17f, 2.005f, 15.881f, 2.005f, 14.5f)
                    verticalLineTo(6.499f)
                    curveTo(2.005f, 5.119f, 3.124f, 3.999f, 4.505f, 3.999f)
                    horizontalLineTo(6.194f)
                    lineTo(6.784f, 2.826f)
                    close()
                    moveTo(10f, 6f)
                    curveTo(7.791f, 6f, 6f, 7.791f, 6f, 10f)
                    curveTo(6f, 12.209f, 7.791f, 14f, 10f, 14f)
                    curveTo(12.209f, 14f, 14f, 12.209f, 14f, 10f)
                    curveTo(14f, 7.791f, 12.209f, 6f, 10f, 6f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.camera(
    color: Color
) = camera(
    SolidColor(color)
)