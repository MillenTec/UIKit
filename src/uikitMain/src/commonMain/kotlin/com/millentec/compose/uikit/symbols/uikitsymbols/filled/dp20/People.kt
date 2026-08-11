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

fun UIKitFilledSymbols.people(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "People",
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
                name = "People",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6.75f, 10f)
                    curveToRelative(1.79f, 0f, 3.25f, -1.46f, 3.25f, -3.25f)
                    reflectiveCurveToRelative(-1.46f, -3.25f, -3.25f, -3.25f)
                    reflectiveCurveToRelative(-3.25f, 1.46f, -3.25f, 3.25f)
                    reflectiveCurveToRelative(1.46f, 3.25f, 3.25f, 3.25f)
                    close()
                    moveTo(1.5f, 13f)
                    curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                    horizontalLineToRelative(6.5f)
                    curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
                    curveToRelative(0f, 0f, 0f, 4f, -5.25f, 4f)
                    reflectiveCurveTo(1.5f, 13f, 1.5f, 13f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(12.44f, 15.14f)
                    curveToRelative(0.53f, 0.22f, 1.2f, 0.36f, 2.06f, 0.36f)
                    curveToRelative(4f, 0f, 4f, -3f, 4f, -3f)
                    curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f)
                    horizontalLineToRelative(-4.63f)
                    curveToRelative(0.39f, 0.48f, 0.63f, 1.09f, 0.63f, 1.75f)
                    verticalLineToRelative(0.31f)
                    reflectiveCurveToRelative(0f, 0f, 0f, 0f)
                    horizontalLineToRelative(0f)
                    reflectiveCurveToRelative(0f, 0.02f, 0f, 0.02f)
                    verticalLineToRelative(0.02f)
                    reflectiveCurveToRelative(0f, 0.04f, 0f, 0.06f)
                    curveToRelative(0f, 0.05f, 0f, 0.11f, -0.01f, 0.19f)
                    curveToRelative(-0.01f, 0.15f, -0.04f, 0.35f, -0.1f, 0.58f)
                    curveToRelative(-0.08f, 0.34f, -0.21f, 0.76f, -0.45f, 1.21f)
                    close()
                    moveTo(17f, 7.5f)
                    curveToRelative(0f, 1.38f, -1.12f, 2.5f, -2.5f, 2.5f)
                    reflectiveCurveToRelative(-2.5f, -1.12f, -2.5f, -2.5f)
                    reflectiveCurveToRelative(1.12f, -2.5f, 2.5f, -2.5f)
                    reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.people(
    color: Color,
    layered: Boolean = false
) = people(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)