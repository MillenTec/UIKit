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

fun UIKitRegularSymbols.arrowRedo(
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
                    moveTo(15.003f, 2.5f)
                    curveTo(15.003f, 2.224f, 15.227f, 2f, 15.503f, 2f)
                    curveTo(15.779f, 2f, 16.003f, 2.224f, 16.003f, 2.5f)
                    verticalLineTo(7.4f)
                    curveTo(16.003f, 7.731f, 15.734f, 8f, 15.403f, 8f)
                    horizontalLineTo(10.503f)
                    curveTo(10.227f, 8f, 10.003f, 7.776f, 10.003f, 7.5f)
                    curveTo(10.003f, 7.224f, 10.227f, 7f, 10.503f, 7f)
                    horizontalLineTo(14.097f)
                    lineTo(10.624f, 3.981f)
                    curveTo(8.957f, 2.532f, 6.431f, 2.709f, 4.981f, 4.376f)
                    curveTo(3.532f, 6.043f, 3.709f, 8.57f, 5.376f, 10.019f)
                    lineTo(13.548f, 17.123f)
                    curveTo(13.756f, 17.304f, 13.778f, 17.62f, 13.597f, 17.828f)
                    curveTo(13.416f, 18.036f, 13.1f, 18.059f, 12.892f, 17.877f)
                    lineTo(4.72f, 10.774f)
                    curveTo(2.636f, 8.962f, 2.415f, 5.804f, 4.227f, 3.72f)
                    curveTo(6.038f, 1.636f, 9.196f, 1.415f, 11.28f, 3.227f)
                    lineTo(15.003f, 6.463f)
                    verticalLineTo(2.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowRedo(
    color: Color
) = arrowRedo(
    SolidColor(color)
)