package com.rabross.acnh.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.rabross.acnh.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_layout.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        viewModel.seaCreatures.observe(this) { seaCreatures ->
            text.text = seaCreatures.toString()
        }
        viewModel.getSeaCreatures()
    }
}
