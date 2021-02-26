package com.rabross.acnh.core.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rabross.acnh.core.network.DispatcherFacade
import com.rabross.acnh.core.network.DispatchersProvider
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

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

    @ExperimentalSerializationApi
    @Provides
    @Named("serialization")
    fun providesSerializationConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        return json.asConverterFactory(contentType)
    }

    @Provides
    @Named("gson")
    fun providesGsonConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        @Named("serialization") converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://acnhapi.com/")
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideDispatchers(dispatchersFacade: DispatcherFacade): DispatchersProvider = dispatchersFacade
}