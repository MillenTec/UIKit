package com.millentec.compose.uikit

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.flyout.UIKitFlyouter
import com.millentec.compose.uikit.foundation.graphics.AcrylicMaterialState
import com.millentec.compose.uikit.foundation.graphics.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.graphics.rememberAcrylicMaterialState
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.i18n.SupportedLanguages
import com.millentec.compose.uikit.i18n.strings.Japanese
import com.millentec.compose.uikit.i18n.strings.SimplifiedChinese
import com.millentec.compose.uikit.i18n.strings.TraditionalChinese
import com.millentec.compose.uikit.i18n.strings.UnitedStatesEnglish
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.views.MainView

val LocalAcrylicMaterialState = compositionLocalOf<AcrylicMaterialState> { error("not provided") }

@Composable
@Preview
fun App() {
    UIKitThemeHost(
        when(AppTheme.theme.collectAsState().value) {
            ThemeType.System -> if (isSystemInDarkTheme()) UIKitTheme.getDark() else UIKitTheme.getLight()
            ThemeType.Light -> UIKitTheme.getLight()
            ThemeType.Dark -> UIKitTheme.getDark()
        }
    ) {
        CompositionLocalProvider(LocalAcrylicMaterialState provides rememberAcrylicMaterialState()) {
            CompositionLocalProvider(LocalStrings provides when(AppSettings.languages.collectAsState().value) {
                SupportedLanguages.EnUS -> UnitedStatesEnglish()
                SupportedLanguages.ZhCN -> SimplifiedChinese()
                SupportedLanguages.ZhTW -> TraditionalChinese()
                SupportedLanguages.JaJP -> Japanese()
            }) {
                UIKitFlyouter {
                    val uikitTheme = getUIKitTheme()
                    val statusBarHeight = WindowInsets.statusBars.getTop(LocalDensity.current)

                    IsStatusBarDarkMode(getUIKitColors().contentFillColorPrimaryBrush.toHsv().value <= 0.5f)

                    Box(
                        modifier = Modifier
                            .acrylicMaterialSource(LocalAcrylicMaterialState.current)
                            .drawWithContent {
                                drawContent()
                                drawRect(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            uikitTheme.colors.contentFillColorPrimaryBrush.copy(0.8f),
                                            uikitTheme.colors.contentFillColorSecondaryBrush.copy(0f),
                                        ),
                                        startY = 0f,
                                        endY = statusBarHeight.toFloat()
                                    ),
                                    size = Size(
                                        width = size.width,
                                        height = statusBarHeight.toFloat()
                                    )
                                )
                            }
                    ) {
                        MainView()
                    }
                }
            }
        }
    }
}