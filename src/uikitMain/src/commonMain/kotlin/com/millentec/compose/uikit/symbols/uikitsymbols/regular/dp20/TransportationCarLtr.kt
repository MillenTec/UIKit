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

fun UIKitRegularSymbols.transportationCarLtr(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationCarLtr",
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
                name = "TransportationCarLtr",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(5.518f, 6.026f)
                    lineTo(4.86f, 8f)
                    horizontalLineTo(8f)
                    verticalLineTo(5f)
                    horizontalLineTo(6.942f)
                    curveTo(6.296f, 5f, 5.723f, 5.413f, 5.518f, 6.026f)
                    close()
                    moveTo(4.527f, 9f)
                    lineTo(4.524f, 9.009f)
                    lineTo(4.258f, 9.076f)
                    lineTo(4.136f, 9.106f)
                    curveTo(3.468f, 9.273f, 3f, 9.873f, 3f, 10.562f)
                    verticalLineTo(12.25f)
                    curveTo(3f, 12.411f, 3.051f, 12.56f, 3.137f, 12.682f)
                    curveTo(3.476f, 11.703f, 4.406f, 11f, 5.5f, 11f)
                    curveTo(6.709f, 11f, 7.718f, 11.859f, 7.95f, 13f)
                    horizontalLineTo(12.05f)
                    curveTo(12.282f, 11.859f, 13.29f, 11f, 14.5f, 11f)
                    curveTo(15.594f, 11f, 16.524f, 11.703f, 16.863f, 12.682f)
                    curveTo(16.949f, 12.56f, 17f, 12.411f, 17f, 12.25f)
                    verticalLineTo(11.037f)
                    curveTo(17f, 10.357f, 16.543f, 9.762f, 15.887f, 9.587f)
                    lineTo(13.684f, 9f)
                    horizontalLineTo(4.527f)
                    close()
                    moveTo(12.873f, 8f)
                    lineTo(11.634f, 5.772f)
                    curveTo(11.37f, 5.295f, 10.868f, 5f, 10.323f, 5f)
                    horizontalLineTo(9f)
                    verticalLineTo(8f)
                    horizontalLineTo(12.873f)
                    close()
                    moveTo(18f, 12.25f)
                    curveTo(18f, 12.957f, 17.58f, 13.566f, 16.977f, 13.842f)
                    curveTo(16.81f, 15.061f, 15.764f, 16f, 14.5f, 16f)
                    curveTo(13.29f, 16f, 12.282f, 15.141f, 12.05f, 14f)
                    horizontalLineTo(7.95f)
                    curveTo(7.718f, 15.141f, 6.709f, 16f, 5.5f, 16f)
                    curveTo(4.235f, 16f, 3.19f, 15.061f, 3.023f, 13.842f)
                    curveTo(2.42f, 13.566f, 2f, 12.957f, 2f, 12.25f)
                    verticalLineTo(10.562f)
                    curveTo(2f, 9.465f, 2.713f, 8.504f, 3.747f, 8.178f)
                    lineTo(4.57f, 5.709f)
                    curveTo(4.91f, 4.689f, 5.865f, 4f, 6.942f, 4f)
                    horizontalLineTo(10.323f)
                    curveTo(11.231f, 4f, 12.068f, 4.492f, 12.509f, 5.286f)
                    lineTo(14.051f, 8.063f)
                    lineTo(16.144f, 8.621f)
                    curveTo(17.239f, 8.913f, 18f, 9.904f, 18f, 11.037f)
                    verticalLineTo(12.25f)
                    close()
                    moveTo(5.5f, 12f)
                    curveTo(4.672f, 12f, 4f, 12.672f, 4f, 13.5f)
                    curveTo(4f, 14.328f, 4.672f, 15f, 5.5f, 15f)
                    curveTo(6.328f, 15f, 7f, 14.328f, 7f, 13.5f)
                    curveTo(7f, 12.672f, 6.328f, 12f, 5.5f, 12f)
                    close()
                    moveTo(14.5f, 12f)
                    curveTo(13.672f, 12f, 13f, 12.672f, 13f, 13.5f)
                    curveTo(13f, 14.328f, 13.672f, 15f, 14.5f, 15f)
                    curveTo(15.328f, 15f, 16f, 14.328f, 16f, 13.5f)
                    curveTo(16f, 12.672f, 15.328f, 12f, 14.5f, 12f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.transportationCarLtr(
    color: Color
) = transportationCarLtr(
    SolidColor(color)
)