package com.niyaj.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Checklist
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.niyaj.core.ui.R
import com.niyaj.designsystem.theme.IconSizeLarge
import com.niyaj.designsystem.theme.IconSizeMedium
import com.niyaj.designsystem.theme.IconSizeMini
import com.niyaj.designsystem.theme.SpaceMini
import com.niyaj.ui.components.customFab.CustomFab
import com.niyaj.ui.components.customFab.MultiFabState
import kotlinx.coroutines.launch

@Composable
fun StandardScaffold(
    navController: NavController,
    scaffoldState: ScaffoldState,
    title: String,
    userId: String,
    profileCompletionStatus: Float,
    userStatus: String,
    location: String,
    onClickRefine: () -> Unit,
    fabPosition: FabPosition = FabPosition.End,
    fabDocked: Boolean = false,
    showFab: Boolean,
    onClickFab: (String) -> Unit = {},
    onSettingsClick: () -> Unit = {},
    stateChanged: (fabState: MultiFabState) -> Unit = {},
    fabButton: @Composable () -> Unit = {
        CustomFab(stateChanged = stateChanged, onFabClick = onClickFab)
    },
    content: @Composable (PaddingValues) -> Unit,
) {
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.spacedBy(SpaceMini),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Howdy $title !!",
                            style = MaterialTheme.typography.subtitle2
                        )
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(SpaceMini)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = stringResource(id = R.string.location_icon),
                                modifier = Modifier.size(IconSizeMini)
                            )
                            Text(
                                text = location,
                                style = MaterialTheme.typography.caption,
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Notes,
                            contentDescription = stringResource(id = R.string.drawer_icon),
                            modifier = Modifier.size(IconSizeLarge)
                        )
                    }
                },
                actions = {
                    Column(
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ) {
                                onClickRefine()
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(SpaceMini)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Checklist,
                            contentDescription = stringResource(id = R.string.checklist_icon),
                            tint = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.size(IconSizeMedium)
                        )

                        Text(
                            text = stringResource(id = R.string.refine),
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }

                }
            )
        },
        floatingActionButtonPosition = fabPosition,
        isFloatingActionButtonDocked = fabDocked,
        floatingActionButton = {
            AnimatedVisibility(
                visible = showFab,
                label = "FloatingActionButton",
                enter = slideInVertically(
                    initialOffsetY = { fullHeight ->
                        fullHeight / 4
                    }
                ),
                exit = slideOutVertically(
                    targetOffsetY = { fullHeight ->
                        fullHeight / 4
                    }
                )
            ) {
                fabButton()
            }
        },
        bottomBar = {
            StandardBottomBar(navController)
        },
        drawerContent = {
            StandardDrawer(
                username = title,
                userId = userId,
                profileCompletionStatus = profileCompletionStatus,
                userStatus = userStatus,
                navController = navController,
                onSettingsClick = onSettingsClick
            )
        },
        drawerShape = RoundedCornerShape(0.dp),
    ) {
        content(it)
    }
}