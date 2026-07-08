package com.millentec.compose.uikit

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun BackHandler(enable: Boolean, onBack: () -> Unit) {
    BackHandler(enabled = enable) {
        onBack()
    }
}