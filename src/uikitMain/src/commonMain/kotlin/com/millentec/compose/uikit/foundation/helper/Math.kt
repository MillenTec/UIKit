package com.millentec.compose.uikit.foundation.helper

fun Double.mapTo(from: ClosedRange<Double>, to: ClosedRange<Double>): Double {
    val fromStart = from.start
    val fromEnd = from.endInclusive
    val toStart = to.start
    val toEnd = to.endInclusive

    if (fromEnd == fromStart) return toStart

    return toStart + (toEnd - toStart) * (this - fromStart) / (fromEnd - fromStart)
}

fun Int.mapTo(from: IntRange, to: IntRange): Double {
    return this.toDouble().mapTo(
        from.first.toDouble()..from.last.toDouble(),
        to.first.toDouble()..to.last.toDouble()
    )
}

fun Float.mapTo(from: ClosedRange<Float>, to: ClosedRange<Float>): Double {
    return this.toDouble().mapTo(
        from.start.toDouble()..from.endInclusive.toDouble(),
        to.start.toDouble()..to.endInclusive.toDouble()
    )
}