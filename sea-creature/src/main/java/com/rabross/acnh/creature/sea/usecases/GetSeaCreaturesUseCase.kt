package com.rabross.acnh.creature.sea.usecases

import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.content.creature.SeaCreature
import io.reactivex.Single
import javax.inject.Inject

class GetSeaCreaturesUseCase @Inject constructor(private val apiRepo: Repo) {
    fun getCreatures(): Single<List<SeaCreature>> = apiRepo.getCreatures()
    fun getCreature(id: String): Single<SeaCreature> = apiRepo.getCreature(id)
}