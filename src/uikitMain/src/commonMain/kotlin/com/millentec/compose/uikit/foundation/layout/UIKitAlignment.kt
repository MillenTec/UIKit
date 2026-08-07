package com.millentec.compose.uikit.foundation.layout

import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment

data class UIKitAlignment(
    val horizontalBias: Float,
    val verticalBias: Float,
) {
    fun toAlignment(): Alignment {
        return BiasAlignment(horizontalBias, verticalBias)
    }

    companion object {
        val TopStart: UIKitAlignment = UIKitAlignment(-1f, -1f)
        val TopCenter: UIKitAlignment = UIKitAlignment(0f, -1f)
        val TopEnd: UIKitAlignment = UIKitAlignment(1f, -1f)
        val CenterStart: UIKitAlignment = UIKitAlignment(-1f, 0f)
        val Center: UIKitAlignment = UIKitAlignment(0f, 0f)
        val CenterEnd: UIKitAlignment = UIKitAlignment(1f, 0f)
        val BottomStart: UIKitAlignment = UIKitAlignment(-1f, 1f)
        val BottomCenter: UIKitAlignment = UIKitAlignment(0f, 1f)
        val BottomEnd: UIKitAlignment = UIKitAlignment(1f, 1f)
    }
}
