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

fun UIKitRegularSymbols.arrowRepeatAll(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowRepeatAll",
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
                name = "ArrowRepeatAll",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(16.5f, 6.671f)
                    curveTo(16.616f, 6.671f, 16.723f, 6.711f, 16.808f, 6.778f)
                    lineTo(16.875f, 6.841f)
                    lineTo(16.892f, 6.861f)
                    curveTo(17.585f, 7.719f, 18f, 8.811f, 18f, 10f)
                    curveTo(18f, 12.689f, 15.878f, 14.882f, 13.217f, 14.995f)
                    lineTo(13f, 15f)
                    horizontalLineTo(7f)
                    curveTo(6.898f, 15f, 6.797f, 14.997f, 6.697f, 14.991f)
                    lineTo(8.354f, 16.646f)
                    curveTo(8.527f, 16.82f, 8.546f, 17.089f, 8.411f, 17.284f)
                    lineTo(8.354f, 17.354f)
                    curveTo(8.18f, 17.527f, 7.911f, 17.546f, 7.716f, 17.411f)
                    lineTo(7.646f, 17.354f)
                    lineTo(5.146f, 14.854f)
                    curveTo(4.973f, 14.68f, 4.954f, 14.411f, 5.089f, 14.216f)
                    lineTo(5.146f, 14.146f)
                    lineTo(7.646f, 11.646f)
                    curveTo(7.842f, 11.451f, 8.158f, 11.451f, 8.354f, 11.646f)
                    curveTo(8.527f, 11.82f, 8.546f, 12.089f, 8.411f, 12.284f)
                    lineTo(8.354f, 12.354f)
                    lineTo(6.717f, 13.99f)
                    lineTo(6.858f, 13.998f)
                    lineTo(7f, 14f)
                    horizontalLineTo(13f)
                    curveTo(15.209f, 14f, 17f, 12.209f, 17f, 10f)
                    curveTo(17f, 9.047f, 16.666f, 8.171f, 16.11f, 7.484f)
                    curveTo(16.041f, 7.399f, 16f, 7.29f, 16f, 7.171f)
                    curveTo(16f, 6.895f, 16.224f, 6.671f, 16.5f, 6.671f)
                    close()
                    moveTo(11.646f, 2.646f)
                    curveTo(11.82f, 2.473f, 12.089f, 2.454f, 12.284f, 2.589f)
                    lineTo(12.354f, 2.646f)
                    lineTo(14.854f, 5.146f)
                    lineTo(14.911f, 5.216f)
                    curveTo(15.03f, 5.386f, 15.03f, 5.614f, 14.911f, 5.784f)
                    lineTo(14.854f, 5.854f)
                    lineTo(12.354f, 8.354f)
                    lineTo(12.284f, 8.411f)
                    curveTo(12.114f, 8.53f, 11.886f, 8.53f, 11.716f, 8.411f)
                    lineTo(11.646f, 8.354f)
                    lineTo(11.589f, 8.284f)
                    curveTo(11.47f, 8.114f, 11.47f, 7.886f, 11.589f, 7.716f)
                    lineTo(11.646f, 7.646f)
                    lineTo(13.283f, 6.01f)
                    lineTo(13.142f, 6.002f)
                    lineTo(13f, 6f)
                    horizontalLineTo(7f)
                    curveTo(4.791f, 6f, 3f, 7.791f, 3f, 10f)
                    curveTo(3f, 10.956f, 3.336f, 11.834f, 3.895f, 12.522f)
                    curveTo(3.96f, 12.606f, 4f, 12.714f, 4f, 12.831f)
                    curveTo(4f, 13.107f, 3.776f, 13.331f, 3.5f, 13.331f)
                    curveTo(3.333f, 13.331f, 3.185f, 13.249f, 3.094f, 13.124f)
                    curveTo(2.41f, 12.268f, 2f, 11.182f, 2f, 10f)
                    curveTo(2f, 7.311f, 4.122f, 5.118f, 6.783f, 5.005f)
                    lineTo(7f, 5f)
                    horizontalLineTo(13f)
                    curveTo(13.102f, 5f, 13.203f, 5.003f, 13.303f, 5.009f)
                    lineTo(11.646f, 3.354f)
                    lineTo(11.589f, 3.284f)
                    curveTo(11.454f, 3.089f, 11.473f, 2.82f, 11.646f, 2.646f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowRepeatAll(
    color: Color
) = arrowRepeatAll(
    SolidColor(color)
)