package com.rabross.acnh.creature.sea.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.SchedulersProvider
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeaCreatureViewModel @Inject constructor(
    private val seaCreaturesUseCase: GetSeaCreaturesUseCase,
    private val schedulers: SchedulersProvider
) : ViewModel() {

    private val _seaCreatures = MutableLiveData<SeaCreatureViewState>()
    val seaCreatures: LiveData<SeaCreatureViewState>
        get() = _seaCreatures

    fun fetchSeaCreatures() {
        viewModelScope.launch {
            seaCreaturesUseCase.execute()
                .onStart { _seaCreatures.value = SeaCreatureViewState.Loading }
                .catch { _seaCreatures.value = SeaCreatureViewState.Error }
                .collect { seaCreatures ->
                _seaCreatures.value = SeaCreatureViewState.Loaded(seaCreatures)
            }
        }
    }
}

sealed class SeaCreatureViewState {
    object Loading : SeaCreatureViewState()
    object Error : SeaCreatureViewState()
    data class Loaded(val seaCreatures: SeaCreatures) : SeaCreatureViewState()
}
