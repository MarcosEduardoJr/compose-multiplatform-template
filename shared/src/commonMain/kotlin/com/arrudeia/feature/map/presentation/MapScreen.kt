package com.arrudeia.feature.map.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arrudeia.core.designsystem.theme.ArrudeiaTheme

@Composable
fun MapScreen() {
    ArrudeiaTheme {
        // TODO: Implement a real map view
        // Implementing a map requires platform-specific setup.
        // A good library for this is `compose-multiplatform-maps`.
        //
        // Steps:
        // 1. Add the dependency to shared/build.gradle.kts:
        //    implementation("com.google.maps.android:maps-compose:2.11.4") // For Android
        //    And the equivalent for iOS (MapKit) would be handled by a multiplatform library.
        //
        // 2. Android: Add Google Maps API key to androidApp/src/main/AndroidManifest.xml
        //    <meta-data android:name="com.google.android.geo.API_KEY" android:value="YOUR_KEY_HERE" />
        //
        // 3. iOS: Configure MapKit and add necessary permissions to Info.plist.
        //
        // 4. Use expect/actual to create a platform-specific map composable.

        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.Map,
                    contentDescription = "Map Icon",
                    modifier = Modifier.padding(16.dp).fillMaxSize(0.5f),
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Interactive Map Coming Soon!",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "This screen will display an interactive map with custom markers for tourist spots, restaurants, and more.",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info",
                    modifier = Modifier.padding(16.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "Developer Note: Full map implementation requires platform-specific API keys and dependencies.",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
} 