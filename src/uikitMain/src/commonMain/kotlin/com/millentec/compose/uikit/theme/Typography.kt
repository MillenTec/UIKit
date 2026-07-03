package com.millentec.compose.uikit.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class Typography(
    val display: TextStyle = TextStyle(
        fontSize = 55.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 66.sp
    ),
    val largeTitle: TextStyle = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 41.sp
    ),
    val title: TextStyle = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 34.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp
    ),
    val body: TextStyle = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp
    ),
    val footnote: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 19.sp
    )
)
