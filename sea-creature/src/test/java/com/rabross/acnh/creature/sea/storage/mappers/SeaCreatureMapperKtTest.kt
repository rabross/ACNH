package com.rabross.acnh.creature.sea.storage.mappers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity
import com.rabross.acnh.creature.sea.storage.SeaCreature as SeaCreatureDBEntity

internal class SeaCreatureMapperKtTest {

    @Test
    fun `sea creature database model to domain model`() {
        assertThat(database.toEntity()).isEqualTo(domain)
    }

    @Test
    fun `sea creature domain model to database model`() {
        assertThat(domain.toDBEntity()).isEqualTo(database)
    }

    private val domain = SeaCreatureEntity(
        id = 0,
        name = "name",
        availability = SeaCreatureEntity.Availability(
            time = listOf(1, 2, 3),
            months = SeaCreatureEntity.Availability.Months(
                listOf(1, 2, 3), listOf(4, 5, 6)
            )
        ),
        shadow = SeaCreatureEntity.Shadow.Unknown,
        speed = "speed",
        price = 0,
        catchphrase = "catchphrase",
        museumphrase = "museumphrase",
        imageUrl = "imageUrl",
        iconUrl = "iconUrl"
    )

    private val database = SeaCreatureDBEntity(
        id = 0,
        name = "name",
        availability = SeaCreatureDBEntity.Availability(
            time = listOf(1, 2, 3),
            months = SeaCreatureDBEntity.Availability.Months(
                listOf(1, 2, 3), listOf(4, 5, 6)
            )
        ),
        shadow = SeaCreatureDBEntity.Shadow.Unknown,
        price = 0,
        catchphrase = "catchphrase",
        museumphrase = "museumphrase",
        imageUrl = "imageUrl",
        iconUrl = "iconUrl",
        speed = "speed"
    )
}
