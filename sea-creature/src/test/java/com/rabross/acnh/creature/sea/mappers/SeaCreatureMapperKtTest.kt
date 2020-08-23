package com.rabross.acnh.creature.sea.mappers

import com.rabross.acnh.creature.sea.models.Availability
import com.rabross.acnh.creature.sea.models.Name
import com.rabross.acnh.creature.sea.models.SeaCreature
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

internal class SeaCreatureMapperKtTest {

    @Test
    fun `sea creature data model to domain model`() {
        assertThat(sut.toEntity()).isEqualTo(expected)
    }

    @Test
    fun `sea creature shadow data model to domain model`() {
        assertThat(sut.copy(shadow = "Smallest").toEntity()).isEqualTo(expected.copy(shadow = SeaCreatureEntity.Shadow.Smallest))
        assertThat(sut.copy(shadow = "Small").toEntity()).isEqualTo(expected.copy(shadow = SeaCreatureEntity.Shadow.Small))
        assertThat(sut.copy(shadow = "Medium").toEntity()).isEqualTo(expected.copy(shadow = SeaCreatureEntity.Shadow.Medium))
        assertThat(sut.copy(shadow = "Large").toEntity()).isEqualTo(expected.copy(shadow = SeaCreatureEntity.Shadow.Large))
        assertThat(sut.copy(shadow = "Largest").toEntity()).isEqualTo(expected.copy(shadow = SeaCreatureEntity.Shadow.Largest))
    }

    private val sut = SeaCreature(
        availability = Availability(
            isAllDay = true,
            isAllYear = true,
            month_array_northern = listOf(1, 2, 3),
            month_array_southern = listOf(4, 5, 6),
            month_northern = "month_northern",
            month_southern = "month_southern",
            time = "time",
            time_array = listOf(7, 8, 9)
        ),
        catchPhrase = "catchphrase",
        fileName = "fileName",
        iconUri = "iconUri",
        id = 0,
        imageUri = "imageUri",
        museumPhrase = "museumphrase",
        name = Name("name"),
        price = 0,
        shadow = "shadow",
        speed = "speed"
    )

    private val expected = SeaCreatureEntity(
        id = 0,
        name = "name",
        availability = SeaCreatureEntity.Availability(
            listOf(7, 8, 9),
            SeaCreatureEntity.Availability.Months(
                listOf(1, 2, 3), listOf(4, 5, 6)
            )
        ),
        shadow = SeaCreatureEntity.Shadow.Unknown,
        price = 0,
        catchphrase = "catchphrase",
        museumphrase = "museumphrase",
        image = "imageUri",
        icon = "iconUri"
    )
}
