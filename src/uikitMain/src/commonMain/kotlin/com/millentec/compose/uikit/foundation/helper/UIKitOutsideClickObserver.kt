package com.millentec.compose.uikit.foundation.helper

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.toSize

class UIKitOutsideClickObserver {
    class Detector(
        val bounds: () -> Rect?,
        val onDownOutside: (change: PointerInputChange) -> Unit
    )

    private val _detectors = mutableListOf<Detector>()
    val detectors: List<Detector>
        get() = _detectors.toList()

    fun register(
        bounds: () -> Rect?,
        onDownOutside: (change: PointerInputChange) -> Unit
    ): Detector {
        val detector = Detector(bounds, onDownOutside)
        _detectors.add(detector)
        return detector
    }

    fun dispose(detector: Detector): Boolean {
        return _detectors.remove(detector)
    }

    fun dispatch(
        change: PointerInputChange,
        coordinates: LayoutCoordinates
    ) {
        if (detectors.isEmpty()) return
        for (detector in detectors) {
            val bounds = detector.bounds() ?: continue
            if (!bounds.contains(coordinates.localToRoot(change.position))) {
                detector.onDownOutside(change)
            }
        }
    }
}

internal val LocalOutsideClickObserver = compositionLocalOf<UIKitOutsideClickObserver?> { null }

@Composable
fun UIKitOutsideClickHost(
    content: @Composable () -> Unit
) {
    val observer = remember { UIKitOutsideClickObserver() }

    CompositionLocalProvider(
        LocalOutsideClickObserver provides observer,
    ) {
        val observer = LocalOutsideClickObserver.current
        val rootCoordinates = remember { mutableStateOf<LayoutCoordinates?>(null) }
        Box(
            modifier = observer?.let { observer ->
                Modifier
                    .fillMaxSize()
                    .onGloballyPositioned { rootCoordinates.value = it }
                    .pointerInput(observer) {
                        awaitEachGesture {
                            val downEvent = awaitFirstDown(
                                requireUnconsumed = false,
                                pass = PointerEventPass.Initial
                            )
                            val coordinates = rootCoordinates.value
                            if (coordinates != null && coordinates.isAttached) {
                                observer.dispatch(downEvent, coordinates)
                            }
                        }
                    }
            } ?: Modifier
        ) {
            content()
        }
    }
}

@Composable
fun Modifier.onClickOutside(
    enabled: Boolean = true,
    onDown: (change: PointerInputChange) -> Unit
) = composed {
    val rootRect = remember { mutableStateOf<Rect?>(null) }
    val observer = LocalOutsideClickObserver.current
    val detector = remember { mutableStateOf<UIKitOutsideClickObserver.Detector?>(null) }
    val onDownCurrent by rememberUpdatedState(onDown)

    DisposableEffect(observer, enabled) {
        if (observer != null && enabled) {
            detector.value = observer.register(
                bounds = { rootRect.value },
                onDownOutside = onDownCurrent
            )

            onDispose {
                detector.value?.let { observer.dispose(it) }
            }
        } else {
            onDispose {
                detector.value?.let { observer?.dispose(it) }
            }
        }
    }

    this.onGloballyPositioned {
        rootRect.value = Rect(
            offset = it.positionInRoot(),
            size = it.size.toSize()
        )
    }
}