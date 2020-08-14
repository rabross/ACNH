package com.rabross.acnh.creature.sea.mappers

import com.rabross.acnh.creature.sea.models.SeaCreature
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

/**
 * A mapper to map the ShareDataModel from server to ShareDetailsModel in a presentable form.
 */
fun SeaCreature.toEntity(): SeaCreatureEntity {
    return SeaCreatureEntity(
        id, name.name_EUen,
        SeaCreatureEntity.Availability(
            availability.time_array,
            SeaCreatureEntity.Availability.Months(
                availability.month_array_northern,
                availability.month_array_southern
            )
        ),
        shadow.toShadow(),
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
