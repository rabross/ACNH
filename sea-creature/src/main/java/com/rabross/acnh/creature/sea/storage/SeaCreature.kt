package com.rabross.acnh.creature.sea.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sea_creature_table")
data class SeaCreature(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val name: String
)