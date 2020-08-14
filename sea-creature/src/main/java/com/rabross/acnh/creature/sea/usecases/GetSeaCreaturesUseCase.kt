package com.rabross.acnh.creature.sea.usecases

import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.content.creature.SeaCreature
import io.reactivex.Single
import javax.inject.Inject

class GetSeaCreaturesUseCase @Inject constructor(private val apiRepo: Repo) :
    SingleUseCase<List<SeaCreature>> {

    override fun execute(): Single<List<SeaCreature>> = apiRepo.getCreatures()
}