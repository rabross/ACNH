package com.rabross.acnh.creature.sea.ui


import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
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
    fun `given an valid flow when fetch is called view state is Loaded`() {
        val useCase = mock<SingleUseCase<SeaCreatures>> {
            on { execute() } doReturn flow { emit(emptyList<SeaCreature>()) }
        }
        val sut = SeaCreatureViewModel(useCase, dispatcherProviderMock)

        sut.fetchSeaCreatures()

        assertThat(sut.seaCreatures.value).isInstanceOf(SeaCreatureViewState.Loaded::class.java)
    }

    @Test
    fun `given an invalid flow when fetch is called view state is Error`() {
        val useCase = mock<SingleUseCase<SeaCreatures>> {
            on { execute() } doReturn flow { }
        }
        val sut = SeaCreatureViewModel(useCase, dispatcherProviderMock)

        sut.fetchSeaCreatures()

        assertThat(sut.seaCreatures.value).isInstanceOf(SeaCreatureViewState.Error::class.java)
    }
}