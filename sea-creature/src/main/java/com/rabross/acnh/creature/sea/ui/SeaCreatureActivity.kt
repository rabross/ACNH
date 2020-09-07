package com.rabross.acnh.creature.sea.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rabross.acnh.core.fragment.AppFragmentFactory
import com.rabross.acnh.creature.sea.R
import com.rabross.acnh.creature.sea.di.inject
import javax.inject.Inject

class SeaCreatureActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: AppFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        supportFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sea_creatures)
    }
}
