package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.mappers.toEntity
import com.rabross.acnh.creature.sea.repository.Repo
import io.reactivex.Single
import javax.inject.Inject

class SeaCreatureRepo @Inject constructor(
    private val apiService: SeaCreatureService
) : Repo<SeaCreatures> {
    override fun get(): Single<SeaCreatures> {
        return apiService.getSeaCreatures().map { seaCreatures ->
            seaCreatures.map { seaCreature ->
                seaCreature.toEntity()
            }
        }
    }
}
