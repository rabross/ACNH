package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.rabross.acnh.creature.sea.databinding.SeaCreaturesBinding
import com.rabross.acnh.creature.sea.di.inject
import javax.inject.Inject

class SeaCreatureActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: SeaCreaturesBinding

    private val viewModel by viewModels<SeaCreatureViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        binding = SeaCreaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.seaCreatures.observe(this) { seaCreatures ->
            binding.text.text = seaCreatures.toString()
        }
        viewModel.getSeaCreatures()
    }
}