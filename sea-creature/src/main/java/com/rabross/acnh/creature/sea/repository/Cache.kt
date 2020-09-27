package com.rabross.acnh.creature.sea.repository

import io.reactivex.Completable

interface Cache<T> : Repo<T>{
    fun put(items: T): Completable
}