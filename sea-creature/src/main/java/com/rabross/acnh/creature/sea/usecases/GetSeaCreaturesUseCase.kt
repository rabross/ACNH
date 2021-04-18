package com.rabross.acnh.creature.sea.usecases

import com.rabross.acnh.creature.sea.repository.Repo
import com.rabross.acnh.content.creature.SeaCreatures
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSeaCreaturesUseCase @Inject constructor(private val apiRepo: Repo) :
    SingleUseCase<SeaCreatures> {

    override fun execute(): Flow<SeaCreatures> = apiRepo.getCreatures()
}