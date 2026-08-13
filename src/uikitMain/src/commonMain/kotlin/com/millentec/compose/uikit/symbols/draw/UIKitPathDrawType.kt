package com.millentec.compose.uikit.symbols.draw

import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin

sealed class UIKitPathDrawType {
    data class Stroke(
        val cap: StrokeCap,
        val join: StrokeJoin
    ): UIKitPathDrawType()

    object Fill: UIKitPathDrawType()
}