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

fun UIKitFilledSymbols.arrowTrendingLines(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowTrendingLines",
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
                name = "ArrowTrendingLines",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14f, 2.75f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    horizontalLineToRelative(2.5f)
                    curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
                    verticalLineToRelative(2.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f)
                    verticalLineToRelative(-0.69f)
                    lineToRelative(-4.47f, 4.47f)
                    curveToRelative(-0.29f, 0.29f, -0.77f, 0.29f, -1.06f, 0f)
                    lineToRelative(-2.47f, -2.47f)
                    lineToRelative(-4.22f, 4.22f)
                    curveToRelative(-0.29f, 0.29f, -0.77f, 0.29f, -1.06f, 0f)
                    curveToRelative(-0.29f, -0.29f, -0.29f, -0.77f, 0f, -1.06f)
                    lineToRelative(4.75f, -4.75f)
                    curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f)
                    lineToRelative(2.47f, 2.47f)
                    lineToRelative(3.94f, -3.94f)
                    horizontalLineToRelative(-0.69f)
                    curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(3.75f, 14f)
                    curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
                    verticalLineToRelative(2.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f)
                    verticalLineToRelative(-2.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(8.5f, 11.75f)
                    curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.75f, 0.34f, -0.75f, 0.75f)
                    verticalLineToRelative(5.5f)
                    curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f)
                    reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f)
                    verticalLineToRelative(-5.5f)
                    close()
                    moveTo(11.75f, 13f)
                    curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
                    verticalLineToRelative(3.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f)
                    verticalLineToRelative(-3.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(16.5f, 9.75f)
                    curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.75f, 0.34f, -0.75f, 0.75f)
                    verticalLineToRelative(7.5f)
                    curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f)
                    reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f)
                    verticalLineToRelative(-7.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.arrowTrendingLines(
    color: Color,
    layered: Boolean = false
) = arrowTrendingLines(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)