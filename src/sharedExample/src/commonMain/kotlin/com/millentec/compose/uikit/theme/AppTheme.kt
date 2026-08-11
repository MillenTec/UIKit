package com.millentec.compose.uikit.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class ThemeType {
    System,
    Light,
    Dark
}

object AppTheme {
    private val _theme = MutableStateFlow(ThemeType.System)
    val theme = _theme.asStateFlow()

    private val _useAcrylic = MutableStateFlow(true)
    val useAcrylic = _useAcrylic.asStateFlow()

    fun switchTheme(theme: ThemeType) {
        _theme.value = theme
    }

    fun enableAcrylic(enabled: Boolean) {
        _useAcrylic.value = enabled
    }
}