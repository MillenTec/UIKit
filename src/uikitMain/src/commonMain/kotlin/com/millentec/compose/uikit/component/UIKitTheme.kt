package com.millentec.compose.uikit.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.millentec.compose.uikit.theme.UIKitTheme

@Composable
fun UIKitTheme(
    theme: UIKitTheme,
    content: @Composable (() -> Unit)
) {
    CompositionLocalProvider(UIKitTheme.themeCurrent provides theme){
        content()
    }
}