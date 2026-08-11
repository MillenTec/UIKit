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

fun UIKitRegularSymbols.personCircle(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "PersonCircle",
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
                name = "PersonCircle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(8f, 7f)
                    curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                    reflectiveCurveToRelative(2f, 0.9f, 2f, 2f)
                    reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f)
                    reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f)
                    close()
                    moveTo(7.5f, 10f)
                    horizontalLineToRelative(5f)
                    curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
                    curveToRelative(0f, 1.12f, -0.46f, 2.01f, -1.21f, 2.61f)
                    curveToRelative(-0.74f, 0.59f, -1.73f, 0.89f, -2.79f, 0.89f)
                    reflectiveCurveToRelative(-2.05f, -0.29f, -2.79f, -0.89f)
                    curveToRelative(-0.75f, -0.6f, -1.21f, -1.5f, -1.21f, -2.61f)
                    curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 2f)
                    curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
                    reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
                    reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
                    reflectiveCurveTo(14.42f, 2f, 10f, 2f)
                    close()
                    moveTo(10f, 17f)
                    curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f)
                    reflectiveCurveToRelative(3.13f, -7f, 7f, -7f)
                    reflectiveCurveToRelative(7f, 3.13f, 7f, 7f)
                    reflectiveCurveToRelative(-3.13f, 7f, -7f, 7f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.personCircle(
    color: Color,
    layered: Boolean = false
) = personCircle(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)