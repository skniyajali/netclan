package com.niyaj.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.ContactEmergency
import androidx.compose.material.icons.filled.HomeRepairService
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.niyaj.designsystem.theme.ProfilePictureSizeMedium
import com.niyaj.designsystem.theme.ProfilePictureSizeSmall
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.designsystem.theme.SpaceMediumMax
import com.niyaj.designsystem.theme.SpaceSmall
import com.niyaj.ui.utils.Screens

@Composable
fun StandardDrawer(
    modifier: Modifier = Modifier,
    username: String,
    userId: String,
    profileCompletionStatus: Float,
    userStatus: String,
    navController: NavController,
    onSettingsClick: () -> Unit,
) {
    val lazyListState = rememberLazyListState()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val drawerItems = listOf(
        DrawerItem(
            title = "Edit Profile",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.Person,
            isSelected = false
        ),
        DrawerItem(
            title = "My Network",
            routeName = Screens.EXPLORE_SCREEN,
            icon = Icons.Default.People,
            isSelected = currentRoute == Screens.EXPLORE_SCREEN
        ),
        DrawerItem(
            title = "Switch to Business",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.Business,
            isSelected = false
        ),
        DrawerItem(
            title = "Switch to Merchant",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.BusinessCenter,
            isSelected = false
        ),
        DrawerItem(
            title = "Dating",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.Whatshot,
            isSelected = false
        ),
        DrawerItem(
            title = "Matrimony",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.Hub,
            isSelected = false
        ),
        DrawerItem(
            title = "Buy-Sell-Rent",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.ShoppingBag,
            isSelected = false
        ),
        DrawerItem(
            title = "Jobs",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.HomeRepairService,
            isSelected = false
        ),
        DrawerItem(
            title = "Business Cards",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.ContactEmergency,
            isSelected = false
        ),
        DrawerItem(
            title = "Netclan Groups",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.Tag,
            isSelected = false
        ),
        DrawerItem(
            title = "Notes",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.NoteAlt,
            isSelected = false
        ),
        DrawerItem(
            title = "Live Locations",
            routeName = "", // TODO: Add route name and must be added into navigation graph
            icon = Icons.Default.LocationOn,
            isSelected = false
        )
    )

    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        item("Drawer Header") {
            StandardDrawerHeader(
                username = username,
                userId = userId,
                profileCompletionStatus = profileCompletionStatus,
                userStatus = userStatus,
                onSettingsClick = onSettingsClick,
            )
        }

        items(
            items = drawerItems,
            key = {
                it.title + it.routeName
            }
        ) { drawerItem ->
            StandardDrawerItem(
                text = drawerItem.title,
                icon = drawerItem.icon,
                selected = drawerItem.isSelected,
                onClick = {
                    if (drawerItem.routeName.isNotEmpty()) {
                        navController.navigate(drawerItem.routeName)
                    }
                }
            )
        }
    }
}


@Composable
fun StandardDrawerHeader(
    username: String,
    userId: String,
    profileCompletionStatus: Float,
    userStatus: String,
    onSettingsClick: () -> Unit,
    @DrawableRes
    backgroundImage: Int = 0,
    icon: ImageVector = Icons.Outlined.Person,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = SpaceMediumMax,
                    bottom = SpaceMedium,
                    top = SpaceMedium,
                    end = SpaceMedium
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(SpaceSmall),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier = Modifier
                        .size(ProfilePictureSizeMedium)
                        .background(MaterialTheme.colors.background, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = username + "icon",
                        tint = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .size(ProfilePictureSizeSmall)
                            .align(Alignment.Center)
                    )
                }

                IconButton(
                    onClick = onSettingsClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings Icon",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }

            Text(
                text = username,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = userId,
                style = MaterialTheme.typography.body2,
            )

            LinearProgressIndicator(
                progress = profileCompletionStatus,
                backgroundColor = MaterialTheme.colors.primaryVariant,
                color = MaterialTheme.colors.onPrimary,
                strokeCap = StrokeCap.Round,
                modifier = Modifier
                    .width(100.dp)
                    .height(10.dp)
            )

            Text(
                text = userStatus.uppercase(),
                style = MaterialTheme.typography.body2,
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StandardDrawerItem(
    text: String,
    icon: ImageVector,
    selected: Boolean,
    selectedColor: Color = MaterialTheme.colors.secondaryVariant,
    unselectedColor: Color = Color.Transparent,
    iconColor: Color = MaterialTheme.colors.primary,
    cardElevation: Dp = 0.dp,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = SpaceSmall),
        shape = RoundedCornerShape(4.dp),
        backgroundColor = if (selected) selectedColor else unselectedColor,
        elevation = cardElevation,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text.plus("Icon"),
                tint = iconColor
            )

            Spacer(modifier = Modifier.width(SpaceSmall))

            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}


data class DrawerItem(
    val title: String,
    val routeName: String,
    val icon: ImageVector,
    val isSelected: Boolean,
)