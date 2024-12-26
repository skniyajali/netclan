package com.niyaj.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.niyaj.core.ui.R

@Composable
fun StandardScaffoldWithoutDrawer(
    scaffoldState: ScaffoldState,
    title: String,
    onBackClick: () -> Unit,
    fabPosition: FabPosition = FabPosition.End,
    fabDocked: Boolean = false,
    navActions: @Composable (RowScope) -> Unit = {},
    fabButton: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = { },
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h6,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBackIosNew,
                            contentDescription = stringResource(id = R.string.go_back),
                        )
                    }
                },
                actions = navActions,
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onPrimary,
            )
        },
        floatingActionButtonPosition = fabPosition,
        isFloatingActionButtonDocked = fabDocked,
        floatingActionButton = fabButton,
        bottomBar = bottomBar,
    ) {
        content(it)
    }
}