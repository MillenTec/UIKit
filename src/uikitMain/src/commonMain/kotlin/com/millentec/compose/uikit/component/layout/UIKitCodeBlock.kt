package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.UIKitCodeBlockColors
import com.millentec.compose.uikit.foundation.UIKitCodeBlockConfig
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitThemeHost(UIKitTheme.getDark()) {
        UIKitCodeViewer(
            config = UIKitCodeBlockConfig.kotlin(UIKitCodeBlockColors.IntelliJ),
        ) {
            """
        val num = 123f
        println("Hello World!")
        println(num)
        
        @Composable
        fun App() {
            // Some Notes Some Notes Some Notes Some Notes Some Notes Some Notes 
            /* Some Notes */
            /**
             Some Docs
             */
        }
        """.trimIndent()
        }
    }
}

@Composable
fun UIKitCodeBlock(
    modifier: Modifier = Modifier,
    config: UIKitCodeBlockConfig = UIKitCodeBlockConfig.text(),
    style: TextStyle = getUIKitTypography().body,
    fontFamily: FontFamily = FontFamily.Monospace,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    content: @Composable () -> String
) {
    val content = content()

    val annotatedString = buildAnnotatedString {
        append(content)

        config.rules?.let {
            it.forEach { rule ->
                rule.first.findAll(content).forEach { item ->
                    addStyle(
                        style = rule.second,
                        start = item.range.first,
                        end = item.range.last + 1,
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .background(config.colors.primaryBackground)
    ) {
        Text(
            modifier = modifier,
            text = annotatedString,
            style = style,
            fontFamily = fontFamily,
            color = config.colors.primaryText,
            onTextLayout = {
                onTextLayout?.invoke(it)
            }
        )
    }
}

@Composable
fun UIKitCodeViewer(
    modifier: Modifier = Modifier,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    divider: Color? = getUIKitColors().lineFillColorPrimaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    lineNumberEnabled: Boolean = true,
    warpEnabled: Boolean = false,
    config: UIKitCodeBlockConfig = UIKitCodeBlockConfig.text(),
    textStyle: TextStyle = getUIKitTypography().footnote,
    fontFamily: FontFamily = FontFamily.Monospace,
    selectable: Boolean = true,
    content: @Composable () -> String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(background)
    ) {
        Row(
            modifier = Modifier
                .padding(getUIKitLayout().basicSpacing)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = config.name,
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorSecondaryBrush
            )
        }

        divider?.let {
            HorizontalDivider(
                color = divider,
                thickness = 1.dp
            )
        }

        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
        ) {
            val lineHeight = textStyle.lineHeight.value.dp
            val lineCount = remember { mutableStateOf(0) }

            AnimatedVisibility(
                visible = lineNumberEnabled,
                enter = slideInHorizontally(
                    animationSpec = tween(
                        getUIKitAnimate().motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                ) {
                    -it
                },
                exit = slideOutHorizontally(
                    animationSpec = tween(
                        getUIKitAnimate().motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                ) {
                    -it
                }
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(getUIKitLayout().basicSpacing)
                    ) {
                        repeat(lineCount.value) {
                            Box(
                                modifier = Modifier
                                    .height(lineHeight),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = (it + 1).toString(),
                                    style = getUIKitTypography().footnote,
                                    color = getUIKitColors().textFillColorSecondaryBrush
                                )
                            }
                        }
                    }

                    divider?.let {
                        VerticalDivider(
                            color = divider,
                            thickness = 1.dp
                        )
                    }
                }
            }

            if (selectable) {
                SelectionContainer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(config.colors.primaryBackground)
                ) {
                    UIKitCodeBlock(
                        modifier = Modifier
                            .fillMaxWidth()
                            .then(
                                if (!warpEnabled) {
                                    Modifier.horizontalScroll(rememberScrollState())
                                } else Modifier
                            )
                            .padding(PaddingValues(getUIKitLayout().basicSpacing)),
                        config = config,
                        style = textStyle,
                        fontFamily = fontFamily,
                        content = content,
                        onTextLayout = {
                            lineCount.value = it.lineCount
                        }
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(config.colors.primaryBackground)
                ) {
                    UIKitCodeBlock(
                        modifier = Modifier
                            .fillMaxWidth()
                            .then(
                                if (!warpEnabled) {
                                    Modifier.horizontalScroll(rememberScrollState())
                                } else Modifier
                            )
                            .padding(PaddingValues(getUIKitLayout().basicSpacing)),
                        config = config,
                        style = textStyle,
                        fontFamily = fontFamily,
                        content = content,
                        onTextLayout = {
                            lineCount.value = it.lineCount
                        }
                    )
                }
            }
        }
    }
}