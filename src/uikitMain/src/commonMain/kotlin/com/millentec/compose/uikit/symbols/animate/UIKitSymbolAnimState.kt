package com.millentec.compose.uikit.symbols.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter

class UIKitSymbolAnimState(
    val id: String,
    initialScale: Float = 1f,
    initialAlpha: Float = 1f,
    initialPathTrimStart: Float = 0f,
    initialPathTrimEnd: Float = 1f,
) {
    val scaleState = Animatable(
        initialValue = initialScale,
        typeConverter = Float.VectorConverter,
    )

    val alphaState = Animatable(
        initialValue = initialAlpha,
        typeConverter = Float.VectorConverter,
    )

    val pathTrimStartState = Animatable(
        initialValue = initialPathTrimStart,
        typeConverter = Float.VectorConverter,
    )

    val pathTrimEndState = Animatable(
        initialValue = initialPathTrimEnd,
        typeConverter = Float.VectorConverter,
    )
}