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

fun UIKitRegularSymbols.hardDrive(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "HardDrive",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "HardDrive",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.81f, 10.86f)
                    curveToRelative(-0.82f, -2.35f, -1.88f, -4.61f, -2.45f, -5.77f)
                    curveToRelative(-0.33f, -0.68f, -1.02f, -1.09f, -1.76f, -1.09f)
                    horizontalLineToRelative(-7.1f)
                    curveToRelative(-0.8f, 0f, -1.52f, 0.48f, -1.84f, 1.21f)
                    lineToRelative(-2.41f, 5.63f)
                    curveToRelative(-0.16f, 0.37f, -0.24f, 0.76f, -0.24f, 1.16f)
                    verticalLineToRelative(2f)
                    curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                    horizontalLineToRelative(12f)
                    curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                    verticalLineToRelative(-2f)
                    curveToRelative(0f, -0.38f, -0.06f, -0.77f, -0.19f, -1.14f)
                    close()
                    moveTo(5.57f, 5.61f)
                    curveToRelative(0.16f, -0.37f, 0.52f, -0.61f, 0.92f, -0.61f)
                    horizontalLineToRelative(7.1f)
                    curveToRelative(0.37f, 0f, 0.71f, 0.21f, 0.87f, 0.53f)
                    curveToRelative(0.47f, 0.96f, 1.27f, 2.65f, 1.99f, 4.52f)
                    curveToRelative(-0.14f, -0.03f, -0.29f, -0.05f, -0.45f, -0.05f)
                    horizontalLineTo(4f)
                    curveToRelative(-0.11f, 0f, -0.22f, 0f, -0.32f, 0.03f)
                    lineToRelative(1.89f, -4.42f)
                    close()
                    moveTo(17f, 14f)
                    curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                    horizontalLineTo(4f)
                    curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                    verticalLineToRelative(-2f)
                    curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
                    horizontalLineToRelative(12f)
                    curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
                    verticalLineToRelative(2f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(14.75f, 13f)
                    moveToRelative(-0.75f, 0f)
                    arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.5f, 0f)
                    arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.5f, 0f)
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.hardDrive(
    color: Color,
    layered: Boolean = false
) = hardDrive(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)