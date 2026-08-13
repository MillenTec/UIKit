package com.millentec.compose.uikit.symbols.draw

sealed class UIKitPathNode {
    object Close: UIKitPathNode()

    data class MoveTo(
        val x: Float,
        val y: Float,
    ): UIKitPathNode()

    data class LineTo(
        val x: Float,
        val y: Float,
    ): UIKitPathNode()

    data class CurveTo(
        val x1: Float,
        val y1: Float,
        val x2: Float,
        val y2: Float,
        val x3: Float,
        val y3: Float,
    ): UIKitPathNode()
}