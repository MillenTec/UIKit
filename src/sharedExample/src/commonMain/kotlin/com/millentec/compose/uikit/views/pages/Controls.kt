package com.millentec.compose.uikit.views.pages

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
import com.millentec.compose.uikit.component.input.*
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel

@Composable
@Preview
fun Controls() {

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

            val uikitColors = getUIKitColors()
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

            Spacer(Modifier.height(getUIKitLayout().x4Spacing))
        }
    }
}