package com.rabross.acnh.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rabross.acnh.creature.sea.ui.SeaCreatureActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, SeaCreatureActivity::class.java))
        finish()
    }
}
