package com.millentec.compose.uikit.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.App
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.LocalAcrylicMaterialState
import com.millentec.compose.uikit.component.input.UIKitDropdownButton
import com.millentec.compose.uikit.component.input.UIKitNavigationDock
import com.millentec.compose.uikit.component.layout.UIKitSurface
import com.millentec.compose.uikit.component.layout.rememberUIKitAdaptiveCornerContainerState
import com.millentec.compose.uikit.data.Pages.*
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.layout.UIKitAlignment
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.foundation.layout.UIKitNavigationDockItem
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialState
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.viewmodels.pageIndex

@Composable
@Preview
private fun Preview() {
    App()
}

private enum class NavDock {
    Home,
    Controls,
    Designs,
}

val LocalNavigationDockHeight = mutableStateOf(0.dp)

@Composable
fun MainView() {
    val nav = MainViewModel.navigation
    val uiKitTheme = getUIKitTheme()
    val strings by rememberUpdatedState(LocalStrings.current)

    val page by nav.page.collectAsState()
    val navAnimate by nav.pageSwitchAnimate.collectAsState()
    val hasHistoryPages by nav.hasHistoryPages.collectAsState()
    val acrylicEnabled by AppTheme.useAcrylic.collectAsState()

    val acrylicMaterialsState = rememberAcrylicMaterialState()

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

        LaunchedEffect(page) {
            if (page in 0..2) {
                MainViewModel.navigationDockVisible(true)
            } else if (pageIndex.getOrNull(page)?.parent?.value in 0..2) {
                MainViewModel.navigationDockVisible(true)
            } else {
                MainViewModel.navigationDockVisible(false)
            }
        }

        Box(
            modifier = Modifier
                .acrylicMaterialSource(acrylicMaterialsState),
        ) {
            AnimatedContent(
                targetState = page,
                transitionSpec = { navAnimate }
            ) {
                pageIndex.getOrNull(it)?.Content()
            }
        }

        val dockGloballyPosition = remember { mutableStateOf<LayoutCoordinates?>(null) }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedVisibility(
                visible = MainViewModel.navigationDockVisible.collectAsState().value,
                enter = slideInVertically(
                    animationSpec = spring(
                        stiffness = getUIKitAnimate().standardSpringStiffness,
                        dampingRatio = getUIKitAnimate().standardSpringDampingRatio
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
                Row(
                    modifier = Modifier
                        .widthIn(max = 700.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    val state = rememberUIKitAdaptiveCornerContainerState(
                        position = UIKitAlignment.BottomStart,
                        expectHeight = 56.dp,
                        expectWidth = 56.dp,
                    )

                    LaunchedEffect(state.height) {
                        LocalNavigationDockHeight.value = state.height + state.margins.calculateBottomPadding()
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        val dockItems = remember { mutableStateOf(NavDock.entries[page.coerceIn(0..2)]) }

                        LaunchedEffect(page) {
                            if (page in 0..2) {
                                dockItems.value = NavDock.entries[page]
                            } else if (pageIndex.getOrNull(page)?.parent?.value in 0..2) {
                                dockItems.value = NavDock.entries[pageIndex.getOrNull(page)?.parent?.value ?: return@LaunchedEffect]
                            }
                        }

                        UIKitNavigationDock(
                            modifier = Modifier
                                .onGloballyPositioned {
                                    if (it.isAttached)
                                        dockGloballyPosition.value = it
                                },
                            state = state,
                            acrylicEffectEnabled = acrylicEnabled,
                            acrylicState = acrylicMaterialsState,
                            shadowEnable = true,
                            checkedIndex = dockItems.value.ordinal,
                            onChecked = {
                                nav.switchPage(it)
                                dockItems.value = NavDock.entries[it]
                            },
                            items = remember {
                                listOf(
                                    UIKitNavigationDockItem.createByStringWithIcon(
                                        text = strings.navigation.home,
                                        icon = FluentIcons.Home
                                    ),
                                    UIKitNavigationDockItem.createByStringWithIcon(
                                        text = strings.navigation.controls,
                                        icon = FluentIcons.toggleMultiple()
                                    ),
                                    UIKitNavigationDockItem.createByStringWithIcon(
                                        text = strings.navigation.designs,
                                        icon = FluentIcons.designIdeas()
                                    )
                                )
                            }
                        )
                    }

                    Spacer(Modifier.width(getUIKitLayout().mediumSpacing))

                    Box(
                        modifier = Modifier
                            .padding(
                                end = state.margins.calculateStartPadding(LocalLayoutDirection.current)
                                        + if (LocalLayoutDirection.current == LayoutDirection.Ltr) (WindowInsets.safeDrawing.getRight(
                                    LocalDensity.current,
                                    LocalLayoutDirection.current
                                ) / LocalDensity.current.density).dp
                                else (WindowInsets.safeDrawing.getLeft(
                                    LocalDensity.current,
                                    LocalLayoutDirection.current
                                ) / LocalDensity.current.density).dp,
                                bottom = state.margins.calculateBottomPadding()
                            )
                    ) {
                        val expanded = remember { mutableStateOf(false) }
                        UIKitDropdownButton(
                            expanded = expanded.value,
                            onDismissRequest = { expanded.value = false },
                            appearPosition = Alignment.BottomEnd,
                            acrylicMaterialState = LocalAcrylicMaterialState.current,
                            acrylicEffectEnabled = AppTheme.useAcrylic.collectAsState().value,
                            items = listOf(
                                UIKitMenuItem.textWithIcon(
                                    icon = FluentIcons.Scales,
                                    text = strings.navigation.license,
                                    onClick = {
                                        nav.switchPage(License.ordinal, type = UIKitNavigationType.Forward)
                                        expanded.value = false
                                    }
                                ),
                                UIKitMenuItem.divider(),
                                UIKitMenuItem.textWithIcon(
                                    icon = FluentIcons.certificate(),
                                    text = strings.navigation.thirdPartyLicenses,
                                    onClick = {
                                        nav.switchPage(ThirdParty.ordinal, type = UIKitNavigationType.Forward)
                                        expanded.value = false
                                    }
                                ),
                                UIKitMenuItem.divider(),
                                UIKitMenuItem.textWithIcon(
                                    icon = FluentIcons.Settings,
                                    text = strings.navigation.settings,
                                    onClick = {
                                        nav.switchPage(Settings.ordinal, type = UIKitNavigationType.Forward)
                                        expanded.value = false
                                    }
                                )
                            )
                        ) {
                            UIKitSurface(
                                modifier = Modifier
                                    .size(
                                        width = state.height,
                                        height = state.height,
                                    ),
                                color = getUIKitColors().contentFillColorSecondaryBrush,
                                shape = RoundedCornerShape(state.cornerRadius),
                                shadow = UIKitShadowMaterial.getMarginal(),
                                acrylicEffectEnabled = acrylicEnabled,
                                acrylicMaterialState = acrylicMaterialsState,
                                indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                                onClick = {
                                    expanded.value = !expanded.value
                                },
                            ) {
                                val iconRotateAnimated = animateFloatAsState(
                                    targetValue = if (expanded.value) 45f else 0f,
                                    animationSpec = tween(
                                        getUIKitAnimate().motionRegularDurationMillis,
                                        easing = FastOutSlowInEasing
                                    )
                                )

                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize(0.6f)
                                        .rotate(iconRotateAnimated.value),
                                    imageVector = FluentIcons.Add,
                                    contentDescription = "More",
                                    tint = getUIKitColors().textFillColorPrimaryBrush
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}