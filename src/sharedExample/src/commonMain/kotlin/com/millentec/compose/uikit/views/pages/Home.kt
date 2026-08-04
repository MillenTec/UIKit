package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.LocalAcrylicMaterialsState
import com.millentec.compose.uikit.component.input.UIKitDropdownButton
import com.millentec.compose.uikit.foundation.layout.UIKitDropdownMenuItem
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import org.jetbrains.compose.resources.painterResource
import uikit.sharedexample.generated.resources.Res
import uikit.sharedexample.generated.resources.testimg1

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

            Image(
                modifier = Modifier
                    .acrylicMaterialSource(acrylicMaterialsState)
                    .fillMaxSize(),
                painter = painterResource(Res.drawable.testimg1),
                contentDescription = null,
                alignment = Alignment.BottomCenter,
                contentScale = ContentScale.FillHeight
            )

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
                            UIKitDropdownMenuItem.text("Item 0", onClick = {}),
                            UIKitDropdownMenuItem.divider(),
                            UIKitDropdownMenuItem.text("Item 1", onClick = {}),
                            UIKitDropdownMenuItem.divider(),
                            UIKitDropdownMenuItem.text("Item 2", onClick = {}),
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