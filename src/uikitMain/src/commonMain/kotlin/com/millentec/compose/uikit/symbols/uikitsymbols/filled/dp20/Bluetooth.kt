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

fun UIKitFilledSymbols.bluetooth(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Bluetooth",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Bluetooth",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9.463f, 2.057f)
                    curveTo(9.743f, 1.941f, 10.066f, 2.005f, 10.28f, 2.22f)
                    lineTo(14.28f, 6.22f)
                    curveTo(14.431f, 6.37f, 14.51f, 6.577f, 14.499f, 6.789f)
                    curveTo(14.488f, 7.001f, 14.388f, 7.198f, 14.223f, 7.332f)
                    lineTo(10.939f, 10f)
                    lineTo(14.223f, 12.668f)
                    curveTo(14.388f, 12.802f, 14.488f, 12.999f, 14.499f, 13.211f)
                    curveTo(14.51f, 13.423f, 14.431f, 13.63f, 14.28f, 13.78f)
                    lineTo(10.28f, 17.78f)
                    curveTo(10.066f, 17.995f, 9.743f, 18.059f, 9.463f, 17.943f)
                    curveTo(9.183f, 17.827f, 9f, 17.553f, 9f, 17.25f)
                    verticalLineTo(11.576f)
                    lineTo(6.223f, 13.832f)
                    curveTo(5.901f, 14.093f, 5.429f, 14.044f, 5.168f, 13.723f)
                    curveTo(4.907f, 13.401f, 4.956f, 12.929f, 5.277f, 12.668f)
                    lineTo(8.561f, 10f)
                    lineTo(5.277f, 7.332f)
                    curveTo(4.956f, 7.071f, 4.907f, 6.599f, 5.168f, 6.277f)
                    curveTo(5.429f, 5.956f, 5.901f, 5.907f, 6.223f, 6.168f)
                    lineTo(9f, 8.424f)
                    verticalLineTo(2.75f)
                    curveTo(9f, 2.447f, 9.183f, 2.173f, 9.463f, 2.057f)
                    close()
                    moveTo(10.5f, 11.576f)
                    verticalLineTo(15.439f)
                    lineTo(12.632f, 13.308f)
                    lineTo(10.5f, 11.576f)
                    close()
                    moveTo(10.5f, 8.424f)
                    lineTo(12.632f, 6.692f)
                    lineTo(10.5f, 4.561f)
                    verticalLineTo(8.424f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.bluetooth(
    color: Color
) = bluetooth(
    SolidColor(color)
)