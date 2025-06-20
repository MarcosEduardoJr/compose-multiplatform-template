package com.arrudeia.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Explore : BottomNavItem("explore", Icons.Default.Explore, "Explore")
    object Missions : BottomNavItem("missions", Icons.Default.MilitaryTech, "Missions")
    object Map : BottomNavItem("map", Icons.Default.Map, "Map")
    object Friends : BottomNavItem("friends", Icons.Default.People, "Friends")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
} 