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

fun UIKitFilledSymbols.transportationTractor(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationTractor",
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
                name = "TransportationTractor",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4.297f, 4.671f)
                    curveTo(4.457f, 3.707f, 5.292f, 3f, 6.269f, 3f)
                    horizontalLineTo(8.728f)
                    curveTo(9.706f, 3f, 10.54f, 3.707f, 10.701f, 4.671f)
                    lineTo(11.256f, 8f)
                    horizontalLineTo(13f)
                    verticalLineTo(6f)
                    curveTo(13f, 5.724f, 13.224f, 5.5f, 13.5f, 5.5f)
                    curveTo(13.776f, 5.5f, 14f, 5.724f, 14f, 6f)
                    verticalLineTo(8f)
                    horizontalLineTo(15.003f)
                    curveTo(16.66f, 8f, 18.003f, 9.343f, 18.003f, 11f)
                    verticalLineTo(12f)
                    curveTo(18.003f, 12.24f, 17.975f, 12.473f, 17.921f, 12.696f)
                    curveTo(18.581f, 13.246f, 19f, 14.074f, 19f, 15f)
                    curveTo(19f, 16.657f, 17.657f, 18f, 16f, 18f)
                    curveTo(14.343f, 18f, 13f, 16.657f, 13f, 15f)
                    horizontalLineTo(10.584f)
                    curveTo(9.812f, 16.766f, 8.05f, 18f, 6f, 18f)
                    curveTo(3.239f, 18f, 1f, 15.761f, 1f, 13f)
                    curveTo(1f, 11.091f, 2.07f, 9.431f, 3.644f, 8.589f)
                    lineTo(4.297f, 4.671f)
                    close()
                    moveTo(9.714f, 4.836f)
                    curveTo(9.634f, 4.353f, 9.217f, 4f, 8.728f, 4f)
                    horizontalLineTo(6.269f)
                    curveTo(5.781f, 4f, 5.363f, 4.353f, 5.283f, 4.836f)
                    lineTo(4.728f, 8.163f)
                    curveTo(5.134f, 8.057f, 5.561f, 8f, 6f, 8f)
                    horizontalLineTo(10.242f)
                    lineTo(9.714f, 4.836f)
                    close()
                    moveTo(6f, 9f)
                    curveTo(3.791f, 9f, 2f, 10.791f, 2f, 13f)
                    curveTo(2f, 15.209f, 3.791f, 17f, 6f, 17f)
                    curveTo(8.209f, 17f, 10f, 15.209f, 10f, 13f)
                    curveTo(10f, 10.791f, 8.209f, 9f, 6f, 9f)
                    close()
                    moveTo(14f, 15f)
                    curveTo(14f, 16.105f, 14.895f, 17f, 16f, 17f)
                    curveTo(17.105f, 17f, 18f, 16.105f, 18f, 15f)
                    curveTo(18f, 13.895f, 17.105f, 13f, 16f, 13f)
                    curveTo(14.895f, 13f, 14f, 13.895f, 14f, 15f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.transportationTractor(
    color: Color
) = transportationTractor(
    SolidColor(color)
)