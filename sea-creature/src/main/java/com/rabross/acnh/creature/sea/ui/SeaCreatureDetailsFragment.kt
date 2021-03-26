package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rabross.acnh.core.image.ImageViewBinding
import com.rabross.acnh.creature.sea.databinding.FragmentSeaCreatureDetailsBinding
import com.rabross.acnh.creature.sea.databinding.SeaCreatureDataBindingComponent
import javax.inject.Inject

class SeaCreatureDetailsFragment
@Inject constructor(imageViewBinding: ImageViewBinding) : Fragment() {

    private val args by navArgs<SeaCreatureDetailsFragmentArgs>()

    init {
        DataBindingUtil.setDefaultComponent(SeaCreatureDataBindingComponent(imageViewBinding))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSeaCreatureDetailsBinding.inflate(layoutInflater)
        binding.viewModel = args.seaCreatureDetail
        return binding.root
    }
}
