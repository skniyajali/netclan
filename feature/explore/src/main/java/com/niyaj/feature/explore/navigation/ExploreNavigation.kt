package com.niyaj.feature.explore.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.niyaj.feature.explore.ExploreScreen
import com.niyaj.ui.utils.Screens

fun NavController.navigateToExploreScreen(navOptions: NavOptions? = null) {
    this.navigate(Screens.EXPLORE_SCREEN, navOptions)
}


fun NavGraphBuilder.exploreScreen(
    navController: NavController,
    onClickRefine: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    composable(
        Screens.EXPLORE_SCREEN,
    ) {
        ExploreScreen(
            navController = navController,
            onClickRefine = onClickRefine,
            onSettingsClick = onSettingsClick,
        )
    }
}