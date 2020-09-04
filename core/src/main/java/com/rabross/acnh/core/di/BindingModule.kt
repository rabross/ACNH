package com.rabross.acnh.core.di

import com.rabross.acnh.core.image.ImageLoader
import com.rabross.acnh.core.image.ImageViewBinding
import dagger.Module
import dagger.Provides

@Module
class BindingModule {

    @Provides
    fun provideImageBindingAdapter(imageLoader: ImageLoader): ImageViewBinding {
        return ImageViewBinding(imageLoader)
    }
}
