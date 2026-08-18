package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.input.UIKitRadioButton
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.i18n.SupportedLanguages
import com.millentec.compose.uikit.i18n.SupportedLanguages.*
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun LanguagesPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush),
        contentPadding = PaddingValues(
            start = getUIKitLayout().x4Spacing,
            top = getUIKitLayout().x4Spacing,
            end = getUIKitLayout().x4Spacing,
        ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
    ) {
        val nav = MainViewModel.navigation

        item {
            Text(
                text = LocalStrings.current.settings.language.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().x2Spacing))
        }

        item {
            Text(
                text = LocalStrings.current.settings.language.description,
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        items(SupportedLanguages.entries.size) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                    .uikitClickable(
                        onClick = {
                            AppSettings.switchLanguage(SupportedLanguages.entries[it])
                        },
                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                    )
                    .padding(getUIKitLayout().mediumSpacing),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                UIKitRadioButton(
                    selected = AppSettings.languages.collectAsState().value == SupportedLanguages.entries[it],
                    onClick = {
                        AppSettings.switchLanguage(SupportedLanguages.entries[it])
                    }
                )

                Spacer(Modifier.width(getUIKitLayout().mediumSpacing))

                Column {
                    Text(
                        text = SupportedLanguages.entries[it].displayName,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )

                    Text(
                        text = when (entries[it]) {
                            EnUS -> LocalStrings.current.settings.language.enUS
                            ZhCN -> LocalStrings.current.settings.language.zhCN
                            ZhTW -> LocalStrings.current.settings.language.zhTW
                            JaJP -> LocalStrings.current.settings.language.jaJP
                        },
                        style = getUIKitTypography().footnote,
                        color = getUIKitColors().textFillColorSecondaryBrush
                    )
                }
            }
        }

        item {
            Spacer(
                Modifier.height(
                    maxOf(
                        LocalNavigationDockHeight.value + getUIKitLayout().mediumSpacing,
                        getUIKitLayout().x4Spacing
                    )
                )
            )
        }
    }
}