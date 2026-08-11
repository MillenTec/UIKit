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

fun UIKitRegularSymbols.addCircle(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "AddCircle",
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
                name = "AddCircle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6f, 10f)
                    curveToRelative(0f, -0.3f, 0.2f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(3f)
                    verticalLineToRelative(-3f)
                    curveToRelative(0f, -0.3f, 0.2f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.2f, 0.5f, 0.5f)
                    verticalLineToRelative(3f)
                    horizontalLineToRelative(3f)
                    curveToRelative(0.3f, 0f, 0.5f, 0.2f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.2f, 0.5f, -0.5f, 0.5f)
                    horizontalLineToRelative(-3f)
                    verticalLineToRelative(3f)
                    curveToRelative(0f, 0.3f, -0.2f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.2f, -0.5f, -0.5f)
                    verticalLineToRelative(-3f)
                    horizontalLineToRelative(-3f)
                    curveToRelative(-0.3f, 0f, -0.5f, -0.2f, -0.5f, -0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 2f)
                    curveTo(5.6f, 2f, 2f, 5.6f, 2f, 10f)
                    reflectiveCurveToRelative(3.6f, 8f, 8f, 8f)
                    reflectiveCurveToRelative(8f, -3.6f, 8f, -8f)
                    reflectiveCurveTo(14.4f, 2f, 10f, 2f)
                    close()
                    moveTo(10f, 17f)
                    curveToRelative(-3.9f, 0f, -7f, -3.1f, -7f, -7f)
                    reflectiveCurveToRelative(3.1f, -7f, 7f, -7f)
                    reflectiveCurveToRelative(7f, 3.1f, 7f, 7f)
                    reflectiveCurveToRelative(-3.1f, 7f, -7f, 7f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.addCircle(
    color: Color,
    layered: Boolean = false
) = addCircle(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)