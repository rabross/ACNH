package com.rabross.acnh.creature.sea.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SeaCreatureDao {

    @Query("SELECT * from sea_creature_table WHERE id IN(:id)")
    fun getSeaCreature(id: Int): Single<SeaCreature>

    @Query("SELECT * from sea_creature_table ORDER BY id ASC")
    fun getSeaCreatures(): Single<List<SeaCreature>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(seaCreatures: List<SeaCreature>): Completable

    @Query("DELETE FROM sea_creature_table")
    fun deleteAll(): Completable
}