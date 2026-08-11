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

fun UIKitFilledSymbols.speaker(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Speaker",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Speaker",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(12f, 3.01f)
                    curveToRelative(0f, -0.87f, -1.04f, -1.33f, -1.68f, -0.73f)
                    lineToRelative(-3.87f, 3.59f)
                    curveToRelative(-0.09f, 0.09f, -0.21f, 0.13f, -0.34f, 0.13f)
                    horizontalLineToRelative(-2.61f)
                    curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f)
                    verticalLineToRelative(5f)
                    curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                    horizontalLineToRelative(2.61f)
                    curveToRelative(0.13f, 0f, 0.25f, 0.05f, 0.34f, 0.13f)
                    lineToRelative(3.87f, 3.59f)
                    curveToRelative(0.64f, 0.59f, 1.68f, 0.14f, 1.68f, -0.73f)
                    verticalLineTo(3.01f)
                    close()
                }
                path(fill = brushes.getOrNull(2)) {
                    moveTo(15.25f, 4.63f)
                    curveToRelative(0.21f, -0.18f, 0.52f, -0.17f, 0.71f, 0.04f)
                    curveToRelative(2.72f, 3.03f, 2.72f, 7.64f, 0f, 10.67f)
                    curveToRelative(-0.18f, 0.21f, -0.5f, 0.22f, -0.71f, 0.04f)
                    curveToRelative(-0.21f, -0.18f, -0.22f, -0.5f, -0.04f, -0.71f)
                    curveToRelative(2.38f, -2.65f, 2.38f, -6.68f, 0f, -9.33f)
                    curveToRelative(-0.18f, -0.21f, -0.17f, -0.52f, 0.04f, -0.71f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(14.08f, 12.93f)
                    curveToRelative(-0.24f, -0.14f, -0.32f, -0.44f, -0.18f, -0.68f)
                    curveToRelative(0.78f, -1.35f, 0.83f, -3.06f, 0f, -4.5f)
                    curveToRelative(-0.14f, -0.24f, -0.06f, -0.54f, 0.18f, -0.68f)
                    curveToRelative(0.24f, -0.14f, 0.54f, -0.06f, 0.68f, 0.18f)
                    curveToRelative(1.02f, 1.76f, 0.95f, 3.86f, 0f, 5.5f)
                    curveToRelative(-0.14f, 0.24f, -0.44f, 0.32f, -0.68f, 0.18f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.speaker(
    color: Color,
    layered: Boolean = false
) = speaker(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)