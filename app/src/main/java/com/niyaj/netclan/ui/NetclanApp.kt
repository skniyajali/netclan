package com.niyaj.netclan.ui

import android.widget.Toast
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.niyaj.data.utils.NetworkMonitor
import com.niyaj.designsystem.components.AppBackground
import com.niyaj.designsystem.components.AppGradientBackground
import com.niyaj.designsystem.theme.GradientColors
import com.niyaj.netclan.navigation.NetclanNavHost
import com.niyaj.ui.utils.Screens
import kotlinx.coroutines.launch

@Composable
fun NetclanApp(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    netclanAppState: NetclanAppState = rememberAppState(
        networkMonitor = networkMonitor,
        windowSizeClass = windowSizeClass,
    ),
) {
    AppBackground {
        AppGradientBackground(
            gradientColors = GradientColors(),
        ) {
            val context = LocalContext.current
            val scope = rememberCoroutineScope()

            val isOffline by netclanAppState.isOffline.collectAsStateWithLifecycle()

            // If user is not connected to the internet show a snack bar to inform them.
            LaunchedEffect(isOffline) {
                if (isOffline) {
                    scope.launch {
                        Toast.makeText(
                            context,
                            "You are not connected to the internet",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            NetclanNavHost(
                netclanAppState = netclanAppState,
                startDestination = Screens.EXPLORE_SCREEN, // TODO: Add start destination
            )
        }
    }
}