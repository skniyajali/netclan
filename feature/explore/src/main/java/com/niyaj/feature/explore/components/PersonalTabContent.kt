package com.niyaj.feature.explore.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.niyaj.model.PersonalProfile
import com.niyaj.ui.components.EmptySearch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PersonalTabContent(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    isLoading: Boolean,
    profileData: List<PersonalProfile>,
    onClickInvite: (String) -> Unit,
    onClickRefresh: () -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isLoading,
        onRefresh = onClickRefresh
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .pullRefresh(pullRefreshState)
    ) {
        if (profileData.isEmpty()) {
            EmptySearch(
                modifier = Modifier.fillMaxSize()
            )
        } else {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(vertical = SpaceSmall),
                state = lazyListState
            ) {
                items(
                    items = profileData,
                    key = {
                        it.userId.plus(it.age)
                    }
                ) { data ->
                    PersonalProfileCard(
                        profile = data,
                        onClickInvite = {
                            onClickInvite(data.userId)
                        }
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