package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.input.UIKitButton
import com.millentec.compose.uikit.component.input.UIKitButtonColors
import com.millentec.compose.uikit.component.input.UIKitToggleButton
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography

@Composable
@Preview
fun Controls() {
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
                    background = getUIKitColors().highlightColorLightBrush,
                    content = getUIKitColors().textFillColorPrimaryBrush
                )
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitToggleButton(
                checked = enabled.value,
                onCheckedChange = {
                    enabled.value = it
                },
                text = "Switch"
            )
        }
    }
}