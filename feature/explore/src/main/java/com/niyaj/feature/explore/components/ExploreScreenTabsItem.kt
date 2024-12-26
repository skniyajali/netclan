package com.niyaj.feature.explore.components

import androidx.compose.runtime.Composable

typealias ComposableFunction = @Composable () -> Unit

sealed class ExploreScreenTabsItem(
    val title: String,
    val content: ComposableFunction,
) {
    data class Personal(
        val screen: @Composable () -> Unit
    ) : ExploreScreenTabsItem(
        title = "Personal",
        content = {
            screen()
        }
    )

    data class Business(
        val screen: @Composable () -> Unit
    ) : ExploreScreenTabsItem(
        title = "Business",
        content = {
            screen()
        }
    )

    data class Merchant(
        val screen: @Composable () -> Unit
    ) : ExploreScreenTabsItem(
        title = "Merchant",
        content = {
            screen()
        }
    )
}