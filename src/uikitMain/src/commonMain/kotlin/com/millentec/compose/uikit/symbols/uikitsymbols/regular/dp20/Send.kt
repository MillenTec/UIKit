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

fun UIKitRegularSymbols.send(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Send",
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
                name = "Send",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(2.184f, 2.112f)
                    curveTo(2.337f, 1.988f, 2.548f, 1.965f, 2.724f, 2.053f)
                    lineTo(17.724f, 9.553f)
                    curveTo(17.893f, 9.637f, 18f, 9.811f, 18f, 10f)
                    curveTo(18f, 10.189f, 17.893f, 10.363f, 17.724f, 10.447f)
                    lineTo(2.724f, 17.947f)
                    curveTo(2.548f, 18.035f, 2.337f, 18.012f, 2.184f, 17.888f)
                    curveTo(2.032f, 17.763f, 1.966f, 17.561f, 2.017f, 17.371f)
                    lineTo(3.983f, 10f)
                    lineTo(2.017f, 2.629f)
                    curveTo(1.966f, 2.439f, 2.032f, 2.237f, 2.184f, 2.112f)
                    close()
                    moveTo(4.884f, 10.5f)
                    lineTo(3.269f, 16.556f)
                    lineTo(16.382f, 10f)
                    lineTo(3.269f, 3.444f)
                    lineTo(4.884f, 9.5f)
                    horizontalLineTo(11.5f)
                    curveTo(11.776f, 9.5f, 12f, 9.724f, 12f, 10f)
                    curveTo(12f, 10.276f, 11.776f, 10.5f, 11.5f, 10.5f)
                    horizontalLineTo(4.884f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.send(
    color: Color
) = send(
    SolidColor(color)
)