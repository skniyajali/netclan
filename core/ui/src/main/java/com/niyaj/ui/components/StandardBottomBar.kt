package com.niyaj.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Hub
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.ui.utils.Screens

@Composable
fun StandardBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val bottomBarItems = listOf(
        BottomBarItem(
            title = "Explore",
            routeName = Screens.EXPLORE_SCREEN,
            selectedIcon = Icons.Default.RemoveRedEye,
            deselectedIcon = Icons.Outlined.RemoveRedEye,
            isSelected = currentRoute == Screens.EXPLORE_SCREEN
        ),
        BottomBarItem(
            title = "Network",
            routeName = Screens.NETWORK_SCREEN,
            selectedIcon = Icons.Default.Hub,
            deselectedIcon = Icons.Outlined.Hub,
            isSelected = currentRoute == Screens.NETWORK_SCREEN
        ),
        BottomBarItem(
            title = "Chat",
            routeName = Screens.CHAT_SCREEN,
            selectedIcon = Icons.Default.Chat,
            deselectedIcon = Icons.Outlined.Chat,
            isSelected = currentRoute == Screens.CHAT_SCREEN
        ),
        BottomBarItem(
            title = "Contacts",
            routeName = Screens.CONTACTS_SCREEN,
            selectedIcon = Icons.Default.Contacts,
            deselectedIcon = Icons.Outlined.Contacts,
            isSelected = currentRoute == Screens.CONTACTS_SCREEN
        ),
        BottomBarItem(
            title = "Groups",
            routeName = Screens.GROUPS_SCREEN,
            selectedIcon = Icons.Default.Tag,
            deselectedIcon = Icons.Outlined.Tag,
            isSelected = currentRoute == Screens.GROUPS_SCREEN
        )
    )

    BottomNavigation(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background,
        elevation = SpaceMedium
    ) {
        bottomBarItems.forEach { navItem ->
            BottomNavigationItem(
                selected = navItem.isSelected,
                onClick = {
//                    navController.navigate(navItem.routeName) Todo: add all route in nav graph
                    navController.navigate(Screens.EXPLORE_SCREEN)
                },
                icon = {
                    Icon(
                        imageVector = if (navItem.isSelected) navItem.selectedIcon else navItem.deselectedIcon,
                        contentDescription = navItem.title + "Icon",
                        tint = if (navItem.isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant
                    )
                },
                alwaysShowLabel = true,
                label = {
                    Text(
                        text = navItem.title,
                        style = MaterialTheme.typography.caption,
                    )
                }
            )
        }
    }
}


@Immutable
data class BottomBarItem(
    @Stable
    val title: String,
    @Stable
    val routeName: String,
    @Stable
    val selectedIcon: ImageVector,
    @Stable
    val deselectedIcon: ImageVector,
    @Stable
    val isSelected: Boolean,
)