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

fun UIKitRegularSymbols.branch(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Branch",
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
                name = "Branch",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 5f)
                    curveTo(10f, 6.36f, 9.095f, 7.508f, 7.855f, 7.876f)
                    curveTo(8.033f, 8.099f, 8.271f, 8.359f, 8.576f, 8.62f)
                    curveTo(9.301f, 9.242f, 10.408f, 9.872f, 12f, 9.983f)
                    curveTo(12.009f, 8.334f, 13.349f, 7f, 15f, 7f)
                    curveTo(16.657f, 7f, 18f, 8.343f, 18f, 10f)
                    curveTo(18f, 11.657f, 16.657f, 13f, 15f, 13f)
                    curveTo(13.691f, 13f, 12.578f, 12.162f, 12.168f, 10.993f)
                    curveTo(10.208f, 10.915f, 8.826f, 10.152f, 7.925f, 9.38f)
                    curveTo(7.769f, 9.246f, 7.627f, 9.112f, 7.5f, 8.982f)
                    verticalLineTo(12.042f)
                    curveTo(8.919f, 12.28f, 10f, 13.514f, 10f, 15f)
                    curveTo(10f, 16.657f, 8.657f, 18f, 7f, 18f)
                    curveTo(5.343f, 18f, 4f, 16.657f, 4f, 15f)
                    curveTo(4f, 13.514f, 5.081f, 12.28f, 6.5f, 12.042f)
                    verticalLineTo(7.959f)
                    curveTo(5.081f, 7.72f, 4f, 6.486f, 4f, 5f)
                    curveTo(4f, 3.343f, 5.343f, 2f, 7f, 2f)
                    curveTo(8.657f, 2f, 10f, 3.343f, 10f, 5f)
                    close()
                    moveTo(7.009f, 7f)
                    curveTo(8.109f, 6.995f, 9f, 6.102f, 9f, 5f)
                    curveTo(9f, 3.895f, 8.105f, 3f, 7f, 3f)
                    curveTo(5.895f, 3f, 5f, 3.895f, 5f, 5f)
                    curveTo(5f, 6.101f, 5.89f, 6.995f, 6.991f, 7f)
                    curveTo(6.997f, 7f, 7.003f, 7f, 7.009f, 7f)
                    close()
                    moveTo(17f, 10f)
                    curveTo(17f, 8.895f, 16.105f, 8f, 15f, 8f)
                    curveTo(13.895f, 8f, 13f, 8.895f, 13f, 10f)
                    curveTo(13f, 11.105f, 13.895f, 12f, 15f, 12f)
                    curveTo(16.105f, 12f, 17f, 11.105f, 17f, 10f)
                    close()
                    moveTo(7f, 17f)
                    curveTo(8.105f, 17f, 9f, 16.105f, 9f, 15f)
                    curveTo(9f, 13.895f, 8.105f, 13f, 7f, 13f)
                    curveTo(5.895f, 13f, 5f, 13.895f, 5f, 15f)
                    curveTo(5f, 16.105f, 5.895f, 17f, 7f, 17f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.branch(
    color: Color
) = branch(
    SolidColor(color)
)