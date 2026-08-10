package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import com.millentec.compose.uikit.LocalAcrylicMaterialState
import com.millentec.compose.uikit.component.input.UIKitDropdownButton
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.foundation.CommonPage
import com.millentec.compose.uikit.foundation.Pages
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20.*
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.theme.ThemeType.*
import com.millentec.compose.uikit.viewmodels.MainViewModel

class Settings: CommonPage("settings") {
    override fun LazyListScope.lazyContent() {
        item {
            val expanded = remember { mutableStateOf(false) }

            UIKitSettingCard(
                onClick = {
                    expanded.value = !expanded.value
                },
                title = LocalStrings.current.settings.themeSettingTitle,
                icon = UIKitSymbols.Color,
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
                            text = LocalStrings.current.settings.themeSystem,
                            icon = UIKitSymbols.Person,
                            onClick = {
                                AppTheme.switchTheme(ThemeType.System)
                                expanded.value = false
                            }
                        ),
                        UIKitMenuItem.divider(),
                        UIKitMenuItem.textWithIcon(
                            text = LocalStrings.current.settings.themeLight,
                            icon = UIKitSymbols.weatherSunny(),
                            onClick = {
                                AppTheme.switchTheme(ThemeType.Light)
                                expanded.value = false
                            }
                        ),
                        UIKitMenuItem.divider(),
                        UIKitMenuItem.textWithIcon(
                            text = LocalStrings.current.settings.themeDark,
                            icon = UIKitSymbols.Moon,
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
                            imageVector = UIKitSymbols.ChevronArrowDown,
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
                title = LocalStrings.current.settings.acrylicEnabledSettingTitle,
                icon = UIKitSymbols.Blur,
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
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = LocalStrings.current.settings.languageSettingTitle,
                icon = UIKitSymbols.Globe,
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.SettingsLanguage.ordinal, type = UIKitNavigationType.Forward)
                }
            )
        }
    }
}