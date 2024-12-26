package com.niyaj.netclan.ui

import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.niyaj.data.utils.NetworkMonitor
import com.niyaj.ui.utils.TrackDisposableJank
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberAppState(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
//    userNewsResourceRepository: UserNewsResourceRepository,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): NetclanAppState {
    NavigationTrackingSideEffect(navController)
    return remember(
        navController,
        coroutineScope,
        windowSizeClass,
        networkMonitor,
//        userNewsResourceRepository,
    ) {
        NetclanAppState(
            navController,
            coroutineScope,
            windowSizeClass,
            networkMonitor,
//            userNewsResourceRepository,
        )
    }
}

@Stable
class NetclanAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
//    userNewsResourceRepository: UserNewsResourceRepository,
) {
    val scaffoldState @Composable get() = rememberScaffoldState()

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )
}

/**
 * Stores information about navigation events to be used with JankStats
 */
@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}





