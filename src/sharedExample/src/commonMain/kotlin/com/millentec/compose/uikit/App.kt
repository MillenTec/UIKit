package com.millentec.compose.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.component.layout.UIKitBottomSheet
import com.millentec.compose.uikit.component.layout.UIKitBottomSheetState
import com.millentec.compose.uikit.component.layout.uikitBottomSheetCollaborativeAnimation
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.filled.dp20.Checkmark
import com.millentec.compose.uikit.icons.fluenticons.filled.dp20.Dismiss
import com.millentec.compose.uikit.theme.AppTheme
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.views.MainViewVerticalLayout

@Composable
@Preview
fun App() {
    UIKitTheme(AppTheme.theme.collectAsState().value) {
        BoxWithConstraints(
            modifier = Modifier
                .background(getUIKitColors().contentFillColorPrimaryBrush)
        ) {
            val expanded = remember { mutableStateOf(false) }
            val bottomSheetState = remember { UIKitBottomSheetState() }
            val maxHeight = maxHeight * 0.7f

            BackHandler(expanded.value) {
                expanded.value = false
            }

            Box(
                modifier = Modifier
                    .uikitBottomSheetCollaborativeAnimation(
                        state = bottomSheetState,
                        blurEffectEnabled = true,
                        onClick = {
                            expanded.value = false
                        }
                    )
            ) {
                MainViewVerticalLayout(
                    onClick = {
                        expanded.value = true
                    }
                )
            }

            UIKitBottomSheet(
                modifier = Modifier
                    .fillMaxSize(),
                expanded = expanded.value,
                onExpandedChange = {
                    expanded.value = it
                },
                leftButton = FluentIcons.Filled.Dismiss,
                rightButton = FluentIcons.Filled.Checkmark,
                onLeftButtonClick = {
                    expanded.value = false
                },
                onRightButtonClick = {
                    expanded.value = false
                },
                maxHeight = maxHeight,
                state = bottomSheetState
            ) {
                Text("Hello World")
                Spacer(Modifier.height(1000.dp))
                Text("Hello World")
            }
        }
    }
}