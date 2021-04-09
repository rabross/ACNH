package com.rabross.acnh.core

import android.view.View
import com.rabross.acnh.core.ui.OnSafeClickListener
import java.util.*

fun String.capitalizeWords() =
    split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }


fun View.setOnSafeClickListener(OnClickListener: View.OnClickListener) {
    setOnClickListener(OnSafeClickListener(OnClickListener))
}

fun View.setOnSafeClickListener(OnClickListener: (View) -> Unit) {
    setOnClickListener(OnSafeClickListener(OnClickListener))
}