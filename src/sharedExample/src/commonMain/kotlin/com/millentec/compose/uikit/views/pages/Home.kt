package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.LocalAcrylicMaterialsState
import com.millentec.compose.uikit.component.input.UIKitDropdownButton
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Accessibility
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Attach
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.BranchFork
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel

@Composable
@Preview
fun Home() {

    LaunchedEffect(Unit) {
        MainViewModel.navigationDockVisible(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val acrylicMaterialsState = LocalAcrylicMaterialsState.current

            LaunchedEffect(maxWidth, maxHeight) {
                acrylicMaterialsState.invalidate()
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
                    .padding(getUIKitLayout().x4Spacing, getUIKitLayout().x6Spacing)
            ) {
                Text(
                    text = "UIKit Gallery",
                    style = getUIKitTypography().largeTitle,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(modifier = Modifier.height(getUIKitLayout().mediumSpacing))

                Box {
                    val expanded = remember { mutableStateOf(false) }
                    UIKitDropdownButton(
                        expanded = expanded.value,
                        onButtonClick = {
                            expanded.value = !expanded.value
                        },
                        items = listOf(
                            UIKitMenuItem.textWithIcon(FluentIcons.Accessibility, "Item 0", onClick = {}),
                            UIKitMenuItem.divider(),
                            UIKitMenuItem.textWithIcon(FluentIcons.BranchFork, "Item 1", onClick = {}),
                            UIKitMenuItem.divider(),
                            UIKitMenuItem.textWithIcon(FluentIcons.Attach, "Item 2", onClick = {}),
                        ),
                        onDismissRequest = { expanded.value = false },
                        acrylicMaterialsState = acrylicMaterialsState
                    ) {
                        Text(
                            text = "Button",
                            style = getUIKitTypography().body,
                            color = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                }
            }
        }
    }
}