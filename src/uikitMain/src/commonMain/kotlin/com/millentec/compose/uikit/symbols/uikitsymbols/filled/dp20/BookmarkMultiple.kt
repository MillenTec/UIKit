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

fun UIKitFilledSymbols.bookmarkMultiple(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "BookmarkMultiple",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "BookmarkMultiple",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(6.27f, 3f)
                    curveToRelative(0.35f, -0.6f, 0.99f, -1f, 1.73f, -1f)
                    horizontalLineToRelative(4.5f)
                    curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f)
                    verticalLineToRelative(10f)
                    curveToRelative(0f, 0.18f, -0.1f, 0.35f, -0.26f, 0.44f)
                    curveToRelative(-0.16f, 0.09f, -0.36f, 0.08f, -0.51f, -0.02f)
                    lineToRelative(-0.22f, -0.15f)
                    verticalLineTo(5.5f)
                    curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f)
                    horizontalLineToRelative(-6.23f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6f, 4f)
                    curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
                    verticalLineToRelative(11.5f)
                    curveToRelative(0f, 0.18f, 0.1f, 0.35f, 0.26f, 0.44f)
                    reflectiveCurveToRelative(0.36f, 0.08f, 0.51f, -0.02f)
                    lineToRelative(4.22f, -2.82f)
                    lineToRelative(4.22f, 2.82f)
                    curveToRelative(0.15f, 0.1f, 0.35f, 0.11f, 0.51f, 0.02f)
                    curveToRelative(0.16f, -0.09f, 0.26f, -0.26f, 0.26f, -0.44f)
                    verticalLineTo(6f)
                    curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
                    horizontalLineToRelative(-6f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.bookmarkMultiple(
    color: Color,
    layered: Boolean = false
) = bookmarkMultiple(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)