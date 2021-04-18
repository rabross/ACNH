package com.rabross.acnh.creature.sea.repository.local

import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.repository.Cache
import com.rabross.acnh.creature.sea.storage.SeaCreatureDao
import com.rabross.acnh.creature.sea.storage.mappers.toDBEntity
import com.rabross.acnh.creature.sea.storage.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SeaCreatureLocalRepo @Inject constructor(private val seaCreatureDao: SeaCreatureDao) :
    Cache<SeaCreatures> {

    override fun get(): Flow<SeaCreatures> {
        return seaCreatureDao.getSeaCreatures().map { seaCreatures ->
            seaCreatures.map { seaCreature ->
                seaCreature.toEntity()
            }
        }
    }

    override suspend fun put(items: SeaCreatures) {
        seaCreatureDao.insertAll(items.map { seaCreature -> seaCreature.toDBEntity() })
    }
}
