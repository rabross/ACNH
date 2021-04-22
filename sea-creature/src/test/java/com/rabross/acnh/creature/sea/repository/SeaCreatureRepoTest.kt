package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.content.creature.seaCreature
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.assertj.core.api.Assertions.assertThat

@ExperimentalCoroutinesApi
class SeaCreatureRepoTest {

    private val coroutineDispatcher = TestCoroutineDispatcher()

    @Test
    fun `given empty cache data is fetched from remote`() {
        coroutineDispatcher.runBlockingTest {
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
        coroutineDispatcher.runBlockingTest {
            val remoteRepo = mock<Repo<SeaCreatures>>()
            val localRepo = mock<Cache<SeaCreatures>> {
                on { get() } doReturn  flow { emit(listOf(seaCreature)) }
            }

            val sut = SeaCreatureRepo(remoteRepo, localRepo)

            assertThat(sut.get().first()).isEqualTo(listOf(seaCreature))
        }
    }

    private val seaCreature = seaCreature {
        id = 0
        name = "name"
        availability {
            time = listOf(7, 8, 9)
            months {
                northern = listOf(1, 2, 3)
                southern = listOf(4, 5, 6)
            }
        }
        shadow = SeaCreature.Shadow.Unknown
        price = 0
        catchphrase = "catchphrase"
        museumphrase = "museumphrase"
        imageUrl = "imageUri"
        iconUrl = "iconUri"
        speed = "speed"
    }
}