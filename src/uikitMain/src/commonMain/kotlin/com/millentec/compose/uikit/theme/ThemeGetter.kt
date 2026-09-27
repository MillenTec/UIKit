package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable

@Composable
fun getUIKitTheme(): UIKitTheme {
    return LocalUIKitTheme.current
}

@Composable
fun getUIKitColors(): UIKitColors {
    return LocalUIKitTheme.current.colors
}

@Composable
fun getUIKitShapes(): UIKitShapes {
    return LocalUIKitTheme.current.shapes
}

@Composable
fun getUIKitTypography(): UIKitTypography {
    return LocalUIKitTheme.current.typography
}

@Composable
fun getUIKitLayout(): UIKitLayout {
    return LocalUIKitTheme.current.layout
}

@Composable
fun getUIKitAnimate(): UIKitAnimate {
    return LocalUIKitTheme.current.animate
}

@Composable
fun getUIKitMaterials(): UIKitMaterials {
    return LocalUIKitTheme.current.materials
}