package com.millentec.compose.uikit.foundation.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection

@Composable
fun Modifier.darken(
    degree: Float,
    shape: Shape = RectangleShape,
): Modifier {
    val layoutDirection = LocalLayoutDirection.current
    val density = LocalDensity.current

    return this.drawWithContent {
        drawContent()
        drawOutline(
            outline = shape.createOutline(
                size = size,
                layoutDirection = layoutDirection,
                density = density
            ),
            color = Color.Black.copy(degree),
            blendMode = BlendMode.Darken
        )
    }
}