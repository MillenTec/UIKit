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

fun UIKitFilledSymbols.zoomOut(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ZoomOut",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.3f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "ZoomOut",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(16.85f, 16.15f)
                    lineToRelative(-3.42f, -3.42f)
                    curveToRelative(0.97f, -1.14f, 1.56f, -2.61f, 1.56f, -4.23f)
                    curveToRelative(0f, -3.59f, -2.91f, -6.5f, -6.5f, -6.5f)
                    reflectiveCurveToRelative(-6.5f, 2.91f, -6.5f, 6.5f)
                    reflectiveCurveToRelative(2.91f, 6.5f, 6.5f, 6.5f)
                    curveToRelative(1.61f, 0f, 3.09f, -0.59f, 4.23f, -1.56f)
                    lineToRelative(3.42f, 3.42f)
                    lineToRelative(0.07f, 0.06f)
                    curveToRelative(0.19f, 0.14f, 0.46f, 0.12f, 0.64f, -0.06f)
                    curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f)
                    close()
                    moveTo(11f, 9f)
                    horizontalLineToRelative(-5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6f, 8f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(5f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.zoomOut(
    color: Color,
    layered: Boolean = false
) = zoomOut(
    listOf(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
)