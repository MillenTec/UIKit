package com.millentec.compose.uikit.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.component.input.UIKitNavigationDock
import com.millentec.compose.uikit.component.input.UIKitNavigationItem
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Add
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Home
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.navigation.UIKitNavigation
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.views.pages.Controls
import com.millentec.compose.uikit.views.pages.Designs
import com.millentec.compose.uikit.views.pages.Home
import com.millentec.compose.uikit.views.pages.Settings

@Composable
@Preview
fun MainViewVerticalLayoutPreview() {
    val nav = remember {
        UIKitNavigation(
            initialPage = Pages.Design,
            homePage = Pages.Home
        )
    }

    val page by nav.page.collectAsState()
    val navAnimate by nav.pageSwitchAnimate.collectAsState()
    val hasHistoryPages by nav.hasHistoryPages.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {

        BackHandler(hasHistoryPages) {
            nav.goBack()
        }

        AnimatedContent(
            targetState = page,
            transitionSpec = { navAnimate }
        ) {
            when (it) {
                Pages.Home -> Home()
                Pages.Controls -> Controls()
                Pages.Design -> Designs()
                Pages.Settings -> Settings()
            }
        }

        UIKitNavigationDock(
            modifier = Modifier
                .fillMaxSize(),
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
    }
}