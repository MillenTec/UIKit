package com.millentec.compose.uikit.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.UIKitCodeViewer
import com.millentec.compose.uikit.component.layout.UIKitGroupedCard
import com.millentec.compose.uikit.component.layout.UIKitSettingsExpander
import com.millentec.compose.uikit.foundation.layout.UIKitCardScope
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Code
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

open class ControlGalleryBasic(
    val page: Pages,
) {
    private val maxWidth = mutableStateOf(Dp.Unspecified)

    @Composable
    open fun ControlView() {}

    @Composable
    open fun UIKitCardScope.ControlOption() {}

    @Composable
    open fun exampleCode(): String { return "" }

    open fun LazyListScope.description() {}

    @Composable
    fun Content(title: String) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush),
            contentPadding = PaddingValues(
                start = getUIKitLayout().screenSideSpacing,
                top = getUIKitLayout().screenSideSpacing,
                end = getUIKitLayout().screenSideSpacing,
                bottom = maxOf(
                    LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                    getUIKitLayout().screenSideSpacing
                )
            ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
        ) {
            val nav = MainViewModel.navigation

            item {
                Text(
                    text = title,
                    style = getUIKitTypography().largeTitle,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )
            }

            item {
                Spacer(Modifier.height(getUIKitLayout().titleSpacing))
            }

            description()

            item {
                Spacer(Modifier.height(getUIKitLayout().sectionSpacing))
            }

            item {
                val densityDpi = LocalDensity.current.density
                val height = remember { mutableStateOf(Dp.Unspecified) }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(
                            max = if (maxWidth.value >= 768.dp) {
                                512.dp
                            } else Dp.Unspecified
                        )
                        .onSizeChanged {
                            maxWidth.value = (it.width / densityDpi).dp
                        }
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .height(if (maxWidth.value >= 768.dp)
                                height.value
                            else Dp.Unspecified)
                            .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                            .background(getUIKitColors().contentFillColorSecondaryBrush)
                            .then(if (maxWidth.value >= 768.dp) {
                                Modifier.verticalScroll(rememberScrollState())
                            } else Modifier)
                            .padding(getUIKitLayout().mediumSpacing)
                    ) {
                        ControlView()
                    }

                    if (maxWidth.value >= 768.dp) {
                        Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                        Column(
                            Modifier
                                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                .width(360.dp)
                                .onSizeChanged {
                                    height.value = (it.height / densityDpi).dp
                                }
                                .verticalScroll(rememberScrollState())
                        ) {
                            UIKitGroupedCard {
                                ControlOption()
                            }
                        }
                    }
                }
            }

            item {
                Spacer(Modifier.height(getUIKitLayout().itemSpacing))
            }

            item {
                val expanded = remember { mutableStateOf(true) }
                UIKitSettingsExpander(
                    expanded = expanded.value,
                    onClick = {
                        expanded.value = !expanded.value
                    },
                    title = LocalStrings.current.controls.inputs.common.sourceCode,
                    icon = FluentIcons.Code,
                    contentPadding = PaddingValues(0.dp),
                    headerPadding = PaddingValues(getUIKitLayout().basicSpacing)
                ) {
                    UIKitCodeViewer(
                        config = UIKitCodeBlockConfig.kotlin(
                            when (AppTheme.theme.collectAsState().value) {
                                ThemeType.System -> {
                                    if (isSystemInDarkTheme()) UIKitCodeBlockColors.IntelliJ
                                    else UIKitCodeBlockColors.IntelliJLight
                                }
                                ThemeType.Dark -> UIKitCodeBlockColors.IntelliJ
                                ThemeType.Light -> UIKitCodeBlockColors.IntelliJLight
                            }
                        )
                    ) {
                        exampleCode()
                    }
                }
            }

            if (maxWidth.value <= 768.dp && maxWidth.value != Dp.Unspecified) {
                item {
                    Spacer(Modifier.height(getUIKitLayout().sectionSpacing))
                }

                item {
                    UIKitGroupedCard {
                        ControlOption()
                    }
                }
            }
        }
    }
}