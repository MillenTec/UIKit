package com.millentec.compose.uikit.foundation.helper

import androidx.compose.runtime.Composable
import com.millentec.compose.uikit.component.flyout.UIKitFlyouter
import com.millentec.compose.uikit.theme.UIKitTheme
import com.millentec.compose.uikit.theme.UIKitThemeHost

@Composable
fun UIKitHost(
    theme: UIKitTheme = UIKitTheme.getLight(),
    content: @Composable () -> Unit
) {
    UIKitThemeHost(theme) {
        UIKitOutsideClickHost {
            UIKitFlyouter {
                content()
            }
        }
    }
}