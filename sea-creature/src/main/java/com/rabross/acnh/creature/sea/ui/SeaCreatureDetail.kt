package com.rabross.acnh.creature.sea.ui

import com.rabross.acnh.creature.sea.ui.item.capitalizeWords
import java.io.Serializable
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal data class SeaCreatureDetail(
    val name: String,
    val imageUrl: String,
    val catchphrase: String
) : Serializable

internal fun SeaCreatureEntity.toSeaCreatureDetail() =
    SeaCreatureDetail(name.capitalizeWords(), imageUrl, catchphrase)

internal val seaCreatureDetailDefault = SeaCreatureDetail("", "", "")