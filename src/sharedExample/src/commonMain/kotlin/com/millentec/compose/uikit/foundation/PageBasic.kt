package com.millentec.compose.uikit.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

open class PageBasic(
    title: String,
    parent: Int? = null,
) {
    val title = mutableStateOf(title)
    val parent = mutableStateOf(parent)

    @Composable
    open fun Content() {}
}