package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.BranchRequestDraft: ImageVector
    get() {
        if (_BranchRequestDraft != null) {
            return _BranchRequestDraft!!
        }
        _BranchRequestDraft = ImageVector.Builder(
            name = "BranchRequestDraft",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(5.5f, 7.959f)
                curveTo(6.919f, 7.72f, 8f, 6.486f, 8f, 5f)
                curveTo(8f, 3.343f, 6.657f, 2f, 5f, 2f)
                curveTo(3.343f, 2f, 2f, 3.343f, 2f, 5f)
                curveTo(2f, 6.486f, 3.081f, 7.72f, 4.5f, 7.959f)
                verticalLineTo(12.042f)
                curveTo(3.081f, 12.28f, 2f, 13.514f, 2f, 15f)
                curveTo(2f, 16.657f, 3.343f, 18f, 5f, 18f)
                curveTo(6.657f, 18f, 8f, 16.657f, 8f, 15f)
                curveTo(8f, 13.514f, 6.919f, 12.28f, 5.5f, 12.042f)
                verticalLineTo(7.959f)
                close()
                moveTo(18f, 15f)
                curveTo(18f, 16.657f, 16.657f, 18f, 15f, 18f)
                curveTo(13.343f, 18f, 12f, 16.657f, 12f, 15f)
                curveTo(12f, 13.343f, 13.343f, 12f, 15f, 12f)
                curveTo(16.657f, 12f, 18f, 13.343f, 18f, 15f)
                close()
                moveTo(16.25f, 8.5f)
                curveTo(16.25f, 9.19f, 15.69f, 9.75f, 15f, 9.75f)
                curveTo(14.31f, 9.75f, 13.75f, 9.19f, 13.75f, 8.5f)
                curveTo(13.75f, 7.81f, 14.31f, 7.25f, 15f, 7.25f)
                curveTo(15.69f, 7.25f, 16.25f, 7.81f, 16.25f, 8.5f)
                close()
                moveTo(15f, 5.25f)
                curveTo(15.69f, 5.25f, 16.25f, 4.69f, 16.25f, 4f)
                curveTo(16.25f, 3.31f, 15.69f, 2.75f, 15f, 2.75f)
                curveTo(14.31f, 2.75f, 13.75f, 3.31f, 13.75f, 4f)
                curveTo(13.75f, 4.69f, 14.31f, 5.25f, 15f, 5.25f)
                close()
            }
        }.build()

        return _BranchRequestDraft!!
    }

@Suppress("ObjectPropertyName")
private var _BranchRequestDraft: ImageVector? = null
