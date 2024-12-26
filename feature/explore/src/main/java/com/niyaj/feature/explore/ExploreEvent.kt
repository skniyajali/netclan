package com.niyaj.feature.explore

sealed interface ExploreEvent {

    data class OnPersonalSearch(val searchText: String): ExploreEvent
    data object OnClearPersonalSearch : ExploreEvent

    data class OnBusinessSearch(val searchText: String): ExploreEvent
    data object OnClearBusinessSearch : ExploreEvent

    data class OnMerchantSearch(val searchText: String): ExploreEvent
    data object OnClearMerchantSearch : ExploreEvent

    data object OnRefreshPersonalProfile: ExploreEvent
    data object OnRefreshBusinessProfile : ExploreEvent
    data object OnRefreshMerchantProfile : ExploreEvent
}