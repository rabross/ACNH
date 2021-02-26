package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.creature.sea.repository.model.SeaCreature
import com.rabross.acnh.creature.sea.repository.model.SeaCreatures
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1a/Sea/")
    fun getSeaCreatures(): Single<SeaCreatures>

    @GET("v1/Sea/{id}")
    fun getSeaCreature(@Path("id") id: String): Single<SeaCreature>

}