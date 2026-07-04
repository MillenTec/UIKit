package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable

@Composable
fun getUIKitTheme(): UIKitTheme {
    return UIKitTheme.themeCurrent.current
}

@Composable
fun getUIKitColors(): UIKitColors {
    return UIKitTheme.themeCurrent.current.colors
}

@Composable
fun getUIKitShapes(): UIKitShapes {
    return UIKitTheme.themeCurrent.current.shapes
}

@Composable
fun getUIKitTypography(): UIKitTypography {
    return UIKitTheme.themeCurrent.current.typography
}

@Composable
fun getUIKitLayout(): UIKitLayout {
    return UIKitTheme.themeCurrent.current.layout
}