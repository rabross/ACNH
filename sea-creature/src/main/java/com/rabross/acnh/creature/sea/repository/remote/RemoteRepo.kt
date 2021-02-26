package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.mappers.toEntity
import com.rabross.acnh.creature.sea.repository.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepo @Inject constructor(
    private val apiService: ApiService
) : Repo {

    override fun getCreatures(): Flow<SeaCreatures> {
        return flow {
            emit(apiService.getSeaCreatures().map { seaCreature -> seaCreature.toEntity() })
        }
    }

    override fun getCreature(id: String): Flow<SeaCreature> {
        return flow {
            emit(apiService.getSeaCreature(id).toEntity())
        }
    }
}
