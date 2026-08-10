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

fun UIKitRegularSymbols.fingerprint(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Fingerprint",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Fingerprint",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6.717f, 3.95f)
                    curveTo(8.254f, 3.209f, 11.534f, 2.513f, 15.227f, 4.919f)
                    curveTo(15.458f, 5.07f, 15.768f, 5.004f, 15.919f, 4.773f)
                    curveTo(16.07f, 4.541f, 16.004f, 4.232f, 15.773f, 4.081f)
                    curveTo(11.736f, 1.451f, 8.076f, 2.184f, 6.283f, 3.05f)
                    curveTo(6.034f, 3.17f, 5.93f, 3.469f, 6.05f, 3.717f)
                    curveTo(6.17f, 3.966f, 6.469f, 4.07f, 6.717f, 3.95f)
                    close()
                    moveTo(4.909f, 4.591f)
                    curveTo(5.061f, 4.822f, 4.997f, 5.132f, 4.766f, 5.284f)
                    curveTo(4.243f, 5.628f, 3.657f, 6.369f, 3.431f, 6.753f)
                    curveTo(3.291f, 6.991f, 2.985f, 7.071f, 2.747f, 6.931f)
                    curveTo(2.509f, 6.791f, 2.429f, 6.485f, 2.569f, 6.247f)
                    curveTo(2.838f, 5.788f, 3.519f, 4.907f, 4.217f, 4.448f)
                    curveTo(4.447f, 4.297f, 4.757f, 4.361f, 4.909f, 4.591f)
                    close()
                    moveTo(10.5f, 4.541f)
                    curveTo(10.224f, 4.541f, 10f, 4.764f, 10f, 5.041f)
                    curveTo(10f, 5.317f, 10.224f, 5.541f, 10.5f, 5.541f)
                    curveTo(12.156f, 5.541f, 16.014f, 6.917f, 17.009f, 12.094f)
                    curveTo(17.061f, 12.365f, 17.323f, 12.543f, 17.594f, 12.491f)
                    curveTo(17.866f, 12.439f, 18.043f, 12.177f, 17.991f, 11.906f)
                    curveTo(16.893f, 6.194f, 12.568f, 4.541f, 10.5f, 4.541f)
                    close()
                    moveTo(9.345f, 10.802f)
                    curveTo(8.475f, 11.508f, 7.818f, 13.487f, 9.903f, 17.258f)
                    curveTo(10.036f, 17.5f, 9.949f, 17.804f, 9.707f, 17.937f)
                    curveTo(9.465f, 18.071f, 9.161f, 17.983f, 9.027f, 17.742f)
                    curveTo(6.879f, 13.856f, 7.249f, 11.216f, 8.714f, 10.026f)
                    curveTo(10.138f, 8.869f, 12.384f, 9.371f, 12.997f, 11.349f)
                    curveTo(13.078f, 11.613f, 13.143f, 11.928f, 13.208f, 12.243f)
                    lineTo(13.24f, 12.401f)
                    curveTo(13.319f, 12.78f, 13.408f, 13.176f, 13.538f, 13.575f)
                    curveTo(13.797f, 14.368f, 14.214f, 15.147f, 15.019f, 15.741f)
                    curveTo(15.241f, 15.905f, 15.289f, 16.219f, 15.125f, 16.441f)
                    curveTo(14.961f, 16.663f, 14.648f, 16.71f, 14.425f, 16.546f)
                    curveTo(13.398f, 15.788f, 12.886f, 14.8f, 12.587f, 13.886f)
                    curveTo(12.439f, 13.431f, 12.342f, 12.989f, 12.261f, 12.604f)
                    lineTo(12.227f, 12.437f)
                    curveTo(12.161f, 12.117f, 12.107f, 11.858f, 12.042f, 11.645f)
                    curveTo(11.652f, 10.388f, 10.255f, 10.062f, 9.345f, 10.802f)
                    close()
                    moveTo(15.499f, 11.973f)
                    curveTo(15.484f, 11.697f, 15.249f, 11.486f, 14.973f, 11.501f)
                    curveTo(14.697f, 11.516f, 14.486f, 11.751f, 14.501f, 12.027f)
                    curveTo(14.599f, 13.835f, 15.717f, 14.773f, 16.347f, 14.976f)
                    curveTo(16.61f, 15.06f, 16.891f, 14.916f, 16.976f, 14.653f)
                    curveTo(17.061f, 14.39f, 16.916f, 14.109f, 16.653f, 14.024f)
                    curveTo(16.426f, 13.951f, 15.576f, 13.376f, 15.499f, 11.973f)
                    close()
                    moveTo(11f, 12.5f)
                    curveTo(11f, 12.224f, 10.776f, 12f, 10.5f, 12f)
                    curveTo(10.224f, 12f, 10f, 12.224f, 10f, 12.5f)
                    curveTo(10f, 13.545f, 10.129f, 14.351f, 10.437f, 15.138f)
                    curveTo(10.741f, 15.913f, 11.209f, 16.642f, 11.842f, 17.538f)
                    curveTo(12.001f, 17.764f, 12.313f, 17.818f, 12.538f, 17.658f)
                    curveTo(12.764f, 17.499f, 12.818f, 17.187f, 12.659f, 16.962f)
                    curveTo(12.031f, 16.072f, 11.624f, 15.427f, 11.368f, 14.773f)
                    curveTo(11.116f, 14.131f, 11f, 13.455f, 11f, 12.5f)
                    close()
                    moveTo(7.969f, 8.79f)
                    curveTo(6.253f, 10.118f, 5.267f, 12.932f, 6.947f, 16.275f)
                    curveTo(7.071f, 16.522f, 6.971f, 16.823f, 6.725f, 16.947f)
                    curveTo(6.478f, 17.071f, 6.177f, 16.971f, 6.053f, 16.724f)
                    curveTo(4.183f, 13.003f, 5.221f, 9.653f, 7.356f, 7.999f)
                    curveTo(8.417f, 7.178f, 9.746f, 6.783f, 11.083f, 7f)
                    curveTo(12.425f, 7.217f, 13.72f, 8.043f, 14.726f, 9.556f)
                    curveTo(14.878f, 9.786f, 14.816f, 10.096f, 14.586f, 10.249f)
                    curveTo(14.356f, 10.402f, 14.046f, 10.34f, 13.893f, 10.11f)
                    curveTo(13.018f, 8.793f, 11.952f, 8.154f, 10.923f, 7.987f)
                    curveTo(9.888f, 7.819f, 8.834f, 8.12f, 7.969f, 8.79f)
                    close()
                    moveTo(8.456f, 5.794f)
                    curveTo(8.715f, 5.7f, 8.849f, 5.413f, 8.755f, 5.153f)
                    curveTo(8.661f, 4.894f, 8.374f, 4.76f, 8.114f, 4.854f)
                    curveTo(3.433f, 6.554f, 2.323f, 11.04f, 2.756f, 14.071f)
                    curveTo(2.795f, 14.344f, 3.048f, 14.534f, 3.322f, 14.495f)
                    curveTo(3.595f, 14.456f, 3.785f, 14.203f, 3.746f, 13.929f)
                    curveTo(3.355f, 11.191f, 4.368f, 7.279f, 8.456f, 5.794f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.fingerprint(
    color: Color
) = fingerprint(
    SolidColor(color)
)