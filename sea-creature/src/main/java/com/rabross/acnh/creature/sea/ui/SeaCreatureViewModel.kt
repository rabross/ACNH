package com.rabross.acnh.creature.sea.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.network.DispatchersProvider
import com.rabross.acnh.creature.sea.storage.SeaCreatureDao
import com.rabross.acnh.creature.sea.storage.mappers.toDBEntity
import com.rabross.acnh.creature.sea.storage.mappers.toEntity
import com.rabross.acnh.creature.sea.usecases.GetSeaCreaturesUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeaCreatureViewModel @Inject constructor(
    private val seaCreaturesUseCase: GetSeaCreaturesUseCase,
    private val seaCreaturesDao: SeaCreatureDao,
    private val dispatcher: DispatchersProvider
) : ViewModel() {

    private val _seaCreatures = MutableStateFlow<SeaCreatureViewState>(SeaCreatureViewState.Loading)
    val seaCreatures: StateFlow<SeaCreatureViewState>
        get() = _seaCreatures

    fun fetchSeaCreatures() {
        viewModelScope.launch(dispatcher.io()) {
            try {
                var seaCreatures = seaCreaturesDao.getSeaCreatures().first().map { it.toEntity() }
                if(seaCreatures.isEmpty()){
                    Log.i("rob", "remote")
                    seaCreatures = seaCreaturesUseCase.execute().single()
                    seaCreaturesDao.insertAll(seaCreatures.map { it.toDBEntity() })
                } else {
                    Log.i("rob", "local")
                }
                _seaCreatures.value = SeaCreatureViewState.Loaded(seaCreatures)
            } catch (exception: Exception) {
                _seaCreatures.value = SeaCreatureViewState.Error
                Log.i("rob", "$exception")
            }
        }
    }
}

sealed class SeaCreatureViewState {
    object Loading : SeaCreatureViewState()
    object Error : SeaCreatureViewState()
    data class Loaded(val seaCreatures: SeaCreatures) : SeaCreatureViewState()
}
