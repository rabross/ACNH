package com.rabross.acnh.creature.sea.ui


import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.seaCreature
import com.rabross.acnh.core.network.DispatchersProvider
import com.rabross.acnh.creature.sea.usecases.SingleUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class SeaCreatureViewModelTest {

    private val dispatcherProviderMock = mock<DispatchersProvider> {
        on { io() } doReturn TestCoroutineDispatcher()
    }

    @Test
    fun `on init view state is Loading`() {
        val sut = SeaCreatureViewModel(mock(), mock())

        assertThat(sut.seaCreatures.value).isInstanceOf(SeaCreatureViewState.Loading::class.java)
    }

    @Test
    fun `when fetch returns a valid response view state is Loaded`() {
        val useCase = mock<SingleUseCase<SeaCreatures>> {
            on { execute() } doReturn flow { emit(emptyList<SeaCreature>()) }
        }
        val sut = SeaCreatureViewModel(useCase, dispatcherProviderMock)

        sut.fetch()

        assertThat(sut.seaCreatures.value).isInstanceOf(SeaCreatureViewState.Loaded::class.java)
    }

    @Test
    fun `when fetch returns an invalid response view state is Error`() {
        val useCase = mock<SingleUseCase<SeaCreatures>> {
            on { execute() } doReturn flow { }
        }
        val sut = SeaCreatureViewModel(useCase, dispatcherProviderMock)

        sut.fetch()

        assertThat(sut.seaCreatures.value).isInstanceOf(SeaCreatureViewState.Error::class.java)
    }

    @Test
    fun `filter returns a filtered list`() {
        val seaCreature1 = seaCreature { name = "filter1" }
        val seaCreature2 = seaCreature { name = "filter2" }
        val useCase = mock<SingleUseCase<SeaCreatures>> {
            on { execute() } doReturn flow { emit(listOf(seaCreature1, seaCreature2)) }
        }
        val sut = SeaCreatureViewModel(useCase, dispatcherProviderMock)

        sut.filter("filter2")

        assertThat((sut.seaCreatures.value as SeaCreatureViewState.Loaded).seaCreatures).containsExactly(seaCreature2)
    }
}