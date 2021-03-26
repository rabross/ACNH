package com.rabross.acnh.creature.sea.ui.model

import com.rabross.acnh.core.capitalizeWords
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal data class SeaCreature(val name: String, val iconUrl: String)

internal fun SeaCreatureEntity.toSeaCreature() = SeaCreature(name.capitalizeWords(), iconUrl)