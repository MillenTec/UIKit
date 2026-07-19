package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
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
        val acrylicMaterialsState = rememberAcrylicMaterialsState()

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        ) {

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
            }
        }
    }
}