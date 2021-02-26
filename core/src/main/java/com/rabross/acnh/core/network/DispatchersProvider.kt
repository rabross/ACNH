package com.rabross.acnh.core.network

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {
    fun ui(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun computation(): CoroutineDispatcher
}