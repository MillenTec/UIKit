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

fun UIKitFilledSymbols.transportationShip(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationShip",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "TransportationShip",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7f, 2.539f)
                    curveTo(7f, 2.263f, 7.224f, 2.039f, 7.5f, 2.039f)
                    horizontalLineTo(12.5f)
                    curveTo(12.776f, 2.039f, 13f, 2.263f, 13f, 2.539f)
                    verticalLineTo(5.001f)
                    horizontalLineTo(15.5f)
                    curveTo(15.776f, 5.001f, 16f, 5.224f, 16f, 5.501f)
                    verticalLineTo(9.564f)
                    lineTo(17.634f, 10.019f)
                    curveTo(17.777f, 10.058f, 17.894f, 10.159f, 17.955f, 10.294f)
                    curveTo(18.017f, 10.429f, 18.015f, 10.584f, 17.951f, 10.717f)
                    lineTo(16.126f, 14.505f)
                    curveTo(15.867f, 14.213f, 15.498f, 14.026f, 15.089f, 14.003f)
                    curveTo(14.437f, 13.966f, 13.836f, 14.355f, 13.603f, 14.964f)
                    curveTo(13.602f, 14.967f, 13.599f, 14.975f, 13.593f, 14.988f)
                    curveTo(13.581f, 15.015f, 13.56f, 15.062f, 13.528f, 15.122f)
                    curveTo(13.464f, 15.246f, 13.369f, 15.405f, 13.247f, 15.556f)
                    curveTo(12.988f, 15.875f, 12.749f, 16f, 12.508f, 16f)
                    curveTo(12.267f, 16f, 12.025f, 15.874f, 11.761f, 15.55f)
                    curveTo(11.637f, 15.397f, 11.54f, 15.236f, 11.475f, 15.111f)
                    curveTo(11.443f, 15.051f, 11.421f, 15.003f, 11.409f, 14.975f)
                    curveTo(11.404f, 14.963f, 11.4f, 14.955f, 11.399f, 14.952f)
                    curveTo(11.175f, 14.373f, 10.618f, 13.992f, 9.997f, 13.993f)
                    curveTo(9.377f, 13.994f, 8.821f, 14.377f, 8.599f, 14.956f)
                    curveTo(8.598f, 14.959f, 8.595f, 14.967f, 8.589f, 14.98f)
                    curveTo(8.577f, 15.007f, 8.555f, 15.055f, 8.524f, 15.116f)
                    curveTo(8.459f, 15.24f, 8.364f, 15.4f, 8.24f, 15.553f)
                    curveTo(7.979f, 15.875f, 7.739f, 16f, 7.5f, 16f)
                    curveTo(7.259f, 16f, 7.02f, 15.875f, 6.761f, 15.556f)
                    curveTo(6.638f, 15.405f, 6.543f, 15.246f, 6.479f, 15.122f)
                    curveTo(6.448f, 15.062f, 6.427f, 15.015f, 6.415f, 14.988f)
                    curveTo(6.409f, 14.975f, 6.406f, 14.967f, 6.405f, 14.964f)
                    curveTo(6.172f, 14.356f, 5.573f, 13.967f, 4.921f, 14.003f)
                    curveTo(4.495f, 14.026f, 4.11f, 14.229f, 3.85f, 14.542f)
                    lineTo(2.048f, 10.713f)
                    curveTo(1.985f, 10.58f, 1.984f, 10.426f, 2.045f, 10.292f)
                    curveTo(2.107f, 10.158f, 2.224f, 10.058f, 2.366f, 10.019f)
                    lineTo(4f, 9.563f)
                    verticalLineTo(5.501f)
                    curveTo(4f, 5.224f, 4.224f, 5.001f, 4.5f, 5.001f)
                    horizontalLineTo(7f)
                    verticalLineTo(2.539f)
                    close()
                    moveTo(12f, 3.039f)
                    horizontalLineTo(8f)
                    verticalLineTo(5.001f)
                    horizontalLineTo(12f)
                    verticalLineTo(3.039f)
                    close()
                    moveTo(15f, 9.285f)
                    verticalLineTo(6.001f)
                    horizontalLineTo(5f)
                    verticalLineTo(9.284f)
                    lineTo(9.191f, 8.116f)
                    curveTo(9.718f, 7.969f, 10.274f, 7.969f, 10.801f, 8.116f)
                    lineTo(15f, 9.285f)
                    close()
                    moveTo(11.399f, 14.952f)
                    curveTo(11.398f, 14.95f, 11.399f, 14.95f, 11.399f, 14.95f)
                    lineTo(11.399f, 14.952f)
                    close()
                    moveTo(11.399f, 14.952f)
                    lineTo(11.401f, 14.956f)
                    lineTo(11.402f, 14.959f)
                    lineTo(11.399f, 14.952f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(15.488f, 15.39f)
                    lineTo(15.485f, 15.38f)
                    curveTo(15.433f, 15.168f, 15.248f, 15.014f, 15.03f, 15.001f)
                    curveTo(14.811f, 14.988f, 14.609f, 15.12f, 14.532f, 15.325f)
                    lineTo(14.528f, 15.336f)
                    curveTo(14.523f, 15.346f, 14.516f, 15.363f, 14.506f, 15.386f)
                    curveTo(14.486f, 15.432f, 14.455f, 15.5f, 14.412f, 15.582f)
                    curveTo(14.325f, 15.748f, 14.195f, 15.968f, 14.018f, 16.185f)
                    curveTo(13.661f, 16.625f, 13.164f, 17f, 12.5f, 17f)
                    curveTo(11.836f, 17f, 11.337f, 16.625f, 10.978f, 16.184f)
                    curveTo(10.801f, 15.967f, 10.67f, 15.747f, 10.583f, 15.581f)
                    curveTo(10.539f, 15.498f, 10.508f, 15.431f, 10.488f, 15.385f)
                    curveTo(10.478f, 15.362f, 10.471f, 15.345f, 10.466f, 15.335f)
                    lineTo(10.462f, 15.323f)
                    curveTo(10.387f, 15.128f, 10.201f, 15f, 9.993f, 15f)
                    curveTo(9.785f, 15.001f, 9.598f, 15.131f, 9.526f, 15.326f)
                    lineTo(9.521f, 15.337f)
                    curveTo(9.517f, 15.347f, 9.51f, 15.364f, 9.5f, 15.387f)
                    curveTo(9.48f, 15.433f, 9.449f, 15.5f, 9.407f, 15.583f)
                    curveTo(9.321f, 15.749f, 9.191f, 15.969f, 9.015f, 16.186f)
                    curveTo(8.659f, 16.625f, 8.164f, 17f, 7.5f, 17f)
                    curveTo(6.836f, 17f, 6.339f, 16.625f, 5.982f, 16.185f)
                    curveTo(5.805f, 15.968f, 5.675f, 15.748f, 5.588f, 15.582f)
                    curveTo(5.545f, 15.5f, 5.514f, 15.432f, 5.494f, 15.386f)
                    curveTo(5.484f, 15.363f, 5.477f, 15.346f, 5.472f, 15.336f)
                    lineTo(5.468f, 15.325f)
                    lineTo(5.468f, 15.324f)
                    curveTo(5.39f, 15.119f, 5.19f, 14.989f, 4.972f, 15.001f)
                    curveTo(4.753f, 15.014f, 4.568f, 15.167f, 4.515f, 15.379f)
                    lineTo(4.515f, 15.378f)
                    lineTo(4.513f, 15.387f)
                    curveTo(4.51f, 15.396f, 4.505f, 15.412f, 4.499f, 15.433f)
                    curveTo(4.485f, 15.476f, 4.462f, 15.541f, 4.429f, 15.621f)
                    curveTo(4.362f, 15.781f, 4.256f, 15.992f, 4.1f, 16.201f)
                    curveTo(3.793f, 16.61f, 3.304f, 17f, 2.5f, 17f)
                    curveTo(2.224f, 17f, 2f, 17.224f, 2f, 17.5f)
                    curveTo(2f, 17.777f, 2.224f, 18f, 2.5f, 18f)
                    curveTo(3.696f, 18f, 4.457f, 17.392f, 4.9f, 16.801f)
                    curveTo(4.951f, 16.733f, 4.998f, 16.665f, 5.041f, 16.599f)
                    curveTo(5.091f, 16.67f, 5.146f, 16.743f, 5.206f, 16.816f)
                    curveTo(5.661f, 17.376f, 6.414f, 18f, 7.5f, 18f)
                    curveTo(8.586f, 18f, 9.338f, 17.375f, 9.792f, 16.815f)
                    curveTo(9.867f, 16.723f, 9.935f, 16.63f, 9.996f, 16.541f)
                    curveTo(10.059f, 16.631f, 10.128f, 16.723f, 10.203f, 16.816f)
                    curveTo(10.66f, 17.376f, 11.414f, 18f, 12.5f, 18f)
                    curveTo(13.586f, 18f, 14.339f, 17.376f, 14.794f, 16.816f)
                    curveTo(14.852f, 16.745f, 14.906f, 16.674f, 14.956f, 16.604f)
                    curveTo(14.999f, 16.671f, 15.046f, 16.74f, 15.097f, 16.808f)
                    curveTo(15.54f, 17.404f, 16.303f, 18.015f, 17.506f, 18f)
                    curveTo(17.782f, 17.997f, 18.003f, 17.771f, 18f, 17.494f)
                    curveTo(17.997f, 17.218f, 17.77f, 16.997f, 17.494f, 17f)
                    curveTo(16.691f, 17.01f, 16.204f, 16.621f, 15.899f, 16.211f)
                    curveTo(15.743f, 16.001f, 15.637f, 15.788f, 15.571f, 15.627f)
                    curveTo(15.538f, 15.547f, 15.516f, 15.481f, 15.502f, 15.437f)
                    curveTo(15.495f, 15.415f, 15.491f, 15.399f, 15.488f, 15.39f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.transportationShip(
    color: Color,
    layered: Boolean = false
) = transportationShip(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)