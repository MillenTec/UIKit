package com.millentec.compose.uikit.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

open class CommonPage(
    title: String,
    parent: Int? = null,
    includeDockSpacing: Boolean = true,
): PageBasic(
    title,
    parent
) {
    val includeDockSpacing = mutableStateOf(includeDockSpacing)

    open fun LazyListScope.lazyContent() {}

    @Composable
    final override fun Content() {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush),
            contentPadding = PaddingValues(
                start = getUIKitLayout().x4Spacing,
                top = getUIKitLayout().x4Spacing,
                end = getUIKitLayout().x4Spacing,
            ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
        ) {
            val nav = MainViewModel.navigation

            item {
                Text(
                    text = getTitleById(id.value),
                    style = getUIKitTypography().largeTitle,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )
            }

            item {
                Spacer(Modifier.height(getUIKitLayout().x2Spacing))
            }

            lazyContent()

            item {
                Spacer(
                    Modifier.height(
                        maxOf(
                            if (includeDockSpacing.value) LocalNavigationDockHeight.value + getUIKitLayout().mediumSpacing else 0.dp,
                            getUIKitLayout().x4Spacing
                        )
                    )
                )
            }
        }
    }
}