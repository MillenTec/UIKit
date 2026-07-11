package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.input.UIKitButton
import com.millentec.compose.uikit.component.input.UIKitButtonColors
import com.millentec.compose.uikit.foundation.materials.acrylicMaterial
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import com.millentec.compose.uikit.theme.getUIKitTypography
import org.jetbrains.compose.resources.painterResource
import uikit.sharedexample.generated.resources.Res
import uikit.sharedexample.generated.resources.testimg1

@Composable
@Preview
fun Home(
    onAdd: () -> Unit = {},
    onRemove: () -> Unit = {},
    onChange: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {
        val acrylicMaterialsState = rememberAcrylicMaterialsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
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

                UIKitButton(
                    modifier = Modifier
                        .acrylicMaterial(acrylicMaterialsState, shape = RoundedCornerShape(getUIKitShapes().circular)),
                    onClick = {
                        onAdd()
                    },
                    colors = UIKitButtonColors.default(
                        background = Color.Transparent
                    )
                ) {
                    Text(
                        "Add",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitButton(
                    onClick = {
                        onRemove()
                    }
                ) {
                    Text(
                        "Remove",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitButton(
                    onClick = {
                        onChange()
                    }
                ) {
                    Text(
                        "Change",
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            }
        }
    }
}