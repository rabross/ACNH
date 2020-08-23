package com.rabross.acnh.creature.sea.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias SeaCreatures = List<SeaCreature>

@Serializable
data class SeaCreature(
    val availability: Availability,
    @SerialName("catch-phrase")
    val catchPhrase: String,
    @SerialName("file-name")
    val fileName: String,
    @SerialName("icon_uri")
    val iconUri: String,
    val id: Int,
    @SerialName("image_uri")
    val imageUri: String,
    @SerialName("museum-phrase")
    val museumPhrase: String,
    val name: Name,
    val price: Int,
    val shadow: String,
    val speed: String
)

@Serializable
data class Availability(
    val isAllDay: Boolean,
    val isAllYear: Boolean,
    @SerialName("month-array-northern")
    val month_array_northern: List<Int>,
    @SerialName("month-array-southern")
    val month_array_southern: List<Int>,
    @SerialName("month-northern")
    val month_northern: String,
    @SerialName("month-southern")
    val month_southern: String,
    val time: String,
    @SerialName("time-array")
    val time_array: List<Int>
)

@Serializable
data class Name(
    @SerialName("name-EUen")
    val name: String
)