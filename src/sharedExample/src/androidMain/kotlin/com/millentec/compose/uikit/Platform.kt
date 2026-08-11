package com.millentec.compose.uikit

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
actual fun BackHandler(enable: Boolean, onBack: () -> Unit) {
    BackHandler(enabled = enable) {
        onBack()
    }
}

@Composable
actual fun IsStatusBarDarkMode(isDark: Boolean) {
    val view = LocalView.current
    val context = LocalContext.current

    val window = (context as? Activity)?.window

    if (window != null) {
        SideEffect {
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = !isDark
        }
    }
}