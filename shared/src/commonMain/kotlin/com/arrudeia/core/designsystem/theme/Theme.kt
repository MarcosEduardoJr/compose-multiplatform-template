package com.arrudeia.core.designsystem.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.ExperimentalResourceApi

private val LightColorPalette = lightColors(
    primary = vibrantGreen,
    primaryVariant = vibrantGreen,
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ArrudeiaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = ArrudeiaTypography(),
        content = content
    )
} 