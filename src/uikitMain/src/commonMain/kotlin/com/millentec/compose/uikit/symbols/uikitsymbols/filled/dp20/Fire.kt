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

fun UIKitFilledSymbols.fire(
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
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.fire(
    color: Color
) = fire(
    SolidColor(color)
)