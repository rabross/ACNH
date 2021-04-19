package com.rabross.acnh.creature.sea.repository

interface Cache<T> : Repo<T> {
    suspend fun put(items: T)
}