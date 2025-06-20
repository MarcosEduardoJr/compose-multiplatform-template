package com.arrudeia.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightColorScheme = lightColorScheme(
    primary = vibrantGreen,
    secondary = sunshineYellow,
    background = background,
    surface = cardsAndPanels,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = softCharcoal,
    onSurface = softCharcoal,
    error = coralRed,
    onError = Color.White
)

@Composable
fun ArrudeiaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightColorScheme,
        typography = ArrudeiaTypography(),
        content = content
    )
} 