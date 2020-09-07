package com.rabross.acnh.creature.sea.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.creature.sea.ui.SeaCreatureAdapter

@BindingAdapter("update")
internal fun RecyclerView.bindData(seaCreatures: SeaCreatures) {
        (adapter as? SeaCreatureAdapter)?.update(seaCreatures)
}
