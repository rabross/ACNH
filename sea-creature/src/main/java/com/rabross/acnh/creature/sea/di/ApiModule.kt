package com.rabross.acnh.creature.sea.di

import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.creature.sea.repository.remote.ApiService
import com.rabross.acnh.creature.sea.repository.remote.RemoteRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepo(apiService: ApiService): Repo {
        return RemoteRepo(apiService)
    }
}