package com.millentec.compose.uikit.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppTheme {
    val themeLight: UIKitTheme = UIKitTheme()
    val themeDark: UIKitTheme = UIKitTheme(
        colors = UIKitColors.getDark(),
        materials = UIKitMaterials.getDark()
    )

    private val _theme = MutableStateFlow(themeLight)
    val theme = _theme.asStateFlow()

    fun dark(isDark: Boolean) {
        if (isDark) _theme.value = themeDark
        else _theme.value = themeLight
    }
}