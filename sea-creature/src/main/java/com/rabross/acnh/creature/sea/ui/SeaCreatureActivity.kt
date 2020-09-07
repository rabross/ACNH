package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rabross.acnh.core.image.ImageViewBinding
import com.rabross.acnh.creature.sea.R
import com.rabross.acnh.creature.sea.databinding.SeaCreatureDataBindingComponent
import com.rabross.acnh.creature.sea.databinding.SeaCreaturesBinding
import com.rabross.acnh.creature.sea.di.inject
import javax.inject.Inject

class SeaCreatureActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var imageViewBinding: ImageViewBinding

    private lateinit var binding: SeaCreaturesBinding

    private val viewModel by viewModels<SeaCreatureViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        DataBindingUtil.setDefaultComponent(SeaCreatureDataBindingComponent(imageViewBinding))
        binding = SeaCreaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.seaCreatureRecyclerview.apply {
            setHasFixedSize(true)
            adapter = SeaCreatureAdapter()
            layoutManager =
                GridLayoutManager(this.context, resources.getInteger(R.integer.sea_creatures_span))
            addItemDecoration(
                GridSpacingItemDecoration(
                    resources.getDimension(R.dimen.sea_creatures_item_spacing).toInt()
                )
            )
        }
        viewModel.fetchSeaCreatures()
    }
}
