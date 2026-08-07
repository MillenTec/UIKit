package com.millentec.compose.uikit.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppTheme {
    val themeLight: UIKitTheme = UIKitTheme.getLight()
    val themeDark: UIKitTheme = UIKitTheme.getDark()

    private val _theme = MutableStateFlow(themeDark)
    val theme = _theme.asStateFlow()

    private val _useAcrylic = MutableStateFlow(true)
    val useAcrylic = _useAcrylic.asStateFlow()

    fun dark(isDark: Boolean) {
        if (isDark) {
            _theme.value = themeDark
        } else {
            _theme.value = themeLight
        }
    }

    fun enableAcrylic(enabled: Boolean) {
        _useAcrylic.value = enabled
    }
}