package com.rabross.acnh.creature.sea.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.DispatchersProvider
import com.rabross.acnh.creature.sea.ui.mappers.toSeaCreatureDetail
import com.rabross.acnh.creature.sea.usecases.SingleUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.RENDEZVOUS
import kotlinx.coroutines.flow.*
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

    private val clicks = Channel<SeaCreature>(RENDEZVOUS)

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

    fun onClick(seaCreature: SeaCreature){
        viewModelScope.launch(dispatcher.ui()) {
            clicks.send(seaCreature)
        }
    }

    fun handleClicks(handler: (NavDirections) -> Unit) {
        viewModelScope.launch(dispatcher.ui()) {
            clicks.consumeAsFlow().collect { seaCreature ->
                handler(
                    SeaCreaturesFragmentDirections.toDetailsFragment(
                        seaCreature.toSeaCreatureDetail()
                    )
                )
            }
        }
    }
}

sealed class SeaCreatureViewState {
    object Loading : SeaCreatureViewState()
    object Error : SeaCreatureViewState()
    data class Loaded(val seaCreatures: SeaCreatures) : SeaCreatureViewState()
}
