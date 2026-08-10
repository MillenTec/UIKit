package com.millentec.compose.uikit.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

open class PageBasic(
    id: String,
    parent: Int? = null,
) {
    val id = mutableStateOf(id)
    val parent = mutableStateOf(parent)

    @Composable
    open fun Content() {}
}