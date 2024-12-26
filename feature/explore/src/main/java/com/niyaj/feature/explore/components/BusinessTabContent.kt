package com.niyaj.feature.explore.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.designsystem.theme.SpaceSmall
import com.niyaj.model.BusinessProfile
import com.niyaj.ui.components.EmptySearch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BusinessTabContent(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    isLoading: Boolean,
    profileData: List<BusinessProfile>,
    onPhoneClick: (String) -> Unit,
    onContactClick: (String) -> Unit,
    onClickRefresh: () -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isLoading,
        onRefresh = onClickRefresh
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .pullRefresh(pullRefreshState)
    ) {
        if (profileData.isEmpty()) {
            EmptySearch()
        }else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = SpaceSmall),
                state = lazyListState
            ) {
                items(
                    items = profileData,
                    key = {
                        it.profileId.plus(it.age)
                    }
                ) { data ->
                    BusinessProfileCard(
                        profile = data,
                        onPhoneClick = onPhoneClick,
                        onContactClick = onContactClick,
                    )

                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }

        PullRefreshIndicator(
            refreshing = isLoading,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}