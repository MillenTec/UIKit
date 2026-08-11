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
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitFilledSymbols.hardDrive(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "HardDrive",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.6f
            )
        )
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
                    moveTo(4f, 10f)
                    curveToRelative(-0.59f, 0f, -1.14f, 0.17f, -1.6f, 0.46f)
                    lineToRelative(2.25f, -5.25f)
                    curveToRelative(0.32f, -0.74f, 1.04f, -1.21f, 1.84f, -1.21f)
                    horizontalLineToRelative(7.1f)
                    curveToRelative(0.74f, 0f, 1.43f, 0.41f, 1.76f, 1.09f)
                    curveToRelative(0.54f, 1.11f, 1.53f, 3.21f, 2.33f, 5.43f)
                    curveToRelative(-0.48f, -0.33f, -1.06f, -0.52f, -1.69f, -0.52f)
                    horizontalLineTo(4f)
                    close()
                    moveTo(16f, 11f)
                    horizontalLineTo(4f)
                    curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
                    verticalLineToRelative(1f)
                    curveToRelative(0f, 1.1f, 0.89f, 1.99f, 1.99f, 2f)
                    horizontalLineToRelative(12.01f)
                    curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                    verticalLineToRelative(-1f)
                    curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
                    close()
                    moveTo(15.5f, 14.25f)
                    curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
                    reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f)
                    reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(15.5f, 13.5f)
                    moveToRelative(-0.75f, 0f)
                    arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.5f, 0f)
                    arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.5f, 0f)
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.hardDrive(
    color: Color,
    layered: Boolean = false
) = hardDrive(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color.copy(0f))
    )
)