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

fun UIKitRegularSymbols.layerDiagonal(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "LayerDiagonal",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.75f
            ), UIKitSymbolLayerInfo(
                description = "Tertiary",
                expectAlpha = 0.6f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "LayerDiagonal",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(2)) {
                    moveTo(10.499f, 3.5f)
                    curveTo(10.499f, 3.147f, 10.144f, 2.906f, 9.815f, 3.036f)
                    lineTo(3.948f, 5.36f)
                    curveTo(3.376f, 5.586f, 3f, 6.139f, 3f, 6.754f)
                    verticalLineTo(12.497f)
                    curveTo(3f, 12.85f, 3.356f, 13.092f, 3.684f, 12.962f)
                    lineTo(4f, 12.836f)
                    verticalLineTo(13.911f)
                    curveTo(3.03f, 14.256f, 2f, 13.537f, 2f, 12.497f)
                    verticalLineTo(6.754f)
                    curveTo(2f, 5.729f, 2.626f, 4.807f, 3.579f, 4.43f)
                    lineTo(9.447f, 2.106f)
                    curveTo(10.402f, 1.727f, 11.436f, 2.399f, 11.497f, 3.407f)
                    lineTo(10.499f, 3.802f)
                    verticalLineTo(3.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(13.499f, 5.501f)
                    curveTo(13.499f, 5.148f, 13.144f, 4.906f, 12.815f, 5.036f)
                    lineTo(6.632f, 7.485f)
                    curveTo(6.25f, 7.636f, 6f, 8.005f, 6f, 8.415f)
                    verticalLineTo(14.497f)
                    curveTo(6f, 14.85f, 6.356f, 15.092f, 6.684f, 14.962f)
                    lineTo(8f, 14.44f)
                    verticalLineTo(15.516f)
                    lineTo(7.053f, 15.892f)
                    curveTo(6.068f, 16.282f, 5f, 15.557f, 5f, 14.497f)
                    verticalLineTo(8.415f)
                    curveTo(5f, 7.595f, 5.501f, 6.857f, 6.264f, 6.555f)
                    lineTo(12.447f, 4.106f)
                    curveTo(13.432f, 3.716f, 14.499f, 4.442f, 14.499f, 5.501f)
                    verticalLineTo(5.603f)
                    lineTo(13.499f, 5.999f)
                    verticalLineTo(5.501f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(16.316f, 7.035f)
                    curveTo(16.644f, 6.905f, 17f, 7.147f, 17f, 7.5f)
                    verticalLineTo(14.123f)
                    curveTo(17f, 14.328f, 16.875f, 14.512f, 16.684f, 14.588f)
                    lineTo(10.684f, 16.964f)
                    curveTo(10.356f, 17.094f, 10f, 16.853f, 10f, 16.5f)
                    verticalLineTo(9.876f)
                    curveTo(10f, 9.671f, 10.125f, 9.487f, 10.316f, 9.411f)
                    lineTo(16.316f, 7.035f)
                    close()
                    moveTo(18f, 7.5f)
                    curveTo(18f, 6.441f, 16.932f, 5.715f, 15.948f, 6.105f)
                    lineTo(9.948f, 8.482f)
                    curveTo(9.376f, 8.708f, 9f, 9.261f, 9f, 9.876f)
                    verticalLineTo(16.5f)
                    curveTo(9f, 17.559f, 10.068f, 18.284f, 11.052f, 17.894f)
                    lineTo(17.052f, 15.518f)
                    curveTo(17.624f, 15.291f, 18f, 14.738f, 18f, 14.123f)
                    verticalLineTo(7.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.layerDiagonal(
    color: Color,
    layered: Boolean = false
) = layerDiagonal(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)