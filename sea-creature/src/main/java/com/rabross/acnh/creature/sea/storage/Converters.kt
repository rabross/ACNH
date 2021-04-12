package com.rabross.acnh.creature.sea.storage

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun toShadow(value: String) = Json.decodeFromString<SeaCreature.Shadow>(value)

    @TypeConverter
    fun fromShadow(value: SeaCreature.Shadow) = Json.encodeToString(value)

    @TypeConverter
    fun toAvailability(value: String) = Json.decodeFromString<SeaCreature.Availability>(value)

    @TypeConverter
    fun fromAvailability(value: SeaCreature.Availability) = Json.encodeToString(value)
}