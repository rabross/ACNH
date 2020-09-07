package com.rabross.acnh.creature.sea.di

import androidx.fragment.app.Fragment
import com.rabross.acnh.core.fragment.FragmentKey
import com.rabross.acnh.creature.sea.ui.SeaCreatureDetailsFragment
import com.rabross.acnh.creature.sea.ui.SeaCreaturesFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(SeaCreaturesFragment::class)
    abstract fun bindSeaCreaturesFragment(seaCreaturesFragment: SeaCreaturesFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SeaCreatureDetailsFragment::class)
    abstract fun bindSeaCreaturesDetailsFragment(seaCreaturesDetailsFragment: SeaCreatureDetailsFragment): Fragment
}
