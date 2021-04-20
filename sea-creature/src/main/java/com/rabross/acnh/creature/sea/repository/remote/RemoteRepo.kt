package com.rabross.acnh.creature.sea.repository.remote

import com.rabross.acnh.creature.sea.repository.Repo
import kotlinx.coroutines.flow.Flow

abstract class RemoteRepo<T>(protected val apiService: ApiService) : Repo<T> {
    abstract override fun get(): Flow<T>
}