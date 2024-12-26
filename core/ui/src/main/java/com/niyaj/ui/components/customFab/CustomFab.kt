package com.niyaj.ui.components.customFab

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ContactEmergency
import androidx.compose.material.icons.filled.HomeRepairService
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomFab(
    modifier: Modifier = Modifier,
    fabItems: List<MultiFabItem> = fabItemList,
    onFabClick: (String) -> Unit = {},
    stateChanged: (fabState: MultiFabState) -> Unit = {},
) {
    MultiFloatingActionButton(
        modifier = modifier,
        items = fabItems,
        fabIcon = FabIcon(
            icon = Icons.Default.Add,
            iconRotate = 45f
        ),
        onFabItemClicked = {
            onFabClick(it.route)
        },
        stateChanged = stateChanged,
    )
}


val fabItemList = listOf(
    MultiFabItem(
        id = 1,
        route = "",
        iconRes = null,
        icon = Icons.Default.Whatshot,
        label = "Dating",
    ),
    MultiFabItem(
        id = 2,
        route = "",
        iconRes = null,
        icon = Icons.Default.Hub,
        label = "Matrimony",
    ),
    MultiFabItem(
        id = 3,
        route = "",
        iconRes = null,
        icon = Icons.Default.ShoppingBag,
        label = "Buy-Sell-Rent",
    ),
    MultiFabItem(
        id = 4,
        route = "",
        iconRes = null,
        icon = Icons.Default.ContactEmergency,
        label = "Business Cards",
    ),
    MultiFabItem(
        id = 5,
        route = "",
        iconRes = null,
        icon = Icons.Default.Tag,
        label = "Netclan Groups",
    ),
    MultiFabItem(
        id = 6,
        route = "",
        iconRes = null,
        icon = Icons.Default.HomeRepairService,
        label = "Jobs",
    ),
    MultiFabItem(
        id = 7,
        route = "",
        iconRes = null,
        icon = Icons.Default.NoteAlt,
        label = "Notes",
    )
)