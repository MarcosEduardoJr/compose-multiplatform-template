package com.arrudeia

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import coil3.compose.setSingletonImageLoaderFactory
import com.arrudeia.core.designsystem.coil.getAsyncImageLoader

actual fun getPlatformName(): String = "Desktop"

@Composable
fun MainView() {
    setSingletonImageLoaderFactory {
        getAsyncImageLoader(it)
    }
    App()
}

@Preview
@Composable
fun MainViewPreview() {
    MainView()
}