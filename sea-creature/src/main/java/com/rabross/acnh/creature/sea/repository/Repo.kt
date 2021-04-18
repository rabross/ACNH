package com.rabross.acnh.creature.sea.repository

import kotlinx.coroutines.flow.Flow

interface Repo<T> {
    fun get(): Flow<T>
}
