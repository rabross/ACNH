package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.rabross.acnh.creature.sea.R
import com.rabross.acnh.creature.sea.di.inject
import kotlinx.android.synthetic.main.sea_creature_layout.*
import javax.inject.Inject

class SeaCreatureActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SeaCreatureViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sea_creature_layout)
        viewModel.seaCreatures.observe(this) { seaCreatures ->
            text.text = seaCreatures.toString()
        }
        viewModel.getSeaCreatures()
    }
}