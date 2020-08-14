package com.rabross.acnh.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import com.rabross.acnh.data.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val seaCreaturesUseCase: GetSeaCreaturesUseCase,
    private val schedulers: SchedulersProvider
) : ViewModel() {

    private val _seaCreatures = MutableLiveData<SeaCreatures>()
    val seaCreatures: LiveData<SeaCreatures> = _seaCreatures
    private val compositeDisposable = CompositeDisposable()

    fun getSeaCreatures() {
        seaCreaturesUseCase.execute()
            .subscribeOn(schedulers.io())
            .subscribe { seaCreatures -> _seaCreatures.postValue(seaCreatures) }
            .let { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}
