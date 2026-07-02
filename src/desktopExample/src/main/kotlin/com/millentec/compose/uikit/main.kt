package com.millentec.compose.uikit

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "UIKit Gallery",
    ) {
        App()
    }
}