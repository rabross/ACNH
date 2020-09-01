package com.rabross.acnh.creature.sea.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rabross.acnh.content.creature.SeaCreatures

@BindingAdapter(value = ["adapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
}

@BindingAdapter(value = ["update"])
fun RecyclerView.bindData(seaCreatures: SeaCreatures) {
        (adapter as? SeaCreatureAdapter)?.update(seaCreatures)
}