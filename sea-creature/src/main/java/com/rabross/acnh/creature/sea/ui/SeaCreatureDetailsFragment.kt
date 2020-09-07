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
@Inject constructor(
    private val imageViewBinding: ImageViewBinding
) : Fragment() {

    private val args: SeaCreatureDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DataBindingUtil.setDefaultComponent(SeaCreatureDataBindingComponent(imageViewBinding))
        val binding = FragmentSeaCreatureDetailsBinding.inflate(layoutInflater)
        binding.viewModel = SeaCreatureDetail(args.seaCreatureName, args.seaCreatureImageUrl)
        return binding.root
    }
}
