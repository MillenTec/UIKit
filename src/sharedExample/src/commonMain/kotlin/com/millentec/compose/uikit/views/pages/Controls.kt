package com.millentec.compose.uikit.views.pages

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.info.UIKitInfoCard
import com.millentec.compose.uikit.component.info.UIKitInfoCardType
import com.millentec.compose.uikit.component.info.UIKitInfoCardType.*
import com.millentec.compose.uikit.component.input.*
import com.millentec.compose.uikit.component.input.UIKitSliderChangeType.*
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.animatable.Download
import com.millentec.compose.uikit.icons.fluenticons.animatable.UIKitDownloadState
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel

@Composable
@Preview
fun Controls() {
    val uikitAnimate = getUIKitAnimate()

    LaunchedEffect(Unit) {
        MainViewModel.navigationDockVisible(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(getUIKitLayout().x4Spacing, getUIKitLayout().x6Spacing)
        ) {
            Text(
                text = "Controls Gallery",
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )

            val enabled = remember { mutableStateOf(true) }

            UIKitButton(
                enabled = enabled.value,
                text = "Button",
                onClick = {}
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                enabled = enabled.value,
                text = "Button",
                onClick = {},
                colors = UIKitButtonColors.default().copy(
                    background = getUIKitColors().contentFillColorPrimaryBrush.copy(0f),
                    content = getUIKitColors().highlightColorPrimaryBrush,
                    border = getUIKitColors().highlightColorPrimaryBrush
                ),
                hasBorder = true
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                enabled = enabled.value,
                icon = FluentIcons.designIdeas(Color(0xFFFFFFFF), true),
                onClick = {},
                colors = UIKitButtonColors.default().copy(
                    background = getUIKitColors().highlightColorPrimaryBrush,
                    content = Color(0xFFFFFFFF)
                )
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                enabled = enabled.value,
                icon = FluentIcons.toggleMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                text = "Button",
                onClick = {},
                colors = UIKitButtonColors.default().copy(
                    background = getUIKitColors().highlightColorFourthBrush,
                    content = getUIKitColors().textFillColorPrimaryBrush
                )
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val value = remember { mutableStateOf(20f) }
            UIKitSlider(
                value = value.value,
                onValueChange = {
                    value.value = it
                },
                enabled = enabled.value,
                maxValue = 100f,
                tickStep = 10f,
                adsorbedOntoTick = true
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            Text(
                text = value.value.toString(),
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush,
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val value1 = remember { mutableStateOf(10f) }
            UIKitSlider(
                value = value1.value,
                onValueChange = {
                    value1.value = it
                },
                enabled = enabled.value,
                maxValue = 100f,
                hasTick = false,
                adsorbedOntoTick = false
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            Text(
                text = value1.value.toString(),
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush,
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val color = remember { mutableStateOf(Color.White.toHsv()) }
            UIKitHSVColorPicker(
                modifier = Modifier
                    .sizeIn(maxWidth = 500.dp),
                enabled = enabled.value,
                onColorChange = {
                    color.value = it
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(getUIKitShapes().basicRounded))
                        .size(80.dp, 35.dp)
                        .background(color.value.getColor())
                )

                Spacer(Modifier.width(getUIKitLayout().smallSpacing))

                Text(
                    text = color.value.getColor().value.toString(16),
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush,
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val selected = remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                UIKitRadioButton(
                    selected = selected.value,
                    onClick = { selected.value = !selected.value },
                    enabled = enabled.value,
                )

                Spacer(Modifier.width(getUIKitLayout().smallSpacing))

                Text(
                    text = selected.value.toString(),
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush,
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                UIKitRadioButton(
                    selected = !selected.value,
                    onClick = { selected.value = !selected.value },
                    enabled = enabled.value,
                )

                Spacer(Modifier.width(getUIKitLayout().smallSpacing))

                Text(
                    text = selected.value.toString(),
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush,
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitToggleSwitch(
                size = DpSize(64.dp, 32.dp),
                checked = enabled.value,
                onCheckedChange = {
                    enabled.value = it
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                clickable = true,
                type = Info,
                title = "Info",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                clickable = true,
                type = HighlightInfo,
                title = "Highlight Info",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                clickable = true,
                type = Success,
                title = "Success",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                clickable = true,
                type = Warning,
                title = "Warning",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                clickable = true,
                type = UIKitInfoCardType.Error,
                title = "Error",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val downloadIconValue = remember { mutableStateOf(0f) }
            val isAnimatedChange = remember { mutableStateOf(false) }
            val downloadIconValueAnimated = remember { Animatable(
                initialValue = downloadIconValue.value,
                typeConverter = Float.VectorConverter
            ) }

            LaunchedEffect(downloadIconValue.value) {
                if (isAnimatedChange.value) {
                    downloadIconValueAnimated.animateTo(
                        targetValue = downloadIconValue.value,
                        animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                    )
                    isAnimatedChange.value = false
                } else {
                    downloadIconValueAnimated.snapTo(downloadIconValue.value)
                }
            }

            val downloadIconState = remember { mutableStateOf(UIKitDownloadState.Downloading) }

            FluentIcons.Animatable.Download(
                progress = downloadIconValueAnimated.value,
                modifier = Modifier.size(100.dp),
                state = downloadIconState.value
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitSlider(
                value = downloadIconValue.value,
                onValueChange = { value, type ->
                    when(type) {
                        TrackTap -> {
                            isAnimatedChange.value = true
                        }
                        ThumbDrag -> {
                            isAnimatedChange.value = false
                        }
                        DragAdsorption -> {
                            isAnimatedChange.value = true
                        }
                        Jump -> {
                            isAnimatedChange.value = true
                        }
                    }
                    downloadIconValue.value = value
                },
                maxValue = 1f,
                hasTick = false
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                text = "Download",
                onClick = {
                    downloadIconState.value = UIKitDownloadState.Downloading
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                text = "Stop",
                onClick = {
                    downloadIconState.value = UIKitDownloadState.Stopped
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                text = "Error",
                onClick = {
                    downloadIconState.value = UIKitDownloadState.Error
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                text = "Success",
                onClick = {
                    downloadIconState.value = UIKitDownloadState.Success
                }
            )

            Spacer(Modifier.height(getUIKitLayout().x4Spacing))
        }
    }
}