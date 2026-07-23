package com.millentec.compose.uikit.views.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.millentec.compose.uikit.IconGalleryList
import com.millentec.compose.uikit.component.input.*
import com.millentec.compose.uikit.component.layout.*
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.mapTo
import com.millentec.compose.uikit.foundation.uikitClickable
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.animatable.Download
import com.millentec.compose.uikit.icons.fluenticons.animatable.UIKitDownloadState
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.icons.fluenticons.resizeable.shapes
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import kotlin.math.ceil
import kotlin.math.floor

private data class IconInfo(
    val iconName: String,
    val iconSize: String,
)

private class OptionState(
    initialTint: Color,
    initialBackground: Color,
    initialLayered: Boolean = false
) {
    val tintColor = mutableStateOf(initialTint)
    val backgroundColor = mutableStateOf(initialBackground)
    val isLayered = mutableStateOf(initialLayered)
    val iconPreview = mutableStateOf<(@Composable BoxScope.() -> Unit)?>(null)
    val extendedOptions = mutableStateOf<(@Composable ColumnScope.() -> Unit)?>(null)
    val iconInfo = mutableStateOf<IconInfo?>(null)
}

@Composable
@Preview
private fun OptionsWindowPreview() {
    val optionState = OptionState(
        initialTint = getUIKitColors().textFillColorPrimaryBrush,
        initialBackground = getUIKitColors().contentFillColorSecondaryBrush
    )

    optionState.iconPreview.value = {
        BoxWithConstraints {
            Icon(
                modifier = Modifier
                    .size(maxWidth * 0.6f),
                imageVector = FluentIcons.Symbols,
                contentDescription = null,
                tint = optionState.tintColor.value,
            )
        }
    }

    optionState.iconInfo.value = IconInfo(
        iconName = "Symbols",
        iconSize = "20 x 20"
    )

    OptionsWindow(
        optionState
    )
}

private data class OptionalColorInfo(
    val color: Color,
    val name: String,
    val contentColor: Color
)

@Composable
private fun OptionsWindow(
    state: OptionState,
) {
    val tintColorPickerExpanded = remember { mutableStateOf(false) }
    val backgroundColorPickerExpanded = remember { mutableStateOf(false) }
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(getUIKitLayout().x2Spacing)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                .fillMaxWidth()
                                .background(getUIKitColors().contentFillColorSecondaryBrush)
                                .padding(getUIKitLayout().mediumSpacing),
                            contentAlignment = Alignment.Center,
                            content = state.iconPreview.value ?: {}
                        )

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Info",
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                            HorizontalDivider(
                                thickness = 1.dp,
                                color = getUIKitColors().lineFillColorPrimaryBrush
                            )
                        }

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        UIKitSettingCard(
                            icon = FluentIcons.Tag,
                            title = "Name",
                            onClick = {}
                        ) {
                            Text(
                                text = state.iconInfo.value?.iconName ?: "Unknown",
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )
                        }

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        UIKitSettingCard(
                            icon = FluentIcons.Resize,
                            title = "Size",
                            onClick = {}
                        ) {
                            Text(
                                text = state.iconInfo.value?.iconSize ?: "Unknown",
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )
                        }

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.extendedOptions.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Extension",
                            style = getUIKitTypography().body,
                            color = getUIKitColors().textFillColorSecondaryBrush
                        )

                        Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                        HorizontalDivider(
                            thickness = 1.dp,
                            color = getUIKitColors().lineFillColorPrimaryBrush
                        )
                    }

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.extendedOptions.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column(
                        content = state.extendedOptions.value ?: {}
                    )
                }
            }
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "General",
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorSecondaryBrush
                )

                Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = getUIKitColors().lineFillColorPrimaryBrush
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                icon = FluentIcons.layerDiagonal(getUIKitColors().textFillColorPrimaryBrush, true),
                title = "Layered Icon",
                onClick = {
                    state.isLayered.value = !state.isLayered.value
                }
            ) {
                UIKitToggleSwitch(
                    checked = state.isLayered.value,
                    onCheckedChange = {
                        state.isLayered.value = it
                    }
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }
        
        item {
            UIKitSettingsExpander(
                expanded = tintColorPickerExpanded.value,
                onClick = {
                    tintColorPickerExpanded.value = !tintColorPickerExpanded.value
                },
                title = "Tint Color",
                icon = FluentIcons.PaintBrush
            ) {
                UIKitHSVColorPicker(
                    color = state.tintColor.value.toHsv(),
                    onColorChange = {
                        state.tintColor.value = it.getColor()
                    }
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

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
                                            state.tintColor.value = optionalColor[it].color
                                        },
                                        indication = if (isDesktopOS()) null else ripple()
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

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingsExpander(
                expanded = backgroundColorPickerExpanded.value,
                onClick = {
                    backgroundColorPickerExpanded.value = !backgroundColorPickerExpanded.value
                },
                title = "Background Color",
                icon = FluentIcons.PaintBucket
            ) {
                UIKitHSVColorPicker(
                    color = state.backgroundColor.value.toHsv(),
                    onColorChange = {
                        state.backgroundColor.value = it.getColor()
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
                                            state.backgroundColor.value = optionalColor[it].color
                                        },
                                        indication = if (isDesktopOS()) null else ripple()
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

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }
    }
}

@Composable
@Preview
private fun IconItemPreview() {
    Box(
        modifier = Modifier
            .size(128.dp)
    ) {
        IconItem(
            title = "Icon",
            onClick = {},
            background = getUIKitColors().contentFillColorSecondaryBrush,
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                imageVector = FluentIcons.Tag,
                contentDescription = null,
                tint = getUIKitColors().textFillColorPrimaryBrush
            )
        }
    }
}

@Composable
private fun IconItem(
    title: String,
    onClick: () -> Unit,
    background: Color,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(getUIKitLayout().smallSpacing)
            .clip(RoundedCornerShape(getUIKitShapes().mediumRounded))
            .background(background)
            .uikitClickable(
                onClick = onClick,
                indication = if (isDesktopOS()) null else ripple()
            )
            .padding(getUIKitLayout().mediumSpacing),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            content()
        }

        Spacer(Modifier.height(getUIKitLayout().smallSpacing))

        Text(
            text = title,
            style = getUIKitTypography().body,
            color = getUIKitColors().textFillColorPrimaryBrush,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview
fun IconsGallery() {
    val uikitTheme = getUIKitTheme()
    val optionsState = remember { OptionState(
        initialTint = uikitTheme.colors.textFillColorPrimaryBrush,
        initialBackground = uikitTheme.colors.contentFillColorSecondaryBrush
    ) }
    val iconLists = remember { mutableStateOf(IconGalleryList(
        optionsState.tintColor.value,
        optionsState.isLayered.value
    )) }
    val checkedIconIndex = remember { mutableStateOf<Int?>(null) }
    val bottomSheetState = remember { UIKitBottomSheetState(
        expanded = false
    ) }
    val animatableIconList = remember { makeAnimatableIconList(optionsState) }

    LaunchedEffect(Unit) {
        MainViewModel.navigationDockVisible(false)
    }

    LaunchedEffect(optionsState.isLayered.value, optionsState.tintColor.value) {
        iconLists.value = IconGalleryList(
            optionsState.tintColor.value,
            optionsState.isLayered.value
        )
    }

    LaunchedEffect(checkedIconIndex.value) {
        optionsState.extendedOptions.value = null
        optionsState.iconPreview.value = if (checkedIconIndex.value == null) null else {
            if ((checkedIconIndex.value ?: return@LaunchedEffect) < iconLists.value.regularIconsList.size) {
                {
                    BoxWithConstraints {
                        Icon(
                            modifier = Modifier
                                .size(maxWidth * 0.6f),
                            imageVector = iconLists.value.regularIconsList.getOrNull(checkedIconIndex.value ?: return@BoxWithConstraints) ?: return@BoxWithConstraints,
                            contentDescription = null,
                            tint = optionsState.tintColor.value,
                        )
                    }
                }
            } else {
                {
                    BoxWithConstraints {
                        Icon(
                            modifier = Modifier
                                .size(maxWidth * 0.6f),
                            imageVector = iconLists.value.filledIconsList.getOrNull((checkedIconIndex.value ?: return@BoxWithConstraints) - iconLists.value.regularIconsList.size) ?: return@BoxWithConstraints,
                            contentDescription = null,
                            tint = optionsState.tintColor.value,
                        )
                    }
                }
            }
        }
    }

    BoxWithConstraints {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush)
                .uikitBottomSheetCollaborativeAnimation(
                    state = bottomSheetState,
                    onClick = {
                        bottomSheetState.expanded.value = false
                    }
                )
        ) {
            Row {
                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1f),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    contentPadding = PaddingValues(
                        horizontal = getUIKitLayout().x4Spacing
                    )
                ) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column(
                            modifier = Modifier
                                .safeDrawingPadding()
                        ) {
                            Spacer(Modifier.height(getUIKitLayout().x6Spacing))

                            Text(
                                text = "Icons Gallery",
                                style = getUIKitTypography().largeTitle,
                                color = getUIKitColors().textFillColorPrimaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().x4Spacing))
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Text(
                                text = "Regular Icons",
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().mediumSpacing))
                        }
                    }

                    items(iconLists.value.regularIconsList.size) {
                        val icon = iconLists.value.regularIconsList.getOrNull(it)

                        IconItem(
                            title = icon?.name ?: "Unknown",
                            onClick = {
                                checkedIconIndex.value = it
                            },
                            background = optionsState.backgroundColor.value
                        ) {
                            if (icon != null) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = optionsState.tintColor.value
                                )
                            }
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Spacer(Modifier.height(getUIKitLayout().mediumSpacing))

                            Text(
                                text = "Filled Icons",
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().mediumSpacing))
                        }
                    }

                    items(iconLists.value.filledIconsList.size) {
                        val icon = iconLists.value.filledIconsList.getOrNull(it)

                        IconItem(
                            title = icon?.name ?: "Unknown",
                            onClick = {
                                checkedIconIndex.value = it + iconLists.value.regularIconsList.size
                            },
                            background = optionsState.backgroundColor.value
                        ) {
                            if (icon != null) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = optionsState.tintColor.value
                                )
                            }
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Spacer(Modifier.height(getUIKitLayout().mediumSpacing))

                            Text(
                                text = "Animatable Icons",
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().mediumSpacing))
                        }
                    }

                    items(animatableIconList.size) {
                        val item = animatableIconList.getOrNull(it)

                        IconItem(
                            title = item?.name ?: "Unknown",
                            onClick = {
                                optionsState.iconPreview.value = {
                                    BoxWithConstraints {
                                        item?.IconContent(
                                            modifier = Modifier
                                                .size(maxWidth * 0.6f)
                                        )
                                    }
                                }
                                optionsState.extendedOptions.value = {
                                    item?.ExtendedOptions()
                                }
                                optionsState.iconInfo.value = IconInfo(
                                    iconName = item?.name ?: "Unknown",
                                    iconSize = item?.size ?: "Unknown",
                                )
                            },
                            background = optionsState.backgroundColor.value
                        ) {
                            item?.IconContent(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .aspectRatio(1f)
                            )
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Spacer(Modifier.height(getUIKitLayout().x4Spacing))
                    }
                }

                AnimatedVisibility(
                    visible = this@BoxWithConstraints.maxWidth >= 1024.dp,
                    enter = slideInHorizontally(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ) {
                        it
                    },
                    exit = slideOutHorizontally(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ) {
                        it
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .width(420.dp)
                            .fillMaxHeight()
                    ) {
                        Spacer(Modifier.height(getUIKitLayout().x6Spacing + (WindowInsets.safeDrawing.getTop(LocalDensity.current) / LocalDensity.current.density).dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(41.dp),
                                imageVector = FluentIcons.options(getUIKitColors().textFillColorPrimaryBrush, true),
                                contentDescription = "Options",
                                tint = getUIKitColors().textFillColorPrimaryBrush
                            )

                            Spacer(Modifier.width(getUIKitLayout().mediumSpacing))

                            Text(
                                text = "Icons Gallery",
                                style = getUIKitTypography().largeTitle,
                                color = getUIKitColors().textFillColorPrimaryBrush
                            )
                        }

                        OptionsWindow(
                            optionsState
                        )
                    }
                }
            }
        }

        UIKitBottomSheet(
            modifier = Modifier
                .fillMaxSize(),
            state = bottomSheetState,
            maxHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            minHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            title = "Options"
        ) {
            OptionsWindow(
                optionsState
            )
        }
    }
}

private open class AnimatableIconItem(
    val name: String,
    val size: String,
    initialProgress: Float = 0f,
    initialLineWidth: Dp = 1.dp,
    initialState: Int = 0,
    initialGeneralOptionsState: OptionState,
) {
    // 几个属性, 故在基类中定义使用
    val progressProperty = mutableStateOf(initialProgress)
    val lineWidthProperty = mutableStateOf(initialLineWidth)
    val stateProperty = mutableStateOf(initialState)
    val generalOptionsStateProperty = initialGeneralOptionsState

    @Composable
    open fun IconContent(modifier: Modifier = Modifier) {}

    @Composable
    open fun ExtendedOptions() {}

    @Composable
    open fun ProgressSlider() {
        val uikitTheme = getUIKitTheme()
        val isAnimatedChange = remember { mutableStateOf(false) }
        val progress = remember { mutableStateOf(progressProperty.value) }
        val progressAnimated = remember { Animatable(
            initialValue = progress.value,
            typeConverter = Float.VectorConverter,
        ) }

        LaunchedEffect(progress.value) {
            if (isAnimatedChange.value) {
                progressAnimated.animateTo(
                    targetValue = progress.value,
                    animationSpec = tween(
                        uikitTheme.animate.motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            } else {
                progressAnimated.snapTo(progress.value)
            }
        }

        LaunchedEffect(progressAnimated.value) {
            progressProperty.value = progressAnimated.value
        }

        @Composable
        fun arc(progress: Float) {
            Canvas(
                modifier = Modifier
                    .size(22.dp)
                    .aspectRatio(1f)
            ) {
                scale(
                    scale = size.width / 20.dp.toPx()
                ) {
                    translate(
                        top = size.height / 2 - 15.dp.toPx() / 2,
                        left = size.width / 2 - 15.dp.toPx() / 2
                    ) {
                        drawArc(
                            color = uikitTheme.colors.textFillColorPrimaryBrush.copy(0.3f),
                            startAngle = -90f,
                            sweepAngle = 360f,
                            useCenter = false,
                            size = Size(
                                width = 15.dp.toPx(),
                                height = 15.dp.toPx()
                            ),
                            style = Stroke(
                                width = 1.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )

                        drawArc(
                            color = uikitTheme.colors.textFillColorPrimaryBrush,
                            startAngle = -90f,
                            sweepAngle = progress.coerceIn(0f..1f) * 360f,
                            useCenter = false,
                            size = Size(
                                width = 15.dp.toPx(),
                                height = 15.dp.toPx()
                            ),
                            style = Stroke(
                                width = 1.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .background(getUIKitColors().contentFillColorSecondaryBrush)
                .padding(getUIKitLayout().basicSpacing)
        ) {
            arc(0.2f)
            
            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            UIKitSlider(
                modifier = Modifier
                    .weight(1f),
                value = progress.value,
                onValueChange = { value, type ->
                    isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                    progress.value = value
                },
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            arc(0.8f)
        }
    }

    @Composable
    open fun LineWidthSlider() {
        val uikitTheme = getUIKitTheme()
        val isAnimatedChange = remember { mutableStateOf(false) }
        val lineWidth = remember { mutableStateOf(lineWidthProperty.value) }
        val lineWidthAnimated = remember { Animatable(
            initialValue = lineWidth.value,
            typeConverter = Dp.VectorConverter,
        ) }

        LaunchedEffect(lineWidth.value) {
            if (isAnimatedChange.value) {
                lineWidthAnimated.animateTo(
                    targetValue = lineWidth.value,
                    animationSpec = tween(
                        uikitTheme.animate.motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            } else {
                lineWidthAnimated.snapTo(lineWidth.value)
            }
        }

        LaunchedEffect(lineWidthAnimated.value) {
            lineWidthProperty.value = lineWidthAnimated.value
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .background(getUIKitColors().contentFillColorSecondaryBrush)
                .padding(getUIKitLayout().basicSpacing)
        ) {
            Icon(
                modifier = Modifier
                    .size(22.dp),
                imageVector = FluentIcons.ResizableIcons.shapes(getUIKitColors().textFillColorPrimaryBrush, true, 0.5f),
                contentDescription = "Thin",
                tint = getUIKitColors().textFillColorPrimaryBrush,
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            UIKitSlider(
                modifier = Modifier
                    .weight(1f),
                value = lineWidth.value.value.mapTo(
                    from = 0.5f..3f,
                    to = 0f..1f
                ).toFloat(),
                hasTick = true,
                tickStep = 0.2f,
                adsorbedOntoTick = false,
                maxValue = 1f,
                onValueChange = { value, type ->
                    val valueDp = value.mapTo(
                        from = 0f..1f,
                        to = 0.5f..3f
                    ).dp

                    isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                    lineWidth.value = valueDp
                },
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            Icon(
                modifier = Modifier
                    .size(22.dp),
                imageVector = FluentIcons.ResizableIcons.shapes(getUIKitColors().textFillColorPrimaryBrush, true, 1.5f),
                contentDescription = "Thin",
                tint = getUIKitColors().textFillColorPrimaryBrush,
            )
        }
    }

    @Composable
    open fun StateSelector(
        states: List<StateSelectorItem>,
        itemWidth: Dp = 148.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            states.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier
                        .padding(
                            top = getUIKitLayout().basicSpacing,
                            bottom = getUIKitLayout().basicSpacing,
                            end = if (index == states.size - 1) 0.dp else getUIKitLayout().basicSpacing,
                        )
                        .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                        .width(itemWidth)
                        .background(getUIKitColors().contentFillColorSecondaryBrush)
                        .uikitClickable(
                            onClick = {
                                stateProperty.value = index
                            },
                            indication = if (isDesktopOS()) null else ripple()
                        )
                        .padding(getUIKitLayout().mediumSpacing),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentAlignment = Alignment.Center,
                        content = item.statePreview
                    )

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                    Text(
                        text = item.state,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

private data class StateSelectorItem(
    val state: String,
    val statePreview: @Composable BoxScope.() -> Unit
)

private fun makeAnimatableIconList(
    providedOptionsState: OptionState
) = listOf<AnimatableIconItem>(
    object: AnimatableIconItem(
        name = "Download",
        size = "20 x 20",
        initialGeneralOptionsState = providedOptionsState
    ) {
        val resetProgressOnError = mutableStateOf(true)
        val autoTint = mutableStateOf(true)

        @Composable
        override fun ExtendedOptions() {
            Column {
                StateSelector(
                    states = listOf(
                        StateSelectorItem("Downloading") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitDownloadState.Downloading,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Stopped") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitDownloadState.Stopped,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Error") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = if (resetProgressOnError.value) 0f else progressProperty.value,
                                state = UIKitDownloadState.Error,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Success") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitDownloadState.Success,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                    )
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitSettingCard(
                    title = "Reset Progress On Error",
                    onClick = {
                        resetProgressOnError.value = !resetProgressOnError.value
                    },
                    icon = FluentIcons.dismissCircle(getUIKitColors().textFillColorPrimaryBrush, true)
                ) {
                    UIKitToggleSwitch(
                        checked = resetProgressOnError.value,
                        onCheckedChange = { resetProgressOnError.value = it },
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitSettingCard(
                    title = "Auto Tint",
                    onClick = {
                        autoTint.value = !autoTint.value
                    },
                    icon = FluentIcons.dismissCircle(getUIKitColors().textFillColorPrimaryBrush, true)
                ) {
                    UIKitToggleSwitch(
                        checked = autoTint.value,
                        onCheckedChange = { autoTint.value = it },
                    )
                }

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                ProgressSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                LineWidthSlider()
            }
        }

        @Composable
        override fun IconContent(modifier: Modifier) {
            if (autoTint.value) {
                FluentIcons.AnimatableIcons.Download(
                    modifier = modifier,
                    progress = progressProperty.value,
                    state = UIKitDownloadState.entries[stateProperty.value],
                    resetProgressOnError = resetProgressOnError.value,
                    lineWidth = lineWidthProperty.value
                )
            } else {
                FluentIcons.AnimatableIcons.Download(
                    modifier = modifier,
                    progress = progressProperty.value,
                    state = UIKitDownloadState.entries[stateProperty.value],
                    resetProgressOnError = resetProgressOnError.value,
                    lineWidth = lineWidthProperty.value,
                    tint = generalOptionsStateProperty.tintColor.value
                )
            }
        }
    }
)

@Composable
@Preview
private fun DownloadIconExtendedOptionsPreview() {
    makeAnimatableIconList(OptionState(Color.Unspecified, Color.Unspecified))[0].ExtendedOptions()
}