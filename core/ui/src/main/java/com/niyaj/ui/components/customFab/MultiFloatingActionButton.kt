package com.niyaj.ui.components.customFab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun MultiFloatingActionButton(
    modifier: Modifier = Modifier,
    items: List<MultiFabItem>,
    fabState: MutableState<MultiFabState> = rememberMultiFabState(),
    fabIcon: FabIcon,
    fabOption: FabOption = FabOption(),
    onFabItemClicked: (fabItem: MultiFabItem) -> Unit,
    stateChanged: (fabState: MultiFabState) -> Unit = {},
    mainFabColor: Color = MaterialTheme.colors.primary,
    mainFabIconTint: Color = MaterialTheme.colors.onPrimary,
) {
    val rotation by animateFloatAsState(
        if (fabState.value == MultiFabState.Expand) {
            fabIcon.iconRotate ?: 0f
        } else {
            0f
        },
        label = "Fab Rotation"
    )

    Column(
        modifier = modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.End,
    ) {
        AnimatedVisibility(
            visible = fabState.value.isExpanded(),
            enter = fadeIn() + expandVertically(),
            exit = fadeOut()
        ) {
            LazyColumn(
                modifier = Modifier
                    .wrapContentSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(items.size) { index ->
                    MiniFabItem(
                        item = items[index],
                        fabOption = fabOption,
                        onFabItemClicked = onFabItemClicked
                    )
                }

                item {}
            }
        }

        FloatingActionButton(
            onClick = {
                fabState.value = fabState.value.toggleValue()
                stateChanged(fabState.value)
            },
            backgroundColor = mainFabColor,
            contentColor = mainFabIconTint,
            shape = fabOption.shape,
        ) {
            if (fabIcon.iconRes != null) {
                Icon(
                    painter = painterResource(id = fabIcon.iconRes!!),
                    contentDescription = "FAB",
                    modifier = Modifier.rotate(rotation),
                    tint = mainFabIconTint
                )
            } else {
                Icon(
                    imageVector = fabIcon.icon,
                    contentDescription = "FAB",
                    modifier = Modifier.rotate(rotation),
                    tint = mainFabIconTint
                )
            }

        }
    }
}

@Composable
fun MiniFabItem(
    item: MultiFabItem,
    fabOption: FabOption,
    onFabItemClicked: (item: MultiFabItem) -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (fabOption.showLabel) {
            Text(
                text = item.label,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            )
        }

        FloatingActionButton(
            onClick = {
                onFabItemClicked(item)
            },
            modifier = Modifier.size(40.dp),
            backgroundColor = fabOption.backgroundTint,
            contentColor = fabOption.iconTint,
            shape = fabOption.shape,
        ) {
            if (item.iconRes != null) {
                Icon(
                    painter = painterResource(id = item.iconRes),
                    contentDescription = "Float Icon",
                    tint = fabOption.iconTint
                )
            } else {
                Icon(
                    imageVector = item.icon,
                    contentDescription = "Float Icon",
                    tint = fabOption.iconTint
                )
            }
        }
    }
}