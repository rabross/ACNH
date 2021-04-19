package com.rabross.acnh.creature.sea.repository.remote.mappers

import com.rabross.acnh.creature.sea.repository.remote.model.SeaCreature
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

fun SeaCreature.toEntity(): SeaCreatureEntity {
    return SeaCreatureEntity(
        id, name.name,
        SeaCreatureEntity.Availability(
            availability.time_array,
            SeaCreatureEntity.Availability.Months(
                availability.month_array_northern,
                availability.month_array_southern
            )
        ),
        shadow.toShadow(), speed,
        price, catchPhrase, museumPhrase, imageUri, iconUri
    )
}

private fun String.toShadow(): SeaCreatureEntity.Shadow {
    return when (this) {
        "Smallest" -> SeaCreatureEntity.Shadow.Smallest
        "Small" -> SeaCreatureEntity.Shadow.Small
        "Medium" -> SeaCreatureEntity.Shadow.Medium
        "Large" -> SeaCreatureEntity.Shadow.Large
        "Largest" -> SeaCreatureEntity.Shadow.Largest
        else -> SeaCreatureEntity.Shadow.Unknown
    }
}
