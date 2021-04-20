package com.rabross.acnh.creature.sea.repository.local

import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SeaCreatureLocalRepoTest {

    @Test
    fun `when get is called dao is invoked`() {
        val daoMock = mock<SeaCreatureDao>()
        val sut = SeaCreatureLocalRepo(daoMock)

        sut.get()

        verify(daoMock).getSeaCreatures()
    }

    @Test
    fun `when put is called dao is invoked`() = TestCoroutineScope().runBlockingTest {
        val daoMock = mock<SeaCreatureDao>()
        val sut = SeaCreatureLocalRepo(daoMock)

        sut.put(emptyList())

        verify(daoMock).insertAll(emptyList())
    }
}