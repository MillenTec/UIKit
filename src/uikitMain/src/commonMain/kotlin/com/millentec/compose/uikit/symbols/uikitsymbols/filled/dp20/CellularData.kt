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

fun UIKitFilledSymbols.cellularData(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "CellularData",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "CellularData",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(4)) {
                    moveTo(16.75f, 4f)
                    curveToRelative(0.37f, 0f, 0.68f, 0.27f, 0.74f, 0.63f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 10.52f, 0f, 10.52f)
                    curveToRelative(0f, 0.41f, -0.33f, 0.75f, -0.74f, 0.75f)
                    curveToRelative(-0.37f, 0f, -0.68f, -0.27f, -0.74f, -0.63f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -10.52f, 0f, -10.52f)
                    curveToRelative(0f, -0.41f, 0.33f, -0.75f, 0.74f, -0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(7.75f, 10f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4.75f, 12f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 2.5f, 0f, 2.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -2.5f, 0f, -2.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(2)) {
                    moveTo(10.75f, 8f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 6.5f, 0f, 6.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -6.5f, 0f, -6.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(3)) {
                    moveTo(13.75f, 6f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 8.5f, 0f, 8.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -8.5f, 0f, -8.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.cellularData(
    color: Color,
    layered: Boolean = false
) = cellularData(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.45f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
)