package com.rabross.acnh.di

import android.app.Application
import com.rabross.acnh.App
import com.rabross.acnh.core.di.NetworkModule
import com.rabross.acnh.creature.sea.di.SeaCreatureModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SeaCreatureModule::class,
        NetworkModule::class,
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityBindingModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}