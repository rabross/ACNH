package com.rabross.acnh.creature.sea.usecases

import io.reactivex.Single

interface SingleUseCase<R> {
    fun execute(): Single<R>
}