package com.millentec.compose.uikit.symbols.draw

import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin

sealed class UIKitPathDrawType {
    data class Stroke(
        val lineWidth: Float,
        val cap: StrokeCap = StrokeCap.Round,
        val join: StrokeJoin = StrokeJoin.Round
    ): UIKitPathDrawType()

    object Fill: UIKitPathDrawType()

    object MaskFilled: UIKitPathDrawType()

    data class MaskStroke(
        val lineWidth: Float,
        val cap: StrokeCap = StrokeCap.Round,
        val join: StrokeJoin = StrokeJoin.Round
    ): UIKitPathDrawType()

    data class Dashed(
        val lineWidth: Float,
        val dash: Float,
        val minGap: Float,
        val cap: StrokeCap = StrokeCap.Round,
        val join: StrokeJoin = StrokeJoin.Round
    ): UIKitPathDrawType()
}