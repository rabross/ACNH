package com.rabross.acnh.creature.sea.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SeaCreatureDao {

    @Query("SELECT * from sea_creature_table WHERE id IN(:id)")
    fun getSeaCreature(id: Int): Flow<SeaCreature>

    @Query("SELECT * from sea_creature_table ORDER BY id ASC")
    fun getSeaCreatures(): Flow<SeaCreatures>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(seaCreatures: SeaCreatures)

    @Query("DELETE FROM sea_creature_table")
    suspend fun deleteAll()
}