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

fun UIKitRegularSymbols.cloud(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Cloud",
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
                name = "Cloud",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 4f)
                    curveTo(12.817f, 4f, 14.415f, 5.923f, 14.647f, 8.246f)
                    lineTo(14.718f, 8.246f)
                    curveTo(16.531f, 8.246f, 18f, 9.758f, 18f, 11.623f)
                    curveTo(18f, 13.488f, 16.531f, 15f, 14.718f, 15f)
                    horizontalLineTo(5.282f)
                    curveTo(3.469f, 15f, 2f, 13.488f, 2f, 11.623f)
                    curveTo(2f, 9.82f, 3.373f, 8.347f, 5.102f, 8.251f)
                    lineTo(5.353f, 8.246f)
                    curveTo(5.587f, 5.908f, 7.183f, 4f, 10f, 4f)
                    close()
                    moveTo(10f, 5f)
                    curveTo(7.886f, 5f, 6.551f, 6.316f, 6.348f, 8.345f)
                    curveTo(6.297f, 8.857f, 5.867f, 9.246f, 5.353f, 9.246f)
                    lineTo(5.282f, 9.246f)
                    curveTo(4.028f, 9.246f, 3f, 10.304f, 3f, 11.623f)
                    curveTo(3f, 12.942f, 4.028f, 14f, 5.282f, 14f)
                    horizontalLineTo(14.718f)
                    curveTo(15.972f, 14f, 17f, 12.942f, 17f, 11.623f)
                    curveTo(17f, 10.304f, 15.972f, 9.246f, 14.718f, 9.246f)
                    lineTo(14.647f, 9.246f)
                    curveTo(14.133f, 9.246f, 13.703f, 8.857f, 13.652f, 8.346f)
                    curveTo(13.45f, 6.325f, 12.108f, 5f, 10f, 5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.cloud(
    color: Color
) = cloud(
    SolidColor(color)
)