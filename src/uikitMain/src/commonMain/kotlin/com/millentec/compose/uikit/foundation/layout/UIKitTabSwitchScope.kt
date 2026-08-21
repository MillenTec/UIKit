package com.millentec.compose.uikit.foundation.layout

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTypography

class UIKitTabSwitchScope: UIKitItemScope<UIKitCheckableItem>() {
    @Composable
    fun Text(
        text: String,
        color: Color? = null,
        colorChecked: Color? = null
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked ?: getUIKitColors().highlightColorPrimaryBrush
                    else
                        color ?: getUIKitColors().textFillColorPrimaryBrush,
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
}