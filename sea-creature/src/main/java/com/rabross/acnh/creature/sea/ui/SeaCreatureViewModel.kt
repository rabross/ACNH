package com.rabross.acnh.creature.sea.ui

import android.annotation.SuppressLint
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
    private val _seaCreatures = MutableLiveData<SeaCreatureViewState>()
    val seaCreatures: LiveData<SeaCreatureViewState>
        get() = _seaCreatures

    @SuppressLint("CheckResult")
    fun fetchSeaCreatures() {
        seaCreaturesUseCase.execute()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe {
                _seaCreatures.value = SeaCreatureViewState.Loading
                compositeDisposable.add(it)
            }
            .subscribe(
                { seaCreatures ->
                    _seaCreatures.value = SeaCreatureViewState.Loaded(seaCreatures)
                },
                {
                    _seaCreatures.value = SeaCreatureViewState.Error
                })
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}

sealed class SeaCreatureViewState {
    object Loading : SeaCreatureViewState()
    object Error : SeaCreatureViewState()
    data class Loaded(val seaCreatures: SeaCreatures) : SeaCreatureViewState()
}
