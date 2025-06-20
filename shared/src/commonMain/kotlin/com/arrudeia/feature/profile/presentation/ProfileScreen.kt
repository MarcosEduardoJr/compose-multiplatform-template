package com.arrudeia.feature.profile.presentation

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.arrudeia.core.designsystem.theme.ArrudeiaTheme

data class UserProfile(
    val name: String,
    val level: Int,
    val xp: Float,
    val avatarUrl: String?,
    val badges: List<String>,
    val travelStats: TravelStats
)

data class TravelStats(
    val cities: Int,
    val countries: Int,
    val categories: Int
)

val sampleUserProfile = UserProfile(
    name = "Arrudeia Explorer",
    level = 15,
    xp = 0.75f,
    avatarUrl = "https://picsum.photos/seed/avatar/300/300",
    badges = listOf("Trailblazer", "City Slicker", "Foodie", "Adventurer", "Night Owl"),
    travelStats = TravelStats(cities = 42, countries = 5, categories = 12)
)

@Composable
fun ProfileScreen(userProfile: UserProfile = sampleUserProfile) {
    ArrudeiaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Avatar(userProfile.avatarUrl)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = userProfile.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))

            LevelAndXp(level = userProfile.level, xp = userProfile.xp)
            Spacer(modifier = Modifier.height(24.dp))

            BadgeGallery(badges = userProfile.badges)
            Spacer(modifier = Modifier.height(24.dp))

            TravelStats(stats = userProfile.travelStats)
        }
    }
}

@Composable
private fun Avatar(avatarUrl: String?) {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = avatarUrl,
            contentDescription = "User Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun LevelAndXp(level: Int, xp: Float) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Level $level", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = xp,
            modifier = Modifier.fillMaxWidth(0.8f),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
private fun BadgeGallery(badges: List<String>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Badges", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            items(badges) { badge ->
                Badge(name = badge)
            }
        }
    }
}

@Composable
private fun Badge(name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = name,
                tint = Color.White,
                modifier = Modifier.size(36.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun TravelStats(stats: TravelStats) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(value = stats.cities, label = "Cities")
        StatItem(value = stats.countries, label = "Countries")
        StatItem(value = stats.categories, label = "Categories")
    }
}

@Composable
private fun StatItem(value: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value.toString(), style = MaterialTheme.typography.headlineSmall)
        Text(text = label, style = MaterialTheme.typography.labelMedium)
    }
} 