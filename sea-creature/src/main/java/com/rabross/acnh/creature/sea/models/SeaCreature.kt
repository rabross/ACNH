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
    @SerialName("name-CNzh")
    val name_CNzh: String,
    @SerialName("name-EUde")
    val name_EUde: String,
    @SerialName("name-EUen")
    val name_EUen: String,
    @SerialName("name-EUes")
    val name_EUes: String,
    @SerialName("name-EUfr")
    val name_EUfr: String,
    @SerialName("name-EUit")
    val name_EUit: String,
    @SerialName("name-EUnl")
    val name_EUnl: String,
    @SerialName("name-EUru")
    val name_EUru: String,
    @SerialName("name-JPja")
    val name_JPja: String,
    @SerialName("name-KRko")
    val name_KRko: String,
    @SerialName("name-TWzh")
    val name_TWzh: String,
    @SerialName("name-USen")
    val name_USen: String,
    @SerialName("name-USes")
    val name_USes: String,
    @SerialName("name-USfr")
    val name_USfr: String
)