package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun getCreatures(): Flow<SeaCreatures>
    fun getCreature(id: String): Flow<SeaCreature>
}
