package com.arrudeia.core.designsystem.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FredokaFontFamily() = FontFamily.Default

@Composable
fun InterFontFamily() = FontFamily.Default

@Composable
fun ArrudeiaTypography(): Typography {
    val fredoka = FredokaFontFamily()
    val inter = InterFontFamily()

    return Typography(
        h1 = androidx.compose.ui.text.TextStyle(
            fontFamily = fredoka,
            fontWeight = FontWeight.Normal,
        ),
        body1 = androidx.compose.ui.text.TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
        )

    )
}