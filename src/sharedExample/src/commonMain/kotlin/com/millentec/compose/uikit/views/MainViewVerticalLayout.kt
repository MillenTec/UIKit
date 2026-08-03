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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.component.flyout.UIKitDropdownMenu
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
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.pages.*

@Composable
@Preview
fun MainViewVerticalLayout() {
    val nav = MainViewModel.navigation
    val uiKitTheme = getUIKitTheme()
    val layoutDirection = LocalLayoutDirection.current
    val density = LocalDensity.current

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

        val menuExpanded = remember { mutableStateOf(false) }
        val dockGloballyPosition = remember { mutableStateOf<LayoutCoordinates?>(null) }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(
                    visible = MainViewModel.navigationDockVisible.collectAsState().value,
                    enter = slideInVertically(
                        animationSpec = tween(
                            durationMillis = getUIKitAnimate().motionRegularDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ) {
                        it
                    },
                    exit = slideOutVertically(
                        animationSpec = tween(
                            durationMillis = getUIKitAnimate().motionRegularDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ) {
                        it
                    }
                ) {
                    UIKitNavigationDock(
                        modifier = Modifier
                            .onGloballyPositioned {
                                if (it.isAttached)
                                    dockGloballyPosition.value = it
                            },
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
                        onIndependentButtonClick = {
                            menuExpanded.value = !menuExpanded.value
                        },
                        maxWidth = 600.dp
                    )
                }

                UIKitDropdownMenu(
                    expanded = menuExpanded.value,
                    items = listOf(
                        Pair("Settings", FluentIcons.Settings),
                        Pair("Info", FluentIcons.info())
                    ),
                    onDismissRequest = {
                        menuExpanded.value = false
                    },
                    onClick = {
                        menuExpanded.value = false
                    },
                    acrylicMaterialsState = acrylicMaterialsState,
                    alignment = Alignment.BottomEnd,
                    appearPosition = Alignment.BottomEnd,
                    offset = { _, _ ->
                        DpOffset(
                            y = -(independentIslandState.margins.calculateBottomPadding()
                                    + independentIslandState.height
                                    + uiKitTheme.layout.mediumSpacing),
                            x = (if (!(dockGloballyPosition.value?.isAttached ?: false)) 0.dp else -((dockGloballyPosition.value?.positionInRoot()?.x ?: 0f) / density.density).dp)
                                    - independentIslandState.margins.calculateEndPadding(
                                layoutDirection)
                        )
                    }
                )
            }
        }
    }
}