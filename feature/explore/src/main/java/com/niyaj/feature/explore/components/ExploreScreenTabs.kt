package com.niyaj.feature.explore.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreenTabs(
    tabs: List<ExploreScreenTabsItem>,
    pagerState: PagerState,
) {
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.secondary,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                color = MaterialTheme.colors.onPrimary,
            )
        },
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier.fillMaxWidth(),
                    selected = pagerState.currentPage == index,
                    text = {
                        Text(
                            text = tab.title,
                            style = MaterialTheme.typography.body1
                        )
                    },
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    unselectedContentColor = MaterialTheme.colors.primaryVariant,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreTabContent(
    tabs: List<ExploreScreenTabsItem>,
    pagerState: PagerState,
) {
    HorizontalPager(
        state = pagerState,
        key = {
            it
        }
    ) {
        tabs[it].content()
    }
}