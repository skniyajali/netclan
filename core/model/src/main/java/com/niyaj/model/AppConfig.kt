package com.niyaj.model

/**
 * Class summarizing user interest data
 */
data class AppConfig(
    val themeBrand: ThemeBrand = ThemeBrand.DEFAULT,
    val darkThemeConfig: DarkThemeConfig = DarkThemeConfig.DARK,
    val useDynamicColor: Boolean = false,
    val shouldHideOnboarding: Boolean = false,
)
