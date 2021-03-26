package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.rabross.acnh.content.creature.SeaCreature
import com.rabross.acnh.core.image.ImageViewBinding
import com.rabross.acnh.core.viewmodel.ViewModelFactory
import com.rabross.acnh.creature.sea.R
import com.rabross.acnh.creature.sea.databinding.FragmentSeaCreaturesBinding
import com.rabross.acnh.creature.sea.databinding.SeaCreatureDataBindingComponent
import com.rabross.acnh.creature.sea.model.SeaCreatureAdapter
import com.rabross.acnh.creature.sea.ui.model.SeaCreatureDetail
import com.rabross.acnh.creature.sea.ui.model.toSeaCreatureDetail
import com.rabross.acnh.creature.sea.ui.util.GridSpacingItemDecoration
import javax.inject.Inject

class SeaCreaturesFragment
@Inject constructor(
    private val viewModelFactory: ViewModelFactory,
    imageViewBinding: ImageViewBinding
) : Fragment() {

    private val viewModel by viewModels<SeaCreatureViewModel> { viewModelFactory }

    private var _binding: FragmentSeaCreaturesBinding? = null
    private val binding get() = _binding!!

    init {
        DataBindingUtil.setDefaultComponent(SeaCreatureDataBindingComponent(imageViewBinding))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeaCreaturesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setupRecyclerView()
        viewModel.fetchSeaCreatures()
    }

    private fun setupRecyclerView() = with(binding.seaCreatureRecyclerview) {
        adapter = SeaCreatureAdapter(::onItemClick)
        addItemDecoration(GridSpacingItemDecoration(resources.getDimensionPixelSize(R.dimen.sea_creatures_item_spacing)))
        setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onItemClick(seaCreature: SeaCreature) {
        val action =
            SeaCreaturesFragmentDirections.actionSeaCreaturesFragmentToSeaCreatureDetailsFragment(
                SeaCreatureDetail()
            ).apply {
                seaCreatureDetail = seaCreature.toSeaCreatureDetail()
            }
        view?.findNavController()?.navigate(action)
    }
}
