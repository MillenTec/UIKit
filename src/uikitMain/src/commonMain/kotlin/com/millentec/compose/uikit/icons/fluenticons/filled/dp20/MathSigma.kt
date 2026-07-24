package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.MathSigma: ImageVector
    get() {
        if (_MathSigma != null) {
            return _MathSigma!!
        }
        _MathSigma = ImageVector.Builder(
            name = "MathSigma",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(3.81f, 3.706f)
                curveTo(3.928f, 3.43f, 4.199f, 3.25f, 4.5f, 3.25f)
                horizontalLineTo(15.5f)
                curveTo(15.914f, 3.25f, 16.25f, 3.586f, 16.25f, 4f)
                curveTo(16.25f, 4.414f, 15.914f, 4.75f, 15.5f, 4.75f)
                horizontalLineTo(6.262f)
                lineTo(10.408f, 9.058f)
                curveTo(10.673f, 9.334f, 10.688f, 9.765f, 10.443f, 10.059f)
                lineTo(6.104f, 15.25f)
                horizontalLineTo(15.5f)
                curveTo(15.914f, 15.25f, 16.25f, 15.586f, 16.25f, 16f)
                curveTo(16.25f, 16.414f, 15.914f, 16.75f, 15.5f, 16.75f)
                horizontalLineTo(4.5f)
                curveTo(4.209f, 16.75f, 3.944f, 16.581f, 3.821f, 16.318f)
                curveTo(3.697f, 16.054f, 3.738f, 15.743f, 3.925f, 15.519f)
                lineTo(8.86f, 9.613f)
                lineTo(3.96f, 4.52f)
                curveTo(3.751f, 4.303f, 3.692f, 3.983f, 3.81f, 3.706f)
                close()
            }
        }.build()

        return _MathSigma!!
    }

@Suppress("ObjectPropertyName")
private var _MathSigma: ImageVector? = null
