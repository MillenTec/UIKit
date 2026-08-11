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

fun UIKitFilledSymbols.arrowRedo(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowRedo",
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
                name = "ArrowRedo",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.141f, 6.5f)
                    horizontalLineTo(10.753f)
                    curveTo(10.339f, 6.5f, 10.003f, 6.836f, 10.003f, 7.25f)
                    curveTo(10.003f, 7.664f, 10.339f, 8f, 10.753f, 8f)
                    horizontalLineTo(15.153f)
                    curveTo(15.623f, 8f, 16.003f, 7.619f, 16.003f, 7.15f)
                    verticalLineTo(2.75f)
                    curveTo(16.003f, 2.336f, 15.667f, 2f, 15.253f, 2f)
                    curveTo(14.839f, 2f, 14.503f, 2.336f, 14.503f, 2.75f)
                    verticalLineTo(5.697f)
                    lineTo(11.444f, 3.038f)
                    curveTo(9.256f, 1.136f, 5.94f, 1.367f, 4.038f, 3.556f)
                    curveTo(2.136f, 5.744f, 2.367f, 9.06f, 4.556f, 10.962f)
                    lineTo(12.728f, 18.066f)
                    curveTo(13.04f, 18.338f, 13.514f, 18.305f, 13.786f, 17.992f)
                    curveTo(14.057f, 17.679f, 14.024f, 17.206f, 13.712f, 16.934f)
                    lineTo(5.54f, 9.83f)
                    curveTo(3.977f, 8.472f, 3.811f, 6.103f, 5.17f, 4.54f)
                    curveTo(6.529f, 2.977f, 8.897f, 2.811f, 10.46f, 4.17f)
                    lineTo(13.141f, 6.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.arrowRedo(
    color: Color
) = arrowRedo(
    SolidColor(color)
)