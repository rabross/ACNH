package com.rabross.acnh.core.di

import android.content.Context
import com.rabross.acnh.core.image.ImageViewBinding
import com.rabross.acnh.core.network.DispatchersProvider
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ImageLoaderModule::class, BindingModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): CoreComponent
    }

    fun retrofit(): Retrofit
    fun dispatchers(): DispatchersProvider
    fun image(): ImageViewBinding
}