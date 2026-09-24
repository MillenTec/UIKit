package com.millentec.compose.uikit.views.pages

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.SystemUISymbols
import com.millentec.compose.uikit.component.flyout.UIKitSwipeableFlyoutState
import com.millentec.compose.uikit.component.input.UIKitHSVColorPicker
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.*
import com.millentec.compose.uikit.foundation.graphics.rememberAcrylicMaterialState
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.navigation.UIKitNavigationAnimate
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.builtin.media.Volume
import com.millentec.compose.uikit.symbols.builtin.shapes.Layer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight
import com.millentec.compose.uikit.views.component.CommonSlider
import com.millentec.compose.uikit.views.component.StateSelector
import com.millentec.compose.uikit.views.pages.CommonSymbolStyle.*
import kotlin.math.ceil
import kotlin.math.floor

@Composable
@Preview
private fun Preview() {
    UIKitSymbolsGalleryPage(SystemUISymbols, LocalStrings.current.designs.uikitSymbols.systemUiTitle)
}

private enum class CommonSymbolStyle {
    Monochrome,
    Hierarchical,
    MultiColor
}

private class CommonConfig(
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
    val commonConfig = remember { CommonConfig(
        style = Monochrome,
        tint = uikitTheme.colors.highlightColorPrimaryBrush,
        backgroundColor = uikitTheme.colors.contentFillColorSecondaryBrush
    ) }
    val symbolFilter = remember { mutableStateOf<(UIKitSymbol) -> Boolean>({ true }) }
    val symbolsFiltered = remember { mutableStateOf(symbols) }

    val commonOptionExpanded = remember { mutableStateOf(false) }
    val commonOptionState = remember { UIKitSwipeableFlyoutState() }

    val selectedSymbol = remember { mutableStateOf<UIKitSymbol?>(null) }
    val symbolConfig = remember(selectedSymbol.value) { SymbolConfig() }

    LaunchedEffect(symbolFilter.value) {
        selectedSymbol.value = null
    }

    LaunchedEffect(symbolFilter.value) {
        symbolsFiltered.value = symbols.filter(symbolFilter.value)
    }

    BoxWithConstraints {
        Row {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .uikitBottomSheetCollaborativeAnimation(commonOptionState)
            ) {
                AnimatedContent(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    targetState = selectedSymbol.value,
                    transitionSpec = { UIKitNavigationAnimate.jump }
                ) { state ->
                    if (state != null && this@BoxWithConstraints.maxWidth <= 1024.dp) {
                        BackHandler { selectedSymbol.value = null }

                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(PaddingValues(
                                        top = getUIKitLayout().screenSideSpacing,
                                        start = getUIKitLayout().interactiveHotspot + getUIKitLayout().mediumSpacing + getUIKitLayout().screenSideSpacing,
                                        end = getUIKitLayout().screenSideSpacing
                                    ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current))
                                    .fillMaxWidth()
                                    .height(getUIKitLayout().interactiveHotspot),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    text = state.name,
                                    style = getUIKitTypography().headline,
                                    color = getUIKitColors().textFillColorPrimaryBrush
                                )
                            }

                            SymbolView(
                                symbol = state,
                                commonConfig = commonConfig,
                                paddingValues = PaddingValues(
                                    start = getUIKitLayout().screenSideSpacing,
                                    end = getUIKitLayout().screenSideSpacing,
                                    bottom = maxOf(
                                        LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                                        getUIKitLayout().screenSideSpacing
                                    )
                                ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current),
                            )
                        }
                    } else if (state != null && this@BoxWithConstraints.maxWidth > 1024.dp) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            UIKitIcon(
                                modifier = Modifier
                                    .fillMaxHeight(0.6f),
                                symbol = state,
                                contentDescription = LocalStrings.current.designs.uikitSymbols.preview,
                                symbolStyle = commonConfig.symbolStyle,
                                symbolEffect = UIKitSymbolEffect()
                                    .visibleEffect(symbolConfig.visible.value)
                                    .stateEffect((state.abilityStatement?.firstOrNull { it is UIKitSymbolAbility.MultiState } as? UIKitSymbolAbility.MultiState)?.states?.getOrNull(
                                        symbolConfig.state.value
                                    ) ?: "default")
                                    .bounceEffect(symbolConfig.bounceTrigger.value)
                                    .variableColorEffect(symbolConfig.variableColorActive.value)
                                    .pulseEffect(symbolConfig.pulseActive.value)
                                    .progressibleEffect(symbolConfig.progress.value)
                            )
                        }
                    } else {
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(getUIKitColors().contentFillColorPrimaryBrush),
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
                                        .dropShadow(
                                            RoundedCornerShape(getUIKitShapes().cardRounded),
                                            UIKitShadowMaterial.getPrimary()
                                        )
                                        .clip(RoundedCornerShape(getUIKitShapes().cardRounded))
                                        .background(commonConfig.backgroundColor.value)
                                        .uikitClickable(
                                            onClick = {
                                                selectedSymbol.value = symbolsFiltered.value[it]
                                            },
                                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                                        )
                                        .padding(getUIKitLayout().mediumSpacing),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    UIKitIcon(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        symbol = symbolsFiltered.value[it],
                                        contentDescription = symbolsFiltered.value[it].name,
                                        symbolEffect = null,
                                        symbolStyle = commonConfig.symbolStyle
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
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(
                            PaddingValues(
                                top = getUIKitLayout().screenSideSpacing,
                                start = getUIKitLayout().screenSideSpacing,
                                end = getUIKitLayout().screenSideSpacing
                            ) + WindowInsets.safeDrawing.asPaddingValues()
                        )
                ) {
                    UIKitSurface(
                        modifier = Modifier
                            .size(getUIKitLayout().interactiveHotspot),
                        onClick = {
                            if (selectedSymbol.value != null)
                                selectedSymbol.value = null
                            else
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
                            contentDescription = LocalStrings.current.designs.uikitSymbols.goBack,
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
                                .fillMaxHeight(0.6f)
                                .aspectRatio(1f),
                            imageVector = FluentIcons.options(),
                            contentDescription = LocalStrings.current.designs.uikitSymbols.commonOptions,
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                }
            }

            if (this@BoxWithConstraints.maxWidth > 1024.dp) {
                LazyColumn(
                    modifier = Modifier
                        .width(420.dp),
                    contentPadding = PaddingValues(getUIKitLayout().cardPadding)
                ) {
                    if (selectedSymbol.value != null) {
                        selectedSymbol.value?.let { symbol ->
                            SymbolOptions(
                                commonConfig = commonConfig,
                                symbol = symbol,
                                config = symbolConfig
                            )
                        }
                    } else {
                        CommonOptions(
                            commonConfig,
                        )
                    }
                }
            }
        }

        UIKitBottomSheet(
            expanded = commonOptionExpanded.value,
            state = commonOptionState,
            title = LocalStrings.current.designs.fluentIcons.options.title,
            minHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            maxHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            onDismissRequest = {
                commonOptionExpanded.value = false
            }
        ) {
            BackHandler { commonOptionExpanded.value = false }

            LazyColumn(
                contentPadding = PaddingValues(getUIKitLayout().x2Spacing)
            ) {
                CommonOptions(commonConfig)
            }
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
        val commonConfig = CommonConfig(
            style = Monochrome,
            tint = getUIKitColors().highlightColorPrimaryBrush,
            backgroundColor = getUIKitColors().contentFillColorSecondaryBrush,
        )
        LazyColumn(
            contentPadding = PaddingValues(getUIKitLayout().x2Spacing)
        ) {
            CommonOptions(
                commonConfig
            )
        }
    }
}

private fun LazyListScope.CommonOptions(
    state: CommonConfig,
    symbolState: String = "default",
    sampleSymbol: UIKitSymbol = UIKitSymbols.shapes.Layer
) {
    item {
        val style = remember { mutableStateOf(state.style.value.ordinal) }

        LaunchedEffect(style.value) {
            state.style.value = CommonSymbolStyle.entries[style.value]
        }

        StateSelector(
            states = listOf(
                StateSelectorItem(LocalStrings.current.designs.uikitSymbols.styles.monochrome) {
                    UIKitIcon(
                        symbol = sampleSymbol,
                        contentDescription = LocalStrings.current.designs.uikitSymbols.example,
                        symbolStyle = UIKitSymbolStyle.Monochrome(state.tint.value),
                        symbolEffect = UIKitSymbolEffect()
                            .stateEffect(symbolState)
                    )
                },
                StateSelectorItem(LocalStrings.current.designs.uikitSymbols.styles.hierarchical) {
                    UIKitIcon(
                        symbol = sampleSymbol,
                        contentDescription = LocalStrings.current.designs.uikitSymbols.example,
                        symbolStyle = UIKitSymbolStyle.Hierarchical(state.tint.value),
                        symbolEffect = UIKitSymbolEffect()
                            .stateEffect(symbolState)
                    )
                },
                StateSelectorItem(LocalStrings.current.designs.uikitSymbols.styles.multiColor) {
                    UIKitIcon(
                        symbol = sampleSymbol,
                        contentDescription = LocalStrings.current.designs.uikitSymbols.example,
                        symbolStyle = UIKitSymbolStyle.MultiColor,
                        symbolEffect = UIKitSymbolEffect()
                            .stateEffect(symbolState)
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
        val tint = remember { mutableStateOf(state.tint.value.toHsv()) }

        LaunchedEffect(tint.value) {
            state.tint.value = tint.value.getColor()
        }

        UIKitGroupedCard {
            Item {
                val expanded = remember { mutableStateOf(false) }
                UIKitSettingsExpander(
                    expanded = expanded.value,
                    onClick = {
                        expanded.value = !expanded.value
                    },
                    title = LocalStrings.current.designs.uikitSymbols.tint,
                    icon = FluentIcons.Color,
                    cornerRadius = 0.dp
                ) {
                    UIKitHSVColorPicker(
                        color = tint.value,
                        onColorChange = {
                            tint.value = it
                        }
                    )

                    val itemHeight = 48.dp

                    val optionalColor = listOf(
                        OptionalColorInfo(getUIKitColors().textFillColorPrimaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.primary, getUIKitColors().contentFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().textFillColorPrimaryBrushReversed, LocalStrings.current.designs.fluentIcons.options.colors.reversed, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().highlightColorPrimaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.highlight, UIKitColors.getDark().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().successGreenColorPrimaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.success, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().warningYellowColorPrimaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.warning, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().errorRedColorPrimaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.error, UIKitColors.getDark().textFillColorPrimaryBrush),
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
                                        .clip(RoundedCornerShape(getUIKitShapes().cardRounded))
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
            Divider()
            Item {
                val background = remember { mutableStateOf(state.backgroundColor.value.toHsv()) }

                LaunchedEffect(background.value) {
                    state.backgroundColor.value = background.value.getColor()
                }

                val expanded = remember { mutableStateOf(false) }
                UIKitSettingsExpander(
                    expanded = expanded.value,
                    onClick = {
                        expanded.value = !expanded.value
                    },
                    title = LocalStrings.current.designs.fluentIcons.options.backgroundColor,
                    icon = FluentIcons.PaintBucket,
                    cornerRadius = 0.dp
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
                        OptionalColorInfo(getUIKitColors().contentFillColorPrimaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.primary, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().contentFillColorSecondaryBrush, LocalStrings.current.designs.fluentIcons.options.colors.secondary, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().highlightColorFourthBrush, LocalStrings.current.designs.fluentIcons.options.colors.highlight, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().successGreenColorFourthBrush, LocalStrings.current.designs.fluentIcons.options.colors.success, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().warningYellowColorFourthBrush, LocalStrings.current.designs.fluentIcons.options.colors.warning, getUIKitColors().textFillColorPrimaryBrush),
                        OptionalColorInfo(getUIKitColors().errorRedColorFourthBrush, LocalStrings.current.designs.fluentIcons.options.colors.error, getUIKitColors().textFillColorPrimaryBrush),
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
                                        .clip(RoundedCornerShape(getUIKitShapes().cardRounded))
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
            }
        }
    }
}

private class SymbolConfig {
    val state = mutableStateOf(0)
    val visible = mutableStateOf(true)
    val bounceTrigger = mutableStateOf(false)
    val variableColorActive = mutableStateOf(false)
    val pulseActive = mutableStateOf(false)
    val progress = mutableStateOf(1f)
}

private fun LazyListScope.SymbolOptions(
    commonConfig: CommonConfig,
    symbol: UIKitSymbol,
    config: SymbolConfig
) {
    item {
        val states = symbol.abilityStatement?.firstOrNull { it is UIKitSymbolAbility.MultiState } as? UIKitSymbolAbility.MultiState
        if (states != null && states.states.isNotEmpty()) {
            StateSelector(
                states = states.states.map {
                    StateSelectorItem(
                        state = it
                    ) {
                        UIKitIcon(
                            symbol = symbol,
                            contentDescription = LocalStrings.current.designs.uikitSymbols.example,
                            symbolStyle = commonConfig.symbolStyle,
                            symbolEffect = UIKitSymbolEffect()
                                .stateEffect(it)
                        )
                    }
                },
                state = config.state
            )

            Spacer(Modifier.height(getUIKitLayout().itemSpacing))
        }
    }

    item {
        UIKitGroupedCard {
            SettingCard(
                icon = FluentIcons.Flash,
                title = LocalStrings.current.designs.uikitSymbols.effect.visible,
                onClick = {
                    config.visible.value = !config.visible.value
                }
            ) {
                UIKitToggleSwitch(
                    checked = config.visible.value,
                    onCheckedChange = { config.visible.value = it }
                )
            }
            if (symbol.abilityStatement?.any { it is UIKitSymbolAbility.Bounce } == true) {
                Divider()
                SettingCard(
                    title = LocalStrings.current.designs.uikitSymbols.effect.bounce,
                    icon = FluentIcons.Fire,
                    onClick = {
                        config.bounceTrigger.value = !config.bounceTrigger.value
                    }
                )
            }
            if (symbol.abilityStatement?.any { it is UIKitSymbolAbility.VariableColor } == true) {
                Divider()
                SettingCard(
                    title = LocalStrings.current.designs.uikitSymbols.effect.variableColor,
                    icon = FluentIcons.Fire,
                    onClick = {
                        config.variableColorActive.value = !config.variableColorActive.value
                    }
                ) {
                    UIKitToggleSwitch(
                        checked = config.variableColorActive.value,
                        onCheckedChange = { config.variableColorActive.value = it }
                    )
                }
            }
            if (symbol.abilityStatement?.any { it is UIKitSymbolAbility.Pulse } == true) {
                Divider()
                SettingCard(
                    title = LocalStrings.current.designs.uikitSymbols.effect.pulse,
                    icon = FluentIcons.Fire,
                    onClick = {
                        config.pulseActive.value = !config.pulseActive.value
                    }
                ) {
                    UIKitToggleSwitch(
                        checked = config.pulseActive.value,
                        onCheckedChange = { config.pulseActive.value = it }
                    )
                }
            }
            if (symbol.abilityStatement?.any { it is UIKitSymbolAbility.Progressable } == true) {
                Divider()
                Item {
                    CommonSlider(
                        state = config.progress
                    )
                }
            }
        }
    }

    item {
        Spacer(Modifier.height(getUIKitLayout().sectionSpacing))

        Text(
            text = LocalStrings.current.designs.uikitSymbols.commonOptions,
            style = getUIKitTypography().subtitle,
            color = getUIKitColors().textFillColorPrimaryBrush
        )

        Spacer(Modifier.height(getUIKitLayout().subheadSpacing))
    }

    CommonOptions(
        commonConfig,
        (symbol.abilityStatement?.firstOrNull { it is UIKitSymbolAbility.MultiState } as? UIKitSymbolAbility.MultiState)?.states?.getOrNull(config.state.value) ?:"default",
        symbol
    )
}

@Composable
@Preview
private fun SymbolViewPreview() {
    Box(
        modifier = Modifier
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {
        SymbolView(UIKitSymbols.media.Volume, CommonConfig(
            style = Monochrome,
            tint = getUIKitColors().highlightColorPrimaryBrush,
            backgroundColor = getUIKitColors().contentFillColorSecondaryBrush
        ), PaddingValues(getUIKitLayout().screenSideSpacing))
    }
}

@Composable
private fun SymbolView(
    symbol: UIKitSymbol,
    commonConfig: CommonConfig,
    paddingValues: PaddingValues,
) {
    val symbolConfig = remember { SymbolConfig() }

    Column {
        Box(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = paddingValues.calculateStartPadding(LocalLayoutDirection.current),
                    end = paddingValues.calculateEndPadding(LocalLayoutDirection.current),
                )
                .dropShadow(shadow = UIKitShadowMaterial.getPrimary(), shape = RoundedCornerShape(getUIKitShapes().cardRounded))
                .clip(RoundedCornerShape(getUIKitShapes().cardRounded))
                .background(commonConfig.backgroundColor.value)
                .padding(getUIKitLayout().cardPadding)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            UIKitIcon(
                modifier = Modifier
                    .fillMaxWidth(0.6f),
                symbol = symbol,
                contentDescription = LocalStrings.current.designs.uikitSymbols.preview,
                symbolStyle = commonConfig.symbolStyle,
                symbolEffect = UIKitSymbolEffect()
                    .visibleEffect(symbolConfig.visible.value)
                    .stateEffect((symbol.abilityStatement?.firstOrNull { it is UIKitSymbolAbility.MultiState } as? UIKitSymbolAbility.MultiState)?.states?.getOrNull(
                        symbolConfig.state.value
                    ) ?: "default")
                    .bounceEffect(symbolConfig.bounceTrigger.value)
                    .variableColorEffect(symbolConfig.variableColorActive.value)
                    .pulseEffect(symbolConfig.pulseActive.value)
                    .progressibleEffect(symbolConfig.progress.value)
            )
        }

        Spacer(Modifier.height(getUIKitLayout().sectionSpacing))

        LazyColumn(
            contentPadding = PaddingValues(
                start = paddingValues.calculateStartPadding(LocalLayoutDirection.current),
                end = paddingValues.calculateEndPadding(LocalLayoutDirection.current),
                bottom = paddingValues.calculateBottomPadding()
            )
        ) {
            SymbolOptions(
                commonConfig = commonConfig,
                symbol = symbol,
                config = symbolConfig
            )
        }
    }
}