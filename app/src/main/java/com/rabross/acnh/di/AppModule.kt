package com.rabross.acnh.di

import android.app.Application
import android.content.Context
import com.rabross.acnh.data.SchedulersFacade
import com.rabross.acnh.data.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulersProvider
}