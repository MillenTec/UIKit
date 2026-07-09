package com.millentec.compose.uikit.foundation.materials

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
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
    shape: Shape = RectangleShape
) = Modifier.cloudy(
    enabled = enabled,
    shape = shape,
    sky = state._sky,
    tint = getUIKitMaterials().acrylicMaterial.tint,
    radius = getUIKitMaterials().acrylicMaterial.radius,
    cpuBlurEnabled = getUIKitMaterials().acrylicMaterial.cpuComputationEnabled
)

@Composable
fun Modifier.acrylicMaterialSource(
    state: AcrylicMaterialsState
) = Modifier.sky(state._sky)