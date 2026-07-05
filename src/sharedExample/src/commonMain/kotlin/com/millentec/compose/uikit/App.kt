package com.millentec.compose.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.component.layout.ScreenSideAdaptiveContainer
import com.millentec.compose.uikit.component.layout.rememberScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.theme.UIKitColors
import com.millentec.compose.uikit.theme.UIKitTheme
import com.millentec.compose.uikit.theme.getUIKitLayout

@Composable
@Preview
fun App() {
    UIKitTheme(UIKitTheme(
        colors = UIKitColors.getDark()
    )) {
        val themeCurrent = UIKitTheme.themeCurrent.current
        val state = rememberScreenSideAdaptiveContainerState(
            expectHeight = 50.dp,
            expectWidth = 50.dp,
            position = LayoutPosition.BottomLeft,
            fillWidth = true,
            fillHeight = false,
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(themeCurrent.colors.contentFillColorPrimaryBrush)
        ) {
            Column (
                modifier = Modifier
                    .safeContentPadding()
                    .verticalScroll(rememberScrollState())
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
                Text(
                    (getScreenCornerRadius()/ LocalDensity.current.density).dp.toString(),
                    style = themeCurrent.typography.footnote,
                    color = themeCurrent.colors.textFillColorSubBrush
                )
                Text(
                    (WindowInsets.statusBars.getTop(LocalDensity.current)/LocalDensity.current.density).dp.toString(),
                    style = themeCurrent.typography.footnote,
                    color = themeCurrent.colors.textFillColorSubBrush
                )
                Text(
                    state.toString(),
                    style = themeCurrent.typography.body,
                    color = themeCurrent.colors.textFillColorSubBrush
                )
                Spacer(Modifier.height(120.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Bottom
            ) {
                ScreenSideAdaptiveContainer(
                    modifier = Modifier
                        .weight(1f),
                    state = state
                ){

                }

                Spacer(Modifier.width(getUIKitLayout().mediumSpacing))

                ScreenSideAdaptiveContainer(
                    modifier = Modifier
                        .scale(1f),
                    state = rememberScreenSideAdaptiveContainerState(
                        expectHeight = 50.dp,
                        expectWidth = 50.dp,
                        position = LayoutPosition.BottomRight,
                        fillWidth = false,
                        fillHeight = false,
                    )
                ) {

                }
            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .fillMaxSize(),
                state = rememberScreenSideAdaptiveContainerState(
                    expectHeight = 50.dp,
                    expectWidth = 50.dp,
                    position = LayoutPosition.Center,
                    fillWidth = false,
                    fillHeight = false,
                )
            ) {

            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .fillMaxSize(),
                state = rememberScreenSideAdaptiveContainerState(
                    expectHeight = 50.dp,
                    expectWidth = 120.dp,
                    position = LayoutPosition.TopLeft,
                    fillWidth = false,
                    fillHeight = false,
                )
            ) {

            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .fillMaxSize(),
                state = rememberScreenSideAdaptiveContainerState(
                    expectHeight = 50.dp,
                    expectWidth = 120.dp,
                    position = LayoutPosition.Top,
                    fillWidth = false,
                    fillHeight = false,
                )
            ) {

            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .fillMaxSize(),
                state = rememberScreenSideAdaptiveContainerState(
                    expectHeight = 50.dp,
                    expectWidth = 50.dp,
                    position = LayoutPosition.TopRight,
                    fillWidth = false,
                    fillHeight = false,
                )
            ) {

            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .fillMaxSize(),
                state = rememberScreenSideAdaptiveContainerState(
                    expectHeight = 50.dp,
                    expectWidth = 50.dp,
                    position = LayoutPosition.Left,
                    fillWidth = false,
                    fillHeight = true,
                )
            ) {

            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .fillMaxSize(),
                state = rememberScreenSideAdaptiveContainerState(
                    expectHeight = 120.dp,
                    expectWidth = 50.dp,
                    position = LayoutPosition.Right,
                    fillWidth = false,
                    fillHeight = false,
                )
            ) {

            }
        }
    }
}