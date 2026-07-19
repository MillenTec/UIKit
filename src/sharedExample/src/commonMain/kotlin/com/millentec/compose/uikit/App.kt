package com.millentec.compose.uikit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.theme.AppTheme
import com.millentec.compose.uikit.views.MainViewVerticalLayout

@Composable
@Preview
fun App() {
    UIKitTheme(AppTheme.theme.collectAsState().value) {
        MainViewVerticalLayout()
    }
}