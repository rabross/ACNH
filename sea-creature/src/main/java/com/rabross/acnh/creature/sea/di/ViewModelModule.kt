package com.rabross.acnh.creature.sea.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rabross.acnh.core.viewmodel.ViewModelFactory
import com.rabross.acnh.core.viewmodel.ViewModelKey
import com.rabross.acnh.creature.sea.ui.SeaCreatureViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SeaCreatureViewModel::class)
    abstract fun bindSeaCreatureViewModel(viewModel: SeaCreatureViewModel): ViewModel
}
