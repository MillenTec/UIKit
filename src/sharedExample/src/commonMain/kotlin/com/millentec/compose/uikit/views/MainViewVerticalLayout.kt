package com.millentec.compose.uikit.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.component.input.UIKitNavigationDock
import com.millentec.compose.uikit.component.input.UIKitNavigationItem
import com.millentec.compose.uikit.component.layout.ScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.component.layout.rememberScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Add
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Home
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.pages.*

@Composable
@Preview
fun MainViewVerticalLayout() {
    val nav = MainViewModel.navigation

    val page by nav.page.collectAsState()
    val navAnimate by nav.pageSwitchAnimate.collectAsState()
    val hasHistoryPages by nav.hasHistoryPages.collectAsState()
    val acrylicEnabled by AppTheme.useAcrylic.collectAsState()

    val acrylicMaterialsState = rememberAcrylicMaterialsState()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {

        BackHandler(hasHistoryPages) {
            nav.goBack()
        }

        LaunchedEffect(maxWidth, maxHeight, page) {
            acrylicMaterialsState.invalidate()
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
                    Pages.Home -> Home()
                    Pages.Controls -> Controls()
                    Pages.Design -> Designs()
                    Pages.Settings -> Settings()
                    Pages.Icons -> IconsGallery()
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

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = MainViewModel.navigationDockVisible.collectAsState().value,
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = getUIKitAnimate().motionRegularDurationMillis, easing = FastOutSlowInEasing)
                ) {
                    it
                },
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = getUIKitAnimate().motionRegularDurationMillis, easing = FastOutSlowInEasing)
                ) {
                    it
                }
            ) {
                UIKitNavigationDock(
                    mainIslandState = mainIslandState,
                    independentIslandState = independentIslandState,
                    acrylicEffectEnabled = acrylicEnabled,
                    acrylicState = acrylicMaterialsState,
                    shadowEnable = true,
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
                    },
                    maxWidth = 600.dp
                )
            }
        }
    }
}