package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.AcrylicMaterialState
import com.millentec.compose.uikit.foundation.graphics.acrylicMaterial
import com.millentec.compose.uikit.foundation.layout.UIKitHActionButtonsScope
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
//    UIKitHActionButtons(
//
//    ) {
//        Button(
//            symbol = UIKitSymbols.systemUI.Home,
//            contentDescription = "Home",
//            onClick = { }
//        )
//
//        SearchBar(
//            watermark = "Search...",
//            onSearch = {}
//        )
//    }
}

@Composable
fun UIKitHActionButtons(
    modifier: Modifier = Modifier,
    minWidth: Dp = getUIKitLayout().interactiveHotspot,
    acrylicEnabled: Boolean = false,
    acrylicState: AcrylicMaterialState? = null,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    shadowEnabled: Boolean = true,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    content: @Composable UIKitHActionButtonsScope.() -> Unit
) {
    val contentScope = UIKitHActionButtonsScope()
    contentScope.content()

    val densityDpi = LocalDensity.current.density
    val rootSize = remember { mutableStateOf(DpSize.Zero) }

    Row(
        modifier = modifier
            .defaultMinSize(minHeight = minWidth)
            .then(if (shadowEnabled) {
                Modifier.dropShadow(
                    shape = shape,
                    shadow = UIKitShadowMaterial.getMarginal()
                )
            } else Modifier)
            .clip(shape)
            .background(getUIKitColors().contentFillColorSecondaryBrush, shape)
            .then(if (acrylicEnabled && acrylicState != null) {
                Modifier.acrylicMaterial(acrylicState, shape = shape)
            } else Modifier)
            .onSizeChanged {
                rootSize.value = DpSize(
                    (it.width / densityDpi).dp,
                    (it.height / densityDpi).dp
                )
            }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = getUIKitAnimate().standardSpringDampingRatio,
                    stiffness = getUIKitAnimate().standardSpringStiffness
                )
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement
    ) {
        val scope = remember { UIKitHActionButtonsScope() }

        LaunchedEffect(rootSize.value) {
            scope.rootSize.value = rootSize.value
        }

        scope.content()
    }
}