package com.rabross.acnh.creature.sea.repository.local.mappers

import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity
import com.rabross.acnh.creature.sea.repository.local.model.SeaCreature as SeaCreatureDBEntity

internal fun SeaCreatureDBEntity.toEntity(): SeaCreatureEntity {
    return SeaCreatureEntity(
        id, name,
        availability.toEntity(),
        shadow.toEntity(),
        speed, price, catchphrase, museumphrase, imageUrl, iconUrl
    )
}

internal fun SeaCreatureEntity.toDBEntity(): SeaCreatureDBEntity {
    return SeaCreatureDBEntity(
        id, name,
        availability.toDBEntity(),
        shadow.toDBEntity(),
        speed, price, catchphrase, museumphrase, imageUrl, iconUrl
    )
}

private fun SeaCreatureDBEntity.Availability.toEntity(): SeaCreatureEntity.Availability {
    return SeaCreatureEntity.Availability(time, months.toEntity())
}

private fun SeaCreatureDBEntity.Availability.Months.toEntity(): SeaCreatureEntity.Availability.Months {
    return SeaCreatureEntity.Availability.Months(northern, southern)
}

private fun SeaCreatureDBEntity.Shadow.toEntity(): SeaCreatureEntity.Shadow {
    return when (this) {
        SeaCreatureDBEntity.Shadow.Smallest -> SeaCreatureEntity.Shadow.Smallest
        SeaCreatureDBEntity.Shadow.Small -> SeaCreatureEntity.Shadow.Small
        SeaCreatureDBEntity.Shadow.Medium -> SeaCreatureEntity.Shadow.Medium
        SeaCreatureDBEntity.Shadow.Large -> SeaCreatureEntity.Shadow.Large
        SeaCreatureDBEntity.Shadow.Largest -> SeaCreatureEntity.Shadow.Largest
        SeaCreatureDBEntity.Shadow.Unknown -> SeaCreatureEntity.Shadow.Unknown
    }
}

private fun SeaCreatureEntity.Availability.toDBEntity(): SeaCreatureDBEntity.Availability {
    return SeaCreatureDBEntity.Availability(time, months.toDBEntity())
}

private fun SeaCreatureEntity.Availability.Months.toDBEntity(): SeaCreatureDBEntity.Availability.Months {
    return SeaCreatureDBEntity.Availability.Months(northern, southern)
}

private fun SeaCreatureEntity.Shadow.toDBEntity(): SeaCreatureDBEntity.Shadow {
    return when (this) {
        SeaCreatureEntity.Shadow.Smallest -> SeaCreatureDBEntity.Shadow.Smallest
        SeaCreatureEntity.Shadow.Small -> SeaCreatureDBEntity.Shadow.Small
        SeaCreatureEntity.Shadow.Medium -> SeaCreatureDBEntity.Shadow.Medium
        SeaCreatureEntity.Shadow.Large -> SeaCreatureDBEntity.Shadow.Large
        SeaCreatureEntity.Shadow.Largest -> SeaCreatureDBEntity.Shadow.Largest
        SeaCreatureEntity.Shadow.Unknown -> SeaCreatureDBEntity.Shadow.Unknown
    }
}