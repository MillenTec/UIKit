package com.millentec.compose.uikit.symbols.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter

class UIKitSymbolAnimState {
    val scaleState = Animatable(
        initialValue = 1f,
        typeConverter = Float.VectorConverter,
    )

    val alphaState = Animatable(
        initialValue = 1f,
        typeConverter = Float.VectorConverter,
    )
}