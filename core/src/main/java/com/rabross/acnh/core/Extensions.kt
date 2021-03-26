package com.rabross.acnh.core

import java.util.*

fun String.capitalizeWords() =
    split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }