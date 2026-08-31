package com.millentec.compose.uikit.symbols.animate

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.ui.geometry.Offset
import com.millentec.compose.uikit.symbols.animate.UIKitAnimSelector.*

class UIKitSymbolAnimState(
    val id: String,
    initialScale: Float = 1f,
    initialScaleCenter: Offset = Offset(10f, 10f),
    initialAlpha: Float = 1f,
    initialPathTrimStart: Float = 0f,
    initialPathTrimEnd: Float = 1f,
    initialRotate: Float = 0f,
    initialRotateCenter: Offset = Offset(10f, 10f),
    initialTranslate: Offset = Offset(0f, 0f),
) {
    val visible: Boolean
        get() = alphaState.value > 0f
                && scaleState.value > 0f
                && pathTrimStartState.value - pathTrimEndState.value != 0f

    fun visible(
        filter: List<UIKitAnimSelector>
    ): Boolean {
        val values = filter.map { selector ->
            when (selector) {
                Empty -> true
                Scale -> scaleState.value > 0f
                ScaleCenterX -> true
                ScaleCenterY -> true
                Alpha -> alphaState.value > 0f
                PathTrimStart -> {
                    pathTrimStartState.value - pathTrimEndState.value != 0f
                }
                PathTrimEnd -> {
                    pathTrimStartState.value - pathTrimEndState.value != 0f
                }
                Rotate -> true
                RotateCenterX -> true
                RotateCenterY -> true
                TranslateX -> true
                TranslateY -> true
            }
        }

        return values.all {
            it
        }
    }

    fun snapshot(): UIKitSymbolGroupState {
        return UIKitSymbolGroupState(
            scale = scaleState.value,
            alpha = alphaState.value,
            pathTrimStart = pathTrimStartState.value,
            pathTrimEnd = pathTrimEndState.value,
        )
    }

    val scaleState = Animatable(
        initialValue = initialScale,
        typeConverter = Float.VectorConverter,
    )

    val scaleCenterXState = Animatable(
        initialValue = initialScaleCenter.x,
        typeConverter = Float.VectorConverter,
    )

    val scaleCenterYState = Animatable(
        initialValue = initialScaleCenter.y,
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

    val rotateState = Animatable(
        initialValue = initialRotate,
        typeConverter = Float.VectorConverter,
    )

    val rotateCenterXState = Animatable(
        initialValue = initialRotateCenter.x,
        typeConverter = Float.VectorConverter,
    )

    val rotateCenterYState = Animatable(
        initialValue = initialRotateCenter.y,
        typeConverter = Float.VectorConverter,
    )

    val translateXState = Animatable(
        initialValue = initialTranslate.x,
        typeConverter = Float.VectorConverter,
    )

    val translateYState = Animatable(
        initialValue = initialTranslate.y,
        typeConverter = Float.VectorConverter,
    )
}

data class UIKitSymbolGroupState(
    val scale: Float = 1f,
    val alpha: Float = 1f,
    val pathTrimStart: Float = 0f,
    val pathTrimEnd: Float = 1f,
) {
    val visible: Boolean
        get() = alpha > 0f
                && scale > 0f
                && pathTrimStart - pathTrimEnd != 0f

    fun visible(
        filter: List<UIKitAnimSelector>
    ): Boolean {
        val values = filter.map { selector ->
            when (selector) {
                Empty -> true
                Scale -> scale > 0f
                ScaleCenterX -> true
                ScaleCenterY -> true
                Alpha -> alpha > 0f
                PathTrimStart -> {
                    pathTrimStart - pathTrimEnd != 0f
                }
                PathTrimEnd -> {
                    pathTrimStart - pathTrimEnd != 0f
                }
                Rotate -> true
                RotateCenterX -> true
                RotateCenterY -> true
                TranslateX -> true
                TranslateY -> true
            }
        }

        return values.all {
            it
        }
    }
}