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

fun UIKitRegularSymbols.textFont(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TextFont",
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
                name = "TextFont",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(8.91f, 8.59f)
                    reflectiveCurveToRelative(0f, -0.01f, 0f, -0.02f)
                    lineToRelative(-2.43f, -6.25f)
                    curveToRelative(-0.07f, -0.19f, -0.26f, -0.32f, -0.47f, -0.32f)
                    reflectiveCurveToRelative(-0.39f, 0.13f, -0.47f, 0.32f)
                    lineToRelative(-2.43f, 6.25f)
                    reflectiveCurveToRelative(0f, 0.01f, 0f, 0.02f)
                    lineToRelative(-1.06f, 2.73f)
                    curveToRelative(-0.1f, 0.26f, 0.03f, 0.55f, 0.28f, 0.65f)
                    curveToRelative(0.26f, 0.1f, 0.55f, -0.03f, 0.65f, -0.28f)
                    lineToRelative(0.94f, -2.42f)
                    horizontalLineToRelative(4.19f)
                    lineToRelative(0.46f, 1.17f)
                    lineToRelative(0.53f, -1.4f)
                    lineToRelative(-0.17f, -0.44f)
                    close()
                    moveTo(4.3f, 8.26f)
                    lineToRelative(1.7f, -4.38f)
                    lineToRelative(1.7f, 4.38f)
                    horizontalLineToRelative(-3.41f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.5f, 17f)
                    horizontalLineToRelative(-0.56f)
                    lineToRelative(-4.47f, -11.68f)
                    curveToRelative(-0.07f, -0.19f, -0.26f, -0.32f, -0.47f, -0.32f)
                    curveToRelative(-0.21f, 0f, -0.39f, 0.13f, -0.47f, 0.32f)
                    lineToRelative(-4.38f, 11.68f)
                    horizontalLineToRelative(-0.65f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(0.99f)
                    reflectiveCurveToRelative(0.01f, 0f, 0.02f, 0f)
                    horizontalLineToRelative(0.99f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-0.28f)
                    lineToRelative(1.12f, -3f)
                    horizontalLineToRelative(5.37f)
                    lineToRelative(1.15f, 3f)
                    horizontalLineToRelative(-0.37f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(2f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    close()
                    moveTo(9.72f, 13f)
                    lineToRelative(2.28f, -6.09f)
                    lineToRelative(2.33f, 6.09f)
                    horizontalLineToRelative(-4.62f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.textFont(
    color: Color,
    layered: Boolean = false
) = textFont(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)