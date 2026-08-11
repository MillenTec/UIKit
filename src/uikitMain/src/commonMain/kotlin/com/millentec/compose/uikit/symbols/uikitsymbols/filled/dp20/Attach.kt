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
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitFilledSymbols.attach(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Attach",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush),
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            )
        )
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Attach",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(5.28f, 10.609f)
                    lineTo(10.584f, 5.305f)
                    curveTo(11.658f, 4.232f, 13.399f, 4.232f, 14.473f, 5.305f)
                    curveTo(15.547f, 6.379f, 15.547f, 8.121f, 14.473f, 9.195f)
                    lineTo(8.109f, 15.559f)
                    curveTo(7.621f, 16.047f, 6.829f, 16.047f, 6.341f, 15.559f)
                    curveTo(5.853f, 15.07f, 5.853f, 14.279f, 6.341f, 13.791f)
                    lineTo(11.998f, 8.134f)
                    curveTo(12.291f, 7.841f, 12.291f, 7.366f, 11.998f, 7.073f)
                    curveTo(11.705f, 6.78f, 11.23f, 6.78f, 10.937f, 7.073f)
                    lineTo(5.28f, 12.73f)
                    curveTo(4.206f, 13.804f, 4.206f, 15.545f, 5.28f, 16.619f)
                    curveTo(6.354f, 17.693f, 8.095f, 17.693f, 9.169f, 16.619f)
                    lineTo(15.533f, 10.255f)
                    curveTo(17.193f, 8.595f, 17.193f, 5.905f, 15.533f, 4.245f)
                    curveTo(13.874f, 2.585f, 11.183f, 2.585f, 9.523f, 4.245f)
                    lineTo(4.22f, 9.548f)
                    curveTo(3.927f, 9.841f, 3.927f, 10.316f, 4.22f, 10.609f)
                    curveTo(4.513f, 10.902f, 4.987f, 10.902f, 5.28f, 10.609f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.attach(
    color: Color
) = attach(
    SolidColor(color)
)