package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.toggleMultiple(
    primaryColor: Color,
    secondaryColor: Color,
    includeThumb: Boolean
): ImageVector {
    val imageVector: ImageVector = ImageVector.Builder(
        name = "ToggleMultiple",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = SolidColor(primaryColor)) {
            moveTo(13.5f, 2f)
            horizontalLineToRelative(-7f)
            curveToRelative(-1.9f, 0f, -3.5f, 1.6f, -3.5f, 3.5f)
            reflectiveCurveToRelative(1.6f, 3.5f, 3.5f, 3.5f)
            horizontalLineToRelative(7f)
            curveToRelative(1.9f, 0f, 3.5f, -1.6f, 3.5f, -3.5f)
            reflectiveCurveToRelative(-1.6f, -3.5f, -3.5f, -3.5f)
            close()
            moveTo(6.5f, 7f)
            curveToRelative(-0.8f, 0f, -1.5f, -0.7f, -1.5f, -1.5f)
            reflectiveCurveToRelative(0.7f, -1.5f, 1.5f, -1.5f)
            reflectiveCurveToRelative(1.5f, 0.7f, 1.5f, 1.5f)
            reflectiveCurveToRelative(-0.7f, 1.5f, -1.5f, 1.5f)
            close()
        }
        path(fill = SolidColor(primaryColor)) {
            moveTo(13.5f, 11f)
            horizontalLineToRelative(-7f)
            curveToRelative(-1.9f, 0f, -3.5f, 1.6f, -3.5f, 3.5f)
            reflectiveCurveToRelative(1.6f, 3.5f, 3.5f, 3.5f)
            horizontalLineToRelative(7f)
            curveToRelative(1.9f, 0f, 3.5f, -1.6f, 3.5f, -3.5f)
            reflectiveCurveToRelative(-1.6f, -3.5f, -3.5f, -3.5f)
            close()
            moveTo(13.5f, 16f)
            curveToRelative(-0.8f, 0f, -1.5f, -0.7f, -1.5f, -1.5f)
            reflectiveCurveToRelative(0.7f, -1.5f, 1.5f, -1.5f)
            reflectiveCurveToRelative(1.5f, 0.7f, 1.5f, 1.5f)
            reflectiveCurveToRelative(-0.7f, 1.5f, -1.5f, 1.5f)
            close()
        }
        if (includeThumb) {
            path(
                fill = SolidColor(secondaryColor),
            ) {
                moveTo(13.5f, 14.5f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
            path(
                fill = SolidColor(secondaryColor),
            ) {
                moveTo(6.5f, 5.5f)
                moveToRelative(-1.5f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3f, 0f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3f, 0f)
            }
        }
    }.build()

    return imageVector
}

fun FluentIcons.Filled.toggleMultiple(): ImageVector {
    return toggleMultiple(Color(0xFF212121), Color.Transparent, false)
}

fun FluentIcons.Filled.toggleMultiple(
    color: Color = Color(0xFF212121),
    layered: Boolean = false
): ImageVector {
    return toggleMultiple(color, if (layered) color.copy(0.3f) else color, layered)
}