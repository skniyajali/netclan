package com.niyaj.feature.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.niyaj.feature.explore.components.BusinessTabContent
import com.niyaj.feature.explore.components.CustomSearchBar
import com.niyaj.feature.explore.components.ExploreScreenTabs
import com.niyaj.feature.explore.components.ExploreScreenTabsItem
import com.niyaj.feature.explore.components.ExploreTabContent
import com.niyaj.feature.explore.components.MerchantTabContent
import com.niyaj.feature.explore.components.PersonalTabContent
import com.niyaj.ui.components.CustomScrim
import com.niyaj.ui.components.StandardScaffold
import com.niyaj.ui.utils.isScrollingUp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(
    navController: NavController,
    onClickRefine: () -> Unit,
    onSettingsClick: () -> Unit,
    viewModel: ExploreViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    val focusManager = LocalFocusManager.current

    val personalListState = rememberLazyListState()
    val businessListState = rememberLazyListState()
    val merchantListState = rememberLazyListState()

    val currentUser = viewModel.currentUser

    val personalSearch = viewModel.personalSearch.collectAsStateWithLifecycle().value
    val businessSearch = viewModel.businessSearch.collectAsStateWithLifecycle().value
    val merchantSearch = viewModel.merchantSearch.collectAsStateWithLifecycle().value

    val personalProfiles = viewModel.personalProfiles.collectAsStateWithLifecycle().value.data
    val personalIsLoading = viewModel.personalProfiles.collectAsStateWithLifecycle().value.isLoading

    val businessProfiles = viewModel.businessProfiles.collectAsStateWithLifecycle().value.data
    val businessIsLoading = viewModel.businessProfiles.collectAsStateWithLifecycle().value.isLoading

    val merchantProfiles = viewModel.merchantProfiles.collectAsStateWithLifecycle().value.data
    val merchantIsLoading = viewModel.merchantProfiles.collectAsStateWithLifecycle().value.isLoading

    val fabExpanded = remember { mutableStateOf(false) }

    val tabs = listOf(
        ExploreScreenTabsItem.Personal {
            PersonalTabContent(
                lazyListState = personalListState,
                isLoading = personalIsLoading,
                profileData = personalProfiles,
                onClickInvite = {},
                onClickRefresh = {
                    viewModel.onEvent(ExploreEvent.OnRefreshPersonalProfile)
                    focusManager.clearFocus()
                }
            )
        },
        ExploreScreenTabsItem.Business {
            BusinessTabContent(
                lazyListState = businessListState,
                isLoading = businessIsLoading,
                profileData = businessProfiles,
                onPhoneClick = {},
                onContactClick = {},
                onClickRefresh = {
                    viewModel.onEvent(ExploreEvent.OnRefreshBusinessProfile)
                    focusManager.clearFocus()
                }
            )
        },
        ExploreScreenTabsItem.Merchant {
            MerchantTabContent(
                lazyListState = merchantListState,
                isLoading = merchantIsLoading,
                profileData = merchantProfiles,
                onPhoneClick = {},
                onLocationClick = {},
                onClickRefresh = {
                    viewModel.onEvent(ExploreEvent.OnRefreshMerchantProfile)
                    focusManager.clearFocus()
                }
            )
        },
    )

    val pagerState = rememberPagerState { tabs.size }

    val showFab = when (pagerState.currentPage) {
        0 -> {
            personalListState.isScrollingUp()
        }

        1 -> {
            businessListState.isScrollingUp()
        }

        else -> merchantListState.isScrollingUp()
    }

    val searchText = when (pagerState.currentPage) {
        0 -> personalSearch
        1 -> businessSearch
        else -> merchantSearch
    }

    fun onClearClick() = when (pagerState.currentPage) {
        0 -> {
            viewModel.onEvent(ExploreEvent.OnClearPersonalSearch)
        }

        1 -> {
            viewModel.onEvent(ExploreEvent.OnClearBusinessSearch)
        }

        else -> {
            viewModel.onEvent(ExploreEvent.OnClearMerchantSearch)
        }
    }

    fun onSearchClick(text: String) = when (pagerState.currentPage) {
        0 -> {
            viewModel.onEvent(ExploreEvent.OnPersonalSearch(text))
        }

        1 -> {
            viewModel.onEvent(ExploreEvent.OnBusinessSearch(text))
        }

        else -> {
            viewModel.onEvent(ExploreEvent.OnMerchantSearch(text))
        }
    }

    StandardScaffold(
        navController = navController,
        scaffoldState = scaffoldState,
        title = currentUser.firstName + currentUser.lastName,
        userId = currentUser.userId,
        userStatus = currentUser.userAvailability.title,
        profileCompletionStatus = currentUser.profileCompletionStatus,
        location = currentUser.city,
        showFab = showFab,
        onClickRefine = onClickRefine,
        onSettingsClick = onSettingsClick,
        stateChanged = {
            fabExpanded.value = it.isExpanded()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            focusManager.clearFocus()
                        }
                    )
                },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ExploreScreenTabs(tabs = tabs, pagerState = pagerState)

            Box(modifier = Modifier.fillMaxSize()) {
                Column {
                    CustomSearchBar(
                        search = searchText,
                        focusManager = focusManager,
                        focusRequester = FocusRequester(),
                        onValueChange = {
                            onSearchClick(it)
                        },
                        onClearClick = {
                            onClearClick()
                        },
                        onClickFilter = {},
                    )

                    ExploreTabContent(tabs = tabs, pagerState = pagerState)
                }

                CustomScrim(
                    color = Color.White,
                    onDismiss = { /*TODO*/ },
                    visible = fabExpanded.value
                )
            }
        }
    }
}
