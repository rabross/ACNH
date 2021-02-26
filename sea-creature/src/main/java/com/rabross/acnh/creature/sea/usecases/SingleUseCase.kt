package com.rabross.acnh.creature.sea.usecases

import kotlinx.coroutines.flow.Flow

interface SingleUseCase<R> {
    fun execute(): Flow<R>
}