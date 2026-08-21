package com.millentec.compose.uikit.foundation.layout

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTypography

class UIKitNavigationBarScope : UIKitItemScope<UIKitCheckableItem>() {
    @Composable
    fun Text(
        text: String,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked
                    else
                        color,
                    animationSpec = tween(
                        getUIKitAnimate().transformRegularDurationMillis,
                        easing = LinearEasing
                    )
                )

                Text(
                    text = text,
                    style = getUIKitTypography().body,
                    color = colorAnimated,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        })
    }

    @Composable
    fun Icon(
        icon: ImageVector,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        contentDescription: String?,
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked
                    else
                        color,
                    animationSpec = tween(
                        getUIKitAnimate().transformRegularDurationMillis,
                        easing = LinearEasing
                    )
                )

                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    imageVector = icon,
                    contentDescription = contentDescription,
                    tint = colorAnimated
                )
            }
        })
    }

    @Composable
    fun TextWithIcon(
        text: String,
        icon: ImageVector,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        contentDescription: String? = text,
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked
                    else
                        color,
                    animationSpec = tween(
                        getUIKitAnimate().transformRegularDurationMillis,
                        easing = LinearEasing
                    )
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(icon.defaultWidth / icon.defaultHeight),
                        imageVector = icon,
                        contentDescription = contentDescription,
                        tint = colorAnimated,
                    )

                    Text(
                        text = text,
                        style = getUIKitTypography().footnote,
                        color = colorAnimated,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        })
    }

    @Suppress("FunctionName")
    fun Item(
        content: @Composable UIKitCheckableItem.() -> Unit,
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                this.content()
            }
        })
    }
}