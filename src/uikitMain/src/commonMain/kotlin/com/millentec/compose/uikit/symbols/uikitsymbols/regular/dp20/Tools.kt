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

fun UIKitRegularSymbols.tools(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Tools",
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
                name = "Tools",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17f, 15.555f)
                    verticalLineTo(10.5f)
                    curveTo(16.995f, 10.385f, 16.971f, 10.294f, 16.93f, 10.227f)
                    curveTo(16.888f, 10.159f, 16.831f, 10.109f, 16.758f, 10.078f)
                    curveTo(16.685f, 10.047f, 16.607f, 10.026f, 16.523f, 10.016f)
                    curveTo(16.44f, 10.005f, 16.354f, 10f, 16.266f, 10f)
                    horizontalLineTo(16f)
                    verticalLineTo(5.117f)
                    curveTo(16.031f, 5.049f, 16.076f, 4.969f, 16.133f, 4.875f)
                    curveTo(16.19f, 4.781f, 16.245f, 4.677f, 16.297f, 4.563f)
                    curveTo(16.349f, 4.448f, 16.396f, 4.341f, 16.438f, 4.242f)
                    curveTo(16.479f, 4.143f, 16.5f, 4.063f, 16.5f, 4f)
                    curveTo(16.495f, 3.938f, 16.471f, 3.831f, 16.43f, 3.68f)
                    curveTo(16.388f, 3.529f, 16.336f, 3.365f, 16.273f, 3.188f)
                    curveTo(16.211f, 3.01f, 16.151f, 2.844f, 16.094f, 2.688f)
                    curveTo(16.037f, 2.531f, 15.997f, 2.417f, 15.977f, 2.344f)
                    curveTo(15.935f, 2.24f, 15.872f, 2.156f, 15.789f, 2.094f)
                    curveTo(15.706f, 2.031f, 15.609f, 2f, 15.5f, 2f)
                    horizontalLineTo(13.5f)
                    curveTo(13.391f, 2.005f, 13.292f, 2.039f, 13.203f, 2.102f)
                    curveTo(13.115f, 2.164f, 13.055f, 2.245f, 13.023f, 2.344f)
                    curveTo(12.997f, 2.422f, 12.956f, 2.539f, 12.898f, 2.695f)
                    curveTo(12.841f, 2.852f, 12.784f, 3.018f, 12.727f, 3.195f)
                    curveTo(12.669f, 3.372f, 12.617f, 3.536f, 12.57f, 3.688f)
                    curveTo(12.523f, 3.839f, 12.5f, 3.943f, 12.5f, 4f)
                    curveTo(12.5f, 4.073f, 12.521f, 4.156f, 12.563f, 4.25f)
                    curveTo(12.604f, 4.344f, 12.654f, 4.448f, 12.711f, 4.563f)
                    curveTo(12.768f, 4.677f, 12.823f, 4.784f, 12.875f, 4.883f)
                    curveTo(12.927f, 4.982f, 12.969f, 5.06f, 13f, 5.117f)
                    verticalLineTo(10f)
                    horizontalLineTo(12.734f)
                    curveTo(12.641f, 10f, 12.552f, 10.005f, 12.469f, 10.016f)
                    curveTo(12.385f, 10.026f, 12.307f, 10.05f, 12.234f, 10.086f)
                    curveTo(12.161f, 10.122f, 12.104f, 10.172f, 12.063f, 10.234f)
                    curveTo(12.021f, 10.297f, 12f, 10.385f, 12f, 10.5f)
                    verticalLineTo(15.555f)
                    curveTo(12f, 15.893f, 12.068f, 16.211f, 12.203f, 16.508f)
                    curveTo(12.339f, 16.805f, 12.521f, 17.065f, 12.75f, 17.289f)
                    curveTo(12.979f, 17.513f, 13.245f, 17.688f, 13.547f, 17.813f)
                    curveTo(13.849f, 17.938f, 14.167f, 18f, 14.5f, 18f)
                    curveTo(14.833f, 18f, 15.151f, 17.935f, 15.453f, 17.805f)
                    curveTo(15.755f, 17.674f, 16.021f, 17.5f, 16.25f, 17.281f)
                    curveTo(16.479f, 17.063f, 16.662f, 16.805f, 16.797f, 16.508f)
                    curveTo(16.932f, 16.211f, 17f, 15.893f, 17f, 15.555f)
                    close()
                    moveTo(15f, 10f)
                    horizontalLineTo(14f)
                    verticalLineTo(5f)
                    curveTo(14f, 4.922f, 13.982f, 4.846f, 13.945f, 4.773f)
                    lineTo(13.539f, 3.961f)
                    lineTo(13.859f, 3f)
                    horizontalLineTo(15.141f)
                    lineTo(15.461f, 3.961f)
                    lineTo(15.055f, 4.773f)
                    curveTo(15.018f, 4.846f, 15f, 4.922f, 15f, 5f)
                    verticalLineTo(10f)
                    close()
                    moveTo(13f, 12f)
                    verticalLineTo(11f)
                    horizontalLineTo(16f)
                    verticalLineTo(12f)
                    horizontalLineTo(13f)
                    close()
                    moveTo(16f, 13f)
                    verticalLineTo(15.5f)
                    curveTo(16.005f, 15.698f, 15.966f, 15.891f, 15.883f, 16.078f)
                    curveTo(15.8f, 16.266f, 15.69f, 16.427f, 15.555f, 16.563f)
                    curveTo(15.419f, 16.698f, 15.26f, 16.805f, 15.078f, 16.883f)
                    curveTo(14.896f, 16.961f, 14.703f, 17f, 14.5f, 17f)
                    curveTo(14.302f, 17.005f, 14.109f, 16.966f, 13.922f, 16.883f)
                    curveTo(13.734f, 16.799f, 13.573f, 16.69f, 13.438f, 16.555f)
                    curveTo(13.302f, 16.419f, 13.195f, 16.26f, 13.117f, 16.078f)
                    curveTo(13.039f, 15.896f, 13f, 15.703f, 13f, 15.5f)
                    verticalLineTo(13f)
                    horizontalLineTo(16f)
                    close()
                    moveTo(6f, 2.542f)
                    curveTo(6f, 2.376f, 5.917f, 2.22f, 5.779f, 2.127f)
                    curveTo(5.642f, 2.034f, 5.467f, 2.016f, 5.312f, 2.078f)
                    curveTo(3.664f, 2.746f, 2.5f, 4.362f, 2.5f, 6.251f)
                    curveTo(2.5f, 8.019f, 3.519f, 9.547f, 5f, 10.283f)
                    verticalLineTo(15.999f)
                    curveTo(5f, 17.103f, 5.895f, 17.999f, 7f, 17.999f)
                    curveTo(8.105f, 17.999f, 9f, 17.103f, 9f, 15.999f)
                    verticalLineTo(10.283f)
                    curveTo(10.481f, 9.547f, 11.5f, 8.019f, 11.5f, 6.251f)
                    curveTo(11.5f, 4.362f, 10.336f, 2.746f, 8.688f, 2.078f)
                    curveTo(8.533f, 2.016f, 8.358f, 2.034f, 8.221f, 2.127f)
                    curveTo(8.083f, 2.22f, 8f, 2.376f, 8f, 2.542f)
                    verticalLineTo(5.999f)
                    curveTo(8f, 6.551f, 7.552f, 6.999f, 7f, 6.999f)
                    curveTo(6.448f, 6.999f, 6f, 6.551f, 6f, 5.999f)
                    verticalLineTo(2.542f)
                    close()
                    moveTo(3.5f, 6.251f)
                    curveTo(3.5f, 5.062f, 4.093f, 4.011f, 5f, 3.378f)
                    verticalLineTo(5.999f)
                    curveTo(5f, 7.103f, 5.895f, 7.999f, 7f, 7.999f)
                    curveTo(8.105f, 7.999f, 9f, 7.103f, 9f, 5.999f)
                    verticalLineTo(3.378f)
                    curveTo(9.907f, 4.011f, 10.5f, 5.062f, 10.5f, 6.251f)
                    curveTo(10.5f, 7.719f, 9.596f, 8.977f, 8.312f, 9.497f)
                    curveTo(8.124f, 9.573f, 8f, 9.757f, 8f, 9.96f)
                    verticalLineTo(15.999f)
                    curveTo(8f, 16.551f, 7.552f, 16.999f, 7f, 16.999f)
                    curveTo(6.448f, 16.999f, 6f, 16.551f, 6f, 15.999f)
                    verticalLineTo(9.96f)
                    curveTo(6f, 9.757f, 5.876f, 9.573f, 5.688f, 9.497f)
                    curveTo(4.404f, 8.977f, 3.5f, 7.719f, 3.5f, 6.251f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.tools(
    color: Color
) = tools(
    SolidColor(color)
)