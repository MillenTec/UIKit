package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

/**
 * 使用 UIKitTheme 主题, 使用 UIKitTheme.themeCurrent 可以得到可响应变化的属性字段
 * @param theme 所提供的 UIKitTheme 实例, 此参数变化时会触发重绘
 * @param content 需要响应主题的内容
 */
@Composable
fun UIKitThemeHost(
    theme: UIKitTheme,
    content: @Composable (() -> Unit)
) {
    CompositionLocalProvider(UIKitTheme.LocalTheme provides theme){
        content()
    }
}