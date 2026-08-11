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

fun UIKitFilledSymbols.listBulletLtr(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ListBulletLtr",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "ListBulletLtr",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(7f, 4.75f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    horizontalLineToRelative(9.5f)
                    curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
                    reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
                    horizontalLineTo(7.75f)
                    curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
                    close()
                    moveTo(7.75f, 9f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(9.5f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
                    horizontalLineTo(7.75f)
                    close()
                    moveTo(7.75f, 14f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(9.5f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
                    horizontalLineTo(7.75f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(3.25f, 6f)
                    curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f)
                    reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f)
                    reflectiveCurveToRelative(-1.25f, 0.56f, -1.25f, 1.25f)
                    reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f)
                    close()
                    moveTo(4.5f, 9.75f)
                    curveToRelative(0f, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f)
                    reflectiveCurveToRelative(-1.25f, -0.56f, -1.25f, -1.25f)
                    reflectiveCurveToRelative(0.56f, -1.25f, 1.25f, -1.25f)
                    reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f)
                    close()
                    moveTo(3.25f, 16f)
                    curveToRelative(0.69f, 0f, 1.25f, -0.56f, 1.25f, -1.25f)
                    reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f)
                    reflectiveCurveToRelative(-1.25f, 0.56f, -1.25f, 1.25f)
                    reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.listBulletLtr(
    color: Color,
    layered: Boolean = false
) = listBulletLtr(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)