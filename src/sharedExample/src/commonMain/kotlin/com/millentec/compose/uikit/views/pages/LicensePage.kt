package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.views.LocalNavigationDockHeight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import uikit.sharedexample.generated.resources.Res

@Composable
@Preview
fun LicensePage() {
    val licenseContents = remember { mutableStateOf(listOf("Loading...")) }
    val density = LocalDensity.current

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            try {
                val bytes = Res.readBytes("files/LICENSE.txt")
                val string = bytes.decodeToString()
                if (string.isEmpty()) {
                    throw Exception("Read or decoded file is blank")
                }
                licenseContents.value = string.split('\n')
            } catch(e: Exception) {
                licenseContents.value = listOf("Loading failed: ${e.message}")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(
                        start = getUIKitLayout().screenSideSpacing,
                        top = getUIKitLayout().screenSideSpacing,
                        end = getUIKitLayout().screenSideSpacing,
                        bottom = maxOf(
                            LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                            getUIKitLayout().screenSideSpacing
                        )
                    ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
                )
        ) {
            Text(
                text = LocalStrings.current.license.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )

            Spacer(modifier = Modifier.height(getUIKitLayout().titleSpacing))

            Text(
                text = LocalStrings.current.license.description,
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush
            )

            Spacer(modifier = Modifier.height(getUIKitLayout().itemSpacing))

            SelectionContainer {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(if (isDesktopOS()) getUIKitShapes().regularRounded else getUIKitShapes().largeRounded))
                        .background(getUIKitColors().contentFillColorSecondaryBrush)
                        .horizontalScroll(rememberScrollState()),
                    contentPadding = PaddingValues(getUIKitLayout().x2Spacing),
                ) {
                    items(licenseContents.value.size) {
                        Text(
                            text = licenseContents.value[it],
                            style = getUIKitTypography().body,
                            color = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                }
            }
        }
    }
}