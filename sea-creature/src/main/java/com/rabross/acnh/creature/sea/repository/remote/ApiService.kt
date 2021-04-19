package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.creature.sea.repository.remote.model.SeaCreature
import com.rabross.acnh.creature.sea.repository.remote.model.SeaCreatures
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1a/Sea/")
    suspend fun getSeaCreatures(): SeaCreatures

    @GET("v1/Sea/{id}")
    suspend fun getSeaCreature(@Path("id") id: String): SeaCreature

}