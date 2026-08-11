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

fun UIKitFilledSymbols.copy(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Copy",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Copy",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(8f, 2f)
                    lineTo(14f, 2f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 4f)
                    lineTo(16f, 14f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 16f)
                    lineTo(8f, 16f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6f, 14f)
                    lineTo(6f, 4f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 2f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(4f, 6f)
                    curveToRelative(0f, -0.74f, 0.4f, -1.39f, 1f, -1.73f)
                    verticalLineToRelative(10.23f)
                    curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f)
                    horizontalLineToRelative(6.23f)
                    curveToRelative(-0.35f, 0.6f, -0.99f, 1f, -1.73f, 1f)
                    horizontalLineToRelative(-4.5f)
                    curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f)
                    verticalLineTo(6f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.copy(
    color: Color,
    layered: Boolean = false
) = copy(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)