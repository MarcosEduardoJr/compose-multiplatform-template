package com.arrudeia.core.designsystem.coil

import coil3.ImageLoader
import coil3.PlatformContext

internal expect fun getAsyncImageLoader(context: PlatformContext): ImageLoader 