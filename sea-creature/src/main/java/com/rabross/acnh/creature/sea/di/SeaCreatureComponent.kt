package com.rabross.acnh.creature.sea.di

import com.rabross.acnh.core.ActivityScope
import com.rabross.acnh.core.di.CoreComponent
import com.rabross.acnh.creature.sea.ui.SeaCreatureActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        SeaCreatureModule::class,
        ViewModelModule::class]
)
internal interface SeaCreatureComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): SeaCreatureComponent
    }

    fun inject(activity: SeaCreatureActivity)
}