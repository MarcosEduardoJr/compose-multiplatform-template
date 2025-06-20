package com.arrudeia

import androidx.compose.runtime.Composable
import com.arrudeia.App

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()
