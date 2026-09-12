package com.millentec.compose.uikit.theme

data class UIKitAnimate(
    val standardSpringDampingRatio: Float = 0.7f,
    val standardSpringStiffness: Float = 240f,

    val transformMomentaryDurationMillis: Int = 50,
    val transformFastDurationMillis: Int = 100,
    val transformRegularDurationMillis: Int = 200,
    val transformMediumDurationMillis: Int = 300,
    val transformSlowDurationMillis: Int = 500,

    val motionMomentaryDurationMillis: Int = 100,
    val motionFastDurationMillis: Int = 300,
    val motionRegularDurationMillis: Int = 400,
    val motionMediumDurationMillis: Int = 600,
    val motionSlowDurationMillis: Int = 800,
)
