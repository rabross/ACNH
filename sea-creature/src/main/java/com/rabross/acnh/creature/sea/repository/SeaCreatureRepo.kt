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
            localRepo.get().first().getOrNull() ?: remoteRepo.get().single().also { localRepo.put(it) }
        )
    }
}

private fun <T> List<T>.getOrNull(): List<T>? {
    return if (isNullOrEmpty()) null else this
}