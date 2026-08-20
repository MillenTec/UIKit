package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.millentec.compose.uikit.SystemUISymbols
import com.millentec.compose.uikit.component.flyout.UIKitSwipeableFlyoutState
import com.millentec.compose.uikit.component.input.UIKitHSVColorPicker
import com.millentec.compose.uikit.component.layout.*
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialState
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.ChevronArrowLeft
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Color
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.PaintBucket
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.options
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.builtin.systemui.AddCircle
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight
import com.millentec.compose.uikit.views.component.StateSelector
import com.millentec.compose.uikit.views.pages.CommonSymbolStyle.*
import kotlin.math.ceil
import kotlin.math.floor

@Composable
@Preview
private fun Preview() {
    UIKitSymbolsGalleryPage(SystemUISymbols, "System UI")
}

private enum class CommonSymbolStyle {
    Monochrome,
    Hierarchical,
    MultiColor
}

private class SymbolConfig(
    style: CommonSymbolStyle,
    tint: Color,
    backgroundColor: Color,
) {
    val symbolStyle: UIKitSymbolStyle
        get() = when (style.value) {
            Monochrome -> UIKitSymbolStyle.Monochrome(tint.value)
            Hierarchical -> UIKitSymbolStyle.Hierarchical(tint.value)
            MultiColor -> UIKitSymbolStyle.MultiColor
        }
    val style = mutableStateOf(style)
    val tint = mutableStateOf(tint)
    val backgroundColor = mutableStateOf(backgroundColor)
}

@Composable
fun UIKitSymbolsGalleryPage(
    symbols: List<UIKitSymbol>,
    title: String,
) {
    val uikitTheme by rememberUpdatedState(getUIKitTheme())
    val acrylicMaterialState = rememberAcrylicMaterialState()
    val symbolConfig = remember { SymbolConfig(
        style = Monochrome,
        tint = uikitTheme.colors.highlightColorPrimaryBrush,
        backgroundColor = uikitTheme.colors.contentFillColorSecondaryBrush
    ) }
    val symbolFilter = remember { mutableStateOf<(UIKitSymbol) -> Boolean>({ true }) }
    val symbolsFiltered = remember { mutableStateOf(symbols) }

    val commonOptionExpanded = remember { mutableStateOf(false) }
    val commonOptionState = remember { UIKitSwipeableFlyoutState() }

    LaunchedEffect(symbolFilter.value) {
        symbolsFiltered.value = symbols.filter(symbolFilter.value)
    }

    BoxWithConstraints(
        modifier = Modifier
            .uikitBottomSheetCollaborativeAnimation(commonOptionState)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush)
                .acrylicMaterialSource(acrylicMaterialState),
            contentPadding = PaddingValues(
                start = getUIKitLayout().screenSideSpacing,
                top = getUIKitLayout().interactiveHotspot + getUIKitLayout().screenSideSpacing + getUIKitLayout().mediumSpacing,
                end = getUIKitLayout().screenSideSpacing,
                bottom = maxOf(
                    LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                    getUIKitLayout().screenSideSpacing
                )
            ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current),
            columns = GridCells.Adaptive(128.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = title,
                    style = getUIKitTypography().largeTitle,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )
            }

            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(Modifier.height(getUIKitLayout().titleSpacing))
            }

            items(symbolsFiltered.value.size) {
                Column(
                    modifier = Modifier
                        .padding(getUIKitLayout().smallSpacing)
                        .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                        .background(symbolConfig.backgroundColor.value)
                        .padding(getUIKitLayout().mediumSpacing),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    UIKitIcon(
                        modifier = Modifier
                            .fillMaxWidth(),
                        symbol = symbolsFiltered.value[it],
                        contentDescription = symbolsFiltered.value[it].name,
                        symbolEffect = null,
                        symbolStyle = symbolConfig.symbolStyle
                    )

                    Spacer(Modifier.height(getUIKitLayout().itemSpacing))

                    Text(
                        text = symbolsFiltered.value[it].name,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorSecondaryBrush,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(PaddingValues(
                    top = getUIKitLayout().screenSideSpacing,
                    start = getUIKitLayout().screenSideSpacing,
                    end = getUIKitLayout().screenSideSpacing
                ) + WindowInsets.safeDrawing.asPaddingValues())
        ) {
            UIKitSurface(
                modifier = Modifier
                    .size(getUIKitLayout().interactiveHotspot),
                onClick = {
                    MainViewModel.navigation.goBack()
                },
                shape = RoundedCornerShape(getUIKitShapes().circular),
                color = getUIKitColors().contentFillColorSecondaryBrush,
                acrylicEffectEnabled = true,
                acrylicMaterialState = acrylicMaterialState,
                shadow = UIKitShadowMaterial.getMarginal()
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(0.6f),
                    imageVector = FluentIcons.ChevronArrowLeft,
                    contentDescription = "Go Back",
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            }

            Spacer(Modifier.weight(1f))

            UIKitSurface(
                modifier = Modifier
                    .size(getUIKitLayout().interactiveHotspot),
                onClick = {
                    commonOptionExpanded.value = !commonOptionExpanded.value
                },
                shape = RoundedCornerShape(getUIKitShapes().circular),
                color = getUIKitColors().contentFillColorSecondaryBrush,
                acrylicEffectEnabled = true,
                acrylicMaterialState = acrylicMaterialState,
                shadow = UIKitShadowMaterial.getMarginal()
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(0.6f),
                    imageVector = FluentIcons.options(),
                    contentDescription = "Common Options",
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            }
        }

        UIKitBottomSheet(
            expanded = commonOptionExpanded.value,
            state = commonOptionState,
            title = "Options",
            minHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            maxHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            onDismissRequest = {
                commonOptionExpanded.value = false
            }
        ) {
            CommonOptions(symbolConfig)
        }
    }
}

@Composable
@Preview
private fun CommonOptionsPreview() {
    Box(
        modifier = Modifier
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {
        CommonOptions(
            SymbolConfig(
                style = Monochrome,
                tint = getUIKitColors().highlightColorPrimaryBrush,
                backgroundColor = getUIKitColors().contentFillColorSecondaryBrush,
            )
        )
    }
}

@Composable
private fun CommonOptions(
    state: SymbolConfig
) {
    val style = remember { mutableStateOf(state.style.value.ordinal) }
    val tint = remember { mutableStateOf(state.tint.value.toHsv()) }
    val background = remember { mutableStateOf(state.backgroundColor.value.toHsv()) }

    LaunchedEffect(style.value) {
        state.style.value = CommonSymbolStyle.entries[style.value]
    }

    LaunchedEffect(tint.value) {
        state.tint.value = tint.value.getColor()
    }

    LaunchedEffect(background.value) {
        state.backgroundColor.value = background.value.getColor()
    }

    LazyColumn(
        contentPadding = PaddingValues(getUIKitLayout().x2Spacing)
    ) {
        item {
            StateSelector(
                states = listOf(
                    StateSelectorItem("Monochrome") {
                        UIKitIcon(
                            symbol = UIKitSymbols.systemUI.AddCircle,
                            contentDescription = "Example",
                            symbolStyle = UIKitSymbolStyle.Monochrome(state.tint.value)
                        )
                    },
                    StateSelectorItem("Hierarchical") {
                        UIKitIcon(
                            symbol = UIKitSymbols.systemUI.AddCircle,
                            contentDescription = "Example",
                            symbolStyle = UIKitSymbolStyle.Hierarchical(state.tint.value)
                        )
                    },
                    StateSelectorItem("Multi Color") {
                        UIKitIcon(
                            symbol = UIKitSymbols.systemUI.AddCircle,
                            contentDescription = "Example",
                            symbolStyle = UIKitSymbolStyle.MultiColor
                        )
                    }
                ),
                state = style
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().itemSpacing))
        }

        item {
            val expanded = remember { mutableStateOf(false) }
            UIKitSettingsExpander(
                expanded = expanded.value,
                onClick = {
                    expanded.value = !expanded.value
                },
                title = "Tint",
                icon = FluentIcons.Color
            ) {
                UIKitHSVColorPicker(
                    color = tint.value,
                    onColorChange = {
                        tint.value = it
                    }
                )

                val itemHeight = 48.dp

                val optionalColor = listOf(
                    OptionalColorInfo(getUIKitColors().textFillColorPrimaryBrush, "Primary", getUIKitColors().contentFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().textFillColorPrimaryBrushReversed, "Reversed", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().highlightColorPrimaryBrush, "Highlight", UIKitColors.getDark().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().successGreenColorPrimaryBrush, "Success", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().warningYellowColorPrimaryBrush, "Warning", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().errorRedColorPrimaryBrush, "Error", UIKitColors.getDark().textFillColorPrimaryBrush),
                )

                BoxWithConstraints {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .height(
                                (ceil(optionalColor.size / floor(maxWidth / 128.dp)) * itemHeight) + getUIKitLayout().smallSpacing * ceil(optionalColor.size / floor(maxWidth / 128.dp)) * 2
                            ),
                        columns = GridCells.Adaptive(128.dp),
                        userScrollEnabled = false
                    ) {
                        items(optionalColor.size) {
                            Box(
                                modifier = Modifier
                                    .padding(getUIKitLayout().smallSpacing)
                                    .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                    .height(itemHeight)
                                    .background(optionalColor[it].color)
                                    .uikitClickable(
                                        onClick = {
                                            tint.value = optionalColor[it].color.toHsv()
                                        },
                                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                                    ),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = optionalColor[it].name,
                                    style = getUIKitTypography().body,
                                    color = optionalColor[it].contentColor,
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().itemSpacing))
        }

        item {
            val expanded = remember { mutableStateOf(false) }
            UIKitSettingsExpander(
                expanded = expanded.value,
                onClick = {
                    expanded.value = !expanded.value
                },
                title = LocalStrings.current.designs.fluentIcons.options.backgroundColor,
                icon = FluentIcons.PaintBucket
            ) {
                UIKitHSVColorPicker(
                    color = background.value,
                    onColorChange = {
                        background.value = it
                    }
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                val itemHeight = 48.dp

                val optionalColor = listOf(
                    OptionalColorInfo(getUIKitColors().contentFillColorPrimaryBrush, "Primary", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().contentFillColorSecondaryBrush, "Secondary", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().highlightColorFourthBrush, "Highlight", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().successGreenColorFourthBrush, "Success", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().warningYellowColorFourthBrush, "Warning", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().errorRedColorFourthBrush, "Error", getUIKitColors().textFillColorPrimaryBrush),
                )

                BoxWithConstraints {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .height(
                                (ceil(optionalColor.size / floor(maxWidth / 128.dp)) * itemHeight) + getUIKitLayout().smallSpacing * ceil(optionalColor.size / floor(maxWidth / 128.dp)) * 2
                            ),
                        columns = GridCells.Adaptive(128.dp),
                        userScrollEnabled = false
                    ) {
                        items(optionalColor.size) {
                            Box(
                                modifier = Modifier
                                    .padding(getUIKitLayout().smallSpacing)
                                    .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                    .height(itemHeight)
                                    .background(optionalColor[it].color)
                                    .uikitClickable(
                                        onClick = {
                                            background.value = optionalColor[it].color.toHsv()
                                        },
                                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                                    ),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = optionalColor[it].name,
                                    style = getUIKitTypography().body,
                                    color = optionalColor[it].contentColor,
                                )
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(getUIKitLayout().itemSpacing))
        }
    }
}