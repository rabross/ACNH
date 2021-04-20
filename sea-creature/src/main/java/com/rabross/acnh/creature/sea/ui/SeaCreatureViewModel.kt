package com.rabross.acnh.creature.sea.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.DispatchersProvider
import com.rabross.acnh.creature.sea.usecases.SingleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class SeaCreatureViewModel @Inject constructor(
    private val seaCreaturesUseCase: SingleUseCase<SeaCreatures>,
    private val dispatcher: DispatchersProvider
) : ViewModel() {

    private val _seaCreatures = MutableStateFlow<SeaCreatureViewState>(SeaCreatureViewState.Loading)
    val seaCreatures: StateFlow<SeaCreatureViewState>
        get() = _seaCreatures

    fun fetchSeaCreatures() {
        viewModelScope.launch(dispatcher.io()) {
            try {
                _seaCreatures.value = SeaCreatureViewState.Loaded(seaCreaturesUseCase.execute().first())
            } catch (exception: Exception) {
                _seaCreatures.value = SeaCreatureViewState.Error
                Timber.d(exception)
            }
        }
    }
}

sealed class SeaCreatureViewState {
    object Loading : SeaCreatureViewState()
    object Error : SeaCreatureViewState()
    data class Loaded(val seaCreatures: SeaCreatures) : SeaCreatureViewState()
}
