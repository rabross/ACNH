package com.rabross.acnh.creature.sea.repository

interface Cache<T> : Repo {
    suspend fun put(items: T)
}