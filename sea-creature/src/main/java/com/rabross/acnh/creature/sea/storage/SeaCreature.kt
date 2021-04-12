package com.rabross.acnh.creature.sea.storage

import androidx.room.*
import com.rabross.acnh.content.creature.SeaCreature
import kotlinx.serialization.Serializable

@Entity(tableName = "sea_creature_table")
data class SeaCreature(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    val name: String,
    val availability: Availability,
    val shadow: Shadow,
    val speed: String,
    val price: Int,
    val catchphrase: String,
    val museumphrase: String,
    val imageUrl: String,
    val iconUrl: String
) {

    @Serializable
    data class Availability(val time: List<Int>, val months: Months) {

        @Serializable
        data class Months(
            val northern: List<Int>,
            val southern: List<Int>
        )
    }

    @Serializable
    enum class Shadow {
        Smallest,
        Small,
        Medium,
        Large,
        Largest,
        Unknown
    }
}

