package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.mappers.toEntity
import com.rabross.acnh.creature.sea.repository.Repo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteRepo @Inject constructor(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : Repo {

    override fun getCreatures(): Flow<SeaCreatures> {
        return flow {
            emit(
                apiService.getSeaCreatures().map { seaCreature ->
                    seaCreature.toEntity()
                }
            )
        }.flowOn(dispatcher)
    }

    override fun getCreature(id: String): Flow<SeaCreature> {
        return flow { emit(apiService.getSeaCreature(id).toEntity()) }.flowOn(dispatcher)
    }
}
