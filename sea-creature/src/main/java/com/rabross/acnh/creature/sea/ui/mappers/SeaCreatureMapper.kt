package com.rabross.acnh.creature.sea.ui.mappers

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.core.capitalizeWords
import com.rabross.acnh.creature.sea.ui.model.SeaCreatureDetail

internal fun SeaCreature.toSeaCreature() =
    com.rabross.acnh.creature.sea.ui.model.SeaCreature(name.capitalizeWords(), iconUrl)

internal fun SeaCreature.toSeaCreatureDetail() =
    SeaCreatureDetail(name.capitalizeWords(), imageUrl, catchphrase, speed)