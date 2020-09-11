package com.rabross.acnh.creature.sea.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.SchedulersProvider
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SeaCreatureViewModel @Inject constructor(
    private val seaCreaturesUseCase: GetSeaCreaturesUseCase,
    private val schedulers: SchedulersProvider
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _seaCreatures = MutableLiveData<SeaCreatures>(emptyList())
    val seaCreatures: LiveData<SeaCreatures>
        get() = _seaCreatures

    fun fetchSeaCreatures() {
        seaCreaturesUseCase.execute()
            .subscribeOn(schedulers.io())
            .doOnSuccess { seaCreatures ->
                _seaCreatures.postValue(seaCreatures)
            }
            .onErrorReturn {
                emptyList()
            }
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .subscribe()
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}
