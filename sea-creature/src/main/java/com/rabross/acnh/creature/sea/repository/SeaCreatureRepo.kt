package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreatures
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class SeaCreatureRepo @Inject constructor(
    private val remoteRepo: Repo<SeaCreatures>,
    private val localRepo: Cache<SeaCreatures>
) : Repo<SeaCreatures> {

    override fun get(): Flow<SeaCreatures> = flow {
        emit(
            // TODO: 18/04/2021 add timber logs in <also> blocks
            localRepo.get().first().getOrNull() ?: remoteRepo.get().single().apply { localRepo.put(this) }
        )
    }
}

private fun <T> List<T>.getOrNull(): List<T>? {
    return if (isNullOrEmpty()) null else this
}