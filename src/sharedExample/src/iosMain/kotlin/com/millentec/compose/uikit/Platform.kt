package com.millentec.compose.uikit

import androidx.compose.runtime.Composable

@Composable
actual fun BackHandler(enable: Boolean, onBack: () -> Unit) {}

@Composable
actual fun IsStatusBarDarkMode(isDark: Boolean) {}