package com.rabross.acnh.creature.sea.repository.local

import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.repository.Cache
import com.rabross.acnh.creature.sea.storage.SeaCreatureDao
import com.rabross.acnh.creature.sea.storage.mappers.toDBEntity
import com.rabross.acnh.creature.sea.storage.mappers.toEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DatabaseCache @Inject constructor(private val seaCreatureDao: SeaCreatureDao) :
    Cache<SeaCreatures> {

    override fun get(): Single<SeaCreatures> {
        return seaCreatureDao.getSeaCreatures().map { seaCreatures ->
            seaCreatures.map { seaCreature ->
                seaCreature.toEntity()
            }
        }
    }

    override fun put(items: SeaCreatures): Completable {
        return seaCreatureDao.insertAll(items.map { seaCreature -> seaCreature.toDBEntity() })
    }

    /*override fun deleteAll(): Completable {
        return seaCreatureDao.deleteAll()
    }*/
}
