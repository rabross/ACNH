package com.rabross.acnh.creature.sea.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.DispatchersProvider
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeaCreatureViewModel @Inject constructor(
    private val seaCreaturesUseCase: GetSeaCreaturesUseCase,
    private val dispatcher: DispatchersProvider
) : ViewModel() {

    private val _seaCreatures = MutableStateFlow<SeaCreatureViewState>(SeaCreatureViewState.Loading)
    val seaCreatures: StateFlow<SeaCreatureViewState>
        get() = _seaCreatures

    fun fetchSeaCreatures() {
        viewModelScope.launch(dispatcher.io()) {
            try {
                val seaCreatures = seaCreaturesUseCase.execute().single()
                _seaCreatures.value = SeaCreatureViewState.Loaded(seaCreatures)
            } catch (exception: Exception) {
                _seaCreatures.value = SeaCreatureViewState.Error
            }
        }
    }
}

sealed class SeaCreatureViewState {
    object Loading : SeaCreatureViewState()
    object Error : SeaCreatureViewState()
    data class Loaded(val seaCreatures: SeaCreatures) : SeaCreatureViewState()
}
