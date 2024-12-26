package com.niyaj.netclan.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.niyaj.feature.explore.navigation.exploreScreen
import com.niyaj.feature.refine.navigation.navigateToRefineScreen
import com.niyaj.feature.refine.navigation.refineScreen
import com.niyaj.netclan.ui.NetclanAppState

@Composable
fun NetclanNavHost(
    modifier: Modifier = Modifier,
    netclanAppState: NetclanAppState,
    startDestination: String,
) {
    val navController = netclanAppState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        // TODO: add navigation graph and composable
        exploreScreen(
            navController = navController,
            onClickRefine = navController::navigateToRefineScreen,
            onSettingsClick = {}
        )

        refineScreen(
            onBackClick = navController::popBackStack
        )
    }
}
