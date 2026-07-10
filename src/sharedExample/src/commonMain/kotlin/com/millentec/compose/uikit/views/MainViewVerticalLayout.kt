package com.millentec.compose.uikit.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.component.input.UIKitIslandButton
import com.millentec.compose.uikit.component.input.UIKitNavigationDock
import com.millentec.compose.uikit.component.input.UIKitNavigationItem
import com.millentec.compose.uikit.component.layout.ScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.component.layout.rememberScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.navigation.UIKitNavigation
import com.millentec.compose.uikit.theme.AppTheme
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import com.millentec.compose.uikit.views.pages.Controls
import com.millentec.compose.uikit.views.pages.Designs
import com.millentec.compose.uikit.views.pages.Home
import com.millentec.compose.uikit.views.pages.Settings

@Composable
@Preview
fun MainViewVerticalLayoutPreview() {
    val nav = remember {
        UIKitNavigation(
            initialPage = Pages.Home,
            homePage = Pages.Home
        )
    }

    val page by nav.page.collectAsState()
    val navAnimate by nav.pageSwitchAnimate.collectAsState()
    val hasHistoryPages by nav.hasHistoryPages.collectAsState()
    val acrylicEnabled by AppTheme.useAcrylic.collectAsState()

    val items = remember {
        mutableStateListOf<@Composable BoxScope.() -> Unit>(
            {
                Icon(
                    imageVector = FluentIcons.Home,
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            },
            {
                Icon(
                    imageVector = FluentIcons.Add,
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            },
            {
                Icon(
                    imageVector = FluentIcons.designIdeas(),
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            }
        )
    }

    val acrylicMaterialsState = rememberAcrylicMaterialsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {

        BackHandler(hasHistoryPages) {
            nav.goBack()
        }

        Box(
            modifier = Modifier
                .acrylicMaterialSource(acrylicMaterialsState),
        ) {
            AnimatedContent(
                targetState = page,
                transitionSpec = { navAnimate }
            ) {
                when (it) {
                    Pages.Home -> Home(
                        onAdd = {
                            items.add(
                                {
                                    Icon(
                                        imageVector = FluentIcons.Apps,
                                        contentDescription = null,
                                        tint = getUIKitColors().textFillColorPrimaryBrush
                                    )
                                }
                            )
                        },
                        onRemove = {
                            items.removeAt(items.size - 1)
                        },
                        onChange = {
                            val item0 = items[0]
                            items[0] = items[1]
                            items[1] = item0
                        }
                    )
                    Pages.Controls -> Controls()
                    Pages.Design -> Designs()
                    Pages.Settings -> Settings()
                }
            }
        }

        val mainIslandState: ScreenSideAdaptiveContainerState = rememberScreenSideAdaptiveContainerState(
            expectHeight = 56.dp,
            expectWidth = 56.dp,
            minMargin = getUIKitLayout().mediumSpacing,
            fallbackCornerRadius = getUIKitShapes().circular,
            position = LayoutPosition.BottomLeft,
            fillHeight = false,
            fillWidth = true
        )

        val independentIslandState = rememberScreenSideAdaptiveContainerState(
            expectHeight = 56.dp,
            expectWidth = 56.dp,
            minMargin = getUIKitLayout().mediumSpacing,
            fallbackCornerRadius = getUIKitShapes().circular,
            position = LayoutPosition.BottomRight,
            fillWidth = false,
            fillHeight = false
        )

        UIKitNavigationDock(
            modifier = Modifier
                .fillMaxSize(),
            mainIslandState = mainIslandState,
            independentIslandState = independentIslandState,
            acrylicEffectEnabled = acrylicEnabled,
            acrylicState = acrylicMaterialsState,
            shadowEnable = acrylicEnabled,
            checkedIndex = page.ordinal,
            onChecked = {
                nav.switchPage(Pages.entries[it])
            },
            items = listOf(
                UIKitNavigationItem(
                    title = "Home",
                    icon = FluentIcons.Home
                ),
                UIKitNavigationItem(
                    title = "Controls",
                    icon = FluentIcons.toggleMultiple()
                ),
                UIKitNavigationItem(
                    title = "Designs",
                    icon = FluentIcons.designIdeas()
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

        UIKitIslandButton(
            modifier = Modifier
                .fillMaxSize(),
            onClicked = {},
            items = items,
            state = rememberScreenSideAdaptiveContainerState(
                position = LayoutPosition.TopRight,
                fillWidth = false,
                fillHeight = false,
                minMargin = independentIslandState.margins.calculateEndPadding(LocalLayoutDirection.current),
                maxMargin = independentIslandState.margins.calculateEndPadding(LocalLayoutDirection.current)
            ),
            acrylicEffectEnabled = acrylicEnabled,
            acrylicState = acrylicMaterialsState,
            shadowEnable = acrylicEnabled,
            dividerColor = if (AppTheme.theme.collectAsState().value == AppTheme.themeLight) {
                getUIKitColors().lineFillColorPrimaryBrush.copy(alpha = 0.75f)
            } else Color(0x4C000000)
        )

        UIKitIslandButton(
            modifier = Modifier
                .fillMaxSize(),
            onClicked = {},
            items = listOf(
                {
                    Icon(
                        imageVector = FluentIcons.Apps,
                        contentDescription = null,
                        tint = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            ),
            state = rememberScreenSideAdaptiveContainerState(
                position = LayoutPosition.TopLeft,
                fillWidth = false,
                fillHeight = false,
                minMargin = mainIslandState.margins.calculateStartPadding(LocalLayoutDirection.current),
                maxMargin = mainIslandState.margins.calculateStartPadding(LocalLayoutDirection.current)
            ),
            acrylicEffectEnabled = acrylicEnabled,
            acrylicState = acrylicMaterialsState,
            shadowEnable = acrylicEnabled,
            dividerColor = if (AppTheme.theme.collectAsState().value == AppTheme.themeLight) {
                getUIKitColors().lineFillColorPrimaryBrush.copy(alpha = 0.75f)
            } else Color(0x4C000000)
        )
    }
}