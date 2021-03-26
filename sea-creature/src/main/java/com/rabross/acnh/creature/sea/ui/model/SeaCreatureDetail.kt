package com.rabross.acnh.creature.sea.ui.model

import com.rabross.acnh.core.capitalizeWords
import java.io.Serializable
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal data class SeaCreatureDetail(
    val name: String = "",
    val imageUrl: String = "",
    val catchphrase: String = "",
    val speed: String = ""
) : Serializable

internal fun SeaCreatureEntity.toSeaCreatureDetail(): SeaCreatureDetail {
    return SeaCreatureDetail(name.capitalizeWords(), imageUrl, catchphrase, speed)
}