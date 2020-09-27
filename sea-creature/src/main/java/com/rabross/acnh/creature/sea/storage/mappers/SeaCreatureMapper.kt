package com.rabross.acnh.creature.sea.storage.mappers

import com.rabross.acnh.creature.sea.storage.SeaCreature
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

fun SeaCreature.toEntity(): SeaCreatureEntity {
    return SeaCreatureEntity(
        id, name,
        SeaCreatureEntity.Availability(
            emptyList(), SeaCreatureEntity.Availability.Months(
                emptyList(), emptyList()
            )
        ),
        SeaCreatureEntity.Shadow.Unknown, "speed",
        0, "catchPhrase", "museumPhrase", "imageUri", "iconUri"
    )
}

fun SeaCreatureEntity.toDBEntity(): SeaCreature {
    return SeaCreature(
        id, name,
    )
}