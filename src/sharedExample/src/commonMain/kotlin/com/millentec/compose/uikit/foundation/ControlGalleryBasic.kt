package com.millentec.compose.uikit.foundation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitSlider
import com.millentec.compose.uikit.component.input.UIKitSliderChangeType
import com.millentec.compose.uikit.component.layout.UIKitCodeViewer
import com.millentec.compose.uikit.component.layout.UIKitSettingsExpander
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Code
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.views.pages.StateSelectorItem

open class ControlGalleryBasic(
    title: String,
    parent: Int? = 1
): CommonPage(
    title,
    parent
) {
    private val maxWidth = mutableStateOf(Dp.Unspecified)

    @Composable
    open fun ControlView() {}

    @Composable
    open fun ControlOption() {}

    @Composable
    open fun exampleCode(): String { return "" }

    open fun LazyListScope.description() {}

    final override fun LazyListScope.lazyContent() {
        description()

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            val densityDpi = LocalDensity.current.density
            val height = remember { mutableStateOf(Dp.Unspecified) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(
                        max = if (maxWidth.value >= 768.dp) {
                            512.dp
                        } else Dp.Unspecified
                    )
                    .onSizeChanged {
                        maxWidth.value = (it.width / densityDpi).dp
                    }
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(if (maxWidth.value >= 768.dp)
                            height.value
                        else Dp.Unspecified)
                        .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                        .background(getUIKitColors().contentFillColorSecondaryBrush)
                        .then(if (maxWidth.value >= 768.dp) {
                            Modifier.verticalScroll(rememberScrollState())
                        } else Modifier)
                        .padding(getUIKitLayout().mediumSpacing)
                ) {
                    ControlView()
                }

                if (maxWidth.value >= 768.dp) {
                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Column(
                        Modifier
                            .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                            .width(360.dp)
                            .onSizeChanged {
                                height.value = (it.height / densityDpi).dp
                            }
                            .verticalScroll(rememberScrollState())
                    ) {
                        ControlOption()
                    }
                }
            }
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            val expanded = remember { mutableStateOf(true) }
            UIKitSettingsExpander(
                expanded = expanded.value,
                onClick = {
                    expanded.value = !expanded.value
                },
                title = "Source Code",
                icon = FluentIcons.Code,
                contentPadding = PaddingValues(0.dp),
                headerPadding = PaddingValues(getUIKitLayout().basicSpacing)
            ) {
                UIKitCodeViewer(
                    config = UIKitCodeBlockConfig.kotlin(
                        when (AppTheme.theme.collectAsState().value) {
                            ThemeType.System -> {
                                if (isSystemInDarkTheme()) UIKitCodeBlockColors.IntelliJ
                                else UIKitCodeBlockColors.IntelliJLight
                            }
                            ThemeType.Dark -> UIKitCodeBlockColors.IntelliJ
                            ThemeType.Light -> UIKitCodeBlockColors.IntelliJLight
                        }
                    )
                ) {
                    exampleCode()
                }
            }
        }

        if (maxWidth.value <= 768.dp && maxWidth.value != Dp.Unspecified) {
            item {
                Spacer(Modifier.height(getUIKitLayout().mediumSpacing))
            }

            item {
                ControlOption()
            }
        }
    }

    @Composable
    open fun CommonSlider(
        state: MutableState<Float>,
        iconStart: @Composable BoxScope.() -> Unit = {},
        iconEnd: @Composable BoxScope.() -> Unit = {},
        maxValue: Float = 1f,
    ) {
        val uikitTheme = getUIKitTheme()
        val isAnimatedChange = remember { mutableStateOf(false) }
        val value = remember { mutableStateOf(state.value) }
        val valueAnimated = remember { Animatable(
            initialValue = value.value,
            typeConverter = Float.VectorConverter,
        ) }

        LaunchedEffect(value.value) {
            if (isAnimatedChange.value) {
                valueAnimated.animateTo(
                    targetValue = value.value,
                    animationSpec = tween(
                        uikitTheme.animate.motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            } else {
                valueAnimated.snapTo(value.value)
            }
        }

        LaunchedEffect(valueAnimated.value) {
            state.value = valueAnimated.value
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .height(getUIKitLayout().interactiveHotspot)
                .background(getUIKitColors().contentFillColorSecondaryBrush)
                .padding(getUIKitLayout().basicSpacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp),
                contentAlignment = Alignment.Center,
                content = iconStart
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            UIKitSlider(
                modifier = Modifier
                    .weight(1f),
                value = value.value,
                maxValue = maxValue,
                onValueChange = { v, type ->
                    isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                    value.value = v
                },
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            Box(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp),
                contentAlignment = Alignment.Center,
                content = iconEnd
            )
        }
    }

    @Composable
    open fun StateSelector(
        states: List<StateSelectorItem>,
        state: MutableState<Int>,
        itemWidth: Dp = 148.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            states.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier
                        .padding(
                            top = getUIKitLayout().basicSpacing,
                            bottom = getUIKitLayout().basicSpacing,
                            end = if (index == states.size - 1) 0.dp else getUIKitLayout().basicSpacing,
                        )
                        .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                        .width(itemWidth)
                        .background(getUIKitColors().contentFillColorSecondaryBrush)
                        .uikitClickable(
                            onClick = {
                                state.value = index
                            },
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                        )
                        .padding(getUIKitLayout().mediumSpacing),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentAlignment = Alignment.Center,
                        content = item.statePreview
                    )

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                    Text(
                        text = item.state,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}