package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.millentec.compose.uikit.LocalAcrylicMaterialState
import com.millentec.compose.uikit.component.flyout.UIKitFlyouter
import com.millentec.compose.uikit.component.input.UIKitDropdownButton
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
private fun Preview() {
    UIKitFlyouter {
        Settings()
    }
}

@Composable
fun Settings() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush),
        contentPadding = PaddingValues(
            start = getUIKitLayout().x4Spacing,
            top = getUIKitLayout().x4Spacing,
            end = getUIKitLayout().x4Spacing,
            bottom = getUIKitLayout().x6Spacing
        ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
    ) {
        val nav = MainViewModel.navigation

        item {
            Text(
                text = "Settings",
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().x2Spacing))
        }

        item {
            val expanded = remember { mutableStateOf(false) }

            UIKitSettingCard(
                onClick = {
                    expanded.value = !expanded.value
                },
                title = "Theme",
                icon = FluentIcons.Color,
            ) {
                UIKitDropdownButton(
                    onDismissRequest = {
                        expanded.value = false
                    },
                    acrylicMaterialState = LocalAcrylicMaterialState.current,
                    acrylicEffectEnabled = AppTheme.useAcrylic.collectAsState().value,
                    offset = DpOffset(
                        x = getUIKitLayout().mediumSpacing,
                        y = getUIKitLayout().basicSpacing
                    ),
                    expanded = expanded.value,
                    items = listOf(
                        UIKitMenuItem.textWithIcon(
                            text = "System",
                            icon = FluentIcons.Person,
                            onClick = {
                                AppTheme.switchTheme(ThemeType.System)
                                expanded.value = false
                            }
                        ),
                        UIKitMenuItem.divider(),
                        UIKitMenuItem.textWithIcon(
                            text = "Light",
                            icon = FluentIcons.weatherSunny(),
                            onClick = {
                                AppTheme.switchTheme(ThemeType.Light)
                                expanded.value = false
                            }
                        ),
                        UIKitMenuItem.divider(),
                        UIKitMenuItem.textWithIcon(
                            text = "Dark",
                            icon = FluentIcons.Moon,
                            onClick = {
                                AppTheme.switchTheme(ThemeType.Dark)
                                expanded.value = false
                            }
                        )
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = AppTheme.theme.collectAsState().value.name,
                            style = getUIKitTypography().footnote,
                            color = getUIKitColors().textFillColorPrimaryBrush
                        )

                        Spacer(Modifier.width(getUIKitLayout().smallSpacing))

                        Icon(
                            imageVector = FluentIcons.ChevronArrowDown,
                            contentDescription = "Expand Dropdown Menu of Theme",
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                }
            }
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            val acrylicEnabled = AppTheme.useAcrylic.collectAsState()

            UIKitSettingCard(
                title = "Acrylic Effect",
                icon = FluentIcons.Blur,
                onClick = {
                    AppTheme.enableAcrylic(!acrylicEnabled.value)
                }
            ) {
                UIKitToggleSwitch(
                    checked = acrylicEnabled.value,
                    onCheckedChange = {
                        AppTheme.enableAcrylic(it)
                    }
                )
            }
        }

        item {
            Spacer(Modifier.height(
                maxOf(
                    LocalNavigationDockHeight.value + getUIKitLayout().mediumSpacing,
                    getUIKitLayout().x4Spacing
                )
            ))
        }
    }
}