package com.rabross.acnh.core.di

import android.content.Context
import com.rabross.acnh.core.network.SchedulersProvider
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): CoreComponent
    }

    fun retrofit(): Retrofit
    fun schedulers(): SchedulersProvider
}