package com.arrudeia

import androidx.compose.runtime.Composable
import com.arrudeia.feature.profile.presentation.ProfileScreen

@Composable
fun App() {
    ProfileScreen()
}

expect fun getPlatformName(): String