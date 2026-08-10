package com.millentec.compose.uikit

import androidx.compose.runtime.Composable

@Composable
expect fun BackHandler(enable: Boolean = true, onBack: () -> Unit)

@Composable
expect fun IsStatusBarDarkMode(isDark: Boolean)