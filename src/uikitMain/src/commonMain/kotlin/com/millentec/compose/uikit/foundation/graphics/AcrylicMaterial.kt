package com.millentec.compose.uikit.foundation.graphics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import com.millentec.compose.uikit.theme.UIKitAcrylicMaterial
import com.millentec.compose.uikit.theme.getUIKitMaterials
import com.skydoves.cloudy.Sky
import com.skydoves.cloudy.cloudy
import com.skydoves.cloudy.rememberSky
import com.skydoves.cloudy.sky

class AcrylicMaterialState {
    internal var _sky: Sky

    internal constructor(sky: Sky) {
        _sky = sky
    }

    fun invalidate() {
        _sky.invalidate()
    }

    fun invalidate(durationMillis: Long) {
        _sky.invalidate(durationMillis)
    }
}

@Composable
fun rememberAcrylicMaterialState(): AcrylicMaterialState {
    val sky = rememberSky()
    return remember(sky) { AcrylicMaterialState(sky) }
}

@Composable
fun Modifier.acrylicMaterial(
    state: AcrylicMaterialState,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    acrylicMaterial: UIKitAcrylicMaterial = getUIKitMaterials().acrylicMaterial
): Modifier {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current

    return this.cloudy(
        enabled = enabled,
        shape = shape,
        sky = state._sky,
        tint = acrylicMaterial.tint,
        radius = (acrylicMaterial.radius * LocalDensity.current.density).value.toInt(),
        cpuBlurEnabled = getUIKitMaterials().acrylicMaterial.cpuComputationEnabled
    ).then(
        if (acrylicMaterial.lightingEffectsEnabled)
        this.drawWithContent {
            drawContent()

            val borderPath = Path().apply { addOutline(shape.createOutline(size, layoutDirection, density)) }
            val brush = Brush.linearGradient(
                colorStops = acrylicMaterial.edgeHighlightStops.toTypedArray(),
                start = Offset(
                    x = size.width / 2f - size.width * 0.1f,
                    y = size.height + size.height * 0.35f
                ),
                end = Offset(
                    x = size.width / 2f + size.width * 0.1f,
                    y = 0f - size.height * 0.35f
                )
            )

            drawPath(
                brush = brush,
                path = borderPath,
                style = Stroke(width = acrylicMaterial.edgeHighlightThickness.toPx())
            )
        } else this)
}

@Composable
fun Modifier.acrylicMaterialSource(
    state: AcrylicMaterialState
) = this.sky(state._sky)

@Composable
fun Modifier.selfBlur(
    radius: Dp,
) = this.cloudy(
    radius = (radius * LocalDensity.current.density).value.toInt()
)