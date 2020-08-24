package com.rabross.acnh.creature.sea.di

import com.rabross.acnh.core.ActivityScope
import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.creature.sea.repository.remote.ApiService
import com.rabross.acnh.creature.sea.repository.remote.RemoteRepo
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
    fun provideRepo(apiService: ApiService): Repo {
        return RemoteRepo(apiService)
    }
}