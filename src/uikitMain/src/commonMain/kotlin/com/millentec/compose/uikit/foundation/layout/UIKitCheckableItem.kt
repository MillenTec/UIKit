package com.millentec.compose.uikit.foundation.layout

import androidx.compose.runtime.Composable

abstract class UIKitCheckableItem {
    @Composable
    abstract fun Content(isChecked: Boolean)
}