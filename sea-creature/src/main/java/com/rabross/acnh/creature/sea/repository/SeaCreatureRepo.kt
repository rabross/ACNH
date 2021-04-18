package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.repository.remote.RemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class SeaCreatureRepo @Inject constructor(
    private val remoteRepo: RemoteRepo,
    private val cache: Cache<SeaCreatures>
) : Repo {

    override fun getCreatures(): Flow<SeaCreatures> = flow {
        emit(
            cache.getCreatures().first().getOrNull() ?: remoteRepo.getCreatures().single()
                .also { cache.put(it) }
        )
    }

    override fun getCreature(id: String): Flow<SeaCreature> {
        TODO("Not yet implemented")
    }
}

private fun <T> List<T>.getOrNull(): List<T>? {
    return if (isNullOrEmpty()) null else this
}