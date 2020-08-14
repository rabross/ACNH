package com.rabross.acnh.di

import com.rabross.acnh.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainScreenActivity(): MainActivity
}