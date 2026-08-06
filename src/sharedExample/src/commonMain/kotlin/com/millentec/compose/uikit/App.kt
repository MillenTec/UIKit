package com.millentec.compose.uikit

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
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.component.flyout.UIKitFlyouter
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.foundation.materials.AcrylicMaterialsState
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.theme.AppTheme
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTheme
import com.millentec.compose.uikit.views.MainView

val LocalAcrylicMaterialsState = compositionLocalOf<AcrylicMaterialsState> { error("not provided") }

@Composable
@Preview
fun App() {
    UIKitTheme(AppTheme.theme.collectAsState().value) {
        UIKitFlyouter {
            CompositionLocalProvider(LocalAcrylicMaterialsState provides rememberAcrylicMaterialsState()) {
                val uikitTheme = getUIKitTheme()
                val statusBarHeight = WindowInsets.statusBars.getTop(LocalDensity.current)

                IsStatusBarDarkMode(getUIKitColors().contentFillColorPrimaryBrush.toHsv().value <= 0.5f)

                Box(
                    modifier = Modifier
                        .acrylicMaterialSource(LocalAcrylicMaterialsState.current)
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