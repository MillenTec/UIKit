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
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitRegularSymbols.code(
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
                    moveTo(12.967f, 3.68f)
                    curveTo(13.066f, 3.422f, 12.937f, 3.133f, 12.679f, 3.033f)
                    curveTo(12.422f, 2.934f, 12.132f, 3.063f, 12.033f, 3.321f)
                    lineTo(7.033f, 16.321f)
                    curveTo(6.934f, 16.578f, 7.063f, 16.868f, 7.321f, 16.967f)
                    curveTo(7.578f, 17.066f, 7.868f, 16.937f, 7.967f, 16.68f)
                    lineTo(12.967f, 3.68f)
                    close()
                    moveTo(5.825f, 6.121f)
                    curveTo(6.035f, 6.3f, 6.059f, 6.616f, 5.88f, 6.826f)
                    lineTo(3.159f, 10f)
                    lineTo(5.88f, 13.175f)
                    curveTo(6.059f, 13.384f, 6.035f, 13.7f, 5.825f, 13.88f)
                    curveTo(5.616f, 14.059f, 5.3f, 14.035f, 5.12f, 13.825f)
                    lineTo(2.12f, 10.325f)
                    curveTo(1.96f, 10.138f, 1.96f, 9.862f, 2.12f, 9.675f)
                    lineTo(5.12f, 6.175f)
                    curveTo(5.3f, 5.965f, 5.616f, 5.941f, 5.825f, 6.121f)
                    close()
                    moveTo(14.175f, 14.38f)
                    curveTo(13.965f, 14.2f, 13.941f, 13.884f, 14.12f, 13.675f)
                    lineTo(16.841f, 10.5f)
                    lineTo(14.12f, 7.326f)
                    curveTo(13.941f, 7.116f, 13.965f, 6.8f, 14.175f, 6.62f)
                    curveTo(14.384f, 6.441f, 14.7f, 6.465f, 14.88f, 6.675f)
                    lineTo(17.88f, 10.175f)
                    curveTo(18.04f, 10.362f, 18.04f, 10.638f, 17.88f, 10.825f)
                    lineTo(14.88f, 14.325f)
                    curveTo(14.7f, 14.535f, 14.384f, 14.559f, 14.175f, 14.38f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.code(
    color: Color
) = code(
    SolidColor(color)
)