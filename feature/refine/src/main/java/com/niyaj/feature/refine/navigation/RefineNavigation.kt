package com.niyaj.feature.refine.navigation

import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.niyaj.feature.refine.RefineScreen
import com.niyaj.ui.utils.Screens

fun NavController.navigateToRefineScreen(navOptions: NavOptions? = null) {
    this.navigate(Screens.REFINE_SCREEN, navOptions)
}

fun NavGraphBuilder.refineScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = Screens.REFINE_SCREEN,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it / 4 }, animationSpec = tween(500))
        },
        exitTransition = {
            fadeOut(
                tween(30, easing = EaseInBack)
            ) + slideOutVertically(targetOffsetY = { it / 20 })
        }
    ) {
        RefineScreen(onBackClick = onBackClick)
    }
}