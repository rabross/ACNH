package com.rabross.acnh.creature.sea.di

import com.rabross.acnh.core.di.CoreComponentProvider
import com.rabross.acnh.creature.sea.ui.SeaCreatureActivity

fun SeaCreatureActivity.inject(){
    DaggerSeaCreatureComponent
        .factory()
        .create((applicationContext as CoreComponentProvider).coreComponent)
        .inject(this)
}