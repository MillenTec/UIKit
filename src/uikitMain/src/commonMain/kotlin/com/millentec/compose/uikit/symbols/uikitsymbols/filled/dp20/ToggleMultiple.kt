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

fun UIKitFilledSymbols.toggleMultiple(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ToggleMultiple",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "ToggleMultiple",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.5f, 2f)
                    horizontalLineToRelative(-7f)
                    curveToRelative(-1.9f, 0f, -3.5f, 1.6f, -3.5f, 3.5f)
                    reflectiveCurveToRelative(1.6f, 3.5f, 3.5f, 3.5f)
                    horizontalLineToRelative(7f)
                    curveToRelative(1.9f, 0f, 3.5f, -1.6f, 3.5f, -3.5f)
                    reflectiveCurveToRelative(-1.6f, -3.5f, -3.5f, -3.5f)
                    close()
                    moveTo(6.5f, 7f)
                    curveToRelative(-0.8f, 0f, -1.5f, -0.7f, -1.5f, -1.5f)
                    reflectiveCurveToRelative(0.7f, -1.5f, 1.5f, -1.5f)
                    reflectiveCurveToRelative(1.5f, 0.7f, 1.5f, 1.5f)
                    reflectiveCurveToRelative(-0.7f, 1.5f, -1.5f, 1.5f)
                    close()
                    moveTo(13.5f, 11f)
                    horizontalLineToRelative(-7f)
                    curveToRelative(-1.9f, 0f, -3.5f, 1.6f, -3.5f, 3.5f)
                    reflectiveCurveToRelative(1.6f, 3.5f, 3.5f, 3.5f)
                    horizontalLineToRelative(7f)
                    curveToRelative(1.9f, 0f, 3.5f, -1.6f, 3.5f, -3.5f)
                    reflectiveCurveToRelative(-1.6f, -3.5f, -3.5f, -3.5f)
                    close()
                    moveTo(13.5f, 16f)
                    curveToRelative(-0.8f, 0f, -1.5f, -0.7f, -1.5f, -1.5f)
                    reflectiveCurveToRelative(0.7f, -1.5f, 1.5f, -1.5f)
                    reflectiveCurveToRelative(1.5f, 0.7f, 1.5f, 1.5f)
                    reflectiveCurveToRelative(-0.7f, 1.5f, -1.5f, 1.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(13.5f, 14.5f)
                    moveToRelative(-1.5f, 0f)
                    arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                    arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
                    close()
                    moveTo(6.5f, 5.5f)
                    moveToRelative(-1.5f, 0f)
                    arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                    arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.toggleMultiple(
    color: Color,
    layered: Boolean = false
) = toggleMultiple(
    listOf(
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color),
        if (layered) SolidColor(color) else SolidColor(color.copy(0f))
    )
)