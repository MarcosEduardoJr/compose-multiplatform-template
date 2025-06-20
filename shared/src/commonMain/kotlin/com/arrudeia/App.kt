package com.arrudeia

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.arrudeia.core.designsystem.theme.ArrudeiaTheme
import com.arrudeia.feature.explore.presentation.ExploreScreen
import com.arrudeia.feature.map.presentation.MapScreen
import com.arrudeia.feature.profile.presentation.ProfileScreen
import com.arrudeia.feature.quests.presentation.MissionsScreen
import com.arrudeia.feature.social.presentation.FriendsScreen
import com.arrudeia.navigation.BottomNavItem

@OptIn(coil3.annotation.ExperimentalCoilApi::class)
@Composable
fun App() {
    ArrudeiaTheme {
        var selectedTab by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Explore) }

        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (selectedTab) {
                    is BottomNavItem.Explore -> ExploreScreen()
                    is BottomNavItem.Missions -> MissionsScreen()
                    is BottomNavItem.Map -> MapScreen()
                    is BottomNavItem.Friends -> FriendsScreen()
                    is BottomNavItem.Profile -> ProfileScreen()
                }
            }
        }
    }
}

@Composable
private fun BottomNavigationBar(
    selectedTab: BottomNavItem,
    onTabSelected: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.Explore,
        BottomNavItem.Missions,
        BottomNavItem.Map,
        BottomNavItem.Friends,
        BottomNavItem.Profile
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedTab == item,
                onClick = { onTabSelected(item) }
            )
        }
    }
}

expect fun getPlatformName(): String