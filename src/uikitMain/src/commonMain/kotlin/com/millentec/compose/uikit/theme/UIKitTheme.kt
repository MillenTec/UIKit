package com.millentec.compose.uikit.theme

import androidx.compose.runtime.compositionLocalOf

data class UIKitTheme(
    val typography: Typography = Typography(),
    val colors: Colors = Colors.getLight()
) {
    companion object {
        val themeCurrent = compositionLocalOf { UIKitTheme() }
    }
}