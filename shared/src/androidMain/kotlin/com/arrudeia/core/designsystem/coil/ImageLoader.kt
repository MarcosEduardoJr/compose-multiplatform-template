package com.arrudeia.core.designsystem.coil

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.network.ktor.KtorNetworkFetcherFactory

internal actual fun getAsyncImageLoader(context: PlatformContext): ImageLoader {
    return ImageLoader.Builder(context)
        .components {
            add(KtorNetworkFetcherFactory())
        }
        .build()
} 