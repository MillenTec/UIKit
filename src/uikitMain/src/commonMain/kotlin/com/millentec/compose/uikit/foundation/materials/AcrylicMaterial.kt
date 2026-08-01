package com.millentec.compose.uikit.foundation.materials

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.millentec.compose.uikit.theme.getUIKitMaterials
import com.skydoves.cloudy.Sky
import com.skydoves.cloudy.cloudy
import com.skydoves.cloudy.rememberSky
import com.skydoves.cloudy.sky

class AcrylicMaterialsState {
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
fun rememberAcrylicMaterialsState(): AcrylicMaterialsState {
    val sky = rememberSky()
    return remember(sky) { AcrylicMaterialsState(sky) }
}

@Composable
fun Modifier.acrylicMaterial(
    state: AcrylicMaterialsState,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    highlightEnabled: Boolean = true,
    tint: Color = getUIKitMaterials().acrylicMaterial.tint,
    radius: Dp = getUIKitMaterials().acrylicMaterial.radius,
) = this.cloudy(
    enabled = enabled,
    shape = shape,
    sky = state._sky,
    tint = tint,
    radius = (radius * LocalDensity.current.density).value.toInt(),
    cpuBlurEnabled = getUIKitMaterials().acrylicMaterial.cpuComputationEnabled
).then(if (highlightEnabled)
    this.border(
        width = getUIKitMaterials().acrylicMaterial.edgeHighlightThickness,
        brush = getUIKitMaterials().acrylicMaterial.edgeHighlightColor,
        shape = shape
    ) else this)

@Composable
fun Modifier.acrylicMaterial(
    state: AcrylicMaterialsState,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
) = this.acrylicMaterial(
    state = state,
    enabled = enabled,
    shape = shape,
    highlightEnabled = getUIKitMaterials().acrylicMaterial.lightingEffectsEnabled,
    tint = getUIKitMaterials().acrylicMaterial.tint,
    radius = getUIKitMaterials().acrylicMaterial.radius,
)

@Composable
fun Modifier.acrylicMaterialSource(
    state: AcrylicMaterialsState
) = this.sky(state._sky)

@Composable
fun Modifier.selfBlur(
    radius: Dp,
) = this.cloudy(
    radius = (radius * LocalDensity.current.density).value.toInt()
)