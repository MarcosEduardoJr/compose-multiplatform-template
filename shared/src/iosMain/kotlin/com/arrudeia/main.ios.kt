package com.arrudeia

import androidx.compose.ui.window.ComposeUIViewController
import coil3.compose.setSingletonImageLoaderFactory
import com.arrudeia.core.designsystem.coil.getAsyncImageLoader

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController {
    setSingletonImageLoaderFactory {
        getAsyncImageLoader(it)
    }
    App()
}