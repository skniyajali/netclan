package com.niyaj.designsystem.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val fontFamily = FontFamily.Default

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        letterSpacing = 0.15.sp
    ),
    h6 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.5.sp
    ),
    caption = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ),
)