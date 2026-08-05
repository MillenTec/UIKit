package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.LocalAcrylicMaterialsState
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography

@Composable
@Preview
fun Home() {
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
                    .padding(
                        start = getUIKitLayout().x4Spacing,
                        top = getUIKitLayout().x4Spacing,
                        end = getUIKitLayout().x4Spacing,
                        bottom = getUIKitLayout().x6Spacing
                    )
            ) {
                Text(
                    text = "UIKit Gallery",
                    style = getUIKitTypography().largeTitle,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )

                Spacer(modifier = Modifier.height(getUIKitLayout().mediumSpacing))
            }
        }
    }
}