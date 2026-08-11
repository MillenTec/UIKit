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

fun UIKitRegularSymbols.timer(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Timer",
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
                name = "Timer",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7.5f, 2f)
                    curveTo(7.224f, 2f, 7f, 2.224f, 7f, 2.5f)
                    curveTo(7f, 2.776f, 7.224f, 3f, 7.5f, 3f)
                    horizontalLineTo(11.5f)
                    curveTo(11.776f, 3f, 12f, 2.776f, 12f, 2.5f)
                    curveTo(12f, 2.224f, 11.776f, 2f, 11.5f, 2f)
                    horizontalLineTo(7.5f)
                    close()
                    moveTo(15.156f, 3.929f)
                    curveTo(14.961f, 3.734f, 14.644f, 3.734f, 14.449f, 3.929f)
                    curveTo(14.254f, 4.124f, 14.254f, 4.441f, 14.449f, 4.636f)
                    lineTo(15.863f, 6.05f)
                    curveTo(16.059f, 6.246f, 16.375f, 6.246f, 16.57f, 6.05f)
                    curveTo(16.766f, 5.855f, 16.766f, 5.538f, 16.57f, 5.343f)
                    lineTo(15.156f, 3.929f)
                    close()
                    moveTo(9.5f, 6f)
                    curveTo(9.224f, 6f, 9f, 6.224f, 9f, 6.5f)
                    verticalLineTo(11.5f)
                    curveTo(9f, 11.776f, 9.224f, 12f, 9.5f, 12f)
                    curveTo(9.776f, 12f, 10f, 11.776f, 10f, 11.5f)
                    verticalLineTo(6.5f)
                    curveTo(10f, 6.224f, 9.776f, 6f, 9.5f, 6f)
                    close()
                    moveTo(9.5f, 18f)
                    curveTo(13.366f, 18f, 16.5f, 14.866f, 16.5f, 11f)
                    curveTo(16.5f, 7.134f, 13.366f, 4f, 9.5f, 4f)
                    curveTo(5.634f, 4f, 2.5f, 7.134f, 2.5f, 11f)
                    curveTo(2.5f, 14.866f, 5.634f, 18f, 9.5f, 18f)
                    close()
                    moveTo(9.5f, 17f)
                    curveTo(6.186f, 17f, 3.5f, 14.314f, 3.5f, 11f)
                    curveTo(3.5f, 7.686f, 6.186f, 5f, 9.5f, 5f)
                    curveTo(12.814f, 5f, 15.5f, 7.686f, 15.5f, 11f)
                    curveTo(15.5f, 14.314f, 12.814f, 17f, 9.5f, 17f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.timer(
    color: Color
) = timer(
    SolidColor(color)
)