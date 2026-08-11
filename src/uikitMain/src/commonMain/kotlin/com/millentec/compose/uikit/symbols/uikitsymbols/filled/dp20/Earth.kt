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

fun UIKitFilledSymbols.earth(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Earth",
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
                name = "Earth",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(2f, 10f)
                    curveTo(2f, 5.582f, 5.582f, 2f, 10f, 2f)
                    curveTo(14.419f, 2f, 18f, 5.582f, 18f, 10f)
                    curveTo(18f, 14.419f, 14.419f, 18.001f, 10f, 18.001f)
                    curveTo(5.582f, 18.001f, 2f, 14.419f, 2f, 10f)
                    close()
                    moveTo(10f, 3f)
                    curveTo(9.915f, 3f, 9.83f, 3.002f, 9.745f, 3.005f)
                    curveTo(9.863f, 3.227f, 9.998f, 3.509f, 10.118f, 3.828f)
                    curveTo(10.399f, 4.574f, 10.644f, 5.645f, 10.203f, 6.586f)
                    curveTo(9.799f, 7.446f, 9.106f, 7.67f, 8.571f, 7.808f)
                    lineTo(8.474f, 7.833f)
                    curveTo(7.968f, 7.963f, 7.719f, 8.027f, 7.544f, 8.292f)
                    curveTo(7.374f, 8.55f, 7.415f, 8.867f, 7.581f, 9.406f)
                    curveTo(7.593f, 9.446f, 7.606f, 9.487f, 7.619f, 9.53f)
                    curveTo(7.686f, 9.741f, 7.763f, 9.987f, 7.803f, 10.218f)
                    curveTo(7.853f, 10.504f, 7.864f, 10.854f, 7.69f, 11.188f)
                    curveTo(7.511f, 11.531f, 7.276f, 11.762f, 7f, 11.912f)
                    curveTo(6.74f, 12.054f, 6.467f, 12.109f, 6.253f, 12.147f)
                    lineTo(6.165f, 12.162f)
                    curveTo(5.758f, 12.234f, 5.52f, 12.275f, 5.298f, 12.513f)
                    curveTo(5.121f, 12.703f, 5.02f, 13.021f, 4.962f, 13.455f)
                    curveTo(4.938f, 13.632f, 4.924f, 13.809f, 4.909f, 13.988f)
                    lineTo(4.902f, 14.083f)
                    curveTo(4.885f, 14.282f, 4.865f, 14.502f, 4.823f, 14.688f)
                    lineTo(4.819f, 14.708f)
                    curveTo(6.099f, 16.117f, 7.946f, 17.001f, 10f, 17.001f)
                    curveTo(11.351f, 17.001f, 12.612f, 16.618f, 13.682f, 15.956f)
                    curveTo(13.596f, 15.87f, 13.501f, 15.767f, 13.407f, 15.649f)
                    curveTo(13.136f, 15.308f, 12.798f, 14.74f, 12.915f, 14.08f)
                    curveTo(12.971f, 13.766f, 13.141f, 13.498f, 13.312f, 13.285f)
                    curveTo(13.487f, 13.069f, 13.698f, 12.868f, 13.888f, 12.693f)
                    curveTo(13.932f, 12.653f, 13.975f, 12.614f, 14.016f, 12.576f)
                    curveTo(14.162f, 12.443f, 14.289f, 12.326f, 14.398f, 12.213f)
                    curveTo(14.545f, 12.059f, 14.59f, 11.976f, 14.597f, 11.95f)
                    curveTo(14.666f, 11.724f, 14.585f, 11.545f, 14.472f, 11.458f)
                    curveTo(14.378f, 11.385f, 14.177f, 11.316f, 13.861f, 11.516f)
                    curveTo(13.743f, 11.591f, 13.634f, 11.657f, 13.539f, 11.707f)
                    curveTo(13.453f, 11.752f, 13.333f, 11.809f, 13.203f, 11.83f)
                    curveTo(13.046f, 11.854f, 12.828f, 11.831f, 12.659f, 11.652f)
                    curveTo(12.531f, 11.516f, 12.495f, 11.35f, 12.481f, 11.277f)
                    curveTo(12.465f, 11.188f, 12.457f, 11.087f, 12.45f, 11.001f)
                    lineTo(12.446f, 10.935f)
                    curveTo(12.441f, 10.861f, 12.435f, 10.784f, 12.427f, 10.697f)
                    curveTo(12.406f, 10.476f, 12.369f, 10.201f, 12.283f, 9.872f)
                    curveTo(12.156f, 9.381f, 11.843f, 8.984f, 11.519f, 8.573f)
                    curveTo(11.472f, 8.513f, 11.424f, 8.452f, 11.377f, 8.391f)
                    curveTo(11.217f, 8.185f, 11.014f, 7.913f, 10.941f, 7.622f)
                    curveTo(10.899f, 7.458f, 10.892f, 7.268f, 10.966f, 7.074f)
                    curveTo(11.038f, 6.884f, 11.168f, 6.738f, 11.317f, 6.626f)
                    curveTo(11.745f, 6.305f, 12.445f, 5.613f, 13.06f, 4.974f)
                    curveTo(13.363f, 4.66f, 13.637f, 4.367f, 13.835f, 4.152f)
                    curveTo(13.837f, 4.15f, 13.839f, 4.148f, 13.84f, 4.146f)
                    curveTo(12.738f, 3.422f, 11.418f, 3f, 10f, 3f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.earth(
    color: Color
) = earth(
    SolidColor(color)
)