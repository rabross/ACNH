package com.rabross.acnh.creature.sea.databinding

import androidx.databinding.DataBindingComponent
import com.rabross.acnh.core.image.ImageViewBinding

class SeaCreatureDataBindingComponent (private val binding: ImageViewBinding) : DataBindingComponent {
    override fun getImageViewBinding() = binding
}
