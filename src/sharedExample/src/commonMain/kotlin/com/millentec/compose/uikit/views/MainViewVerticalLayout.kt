package com.millentec.compose.uikit.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.component.input.UIKitNavigationDock
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.layout.UIKitNavigationDockItem
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Home
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.AppTheme
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTheme
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.pages.*

@Composable
@Preview
fun MainViewVerticalLayout() {
    val nav = MainViewModel.navigation
    val uiKitTheme = getUIKitTheme()

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
                        acrylicEffectEnabled = acrylicEnabled,
                        acrylicState = acrylicMaterialsState,
                        shadowEnable = true,
                        checkedIndex = page.ordinal,
                        onChecked = {
                            nav.switchPage(Pages.entries[it])
                        },
                        items = remember { listOf(
                            UIKitNavigationDockItem.createByStringWithIcon(
                                text = "Home",
                                icon = FluentIcons.Home
                            ),
                            UIKitNavigationDockItem.createByStringWithIcon(
                                text = "Controls",
                                icon = FluentIcons.toggleMultiple()
                            ),
                            UIKitNavigationDockItem.createByStringWithIcon(
                                text = "Designs",
                                icon = FluentIcons.designIdeas()
                            )
                        ) },
                        maxWidth = 600.dp
                    )
                }
            }
        }
    }
}