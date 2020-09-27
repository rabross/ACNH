package com.rabross.acnh.creature.sea.usecases

import com.rabross.acnh.creature.sea.repository.Repo
import io.reactivex.Single
import javax.inject.Inject

class SingleRepoUseCase<T> @Inject constructor(private val apiRepo: Repo<T>) :
    SingleUseCase<T> {

    override fun execute(): Single<T> = apiRepo.get()
}