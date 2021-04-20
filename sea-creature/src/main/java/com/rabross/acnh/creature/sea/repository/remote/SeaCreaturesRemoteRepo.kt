package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.repository.remote.mappers.toEntity
import com.rabross.acnh.creature.sea.repository.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SeaCreaturesRemoteRepo @Inject constructor(apiService: ApiService) : RemoteRepo<SeaCreatures>(apiService) {
    override fun get(): Flow<SeaCreatures> {
        return flow {
            emit(apiService.getSeaCreatures().map { seaCreature -> seaCreature.toEntity() })
        }
    }
}
