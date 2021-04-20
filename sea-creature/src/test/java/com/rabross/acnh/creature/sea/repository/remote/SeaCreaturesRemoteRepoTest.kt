package com.rabross.acnh.creature.sea.repository.remote

import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SeaCreaturesRemoteRepoTest {

    @Test
    fun `api service is invoked`() = TestCoroutineDispatcher().runBlockingTest {
        val apiServiceMock = mock<ApiService> {
            onBlocking { getSeaCreatures() } doReturn emptyList()
        }
        val sut = SeaCreaturesRemoteRepo(apiServiceMock)

        sut.get().single()

        verify(apiServiceMock).getSeaCreatures()
    }
}