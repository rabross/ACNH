package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.assertj.core.api.Assertions.assertThat

class SeaCreatureRepoTest {

    @Test
    fun `given empty cache data is fetched from remote`() {
        runBlocking {
            val remoteRepo = mock<Repo<SeaCreatures>> {
                on { get() } doReturn flow { emit(listOf(seaCreature)) }
            }
            val localRepo = mock<Cache<SeaCreatures>> {
                on { get() } doReturn flow { emit(emptyList<SeaCreature>()) }
            }

            val sut = SeaCreatureRepo(remoteRepo, localRepo)

            assertThat(sut.get().first()).isEqualTo(listOf(seaCreature))
        }
    }

    @Test
    fun `given available cache data is fetched from local`() {
        runBlocking {
            val remoteRepo = mock<Repo<SeaCreatures>>()
            val localRepo = mock<Cache<SeaCreatures>> {
                on { get() } doReturn  flow { emit(listOf(seaCreature)) }
            }

            val sut = SeaCreatureRepo(remoteRepo, localRepo)

            assertThat(sut.get().first()).isEqualTo(listOf(seaCreature))
        }
    }

    private val seaCreature = SeaCreature(
        id = 0,
        name = "name",
        availability = SeaCreature.Availability(
            listOf(7, 8, 9),
            SeaCreature.Availability.Months(
                listOf(1, 2, 3), listOf(4, 5, 6)
            )
        ),
        shadow = SeaCreature.Shadow.Unknown,
        price = 0,
        catchphrase = "catchphrase",
        museumphrase = "museumphrase",
        imageUrl = "imageUri",
        iconUrl = "iconUri",
        speed = "speed"
    )
}