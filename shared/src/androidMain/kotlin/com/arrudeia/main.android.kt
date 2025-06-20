package com.arrudeia

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import com.arrudeia.core.designsystem.coil.getAsyncImageLoader

actual fun getPlatformName(): String = "Android"

@Composable
fun MainView() {
    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }
    App()
}
