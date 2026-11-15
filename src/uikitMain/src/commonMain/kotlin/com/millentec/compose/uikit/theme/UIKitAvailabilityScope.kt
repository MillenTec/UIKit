package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.millentec.compose.uikit.theme.colors.UIKitColors
import com.millentec.compose.uikit.theme.colors.disabledScope

@Composable
fun UIKitAvailabilityScope(
    enabled: Boolean,
    transform: ((basicColors: UIKitColors) -> UIKitColors)? = null,
    adjust: ((handledColors: UIKitColors) -> UIKitColors)? = null,
    content: @Composable () -> Unit
) {
    val colors = transform?.invoke(LocalUIKitTheme.current.colors) ?: LocalUIKitTheme.current.colors.disabledScope()

    CompositionLocalProvider(
        LocalUIKitTheme provides
            if (enabled)
                LocalUIKitTheme.current
            else
                LocalUIKitTheme.current.copy(colors = adjust?.invoke(colors) ?: colors)
    ) {
        content()
    }
}