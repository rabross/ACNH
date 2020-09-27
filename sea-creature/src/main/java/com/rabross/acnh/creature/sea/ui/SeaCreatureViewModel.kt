package com.rabross.acnh.creature.sea.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.SchedulersProvider
import com.rabross.acnh.creature.sea.storage.SeaCreatureDao
import com.rabross.acnh.creature.sea.storage.mappers.toDBEntity
import com.rabross.acnh.creature.sea.storage.mappers.toEntity
import com.rabross.acnh.creature.sea.usecases.SingleRepoUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SeaCreatureViewModel @Inject constructor(
    private val seaCreaturesUseCase: SingleRepoUseCase<SeaCreatures>,
    private val seaCreaturesDao: SeaCreatureDao,
    private val schedulers: SchedulersProvider
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _seaCreatures = MutableLiveData<SeaCreatureViewState>().apply {
        value = SeaCreatureViewState.Loading
    }
    val seaCreatures: LiveData<SeaCreatureViewState>
        get() = _seaCreatures

    @SuppressLint("CheckResult")
    fun fetchSeaCreatures() {
        seaCreaturesDao.getSeaCreatures()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe {
                _seaCreatures.value = SeaCreatureViewState.Loading
                compositeDisposable.add(it)
            }
            .doOnError { _seaCreatures.value = SeaCreatureViewState.Error }
            .subscribe(
                { seaCreatures ->
                    _seaCreatures.value =
                        SeaCreatureViewState.Loaded(seaCreatures.map { seaCreature -> seaCreature.toEntity() })
                    Log.i("rob", "cache loaded")
                },
                {
                    _seaCreatures.value = SeaCreatureViewState.Error
                })

        seaCreaturesUseCase.execute()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe {
                _seaCreatures.value = SeaCreatureViewState.Loading
                compositeDisposable.add(it)
            }
            .doOnError {
                if (_seaCreatures.value !is SeaCreatureViewState.Loaded)
                    _seaCreatures.value = SeaCreatureViewState.Error
            }
            .flatMapCompletable { seaCreatures ->
                _seaCreatures.postValue(SeaCreatureViewState.Loaded(seaCreatures))
                seaCreaturesDao.insertAll(seaCreatures.map { it.toDBEntity() })
            }.subscribe({
                Log.i("rob", "completed")
            }, {
                Log.i("rob", "${it.localizedMessage}")
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
