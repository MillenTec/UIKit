package com.millentec.compose.uikit.foundation.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class UIKitInputControlState(
    initialFocus: Boolean = false,
    initialValue: String = ""
) {
    val focused = mutableStateOf(initialFocus)
    val value = mutableStateOf(initialValue)
}

@Composable
fun rememberUIKitInputControlState(
    initialFocus: Boolean = false,
    initialValue: String = ""
): UIKitInputControlState {
    val state = remember { UIKitInputControlState(initialFocus, initialValue) }
    return state
}