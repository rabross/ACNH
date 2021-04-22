package com.rabross.acnh.creature.sea.repository.local.mappers

import com.rabross.acnh.content.creature.seaCreature
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity
import com.rabross.acnh.creature.sea.repository.local.model.SeaCreature as SeaCreatureDBEntity

internal class SeaCreatureMapperKtTest {

    @Test
    fun `sea creature database model to domain model`() {
        assertThat(database.toEntity()).isEqualTo(domain)
    }

    @Test
    fun `sea creature domain model to database model`() {
        assertThat(domain.toDBEntity()).isEqualTo(database)
    }

    private val domain = seaCreature {
        id = 0
        name = "name"
        availability {
            time = listOf(1, 2, 3)
            months {
                northern = listOf(1, 2, 3)
                southern = listOf(4, 5, 6)
            }
        }
        shadow = SeaCreatureEntity.Shadow.Unknown
        price = 0
        catchphrase = "catchphrase"
        museumphrase = "museumphrase"
        imageUrl = "imageUrl"
        iconUrl = "iconUrl"
        speed = "speed"
    }

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
