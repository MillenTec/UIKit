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

fun UIKitFilledSymbols.wand(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Wand",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.6f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Wand",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(17f, 2.5f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    horizontalLineToRelative(-0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-0.5f)
                    horizontalLineToRelative(0.5f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-0.5f)
                    verticalLineToRelative(-0.5f)
                    close()
                    moveTo(7f, 5.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    horizontalLineToRelative(-0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-0.5f)
                    horizontalLineToRelative(-0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(0.5f)
                    verticalLineToRelative(-0.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    horizontalLineToRelative(0.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    close()
                    moveTo(16f, 14.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    horizontalLineToRelative(-0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-0.5f)
                    horizontalLineToRelative(-0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(0.5f)
                    verticalLineToRelative(-0.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    horizontalLineToRelative(0.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.43f, 6.57f)
                    curveToRelative(-0.75f, -0.75f, -1.96f, -0.75f, -2.71f, 0f)
                    lineToRelative(-0.48f, 0.48f)
                    lineToRelative(2.71f, 2.71f)
                    lineToRelative(0.48f, -0.48f)
                    curveToRelative(0.75f, -0.75f, 0.75f, -1.96f, 0f, -2.71f)
                    close()
                    moveTo(12.25f, 10.46f)
                    lineToRelative(-2.71f, -2.71f)
                    lineToRelative(-6.98f, 6.98f)
                    curveToRelative(-0.75f, 0.75f, -0.75f, 1.96f, 0f, 2.71f)
                    curveToRelative(0.75f, 0.75f, 1.96f, 0.75f, 2.71f, 0f)
                    lineToRelative(6.98f, -6.98f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.wand(
    color: Color,
    layered: Boolean = false
) = wand(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)