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

fun UIKitRegularSymbols.checkmarkCircle(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "CheckmarkCircle",
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
                name = "CheckmarkCircle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
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
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.36f, 7.65f)
                    curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
                    lineToRelative(-0.06f, 0.07f)
                    lineToRelative(-4f, 4f)
                    curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
                    lineToRelative(-0.07f, -0.06f)
                    lineToRelative(-2f, -2f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
                    lineToRelative(0.07f, 0.06f)
                    lineToRelative(1.65f, 1.65f)
                    lineToRelative(3.65f, -3.65f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.checkmarkCircle(
    color: Color,
    layered: Boolean = false
) = checkmarkCircle(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)