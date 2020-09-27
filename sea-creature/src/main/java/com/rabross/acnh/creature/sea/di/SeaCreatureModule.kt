package com.rabross.acnh.creature.sea.di

import android.content.Context
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.ActivityScope
import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.creature.sea.repository.remote.SeaCreatureRepo
import com.rabross.acnh.creature.sea.repository.remote.SeaCreatureService
import com.rabross.acnh.creature.sea.storage.SeaCreatureDao
import com.rabross.acnh.creature.sea.storage.SeaCreatureRoomDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SeaCreatureModule {

    @Provides
    @ActivityScope
    fun provideSeaCreatureService(retrofit: Retrofit): SeaCreatureService {
        return retrofit.create(SeaCreatureService::class.java)
    }

    @Provides
    @ActivityScope
    fun provideRepo(apiService: SeaCreatureService): Repo<SeaCreatures> {
        return SeaCreatureRepo(apiService)
    }

     @Provides
     @ActivityScope
     fun provideSeaCreatureDao(context: Context): SeaCreatureDao {
         return SeaCreatureRoomDatabase.getDatabase(context).seaCreatureDao()
     }
}