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

fun UIKitRegularSymbols.tag(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Tag",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Tag",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14f, 7f)
                    curveTo(14.552f, 7f, 15f, 6.552f, 15f, 6f)
                    curveTo(15f, 5.448f, 14.552f, 5f, 14f, 5f)
                    curveTo(13.448f, 5f, 13f, 5.448f, 13f, 6f)
                    curveTo(13f, 6.552f, 13.448f, 7f, 14f, 7f)
                    close()
                    moveTo(11.129f, 2f)
                    curveTo(10.595f, 1.997f, 10.082f, 2.207f, 9.704f, 2.584f)
                    lineTo(3.022f, 9.249f)
                    curveTo(2.239f, 10.029f, 2.239f, 11.297f, 3.02f, 12.079f)
                    lineTo(7.969f, 17.027f)
                    curveTo(8.75f, 17.808f, 10.016f, 17.808f, 10.797f, 17.027f)
                    lineTo(17.428f, 10.396f)
                    curveTo(17.804f, 10.021f, 18.015f, 9.511f, 18.014f, 8.979f)
                    lineTo(18.007f, 4.029f)
                    curveTo(18.005f, 2.931f, 17.118f, 2.039f, 16.02f, 2.032f)
                    lineTo(11.129f, 2f)
                    close()
                    moveTo(10.41f, 3.292f)
                    curveTo(10.599f, 3.103f, 10.856f, 2.998f, 11.123f, 3f)
                    lineTo(16.013f, 3.032f)
                    curveTo(16.562f, 3.036f, 17.006f, 3.481f, 17.007f, 4.031f)
                    lineTo(17.014f, 8.981f)
                    curveTo(17.014f, 9.246f, 16.909f, 9.501f, 16.721f, 9.689f)
                    lineTo(10.09f, 16.32f)
                    curveTo(9.7f, 16.711f, 9.066f, 16.711f, 8.676f, 16.32f)
                    lineTo(3.727f, 11.372f)
                    curveTo(3.337f, 10.981f, 3.337f, 10.347f, 3.728f, 9.957f)
                    lineTo(10.41f, 3.292f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.tag(
    color: Color
) = tag(
    SolidColor(color)
)