package com.rabross.acnh.creature.sea.ui

import com.rabross.acnh.creature.sea.ui.item.SeaCreature
import com.rabross.acnh.creature.sea.ui.item.capitalizeWords
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal data class SeaCreatureDetail(val name: String, val imageUrl: String)

internal fun SeaCreatureEntity.toSeaCreatureDetail() = SeaCreature(name.capitalizeWords(), imageUrl)