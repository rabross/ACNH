package com.rabross.acnh.creature.sea.ui.model

import com.rabross.acnh.content.creature.SeaCreature

typealias SeaCreatures = List<SeaCreature>
internal data class SeaCreature(val name: String, val iconUrl: String)