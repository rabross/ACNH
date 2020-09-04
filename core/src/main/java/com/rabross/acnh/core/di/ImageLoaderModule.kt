package com.rabross.acnh.core.di

import com.rabross.acnh.core.image.GlideImageLoader
import com.rabross.acnh.core.image.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class ImageLoaderModule {

    @Provides
    fun provideGlide(): ImageLoader {
        return GlideImageLoader()
    }
}