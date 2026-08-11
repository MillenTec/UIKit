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

fun UIKitRegularSymbols.dismissCircle(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "DismissCircle",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "DismissCircle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 2f)
                    curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
                    reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
                    reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
                    reflectiveCurveTo(14.42f, 2f, 10f, 2f)
                    close()
                    moveTo(10f, 17f)
                    curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f)
                    reflectiveCurveToRelative(3.13f, -7f, 7f, -7f)
                    reflectiveCurveToRelative(7f, 3.13f, 7f, 7f)
                    reflectiveCurveToRelative(-3.13f, 7f, -7f, 7f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(7.81f, 7.11f)
                    lineToRelative(0.07f, 0.06f)
                    lineToRelative(2.12f, 2.12f)
                    lineToRelative(2.12f, -2.12f)
                    curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
                    lineToRelative(0.07f, 0.06f)
                    curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
                    lineToRelative(-0.06f, 0.07f)
                    lineToRelative(-2.12f, 2.12f)
                    lineToRelative(2.12f, 2.12f)
                    curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
                    lineToRelative(-0.06f, 0.07f)
                    curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
                    lineToRelative(-0.07f, -0.06f)
                    lineToRelative(-2.12f, -2.12f)
                    lineToRelative(-2.12f, 2.12f)
                    curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
                    lineToRelative(-0.07f, -0.06f)
                    curveToRelative(-0.17f, -0.17f, -0.19f, -0.44f, -0.06f, -0.64f)
                    lineToRelative(0.06f, -0.07f)
                    lineToRelative(2.12f, -2.12f)
                    lineToRelative(-2.12f, -2.12f)
                    curveToRelative(-0.17f, -0.17f, -0.19f, -0.44f, -0.06f, -0.64f)
                    lineToRelative(0.06f, -0.07f)
                    curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.dismissCircle(
    color: Color,
    layered: Boolean = false
) = dismissCircle(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)