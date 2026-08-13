package com.millentec.compose.uikit.symbols.draw

class UIKitPath {
    private val _nodes: MutableList<UIKitPathNode> = mutableListOf()
    val nodes: List<UIKitPathNode>
        get() = _nodes.toList()

    private var subPathStartX: Float = 0f
    private var subPathStartY: Float = 0f

    private val currentX: Float
        get() {
            val pre = _nodes.lastOrNull() ?: return 0f
            return when (pre) {
                is UIKitPathNode.Close -> subPathStartX
                is UIKitPathNode.LineTo -> pre.x
                is UIKitPathNode.MoveTo -> pre.x
                is UIKitPathNode.CurveTo -> pre.x3
            }
        }

    private val currentY: Float
        get() {
            val pre = _nodes.lastOrNull() ?: return 0f
            return when (pre) {
                is UIKitPathNode.Close -> subPathStartY
                is UIKitPathNode.LineTo -> pre.y
                is UIKitPathNode.MoveTo -> pre.y
                is UIKitPathNode.CurveTo -> pre.y3
            }
        }

    fun close() {
        _nodes.add(UIKitPathNode.Close)
    }

    fun moveTo(x: Float, y: Float) {
        subPathStartX = x
        subPathStartY = y
        _nodes.add(UIKitPathNode.MoveTo(x, y))
    }

    fun moveToRelative(dx: Float, dy: Float) {
        val x = currentX + dx
        val y = currentY + dy
        subPathStartX = x
        subPathStartY = y
        _nodes.add(UIKitPathNode.MoveTo(x, y))
    }

    fun lineTo(x: Float, y: Float) {
        _nodes.add(UIKitPathNode.LineTo(x, y))
    }

    fun lineToRelative(dx: Float, dy: Float) {
        _nodes.add(UIKitPathNode.LineTo(currentX + dx, currentY + dy))
    }

    fun horizontalLineTo(x: Float) {
        _nodes.add(UIKitPathNode.LineTo(x, currentY))
    }

    fun horizontalLineToRelative(dx: Float) {
        _nodes.add(UIKitPathNode.LineTo(currentX + dx, currentY))
    }

    fun verticalLineTo(y: Float) {
        _nodes.add(UIKitPathNode.LineTo(currentX, y))
    }

    fun verticalLineToRelative(dy: Float) {
        _nodes.add(UIKitPathNode.LineTo(currentX, currentY + dy))
    }

    fun curveTo(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float) {
        _nodes.add(UIKitPathNode.CurveTo(x1, y1, x2, y2, x3, y3))
    }

    fun curveToRelative(dx1: Float, dy1: Float, dx2: Float, dy2: Float, dx3: Float, dy3: Float) {
        val cx = currentX
        val cy = currentY
        _nodes.add(UIKitPathNode.CurveTo(
            x1 = cx + dx1, y1 = cy + dy1,
            x2 = cx + dx2, y2 = cy + dy2,
            x3 = cx + dx3, y3 = cy + dy3
        ))
    }

    fun reflectiveCurveTo(x1: Float, y1: Float, x2: Float, y2: Float) {
        val pre = _nodes.lastOrNull() ?: return

        val cx1 = when (pre) {
            is UIKitPathNode.CurveTo -> 2 * pre.x3 - pre.x2
            else -> currentX
        }
        val cy1 = when (pre) {
            is UIKitPathNode.CurveTo -> 2 * pre.y3 - pre.y2
            else -> currentY
        }

        _nodes.add(UIKitPathNode.CurveTo(
            x1 = cx1, y1 = cy1,
            x2 = x1, y2 = y1,
            x3 = x2, y3 = y2
        ))
    }

    fun reflectiveCurveToRelative(dx1: Float, dy1: Float, dx2: Float, dy2: Float) {
        val pre = _nodes.lastOrNull() ?: return
        val cx = currentX
        val cy = currentY

        val cx1 = when (pre) {
            is UIKitPathNode.CurveTo -> 2 * pre.x3 - pre.x2
            else -> cx
        }
        val cy1 = when (pre) {
            is UIKitPathNode.CurveTo -> 2 * pre.y3 - pre.y2
            else -> cy
        }

        val cx2 = cx + dx1
        val cy2 = cy + dy1
        val cx3 = cx + dx2
        val cy3 = cy + dy2

        _nodes.add(UIKitPathNode.CurveTo(
            x1 = cx1, y1 = cy1,
            x2 = cx2, y2 = cy2,
            x3 = cx3, y3 = cy3
        ))
    }
}