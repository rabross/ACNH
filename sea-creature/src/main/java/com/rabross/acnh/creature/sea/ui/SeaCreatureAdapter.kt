package com.rabross.acnh.creature.sea.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.content.creature.SeaCreatures
import com.rabross.acnh.core.ui.setOnSafeClickListener
import com.rabross.acnh.creature.sea.databinding.ItemSeaCreatureBinding
import com.rabross.acnh.creature.sea.ui.item.SeaCreatureViewHolder
import com.rabross.acnh.creature.sea.ui.item.toSeaCreature

internal class SeaCreatureAdapter(private val callback: (SeaCreature) -> Unit) : RecyclerView.Adapter<SeaCreatureViewHolder>() {

    private val listManager = createListManager()

    fun update(seaCreatures: SeaCreatures) {
        listManager.submitList(seaCreatures)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeaCreatureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSeaCreatureBinding.inflate(layoutInflater)
        return SeaCreatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeaCreatureViewHolder, position: Int) {
        val seaCreature = listManager.currentList[position]
        holder.binding.viewModel = seaCreature.toSeaCreature()
        holder.binding.root.setOnSafeClickListener {
            callback(seaCreature)
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = listManager.currentList.size

    private fun <VH : RecyclerView.ViewHolder> RecyclerView.Adapter<VH>.createListManager(): AsyncListDiffer<SeaCreature> {
        val asyncDifferConfig = AsyncDifferConfig.Builder(Companion).build()
        return AsyncListDiffer(AdapterListUpdateCallback(this), asyncDifferConfig)
    }

    companion object : DiffUtil.ItemCallback<SeaCreature>() {
        override fun areItemsTheSame(oldItem: SeaCreature, newItem: SeaCreature): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: SeaCreature, newItem: SeaCreature): Boolean =
            oldItem.id == newItem.id
    }
}