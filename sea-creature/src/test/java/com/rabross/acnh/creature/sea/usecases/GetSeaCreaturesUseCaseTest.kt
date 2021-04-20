package com.rabross.acnh.creature.sea.usecases

import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.repository.Repo
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class GetSeaCreaturesUseCaseTest {

    @Test
    fun `repo is invoked on execute`() {
        val repoMock = mock<Repo<SeaCreatures>>()
        val sut = GetSeaCreaturesUseCase(repoMock)

        sut.execute()

        verify(repoMock).get()
    }
}