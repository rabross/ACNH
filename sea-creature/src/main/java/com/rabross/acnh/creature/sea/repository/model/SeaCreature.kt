package com.rabross.acnh.creature.sea.repository.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias SeaCreatures = List<SeaCreature>

@Serializable
data class SeaCreature(
    val availability: Availability,
    @SerialName("catch-phrase")
    @SerializedName("catch-phrase")
    val catchPhrase: String,
    @SerialName("file-name")
    @SerializedName("file-name")
    val fileName: String,
    @SerialName("icon_uri")
    @SerializedName("icon_uri")
    val iconUri: String,
    val id: Int,
    @SerialName("image_uri")
    @SerializedName("image_uri")
    val imageUri: String,
    @SerialName("museum-phrase")
    @SerializedName("museum-phrase")
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
    @SerializedName("month-array-northern")
    val month_array_northern: List<Int>,
    @SerialName("month-array-southern")
    @SerializedName("month-array-southern")
    val month_array_southern: List<Int>,
    @SerialName("month-northern")
    @SerializedName("month-northern")
    val month_northern: String,
    @SerialName("month-southern")
    @SerializedName("month-southern")
    val month_southern: String,
    val time: String,
    @SerialName("time-array")
    @SerializedName("time-array")
    val time_array: List<Int>
)

@Serializable
data class Name(
    @SerialName("name-EUen")
    @SerializedName("name-EUen")
    val name: String
)