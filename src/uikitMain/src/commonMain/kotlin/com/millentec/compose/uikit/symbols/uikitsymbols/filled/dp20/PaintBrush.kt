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

fun UIKitFilledSymbols.paintBrush(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "PaintBrush",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "PaintBrush",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 4.5f)
                    verticalLineTo(2f)
                    horizontalLineToRelative(-4.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(6.5f)
                    horizontalLineToRelative(10f)
                    verticalLineTo(2.5f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-1.5f)
                    verticalLineToRelative(3.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineTo(2f)
                    horizontalLineToRelative(-1f)
                    verticalLineToRelative(2.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(15f, 10f)
                    horizontalLineTo(5f)
                    verticalLineToRelative(1f)
                    curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                    horizontalLineToRelative(1.5f)
                    verticalLineToRelative(3.5f)
                    curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                    reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f)
                    verticalLineToRelative(-3.5f)
                    horizontalLineToRelative(1.5f)
                    curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                    verticalLineToRelative(-1f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.paintBrush(
    color: Color,
    layered: Boolean = false
) = paintBrush(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)