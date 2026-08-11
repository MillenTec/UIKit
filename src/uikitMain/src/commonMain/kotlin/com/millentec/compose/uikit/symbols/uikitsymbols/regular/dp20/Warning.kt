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

fun UIKitRegularSymbols.warning(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Warning",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Warning",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 12.75f)
                    curveTo(10.414f, 12.75f, 10.75f, 13.086f, 10.75f, 13.5f)
                    curveTo(10.75f, 13.914f, 10.414f, 14.25f, 10f, 14.25f)
                    curveTo(9.586f, 14.25f, 9.25f, 13.914f, 9.25f, 13.5f)
                    curveTo(9.25f, 13.086f, 9.586f, 12.75f, 10f, 12.75f)
                    close()
                    moveTo(10f, 6.5f)
                    curveTo(10.276f, 6.5f, 10.5f, 6.724f, 10.5f, 7f)
                    verticalLineTo(11f)
                    curveTo(10.5f, 11.276f, 10.276f, 11.5f, 10f, 11.5f)
                    curveTo(9.724f, 11.5f, 9.5f, 11.276f, 9.5f, 11f)
                    verticalLineTo(7f)
                    curveTo(9.5f, 6.724f, 9.724f, 6.5f, 10f, 6.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(7.37f, 3.556f)
                    curveTo(8.509f, 1.482f, 11.49f, 1.482f, 12.629f, 3.556f)
                    lineTo(18.125f, 13.561f)
                    curveTo(19.223f, 15.56f, 17.776f, 18.005f, 15.495f, 18.005f)
                    horizontalLineTo(4.504f)
                    curveTo(2.223f, 18.005f, 0.777f, 15.56f, 1.875f, 13.561f)
                    lineTo(7.37f, 3.556f)
                    close()
                    moveTo(11.753f, 4.037f)
                    curveTo(10.993f, 2.654f, 9.007f, 2.655f, 8.247f, 4.037f)
                    lineTo(2.751f, 14.042f)
                    curveTo(2.019f, 15.375f, 2.983f, 17.005f, 4.504f, 17.005f)
                    horizontalLineTo(15.495f)
                    curveTo(17.016f, 17.005f, 17.98f, 15.375f, 17.248f, 14.042f)
                    lineTo(11.753f, 4.037f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.warning(
    color: Color,
    layered: Boolean = false
) = warning(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)