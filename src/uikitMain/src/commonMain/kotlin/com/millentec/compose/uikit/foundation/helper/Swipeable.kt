package com.millentec.compose.uikit.foundation.helper

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Composable
fun Modifier.uikitSwipeable(
    onDragStart: (Offset) -> Unit = {},
    onDrag: (Offset) -> Unit = {},
    onDragEnd: () -> Unit = {},
    onDragCancel: () -> Unit = {},
    onSwipeLeft: () -> Unit = {},
    onSwipeRight: () -> Unit = {},
    onSwipeUp: () -> Unit = {},
    onSwipeDown: () -> Unit = {},
    swipeThreshold: Dp = 400.dp
): Modifier {
    val velocityTracker = remember { VelocityTracker() }

    return this
        .pointerInput(Unit) {
            awaitEachGesture {
                val down = awaitFirstDown()
                velocityTracker.resetTracking()
                velocityTracker.addPosition(down.uptimeMillis, down.position)
            }
        }
        .pointerInput(Unit) {
            detectDragGestures(
                onDragStart = {
                    onDragStart(it)
                },
                onDrag = { change, dragAmount ->
                    onDrag(dragAmount)
                    velocityTracker.addPosition(change.uptimeMillis, change.position)
                    change.consume()
                },
                onDragEnd = {
                    onDragEnd()
                    val velocity = velocityTracker.calculateVelocity()

                    val thresholdPx = swipeThreshold.toPx()

                    if (abs(velocity.x) > abs(velocity.y)) {
                        if (velocity.x > thresholdPx) onSwipeRight()
                        else if (velocity.x < -thresholdPx) onSwipeLeft()
                    } else {
                        if (velocity.y > thresholdPx) onSwipeDown()
                        else if (velocity.y < -thresholdPx) onSwipeUp()
                    }
                },
                onDragCancel = onDragCancel
            )
        }
}