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

fun UIKitRegularSymbols.fire(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Fire",
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
                name = "Fire",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4f, 11.75f)
                    curveTo(4f, 11.214f, 4.063f, 10.685f, 4.188f, 10.164f)
                    curveTo(4.313f, 9.643f, 4.508f, 9.146f, 4.773f, 8.672f)
                    curveTo(4.815f, 8.599f, 4.857f, 8.523f, 4.898f, 8.445f)
                    curveTo(4.94f, 8.367f, 4.99f, 8.294f, 5.047f, 8.227f)
                    curveTo(5.104f, 8.154f, 5.164f, 8.099f, 5.227f, 8.063f)
                    curveTo(5.289f, 8.026f, 5.37f, 8.005f, 5.469f, 8f)
                    curveTo(5.552f, 8f, 5.633f, 8.021f, 5.711f, 8.063f)
                    curveTo(5.789f, 8.104f, 5.849f, 8.161f, 5.891f, 8.234f)
                    lineTo(6.93f, 9.93f)
                    curveTo(6.977f, 10.008f, 7.039f, 10.068f, 7.117f, 10.109f)
                    curveTo(7.195f, 10.151f, 7.284f, 10.175f, 7.383f, 10.18f)
                    curveTo(7.56f, 10.18f, 7.698f, 10.115f, 7.797f, 9.984f)
                    curveTo(7.896f, 9.854f, 7.948f, 9.706f, 7.953f, 9.539f)
                    curveTo(7.953f, 9.466f, 7.945f, 9.401f, 7.93f, 9.344f)
                    curveTo(7.914f, 9.286f, 7.891f, 9.224f, 7.859f, 9.156f)
                    curveTo(7.646f, 8.698f, 7.471f, 8.247f, 7.336f, 7.805f)
                    curveTo(7.201f, 7.362f, 7.133f, 6.88f, 7.133f, 6.359f)
                    curveTo(7.133f, 5.703f, 7.242f, 5.128f, 7.461f, 4.633f)
                    curveTo(7.68f, 4.138f, 7.984f, 3.714f, 8.375f, 3.359f)
                    curveTo(8.766f, 3.005f, 9.221f, 2.719f, 9.742f, 2.5f)
                    curveTo(10.263f, 2.281f, 10.82f, 2.117f, 11.414f, 2.008f)
                    curveTo(11.435f, 2.003f, 11.464f, 2f, 11.5f, 2f)
                    curveTo(11.62f, 2f, 11.727f, 2.039f, 11.82f, 2.117f)
                    curveTo(11.94f, 2.221f, 12f, 2.349f, 12f, 2.5f)
                    curveTo(12f, 3.281f, 12.133f, 4.026f, 12.398f, 4.734f)
                    curveTo(12.664f, 5.443f, 13.031f, 6.107f, 13.5f, 6.727f)
                    curveTo(13.786f, 7.102f, 14.075f, 7.479f, 14.367f, 7.859f)
                    curveTo(14.659f, 8.24f, 14.927f, 8.635f, 15.172f, 9.047f)
                    curveTo(15.417f, 9.458f, 15.615f, 9.885f, 15.766f, 10.328f)
                    curveTo(15.917f, 10.771f, 15.995f, 11.245f, 16f, 11.75f)
                    curveTo(16f, 12.307f, 15.932f, 12.849f, 15.797f, 13.375f)
                    curveTo(15.661f, 13.901f, 15.464f, 14.396f, 15.203f, 14.859f)
                    curveTo(14.943f, 15.323f, 14.635f, 15.745f, 14.281f, 16.125f)
                    curveTo(13.927f, 16.505f, 13.526f, 16.836f, 13.078f, 17.117f)
                    curveTo(12.63f, 17.398f, 12.148f, 17.615f, 11.633f, 17.766f)
                    curveTo(11.117f, 17.917f, 10.573f, 17.995f, 10f, 18f)
                    curveTo(9.427f, 18f, 8.883f, 17.924f, 8.367f, 17.773f)
                    curveTo(7.852f, 17.622f, 7.372f, 17.406f, 6.93f, 17.125f)
                    curveTo(6.487f, 16.844f, 6.083f, 16.513f, 5.719f, 16.133f)
                    curveTo(5.354f, 15.753f, 5.047f, 15.328f, 4.797f, 14.859f)
                    curveTo(4.547f, 14.391f, 4.352f, 13.896f, 4.211f, 13.375f)
                    curveTo(4.07f, 12.854f, 4f, 12.313f, 4f, 11.75f)
                    close()
                    moveTo(15f, 11.695f)
                    curveTo(15f, 11.294f, 14.925f, 10.898f, 14.773f, 10.508f)
                    curveTo(14.622f, 10.117f, 14.43f, 9.734f, 14.195f, 9.359f)
                    curveTo(13.961f, 8.984f, 13.711f, 8.63f, 13.445f, 8.297f)
                    curveTo(13.18f, 7.964f, 12.93f, 7.638f, 12.695f, 7.32f)
                    curveTo(12.227f, 6.701f, 11.849f, 6.039f, 11.563f, 5.336f)
                    curveTo(11.276f, 4.633f, 11.096f, 3.891f, 11.023f, 3.109f)
                    curveTo(10.602f, 3.214f, 10.216f, 3.357f, 9.867f, 3.539f)
                    curveTo(9.518f, 3.721f, 9.214f, 3.945f, 8.953f, 4.211f)
                    curveTo(8.693f, 4.477f, 8.492f, 4.789f, 8.352f, 5.148f)
                    curveTo(8.211f, 5.508f, 8.138f, 5.917f, 8.133f, 6.375f)
                    curveTo(8.133f, 6.792f, 8.188f, 7.19f, 8.297f, 7.57f)
                    curveTo(8.406f, 7.951f, 8.555f, 8.326f, 8.742f, 8.695f)
                    curveTo(8.81f, 8.831f, 8.859f, 8.969f, 8.891f, 9.109f)
                    curveTo(8.922f, 9.25f, 8.94f, 9.396f, 8.945f, 9.547f)
                    curveTo(8.945f, 9.766f, 8.909f, 9.974f, 8.836f, 10.172f)
                    curveTo(8.763f, 10.37f, 8.656f, 10.544f, 8.516f, 10.695f)
                    curveTo(8.375f, 10.846f, 8.211f, 10.966f, 8.023f, 11.055f)
                    curveTo(7.836f, 11.143f, 7.625f, 11.188f, 7.391f, 11.188f)
                    curveTo(7.115f, 11.188f, 6.865f, 11.125f, 6.641f, 11f)
                    curveTo(6.417f, 10.875f, 6.229f, 10.693f, 6.078f, 10.453f)
                    curveTo(5.974f, 10.292f, 5.875f, 10.133f, 5.781f, 9.977f)
                    curveTo(5.688f, 9.82f, 5.589f, 9.659f, 5.484f, 9.492f)
                    curveTo(5.161f, 10.211f, 5f, 10.964f, 5f, 11.75f)
                    curveTo(5f, 12.219f, 5.057f, 12.672f, 5.172f, 13.109f)
                    curveTo(5.286f, 13.547f, 5.448f, 13.961f, 5.656f, 14.352f)
                    curveTo(5.865f, 14.742f, 6.12f, 15.099f, 6.422f, 15.422f)
                    curveTo(6.724f, 15.745f, 7.06f, 16.023f, 7.43f, 16.258f)
                    curveTo(7.799f, 16.492f, 8.201f, 16.674f, 8.633f, 16.805f)
                    curveTo(9.065f, 16.935f, 9.521f, 17f, 10f, 17f)
                    curveTo(10.729f, 17f, 11.398f, 16.857f, 12.008f, 16.57f)
                    curveTo(12.617f, 16.284f, 13.146f, 15.896f, 13.594f, 15.406f)
                    curveTo(14.042f, 14.917f, 14.385f, 14.352f, 14.625f, 13.711f)
                    curveTo(14.865f, 13.07f, 14.99f, 12.398f, 15f, 11.695f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.fire(
    color: Color
) = fire(
    SolidColor(color)
)