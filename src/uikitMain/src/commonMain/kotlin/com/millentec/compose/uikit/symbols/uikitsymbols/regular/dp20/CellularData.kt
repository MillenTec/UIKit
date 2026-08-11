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

fun UIKitRegularSymbols.cellularData(
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
                    moveTo(16.5f, 4f)
                    curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
                    verticalLineToRelative(0.09f)
                    reflectiveCurveToRelative(0f, 11f, 0f, 11f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
                    verticalLineToRelative(-0.09f)
                    reflectiveCurveToRelative(0f, -11f, 0f, -11f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(7.5f, 10f)
                    curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
                    verticalLineToRelative(0.09f)
                    reflectiveCurveToRelative(0f, 5f, 0f, 5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
                    verticalLineToRelative(-0.09f)
                    reflectiveCurveToRelative(0f, -5f, 0f, -5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4.5f, 12f)
                    curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
                    verticalLineToRelative(0.09f)
                    reflectiveCurveToRelative(0f, 3f, 0f, 3f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
                    verticalLineToRelative(-0.09f)
                    reflectiveCurveToRelative(0f, -3f, 0f, -3f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(2)) {
                    moveTo(10.5f, 8f)
                    curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
                    verticalLineToRelative(0.09f)
                    reflectiveCurveToRelative(0f, 7f, 0f, 7f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
                    verticalLineToRelative(-0.09f)
                    reflectiveCurveToRelative(0f, -7f, 0f, -7f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(3)) {
                    moveTo(13.5f, 6f)
                    curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
                    verticalLineToRelative(0.09f)
                    reflectiveCurveToRelative(0f, 9f, 0f, 9f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
                    verticalLineToRelative(-0.09f)
                    reflectiveCurveToRelative(0f, -9f, 0f, -9f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.cellularData(
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