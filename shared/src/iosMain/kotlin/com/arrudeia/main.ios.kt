package com.arrudeia

import androidx.compose.ui.window.ComposeUIViewController
import com.arrudeia.App

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }