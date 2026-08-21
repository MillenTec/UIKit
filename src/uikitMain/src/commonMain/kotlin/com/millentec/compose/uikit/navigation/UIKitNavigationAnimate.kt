package com.millentec.compose.uikit.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween

object UIKitNavigationAnimate {
    val jump: ContentTransform = ContentTransform(
        targetContentEnter = fadeIn(animationSpec = tween(220, easing = FastOutSlowInEasing, delayMillis = 160))
                + slideInVertically(animationSpec = tween(220, easing = FastOutSlowInEasing, delayMillis = 160)) { 24 },
        initialContentExit = fadeOut(animationSpec = tween(160, easing = FastOutSlowInEasing))
            + slideOutVertically(animationSpec = tween(160, easing = FastOutSlowInEasing)) { -24 }
    )

    val forward: ContentTransform = ContentTransform(
        targetContentEnter = slideInHorizontally(
            animationSpec = tween(380, easing = FastOutSlowInEasing)
        ) {
            it
        },
        initialContentExit = slideOutHorizontally(
            animationSpec = tween(380, easing = FastOutSlowInEasing)
        ) {
            -420
        } + fadeOut(tween(380), targetAlpha = 0.2f)
    )

    fun backward(targetContentZIndex: Float): ContentTransform {
        return ContentTransform(
            targetContentEnter = slideInHorizontally(
                animationSpec = tween(380, easing = FastOutSlowInEasing)
            ) {
                -420
            } + fadeIn(tween(380), initialAlpha = 0.2f),
            initialContentExit = slideOutHorizontally(
                animationSpec = tween(380, easing = FastOutSlowInEasing)
            ) {
                it
            },
            targetContentZIndex = -targetContentZIndex
        )
    }
}