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

fun UIKitFilledSymbols.documentAdd(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "DocumentAdd",
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
                name = "DocumentAdd",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 2f)
                    verticalLineToRelative(4.5f)
                    curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                    horizontalLineToRelative(4.5f)
                    verticalLineToRelative(8.5f)
                    curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f)
                    horizontalLineToRelative(-4.76f)
                    curveToRelative(0.79f, -0.95f, 1.26f, -2.17f, 1.26f, -3.5f)
                    curveToRelative(0f, -3.04f, -2.46f, -5.5f, -5.5f, -5.5f)
                    curveToRelative(-0.52f, 0f, -1.02f, 0.07f, -1.5f, 0.21f)
                    verticalLineTo(3.5f)
                    curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
                    horizontalLineToRelative(4.5f)
                    close()
                    moveTo(11f, 2.25f)
                    verticalLineToRelative(4.25f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(4.25f)
                    lineToRelative(-4.75f, -4.75f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(5.5f, 10f)
                    curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
                    reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
                    reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
                    reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
                    close()
                    moveTo(7.5f, 15f)
                    horizontalLineToRelative(-1.5f)
                    verticalLineToRelative(1.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-1.5f)
                    horizontalLineToRelative(-1.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(1.5f)
                    verticalLineToRelative(-1.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(1.5f)
                    horizontalLineToRelative(1.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.documentAdd(
    color: Color,
    layered: Boolean = false
) = documentAdd(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)