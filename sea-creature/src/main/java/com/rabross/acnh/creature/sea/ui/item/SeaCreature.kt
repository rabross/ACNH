package com.rabross.acnh.creature.sea.ui.item

import java.util.*
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal data class SeaCreature(val name: String, val iconUrl: String)

internal fun SeaCreatureEntity.toSeaCreature() = SeaCreature(name.capitalizeWords(), iconUrl)

private fun String.capitalizeWords() =
    split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }