package com.arrudeia.feature.explore.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.arrudeia.core.designsystem.theme.ArrudeiaTheme
import kotlin.random.Random

data class LocationItem(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val xp: Int,
    val height: Dp,
    val category: String
)

val sampleLocations = listOf(
    LocationItem(1, "Eiffel Tower", "Iconic tower in Paris.", "https://picsum.photos/seed/eiffel/400/600", 100, Random.nextInt(250, 320).dp, "Sights"),
    LocationItem(2, "Colosseum", "Ancient amphitheater in Rome.", "https://picsum.photos/seed/colosseum/400/600", 150, Random.nextInt(250, 320).dp, "Sights"),
    LocationItem(3, "Pizza Place", "Best pizza in town.", "https://picsum.photos/seed/pizza/400/600", 120, Random.nextInt(250, 320).dp, "Food"),
    LocationItem(4, "Machu Picchu", "Incan citadel in Peru.", "https://picsum.photos/seed/machu/400/600", 200, Random.nextInt(250, 320).dp, "Sights"),
    LocationItem(5, "Local Concert", "Live music event.", "https://picsum.photos/seed/concert/400/600", 250, Random.nextInt(250, 320).dp, "Events"),
    LocationItem(6, "Cozy Hostel", "Affordable and friendly stay.", "https://picsum.photos/seed/hostel/400/600", 180, Random.nextInt(250, 320).dp, "Hotels"),
    LocationItem(7, "Art Museum", "Modern and classic art.", "https://picsum.photos/seed/museum/400/600", 220, Random.nextInt(250, 320).dp, "Sights")
)

val categories = listOf("All", "Sights", "Food", "Hotels", "Events")

@Composable
fun ExploreScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    val filteredLocations = remember(searchQuery, selectedCategory) {
        sampleLocations.filter { location ->
            val matchesCategory = selectedCategory == "All" || location.category == selectedCategory
            val matchesSearch = searchQuery.isBlank() || location.name.contains(searchQuery, ignoreCase = true)
            matchesCategory && matchesSearch
        }
    }

    ArrudeiaTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it }
            )
            CategoryFilters(
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 8.dp
            ) {
                items(filteredLocations) { location ->
                    LocationCard(location)
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Explore Your World",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Discover new adventures",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        placeholder = { Text("Search destinations...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
        shape = RoundedCornerShape(32.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryFilters(selectedCategory: String, onCategorySelected: (String) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = selectedCategory == category,
                onClick = { onCategorySelected(category) },
                label = { Text(category) }
            )
        }
    }
}

@Composable
fun LocationCard(location: LocationItem) {
    var completed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (completed) 1.05f else 1f, animationSpec = tween(300), label = "")
    val elevation by animateDpAsState(targetValue = if (completed) 8.dp else 2.dp, animationSpec = tween(300), label = "")
    val xpAlpha by animateFloatAsState(targetValue = if (completed) 1f else 0f, animationSpec = tween(600, delayMillis = 200), label = "")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .clickable { completed = !completed },
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Box(
            modifier = Modifier
                .height(location.height)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = location.imageUrl,
                contentDescription = location.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = location.height.value * 0.5f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = location.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = location.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.8f),
                        maxLines = 2,
                        modifier = Modifier.weight(1f, fill = false)
                    )
                    IconButton(onClick = { completed = !completed }) {
                        Icon(
                            imageVector = if (completed) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                            contentDescription = if (completed) "Mark as not visited" else "Mark as visited",
                            tint = Color.White
                        )
                    }
                }
            }

            // XP Badge
            if (completed) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .alpha(xpAlpha)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                     Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "+${location.xp}",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Completed",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(16.dp)
                        )
                    }
                }
            }
        }
    }
} 