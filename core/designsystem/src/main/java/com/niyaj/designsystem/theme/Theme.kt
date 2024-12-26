package com.niyaj.designsystem.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColors(
    primary = primaryColor,
    primaryVariant = surfaceVariant,

    secondary = secondaryColor,
    secondaryVariant = containerColor,

    surface = surfaceColor,
)

@Composable
fun AppTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    androidTheme: Boolean = false,
//    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = LightColorScheme,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}