package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable

@Composable
fun getUIKitTheme(): UIKitTheme {
    return UIKitTheme.LocalTheme.current
}

@Composable
fun getUIKitColors(): UIKitColors {
    return UIKitTheme.LocalTheme.current.colors
}

@Composable
fun getUIKitShapes(): UIKitShapes {
    return UIKitTheme.LocalTheme.current.shapes
}

@Composable
fun getUIKitTypography(): UIKitTypography {
    return UIKitTheme.LocalTheme.current.typography
}

@Composable
fun getUIKitLayout(): UIKitLayout {
    return UIKitTheme.LocalTheme.current.layout
}

@Composable
fun getUIKitAnimate(): UIKitAnimate {
    return UIKitTheme.LocalTheme.current.animate
}

@Composable
fun getUIKitMaterials(): UIKitMaterials {
    return UIKitTheme.LocalTheme.current.materials
}