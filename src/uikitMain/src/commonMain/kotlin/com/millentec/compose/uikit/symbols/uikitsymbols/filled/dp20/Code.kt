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

fun UIKitFilledSymbols.code(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Code",
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
                name = "Code",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(12.936f, 4.052f)
                    curveTo(13.103f, 3.673f, 12.931f, 3.231f, 12.552f, 3.064f)
                    curveTo(12.173f, 2.897f, 11.73f, 3.069f, 11.564f, 3.448f)
                    lineTo(6.064f, 15.948f)
                    curveTo(5.897f, 16.327f, 6.069f, 16.77f, 6.448f, 16.937f)
                    curveTo(6.827f, 17.104f, 7.27f, 16.931f, 7.436f, 16.552f)
                    lineTo(12.936f, 4.052f)
                    close()
                    moveTo(14.293f, 13.845f)
                    curveTo(13.964f, 13.592f, 13.903f, 13.121f, 14.156f, 12.793f)
                    lineTo(16.304f, 10f)
                    lineTo(14.156f, 7.207f)
                    curveTo(13.903f, 6.879f, 13.964f, 6.408f, 14.293f, 6.156f)
                    curveTo(14.621f, 5.903f, 15.092f, 5.965f, 15.344f, 6.293f)
                    lineTo(17.844f, 9.543f)
                    curveTo(18.052f, 9.813f, 18.052f, 10.188f, 17.844f, 10.458f)
                    lineTo(15.344f, 13.708f)
                    curveTo(15.092f, 14.036f, 14.621f, 14.097f, 14.293f, 13.845f)
                    close()
                    moveTo(5.707f, 6.156f)
                    curveTo(6.036f, 6.408f, 6.097f, 6.879f, 5.844f, 7.208f)
                    lineTo(3.696f, 10f)
                    lineTo(5.844f, 12.793f)
                    curveTo(6.097f, 13.121f, 6.036f, 13.592f, 5.707f, 13.845f)
                    curveTo(5.379f, 14.097f, 4.908f, 14.036f, 4.656f, 13.708f)
                    lineTo(2.156f, 10.458f)
                    curveTo(1.948f, 10.188f, 1.948f, 9.813f, 2.156f, 9.543f)
                    lineTo(4.656f, 6.293f)
                    curveTo(4.908f, 5.965f, 5.379f, 5.903f, 5.707f, 6.156f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.code(
    color: Color
) = code(
    SolidColor(color)
)