package com.rabross.acnh.core.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherFacade @Inject constructor() :
    DispatchersProvider {
    override fun io(): CoroutineDispatcher = Dispatchers.IO
    override fun computation(): CoroutineDispatcher = Dispatchers.Default
    override fun ui(): CoroutineDispatcher = Dispatchers.Main
}