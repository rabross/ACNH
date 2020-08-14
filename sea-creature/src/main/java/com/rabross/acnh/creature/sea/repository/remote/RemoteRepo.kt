package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.creature.sea.mappers.toEntity
import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.repository.Repo
import io.reactivex.Single
import javax.inject.Inject

class RemoteRepo @Inject constructor(private val apiService: ApiService) :
    Repo {

    override fun getCreatures(): Single<SeaCreatures> {
        return apiService.getSeaCreatures().map { seaCreatures ->
            seaCreatures.map {
                    seaCreature -> seaCreature.toEntity()
            }
        }
    }

    override fun getCreature(id: String): Single<SeaCreature> {
        return apiService.getSeaCreature(id).map { it.toEntity() }
    }
}
