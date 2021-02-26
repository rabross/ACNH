package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreature
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun getCreatures(): Flow<List<SeaCreature>>
    fun getCreature(id: String): Flow<SeaCreature>
}
