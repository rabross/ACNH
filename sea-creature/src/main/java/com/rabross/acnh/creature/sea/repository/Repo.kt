package com.rabross.acnh.creature.sea.repository

import io.reactivex.Single

interface Repo<T> {
    fun get(): Single<T>
}
