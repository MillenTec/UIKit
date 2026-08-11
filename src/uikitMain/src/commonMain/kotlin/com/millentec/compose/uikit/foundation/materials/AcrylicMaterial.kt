package com.millentec.compose.uikit.foundation.materials

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
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
) = this.cloudy(
    enabled = enabled,
    shape = shape,
    sky = state._sky,
    tint = acrylicMaterial.tint,
    radius = (acrylicMaterial.radius * LocalDensity.current.density).value.toInt(),
    cpuBlurEnabled = getUIKitMaterials().acrylicMaterial.cpuComputationEnabled
).then(if (acrylicMaterial.lightingEffectsEnabled)
    this.border(
        width = acrylicMaterial.edgeHighlightThickness,
        brush = acrylicMaterial.edgeHighlightColor,
        shape = shape
    ) else this)

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