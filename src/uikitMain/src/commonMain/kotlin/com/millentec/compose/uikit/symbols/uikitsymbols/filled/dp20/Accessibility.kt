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

fun UIKitFilledSymbols.accessibility(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Accessibility",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Accessibility",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 6f)
                    curveTo(11.105f, 6f, 12f, 5.105f, 12f, 4f)
                    curveTo(12f, 2.895f, 11.105f, 2f, 10f, 2f)
                    curveTo(8.895f, 2f, 8f, 2.895f, 8f, 4f)
                    curveTo(8f, 5.105f, 8.895f, 6f, 10f, 6f)
                    close()
                    moveTo(5.472f, 4.151f)
                    curveTo(4.59f, 3.758f, 3.554f, 4.152f, 3.155f, 5.03f)
                    curveTo(2.754f, 5.912f, 3.147f, 6.947f, 4.032f, 7.34f)
                    lineTo(6.703f, 8.53f)
                    curveTo(6.884f, 8.61f, 7f, 8.789f, 7f, 8.987f)
                    verticalLineTo(10.852f)
                    curveTo(7f, 10.916f, 6.988f, 10.98f, 6.964f, 11.039f)
                    lineTo(5.123f, 15.594f)
                    curveTo(4.761f, 16.49f, 5.194f, 17.51f, 6.09f, 17.872f)
                    curveTo(6.986f, 18.234f, 8.006f, 17.801f, 8.368f, 16.905f)
                    lineTo(9.766f, 13.446f)
                    curveTo(9.85f, 13.238f, 10.145f, 13.238f, 10.229f, 13.446f)
                    lineTo(11.627f, 16.905f)
                    curveTo(11.989f, 17.801f, 13.009f, 18.234f, 13.905f, 17.872f)
                    curveTo(14.801f, 17.51f, 15.234f, 16.49f, 14.872f, 15.594f)
                    lineTo(13.036f, 11.05f)
                    curveTo(13.012f, 10.991f, 13f, 10.927f, 13f, 10.863f)
                    verticalLineTo(8.987f)
                    curveTo(13f, 8.789f, 13.116f, 8.61f, 13.297f, 8.53f)
                    lineTo(15.968f, 7.34f)
                    curveTo(16.853f, 6.947f, 17.246f, 5.912f, 16.845f, 5.03f)
                    curveTo(16.446f, 4.152f, 15.41f, 3.758f, 14.528f, 4.151f)
                    lineTo(13.252f, 4.719f)
                    curveTo(13.006f, 4.828f, 12.83f, 5.026f, 12.731f, 5.243f)
                    curveTo(12.259f, 6.28f, 11.213f, 7f, 10f, 7f)
                    curveTo(8.787f, 7f, 7.741f, 6.28f, 7.268f, 5.243f)
                    curveTo(7.17f, 5.026f, 6.994f, 4.828f, 6.748f, 4.719f)
                    lineTo(5.472f, 4.151f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.accessibility(
    color: Color
) = accessibility(
    SolidColor(color)
)