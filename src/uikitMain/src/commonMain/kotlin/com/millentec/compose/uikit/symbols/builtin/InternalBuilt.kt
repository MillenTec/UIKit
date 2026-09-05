@file:Suppress("FunctionName")

package com.millentec.compose.uikit.symbols.builtin

import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer

internal fun UIKitSymbolDisable(zIndex: Int = 1): UIKitSymbolLayer {
    return UIKitSymbolLayer("disable", zIndex).apply {
        group(
            id = "disable.mask",
            drawType = UIKitPathDrawType.MaskStroke(
                lineWidth = 3f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            ),
            defaultState = UIKitSymbolGroupState(
                pathTrimEnd = 0f
            )
        ) {
            moveTo(2.5f, 2.5f)
            lineTo(17.5f, 17.5f)
        }

        group(
            id = "disable",
            drawType = UIKitPathDrawType.Stroke(
                lineWidth = 1f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            ),
            defaultState = UIKitSymbolGroupState(
                pathTrimEnd = 0f
            )
        ) {
            moveTo(2.5f, 2.5f)
            lineTo(17.5f, 17.5f)
        }
    }
}