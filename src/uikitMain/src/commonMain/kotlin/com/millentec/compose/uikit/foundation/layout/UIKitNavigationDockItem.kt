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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTypography

open class UIKitNavigationDockItem: UIKitItem() {
    val isChecked = mutableStateOf(false)

    companion object {
        fun createByString(
            text: String,
            color: Color? = null,
            colorChecked: Color? = null
        ): UIKitNavigationDockItem {
            return object: UIKitNavigationDockItem() {
                @Composable
                override fun Content() {
                    val colorAnimated by animateColorAsState(
                        targetValue = if (this.isChecked.value)
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
            }
        }

        fun createByIcon(
            icon: ImageVector,
            color: Color? = null,
            colorChecked: Color? = null,
            description: String? = null,
        ): UIKitNavigationDockItem {
            return object: UIKitNavigationDockItem() {
                @Composable
                override fun Content() {
                    val colorAnimated by animateColorAsState(
                        targetValue = if (this.isChecked.value)
                            colorChecked ?: getUIKitColors().highlightColorPrimaryBrush
                        else
                            color ?: getUIKitColors().textFillColorPrimaryBrush,
                        animationSpec = tween(
                            getUIKitAnimate().transformRegularDurationMillis,
                            easing = LinearEasing
                        )
                    )

                    Icon(
                        modifier = Modifier
                            .fillMaxSize(),
                        imageVector = icon,
                        contentDescription = description,
                        tint = colorAnimated
                    )
                }
            }
        }

        fun createByStringWithIcon(
            text: String,
            icon: ImageVector,
            color: Color? = null,
            colorChecked: Color? = null,
            description: String? = null,
        ): UIKitNavigationDockItem {
            return object: UIKitNavigationDockItem() {
                @Composable
                override fun Content() {
                    val colorAnimated by animateColorAsState(
                        targetValue = if (this.isChecked.value)
                            colorChecked ?: getUIKitColors().highlightColorPrimaryBrush
                        else
                            color ?: getUIKitColors().textFillColorPrimaryBrush,
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
                            contentDescription = description,
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
            }
        }
    }
}