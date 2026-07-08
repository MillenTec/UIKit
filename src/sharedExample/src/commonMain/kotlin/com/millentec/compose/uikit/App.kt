package com.millentec.compose.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.component.input.UIKitNavigationDock
import com.millentec.compose.uikit.component.input.UIKitNavigationItem
import com.millentec.compose.uikit.component.layout.rememberScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.theme.UIKitColors
import com.millentec.compose.uikit.theme.UIKitTheme
import com.millentec.compose.uikit.theme.getUIKitColors

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
                Icon(
                    modifier = Modifier
                        .size(48.dp),
                    imageVector = FluentIcons.addCircle(getUIKitColors().textFillColorPrimaryBrush),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier
                        .size(48.dp),
                    imageVector = FluentIcons.addCircle(getUIKitColors().textFillColorPrimaryBrush, true),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier
                        .size(48.dp),
                    imageVector = FluentIcons.addCircle(getUIKitColors().highlightColorBrush, true),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier
                        .size(48.dp),
                    imageVector = FluentIcons.addCircle(getUIKitColors().highlightColorBrush, getUIKitColors().textFillColorPrimaryBrush),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier
                        .size(48.dp),
                    imageVector = FluentIcons.addCircle(getUIKitColors().highlightColorBrush, getUIKitColors().textFillColorPrimaryBrush),
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
                Spacer(Modifier.height(120.dp))
            }

            val checkedIndex = remember { mutableStateOf(0) }

            UIKitNavigationDock(
                modifier = Modifier
                    .fillMaxSize(),
                checkedIndex = checkedIndex.value,
                onChecked = {
                    checkedIndex.value = it
                },
                independentButtonPosition = LayoutPosition.Right,
                items = listOf(
                    UIKitNavigationItem(
                        "Home",
                        FluentIcons.Home
                    ),
                    UIKitNavigationItem(
                        "Debug",
                        FluentIcons.Bug
                    ),
                    UIKitNavigationItem(
                        "App",
                        FluentIcons.Apps
                    ),
                    UIKitNavigationItem(
                        "Settings",
                        FluentIcons.Settings
                    )
                ),
                hasIndependentButton = true,
                independentButtonContent = {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize(0.6f),
                        imageVector = FluentIcons.Add,
                        contentDescription = null,
                        tint = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            )
        }
    }
}