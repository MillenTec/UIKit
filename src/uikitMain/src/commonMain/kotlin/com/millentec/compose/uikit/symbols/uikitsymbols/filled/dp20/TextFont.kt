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

fun UIKitFilledSymbols.textFont(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TextFont",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
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
                    moveTo(9.02f, 8.55f)
                    reflectiveCurveToRelative(-0.03f, -0.09f, -0.05f, -0.13f)
                    lineToRelative(-2.27f, -5.94f)
                    curveToRelative(-0.11f, -0.29f, -0.39f, -0.48f, -0.7f, -0.48f)
                    reflectiveCurveToRelative(-0.59f, 0.19f, -0.7f, 0.48f)
                    lineToRelative(-3.25f, 8.5f)
                    curveToRelative(-0.15f, 0.39f, 0.05f, 0.82f, 0.43f, 0.97f)
                    curveToRelative(0.39f, 0.15f, 0.82f, -0.05f, 0.97f, -0.43f)
                    lineToRelative(0.77f, -2.02f)
                    horizontalLineToRelative(3.55f)
                    lineToRelative(0.49f, 1.27f)
                    lineToRelative(0.79f, -2.13f)
                    lineToRelative(-0.04f, -0.1f)
                    close()
                    moveTo(4.79f, 8f)
                    lineToRelative(1.2f, -3.15f)
                    lineToRelative(1.2f, 3.15f)
                    horizontalLineToRelative(-2.41f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.25f, 16.5f)
                    horizontalLineToRelative(-0.44f)
                    lineToRelative(-4.1f, -11.01f)
                    curveToRelative(-0.11f, -0.29f, -0.39f, -0.49f, -0.7f, -0.49f)
                    reflectiveCurveToRelative(-0.59f, 0.19f, -0.7f, 0.49f)
                    lineToRelative(-4.1f, 11.01f)
                    horizontalLineToRelative(-0.44f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(2.5f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
                    horizontalLineToRelative(-0.46f)
                    lineToRelative(0.75f, -2f)
                    horizontalLineToRelative(4.92f)
                    lineToRelative(0.75f, 2f)
                    horizontalLineToRelative(-0.46f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(2.5f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
                    close()
                    moveTo(10.1f, 13f)
                    lineToRelative(1.9f, -5.1f)
                    lineToRelative(1.9f, 5.1f)
                    horizontalLineToRelative(-3.8f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.textFont(
    color: Color,
    layered: Boolean = false
) = textFont(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)