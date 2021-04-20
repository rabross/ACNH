package com.rabross.acnh.creature.sea.di

import android.content.Context
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.ActivityScope
import com.rabross.acnh.creature.sea.repository.Cache
import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.creature.sea.repository.SeaCreatureRepo
import com.rabross.acnh.creature.sea.repository.local.SeaCreatureLocalRepo
import com.rabross.acnh.creature.sea.repository.remote.ApiService
import com.rabross.acnh.creature.sea.repository.remote.SeaCreaturesRemoteRepo
import com.rabross.acnh.creature.sea.repository.local.SeaCreatureDao
import com.rabross.acnh.creature.sea.repository.local.SeaCreatureRoomDatabase
import com.rabross.acnh.creature.sea.repository.remote.RemoteRepo
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import com.rabross.acnh.creature.sea.usecases.SingleUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SeaCreatureModule {

    @Provides
    @ActivityScope
    fun provideSeaCreatureUsecase(repo: Repo<SeaCreatures>): SingleUseCase<SeaCreatures> {
        return GetSeaCreaturesUseCase(repo)
    }

    @Provides
    @ActivityScope
    fun provideRepo(remoteRepo: RemoteRepo<SeaCreatures>, localRepo: Cache<SeaCreatures>): Repo<SeaCreatures> {
        return SeaCreatureRepo(remoteRepo, localRepo)
    }

    @Provides
    @ActivityScope
    fun provideRemoteRepo(apiService: ApiService): RemoteRepo<SeaCreatures> {
        return SeaCreaturesRemoteRepo(apiService)
    }

    @Provides
    @ActivityScope
    fun provideCache(dao: SeaCreatureDao): Cache<SeaCreatures> {
        return SeaCreatureLocalRepo(dao)
    }

    @Provides
    @ActivityScope
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @ActivityScope
    fun provideSeaCreatureDao(context: Context): SeaCreatureDao {
        return SeaCreatureRoomDatabase.getDatabase(context).seaCreatureDao()
    }
}