package com.rabross.acnh.creature.sea.ui

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PageKeyedDataSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.rxjava2.RxPagingSource
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.flowable
import androidx.paging.rxjava2.observable
import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.SchedulersProvider
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import io.reactivex.Single
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
        /*seaCreaturesUseCase.getCreatures()
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
                })*/

        val listData = Pager(PagingConfig(pageSize = 6)) {
            SeaCreaturesRemotePagingSource(seaCreaturesUseCase, schedulers)
        }.observable.cachedIn(viewModelScope)

        listData
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe {
                _seaCreatures.value = SeaCreatureViewState.Loading
                compositeDisposable.add(it)
            }
            .subscribe(
                { seaCreatures ->
                    seaCreatures.
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

class SeaCreaturesRemotePagingSource(
    private val seaCreaturesUseCase: GetSeaCreaturesUseCase,
    private val schedulers: SchedulersProvider
) : RxPagingSource<Int, SeaCreature>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, SeaCreature>> {
        val position = params.key ?: 1

        return seaCreaturesUseCase.getCreature(position.toString())
            .subscribeOn(schedulers.io())
            .map { toLoadResult(it, position) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: SeaCreature, position: Int): LoadResult<Int, SeaCreature> {
        return LoadResult.Page(
            data = listOf(data),
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == 40) null else position + 1
        )
    }
}
