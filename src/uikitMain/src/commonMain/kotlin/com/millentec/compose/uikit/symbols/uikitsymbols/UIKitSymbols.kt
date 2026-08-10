package com.millentec.compose.uikit.symbols.uikitsymbols

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize

object UIKitSymbols {
    val regular = UIKitRegularSymbols()
    val filled = UIKitFilledSymbols()
    val animatable = UIKitAnimatableSymbols()
    val resizeable = UIKitResizableSymbols()

    object Filled
    object AnimatableIcons
    object ResizableIcons
}

class UIKitRegularSymbols { internal constructor() }
class UIKitFilledSymbols { internal constructor() }
class UIKitAnimatableSymbols { internal constructor() }
class UIKitResizableSymbols { internal constructor() }

abstract class UIKitSymbol(
    val name: String,
    val defaultSize: DpSize,
    brushes: List<Brush>
) {
    private val _brushes = brushes.toMutableList()
    val brushes: List<Brush>
        get() = _brushes.toList()

    fun resetBrushes(brushes: List<Brush>) {
        _brushes.clear()
        _brushes.addAll(brushes)
    }

    @Composable
    abstract fun Draw(
        modifier: Modifier
    )
}

abstract class UIKitStaticSymbol(
    name: String,
    defaultSize: DpSize,
    brushes: List<Brush>
): UIKitSymbol(name, defaultSize, brushes) {
    private var cachedVector: ImageVector? = null
    private var cachedKey: Any? = null

    internal fun buildWithKey(key: Any?): ImageVector {
        return when {
            key == null -> builder()
            key === Unit -> {
                if (cachedVector == null) cachedVector = builder()
                cachedVector!!
            }
            key != cachedKey -> {
                cachedVector = builder()
                cachedKey = key
                cachedVector!!
            }
            else -> cachedVector!!
        }
    }

    internal abstract fun builder(): ImageVector

    @Composable
    override fun Draw(modifier: Modifier) {
        val painter = rememberVectorPainter(buildWithKey(this.brushes))

        Canvas(
            modifier = modifier
        ) {
            with(painter) {
                translate(
                    top = 0f,
                    left = 0f
                ) {
                    draw(
                        size = size,
                    )
                }
            }
        }
    }

    open fun asImageVector(): ImageVector {
        return builder()
    }
}

abstract class UIKitAnimatableSymbol(
    name: String,
    defaultSize: DpSize,
    brushes: List<Brush>
): UIKitSymbol(name, defaultSize, brushes)

abstract class UIKitResizableSymbol(
    name: String,
    defaultSize: DpSize,
    initialLineWidth: Dp,
    brushes: List<Brush>
): UIKitSymbol(name, defaultSize, brushes) {
    var lineWidth = initialLineWidth
        private set

    private var cachedVector: ImageVector? = null
    private var cachedKey: Any? = null

    internal fun buildWithKey(key: Any?): ImageVector {
        return when {
            key == null -> builder()
            key === Unit -> {
                if (cachedVector == null) cachedVector = builder()
                cachedVector!!
            }
            key != cachedKey -> {
                cachedVector = builder()
                cachedKey = key
                cachedVector!!
            }
            else -> cachedVector!!
        }
    }

    internal abstract fun builder(): ImageVector

    @Composable
    override fun Draw(modifier: Modifier) {
        val painter = rememberVectorPainter(buildWithKey(listOf(this.brushes, this.lineWidth)))

        Canvas(
            modifier = modifier
        ) {
            with(painter) {
                translate(
                    top = 0f,
                    left = 0f
                ) {
                    draw(
                        size = size,
                    )
                }
            }
        }
    }

    open fun asImageVector(): ImageVector {
        return builder()
    }

    open fun resize(lineWidth: Dp) {
        this.lineWidth = lineWidth
    }
}