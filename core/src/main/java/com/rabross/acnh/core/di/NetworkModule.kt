package com.rabross.acnh.core.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rabross.acnh.core.network.SchedulersFacade
import com.rabross.acnh.core.network.SchedulersProvider
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @OptIn(UnstableDefault::class)
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl("https://acnhapi.com/")
            .addConverterFactory(Json(JsonConfiguration(ignoreUnknownKeys = true)).asConverterFactory(contentType))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideSchedulers(schedulersFacade: SchedulersFacade): SchedulersProvider = schedulersFacade
}