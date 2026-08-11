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

fun UIKitFilledSymbols.weatherBlowingSnow(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "WeatherBlowingSnow",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "WeatherBlowingSnow",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9.5f, 3f)
                    curveToRelative(-1.67f, 0f, -3.1f, 1.18f, -3.43f, 2.81f)
                    lineToRelative(-0.06f, 0.29f)
                    curveToRelative(-0.08f, 0.41f, 0.18f, 0.8f, 0.59f, 0.88f)
                    curveToRelative(0.41f, 0.08f, 0.8f, -0.18f, 0.88f, -0.59f)
                    lineToRelative(0.06f, -0.29f)
                    curveToRelative(0.19f, -0.93f, 1.01f, -1.61f, 1.96f, -1.61f)
                    curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
                    reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f)
                    horizontalLineTo(2.75f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(6.75f)
                    curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f)
                    reflectiveCurveToRelative(-1.57f, -3.5f, -3.5f, -3.5f)
                    close()
                    moveTo(15.55f, 8f)
                    curveToRelative(-0.93f, 0f, -1.78f, 0.52f, -2.19f, 1.35f)
                    lineToRelative(-0.03f, 0.06f)
                    curveToRelative(-0.19f, 0.37f, -0.04f, 0.82f, 0.34f, 1.01f)
                    curveToRelative(0.37f, 0.19f, 0.82f, 0.04f, 1.01f, -0.34f)
                    lineToRelative(0.03f, -0.06f)
                    curveToRelative(0.16f, -0.32f, 0.49f, -0.52f, 0.85f, -0.52f)
                    curveToRelative(0.52f, 0f, 0.95f, 0.43f, 0.95f, 0.95f)
                    verticalLineToRelative(0.05f)
                    curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                    horizontalLineTo(2.75f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    horizontalLineToRelative(9.62f)
                    curveToRelative(0.48f, 0f, 0.88f, 0.39f, 0.88f, 0.88f)
                    reflectiveCurveToRelative(-0.39f, 0.88f, -0.88f, 0.88f)
                    curveToRelative(-0.29f, 0f, -0.57f, -0.15f, -0.73f, -0.39f)
                    lineToRelative(-0.02f, -0.02f)
                    curveToRelative(-0.23f, -0.34f, -0.7f, -0.44f, -1.04f, -0.21f)
                    curveToRelative(-0.34f, 0.23f, -0.44f, 0.7f, -0.21f, 1.04f)
                    lineToRelative(0.02f, 0.02f)
                    curveToRelative(0.44f, 0.66f, 1.19f, 1.06f, 1.98f, 1.06f)
                    curveToRelative(1.31f, 0f, 2.38f, -1.06f, 2.38f, -2.38f)
                    curveToRelative(0f, -0.31f, -0.06f, -0.6f, -0.17f, -0.88f)
                    horizontalLineToRelative(0.92f)
                    curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f)
                    verticalLineToRelative(-0.05f)
                    curveToRelative(0f, -1.35f, -1.1f, -2.45f, -2.45f, -2.45f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(4f, 5f)
                    curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
                    reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
                    reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
                    reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
                    close()
                    moveTo(8f, 16f)
                    curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                    reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f)
                    reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
                    reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
                    close()
                    moveTo(16f, 6f)
                    curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
                    reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
                    reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
                    reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.weatherBlowingSnow(
    color: Color,
    layered: Boolean = false
) = weatherBlowingSnow(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)