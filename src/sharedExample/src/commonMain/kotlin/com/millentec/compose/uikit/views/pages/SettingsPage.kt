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
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.LocalAcrylicMaterialState
import com.millentec.compose.uikit.component.input.UIKitDropdownButton
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.UIKitGroupedCard
import com.millentec.compose.uikit.foundation.Pages
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.foundation.layout.UIKitCardItem
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.theme.ThemeType.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun SettingsPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush),
        contentPadding = PaddingValues(
            start = getUIKitLayout().screenSideSpacing,
            top = getUIKitLayout().screenSideSpacing,
            end = getUIKitLayout().screenSideSpacing,
            bottom = maxOf(
                LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                getUIKitLayout().screenSideSpacing
            )
        ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
    ) {
        val nav = MainViewModel.navigation

        item {
            Text(
                text = LocalStrings.current.settings.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().titleSpacing))
        }

        item {
            val themeOptionsExpanded = remember { mutableStateOf(false) }
            val acrylicEnabled = AppTheme.useAcrylic.collectAsState()

            UIKitGroupedCard(
                items = listOf(
                    UIKitCardItem.settingCard(
                        onClick = {
                            themeOptionsExpanded.value = !themeOptionsExpanded.value
                        },
                        title = LocalStrings.current.settings.themeSettingTitle,
                        icon = FluentIcons.Color,
                    ) {
                        UIKitDropdownButton(
                            onDismissRequest = {
                                themeOptionsExpanded.value = false
                            },
                            acrylicMaterialState = LocalAcrylicMaterialState.current,
                            acrylicEffectEnabled = AppTheme.useAcrylic.collectAsState().value,
                            offset = DpOffset(
                                x = getUIKitLayout().mediumSpacing,
                                y = 0.dp
                            ),
                            expanded = themeOptionsExpanded.value,
                            items = listOf(
                                UIKitMenuItem.textWithIcon(
                                    text = LocalStrings.current.settings.themeSystem,
                                    icon = FluentIcons.Person,
                                    onClick = {
                                        AppTheme.switchTheme(ThemeType.System)
                                        themeOptionsExpanded.value = false
                                    }
                                ),
                                UIKitMenuItem.divider(),
                                UIKitMenuItem.textWithIcon(
                                    text = LocalStrings.current.settings.themeLight,
                                    icon = FluentIcons.weatherSunny(),
                                    onClick = {
                                        AppTheme.switchTheme(ThemeType.Light)
                                        themeOptionsExpanded.value = false
                                    }
                                ),
                                UIKitMenuItem.divider(),
                                UIKitMenuItem.textWithIcon(
                                    text = LocalStrings.current.settings.themeDark,
                                    icon = FluentIcons.Moon,
                                    onClick = {
                                        AppTheme.switchTheme(ThemeType.Dark)
                                        themeOptionsExpanded.value = false
                                    }
                                )
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = when(AppTheme.theme.collectAsState().value) {
                                        System -> LocalStrings.current.settings.themeSystem
                                        Light -> LocalStrings.current.settings.themeLight
                                        Dark -> LocalStrings.current.settings.themeDark
                                    },
                                    style = getUIKitTypography().footnote,
                                    color = getUIKitColors().textFillColorPrimaryBrush
                                )

                                Spacer(Modifier.width(getUIKitLayout().smallSpacing))

                                Icon(
                                    modifier = Modifier
                                        .size(getUIKitTypography().footnote.lineHeight.value.dp),
                                    imageVector = FluentIcons.ChevronArrowDown,
                                    contentDescription = "Expand Dropdown Menu of Theme",
                                    tint = getUIKitColors().textFillColorPrimaryBrush
                                )
                            }
                        }
                    },
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = LocalStrings.current.settings.acrylicEnabledSettingTitle,
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
                    },
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = LocalStrings.current.settings.languageSettingTitle,
                        icon = FluentIcons.Globe,
                        onClick = {
                            MainViewModel.navigation.switchPage(Pages.Settings_Language, type = UIKitNavigationType.Forward)
                        }
                    )
                )
            )
        }
    }
}