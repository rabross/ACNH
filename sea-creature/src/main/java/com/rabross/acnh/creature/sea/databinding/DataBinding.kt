package com.rabross.acnh.creature.sea.databinding

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rabross.acnh.creature.sea.model.SeaCreatureAdapter
import com.rabross.acnh.creature.sea.ui.SeaCreatureViewState

@BindingAdapter("update")
internal fun RecyclerView.bindData(seaCreaturesViewState: SeaCreatureViewState) {
    visibility = when (seaCreaturesViewState) {
        is SeaCreatureViewState.Loaded -> {
            (adapter as? SeaCreatureAdapter)?.update(seaCreaturesViewState.seaCreatures)
            VISIBLE
        }
        else -> GONE
    }
}

@BindingAdapter("handleLoading")
internal fun View.bindData(seaCreaturesViewState: SeaCreatureViewState) {
    visibility = when (seaCreaturesViewState) {
        is SeaCreatureViewState.Loading -> VISIBLE
        else -> GONE
    }
}

@BindingAdapter("handleError")
internal fun View.bindError(seaCreaturesViewState: SeaCreatureViewState) {
    visibility = when (seaCreaturesViewState) {
        is SeaCreatureViewState.Error -> VISIBLE
        else -> GONE
    }
}
