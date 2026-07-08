package com.millentec.compose.uikit.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween

class NavigationAnimate {
    val jump: ContentTransform = ContentTransform(
        targetContentEnter = fadeIn(animationSpec = tween(220, delayMillis = 160)) +
                scaleIn(initialScale = 0.96f, animationSpec = tween(220, delayMillis = 160)),
        initialContentExit = fadeOut(animationSpec = tween(160))
    )

    val forward: ContentTransform = ContentTransform(
        targetContentEnter = slideInHorizontally(
            animationSpec = tween(300, easing = FastOutSlowInEasing)
        ) {
            it
        },
        initialContentExit = slideOutHorizontally(
            animationSpec = tween(300, easing = FastOutSlowInEasing)
        ) {
            -300
        } + fadeOut(tween(300), targetAlpha = 0.2f) + scaleOut(tween(300, easing = EaseInOut), targetScale = 0.96f)
    )

    fun backward(targetContentZIndex: Float): ContentTransform {
        return ContentTransform(
            targetContentEnter = slideInHorizontally(
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) {
                -300
            } + fadeIn(tween(350), initialAlpha = 0.2f),
            initialContentExit = slideOutHorizontally(
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) {
                it
            },
            targetContentZIndex = -targetContentZIndex
        )
    }
}