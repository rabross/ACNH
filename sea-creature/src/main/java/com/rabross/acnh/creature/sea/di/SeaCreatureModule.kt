package com.rabross.acnh.creature.sea.di

import android.content.Context
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.ActivityScope
import com.rabross.acnh.creature.sea.repository.Cache
import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.creature.sea.repository.SeaCreatureRepo
import com.rabross.acnh.creature.sea.repository.local.DatabaseCache
import com.rabross.acnh.creature.sea.repository.remote.ApiService
import com.rabross.acnh.creature.sea.repository.remote.RemoteRepo
import com.rabross.acnh.creature.sea.storage.SeaCreatureDao
import com.rabross.acnh.creature.sea.storage.SeaCreatureRoomDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SeaCreatureModule {

    @Provides
    @ActivityScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @ActivityScope
    fun provideRepo(apiService: ApiService, cache: Cache<SeaCreatures>): Repo {
        return SeaCreatureRepo(RemoteRepo(apiService), cache)
    }

    @Provides
    @ActivityScope
    fun provideSeaCreatureDao(context: Context): SeaCreatureDao {
        return SeaCreatureRoomDatabase.getDatabase(context).seaCreatureDao()
    }

    @Provides
    @ActivityScope
    fun provideCache(dao: SeaCreatureDao): Cache<SeaCreatures> {
        return DatabaseCache(dao)
    }
}