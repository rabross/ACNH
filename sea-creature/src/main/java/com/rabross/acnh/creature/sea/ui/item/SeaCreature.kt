package com.rabross.acnh.creature.sea.ui.item

import java.util.*
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal data class SeaCreature(val name: String, val imageUrl: String)

internal fun SeaCreatureEntity.toSeaCreature() = SeaCreature(name.capitalizeWords(), imageUrl)

private fun String.capitalizeWords(): String =
    split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }