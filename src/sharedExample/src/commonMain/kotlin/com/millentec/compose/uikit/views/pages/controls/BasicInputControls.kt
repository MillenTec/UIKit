package com.millentec.compose.uikit.views.pages.controls

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.*
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.component.layout.UIKitSettingsExpander
import com.millentec.compose.uikit.foundation.ControlGalleryBasic
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.theme.UIKitColors
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography

val BasicInputControls = listOf(
    object: ControlGalleryBasic("Button") {
        private val buttonSize = mutableStateOf(IntSize.Zero)
        private val buttonEnabled = mutableStateOf(true)
        private val buttonBackground = mutableStateOf<Color?>(null)
        private val buttonForeground = mutableStateOf<Color?>(null)
        private val buttonCornerRadius = mutableStateOf(1f)

        override fun LazyListScope.description() {
            item {
                Text(
                    text = "按钮是一个基础的可点击控件，提供了 onClick 回调，在被点击时触发",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )
            }
        }

        @Composable
        override fun ControlView() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "A simple Button with text content.",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val uikitColors = getUIKitColors()
                    val count = remember { mutableStateOf(0) }

                    LaunchedEffect(buttonBackground.value) {
                        val hsv = buttonBackground.value?.toHsv() ?: return@LaunchedEffect
                        if (hsv.value >= 0.7f) {
                            if (hsv.alpha < 0.5f)
                                buttonForeground.value = uikitColors.textFillColorPrimaryBrush
                            else
                                buttonForeground.value = UIKitColors.Black
                        } else {
                            if (hsv.alpha < 0.5f)
                                buttonForeground.value = uikitColors.textFillColorPrimaryBrush
                            else
                                buttonForeground.value = UIKitColors.White
                        }
                    }

                    UIKitButton(
                        modifier = Modifier
                            .onSizeChanged {
                                buttonSize.value = it
                            },
                        text = "Button",
                        shape = RoundedCornerShape(
                            (buttonSize.value.height / LocalDensity.current.density / 2).dp * buttonCornerRadius.value
                        ),
                        enabled = buttonEnabled.value,
                        colors = UIKitButtonColors.default(
                            background = buttonBackground.value ?: getUIKitColors().contentFillColorTertiaryBrush,
                            content = buttonForeground.value ?: getUIKitColors().textFillColorPrimaryBrush
                        ),
                        onClick = {
                            count.value++
                        }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = "You clicked ${count.value} times.",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                Text(
                    text = "A Button with text and icon content.",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val count = remember { mutableStateOf(0) }
                    val buttonSize = remember { mutableStateOf(IntSize.Zero) }

                    UIKitButton(
                        modifier = Modifier
                            .onSizeChanged {
                                buttonSize.value = it
                            },
                        text = "Add",
                        shape = RoundedCornerShape(
                            (buttonSize.value.height / LocalDensity.current.density / 2).dp * buttonCornerRadius.value
                        ),
                        enabled = buttonEnabled.value,
                        colors = UIKitButtonColors.default(
                            background = buttonBackground.value ?: getUIKitColors().contentFillColorTertiaryBrush,
                            content = buttonForeground.value ?: getUIKitColors().textFillColorPrimaryBrush
                        ),
                        icon = FluentIcons.Add,
                        onClick = {
                            count.value++
                        }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = "You clicked ${count.value} times.",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            }
        }

        @Composable
        override fun ControlOption() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                UIKitSettingCard(
                    title = "Enabled",
                    icon = FluentIcons.checkmarkCircle(getUIKitColors().textFillColorPrimaryBrush, true),
                    onClick = {
                        buttonEnabled.value = !buttonEnabled.value
                    }
                ) {
                    UIKitToggleSwitch(
                        checked = buttonEnabled.value,
                        onCheckedChange = {
                            buttonEnabled.value = it
                        }
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                CommonSlider(
                    state = buttonCornerRadius,
                    iconStart = {
                        Icon(
                            modifier = Modifier.size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = FluentIcons.Square,
                            contentDescription = "Rectangle",
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    },
                    iconEnd = {
                        Icon(
                            modifier = Modifier.size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = FluentIcons.Circle,
                            contentDescription = "Rounded",
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                val backgroundPickerExpanded = remember { mutableStateOf(false) }
                UIKitSettingsExpander(
                    expanded = backgroundPickerExpanded.value,
                    onClick = {
                        backgroundPickerExpanded.value = !backgroundPickerExpanded.value
                    },
                    title = "Color",
                    icon = FluentIcons.Color
                ) {
                    val uikitColors = getUIKitColors()
                    val color = remember { mutableStateOf((buttonBackground.value ?: uikitColors.contentFillColorTertiaryBrush).toHsv()) }
                    LaunchedEffect(color.value) {
                        buttonBackground.value = color.value.getColor()
                    }

                    UIKitHSVColorPicker(
                        color = color.value,
                        onColorChange = {
                            color.value = it
                        }
                    )
                }
            }
        }

        @Composable
        override fun exampleCode(): String {
            return """
                UIKitButton(
                    text = "Add",
                    icon = FluentIcons.Add,
                    enabled = ${buttonEnabled.value},
                    shape = RoundedCornerShape(${buttonCornerRadius.value * buttonSize.value.height / LocalDensity.current.density / 2}.dp),
                    colors = UIKitButtonColors.default(
                        background = Color(0x${(buttonBackground.value ?: getUIKitColors().contentFillColorTertiaryBrush).toArgb().toHexString(HexFormat.UpperCase)}),
                        content = Color(0x${(buttonForeground.value ?: getUIKitColors().textFillColorPrimaryBrush).toArgb().toHexString(HexFormat.UpperCase)})
                    ),
                    onClick = {
                        count.value++
                    }
                )
            """.trimIndent()
        }
    },
    object: ControlGalleryBasic("Toggle Button") {
        private val buttonSize = mutableStateOf(IntSize.Zero)
        private val buttonEnabled = mutableStateOf(true)
        private val buttonBackground = mutableStateOf<Color?>(null)
        private val buttonForeground = mutableStateOf<Color?>(null)
        private val buttonCornerRadius = mutableStateOf(1f)

        override fun LazyListScope.description() {
            item {
                Text(
                    text = "开关拥有两种状态并可保持，提供的 onCheckedChange 回调在状态更新时调用",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )
            }
        }

        @Composable
        override fun ControlView() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "A simple Toggle Button with text content.",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val uikitColors = getUIKitColors()
                    val checked = remember { mutableStateOf(false) }

                    LaunchedEffect(buttonBackground.value) {
                        val hsv = buttonBackground.value?.toHsv() ?: return@LaunchedEffect
                        if (hsv.value >= 0.8f) {
                            if (hsv.alpha < 0.5f)
                                buttonForeground.value = uikitColors.textFillColorPrimaryBrush
                            else
                                buttonForeground.value = UIKitColors.Black
                        } else {
                            if (hsv.alpha < 0.5f)
                                buttonForeground.value = uikitColors.textFillColorPrimaryBrush
                            else
                                buttonForeground.value = UIKitColors.White
                        }
                    }

                    UIKitToggleButton(
                        modifier = Modifier
                            .onSizeChanged {
                                buttonSize.value = it
                            },
                        checked = checked.value,
                        text = "Button",
                        shape = RoundedCornerShape(
                            (buttonSize.value.height / LocalDensity.current.density / 2).dp * buttonCornerRadius.value
                        ),
                        enabled = buttonEnabled.value,
                        colors = UIKitToggleButtonColors.default(
                            backgroundChecked = buttonBackground.value ?: getUIKitColors().highlightColorPrimaryBrush,
                            contentChecked = buttonForeground.value ?: UIKitColors.White
                        ),
                        onCheckedChange = {
                            checked.value = it
                        }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = if (checked.value) "Checked" else "Unchecked",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                Text(
                    text = "A Button with text and icon content.",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val checked = remember { mutableStateOf(false) }
                    val buttonSize = remember { mutableStateOf(IntSize.Zero) }

                    UIKitToggleButton(
                        modifier = Modifier
                            .onSizeChanged {
                                buttonSize.value = it
                            },
                        text = "Add",
                        checked = checked.value,
                        shape = RoundedCornerShape(
                            (buttonSize.value.height / LocalDensity.current.density / 2).dp * buttonCornerRadius.value
                        ),
                        enabled = buttonEnabled.value,
                        colors = UIKitToggleButtonColors.default(
                            backgroundChecked = buttonBackground.value ?: getUIKitColors().highlightColorPrimaryBrush,
                            contentChecked = buttonForeground.value ?: UIKitColors.White
                        ),
                        icon = FluentIcons.Add,
                        onCheckedChange = {
                            checked.value = it
                        }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = if (checked.value) "Checked" else "Unchecked",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            }
        }

        @Composable
        override fun exampleCode(): String {
            return """
                val checked = remember { mutableStateOf(false) }
                UIKitToggleButton(
                    enabled = buttonEnabled.value,
                    checked = checked.value,
                    text = "Button",
                    shape = RoundedCornerShape(${buttonCornerRadius.value * buttonSize.value.height / LocalDensity.current.density / 2}.dp),
                    colors = UIKitToggleButtonColors.default(
                        backgroundChecked = Color(0x${(buttonBackground.value ?: getUIKitColors().contentFillColorTertiaryBrush).toArgb().toHexString(HexFormat.UpperCase)}),
                        contentChecked = Color(0x${(buttonForeground.value ?: getUIKitColors().textFillColorPrimaryBrush).toArgb().toHexString(HexFormat.UpperCase)})
                    ),
                    onCheckedChange = {
                        checked.value = it
                    }
                )
            """.trimIndent()
        }

        @Composable
        override fun ControlOption() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                UIKitSettingCard(
                    title = "Enabled",
                    icon = FluentIcons.checkmarkCircle(getUIKitColors().textFillColorPrimaryBrush, true),
                    onClick = {
                        buttonEnabled.value = !buttonEnabled.value
                    }
                ) {
                    UIKitToggleSwitch(
                        checked = buttonEnabled.value,
                        onCheckedChange = {
                            buttonEnabled.value = it
                        }
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                CommonSlider(
                    state = buttonCornerRadius,
                    iconStart = {
                        Icon(
                            modifier = Modifier.size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = FluentIcons.Square,
                            contentDescription = "Rectangle",
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    },
                    iconEnd = {
                        Icon(
                            modifier = Modifier.size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = FluentIcons.Circle,
                            contentDescription = "Rounded",
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                val backgroundPickerExpanded = remember { mutableStateOf(false) }
                UIKitSettingsExpander(
                    expanded = backgroundPickerExpanded.value,
                    onClick = {
                        backgroundPickerExpanded.value = !backgroundPickerExpanded.value
                    },
                    title = "Color (Checked)",
                    icon = FluentIcons.Color
                ) {
                    val uikitColors = getUIKitColors()
                    val color = remember { mutableStateOf((buttonBackground.value ?: uikitColors.highlightColorPrimaryBrush).toHsv()) }
                    LaunchedEffect(color.value) {
                        buttonBackground.value = color.value.getColor()
                    }

                    UIKitHSVColorPicker(
                        color = color.value,
                        onColorChange = {
                            color.value = it
                        }
                    )
                }
            }
        }
    },
    object: ControlGalleryBasic("Toggle Switch") {
        private val buttonEnabled = mutableStateOf(true)
        private val buttonBackground = mutableStateOf<Color?>(null)

        @Composable
        override fun ControlView() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "A simple Toggle Switch",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val checked = remember { mutableStateOf(false) }

                    UIKitToggleSwitch(
                        checked = checked.value,
                        enabled = buttonEnabled.value,
                        colors = UIKitToggleSwitchColors.default(
                            backgroundChecked = buttonBackground.value ?: getUIKitColors().highlightColorPrimaryBrush,
                            borderChecked = buttonBackground.value ?: getUIKitColors().highlightColorPrimaryBrush
                        ),
                        onCheckedChange = {
                            checked.value = it
                        }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = if (checked.value) "Checked" else "Unchecked",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            }
        }

        @Composable
        override fun exampleCode(): String {
            return """
                val checked = remember { mutableStateOf(false) }
                UIKitToggleSwitch(
                    enabled = buttonEnabled.value,
                    checked = checked.value,
                    colors = UIKitToggleSwitchColors.default(
                        backgroundChecked = Color(0x${(buttonBackground.value ?: getUIKitColors().contentFillColorTertiaryBrush).toArgb().toHexString(HexFormat.UpperCase)}),
                        borderChecked = Color(0x${(buttonBackground.value ?: getUIKitColors().contentFillColorTertiaryBrush).toArgb().toHexString(HexFormat.UpperCase)})
                    ),
                    onCheckedChange = {
                        checked.value = it
                    }
                )
            """.trimIndent()
        }

        @Composable
        override fun ControlOption() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                UIKitSettingCard(
                    title = "Enabled",
                    icon = FluentIcons.checkmarkCircle(getUIKitColors().textFillColorPrimaryBrush, true),
                    onClick = {
                        buttonEnabled.value = !buttonEnabled.value
                    }
                ) {
                    UIKitToggleSwitch(
                        checked = buttonEnabled.value,
                        onCheckedChange = {
                            buttonEnabled.value = it
                        }
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                val backgroundPickerExpanded = remember { mutableStateOf(false) }
                UIKitSettingsExpander(
                    expanded = backgroundPickerExpanded.value,
                    onClick = {
                        backgroundPickerExpanded.value = !backgroundPickerExpanded.value
                    },
                    title = "Color (Checked)",
                    icon = FluentIcons.Color
                ) {
                    val uikitColors = getUIKitColors()
                    val color = remember { mutableStateOf((buttonBackground.value ?: uikitColors.contentFillColorTertiaryBrush).toHsv()) }
                    LaunchedEffect(color.value) {
                        buttonBackground.value = color.value.getColor()
                    }

                    UIKitHSVColorPicker(
                        color = color.value,
                        onColorChange = {
                            color.value = it
                        }
                    )
                }
            }
        }
    }
)

@Composable
@Preview
private fun Preview() {
    BasicInputControls[2].Content()
}