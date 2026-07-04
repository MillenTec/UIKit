package com.millentec.compose.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.theme.UIKitColors
import com.millentec.compose.uikit.theme.UIKitTheme

@Composable
@Preview
fun App() {
    UIKitTheme(UIKitTheme(
        colors = UIKitColors.getDark()
    )) {
        val themeCurrent = UIKitTheme.themeCurrent.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(themeCurrent.colors.contentFillColorPrimaryBrush)
        ) {
            Column (
                modifier = Modifier
                    .safeContentPadding()
            ) {
                Text(
                    "Display 显示",
                    style = themeCurrent.typography.display,
                    color = themeCurrent.colors.textFillColorPrimaryBrush
                )
                Text(
                    "Large Title 大标题",
                    style = themeCurrent.typography.largeTitle,
                    color = themeCurrent.colors.textFillColorPrimaryBrush
                )
                Text(
                    "Title 标题",
                    style = themeCurrent.typography.title,
                    color = themeCurrent.colors.textFillColorPrimaryBrush
                )
                Text(
                    "Subtitle 副标题",
                    style = themeCurrent.typography.subtitle,
                    color = themeCurrent.colors.textFillColorPrimaryBrush
                )
                Text(
                    "Body 正文",
                    style = themeCurrent.typography.body,
                    color = themeCurrent.colors.textFillColorPrimaryBrush
                )
                Text(
                    "Footnote 脚注",
                    style = themeCurrent.typography.footnote,
                    color = themeCurrent.colors.textFillColorSubBrush
                )
            }
        }
    }
}