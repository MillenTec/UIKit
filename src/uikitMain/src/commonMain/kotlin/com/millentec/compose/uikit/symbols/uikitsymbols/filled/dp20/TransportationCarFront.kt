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

fun UIKitFilledSymbols.transportationCarFront(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "TransportationCarFront",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "TransportationCarFront",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(6f, 16f)
                    verticalLineToRelative(1f)
                    curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                    reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f)
                    verticalLineToRelative(-1f)
                    horizontalLineToRelative(2f)
                    close()
                    moveTo(16f, 16f)
                    verticalLineToRelative(1f)
                    curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                    reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f)
                    verticalLineToRelative(-1f)
                    horizontalLineToRelative(2f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(16.92f, 8.06f)
                    lineToRelative(-0.11f, -0.56f)
                    horizontalLineToRelative(0.54f)
                    curveToRelative(0.37f, -0.06f, 0.65f, -0.37f, 0.65f, -0.75f)
                    verticalLineToRelative(-0.1f)
                    curveToRelative(-0.06f, -0.37f, -0.37f, -0.65f, -0.75f, -0.65f)
                    horizontalLineToRelative(-0.74f)
                    lineToRelative(-0.2f, -0.99f)
                    curveToRelative(-0.23f, -1.17f, -1.26f, -2.01f, -2.45f, -2.01f)
                    horizontalLineToRelative(-7.72f)
                    curveToRelative(-1.19f, 0f, -2.22f, 0.84f, -2.45f, 2.01f)
                    lineToRelative(-0.2f, 0.99f)
                    horizontalLineToRelative(-0.74f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(0.44f)
                    lineToRelative(-0.11f, 0.56f)
                    curveToRelative(-0.62f, 0.18f, -1.08f, 0.76f, -1.08f, 1.44f)
                    verticalLineToRelative(4f)
                    curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                    horizontalLineToRelative(13f)
                    curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f)
                    verticalLineToRelative(-4f)
                    curveToRelative(0f, -0.68f, -0.46f, -1.26f, -1.08f, -1.44f)
                    close()
                    moveTo(6f, 12.5f)
                    curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                    reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
                    reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
                    reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
                    close()
                    moveTo(14f, 12.5f)
                    curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                    reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
                    reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
                    reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
                    close()
                    moveTo(4.11f, 8f)
                    lineToRelative(0.56f, -2.79f)
                    curveToRelative(0.14f, -0.7f, 0.76f, -1.21f, 1.47f, -1.21f)
                    horizontalLineToRelative(7.72f)
                    curveToRelative(0.71f, 0f, 1.33f, 0.5f, 1.47f, 1.21f)
                    lineToRelative(0.56f, 2.79f)
                    horizontalLineTo(4.11f)
                    close()
                    moveTo(6f, 10.5f)
                    curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f)
                    reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
                    reflectiveCurveToRelative(1f, -0.45f, 1f, -1f)
                    reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
                    close()
                    moveTo(14f, 10.5f)
                    curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f)
                    reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
                    reflectiveCurveToRelative(1f, -0.45f, 1f, -1f)
                    reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.transportationCarFront(
    color: Color,
    layered: Boolean = false
) = transportationCarFront(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color.copy(0f))
    )
)