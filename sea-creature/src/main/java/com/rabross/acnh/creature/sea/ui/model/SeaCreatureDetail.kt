package com.rabross.acnh.creature.sea.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class SeaCreatureDetail(
    val name: String = "",
    val imageUrl: String = "",
    val catchphrase: String = "",
    val speed: String = ""
) : Parcelable