package com.rabross.acnh.creature.sea.ui.model

import android.os.Parcelable
import com.rabross.acnh.core.capitalizeWords
import kotlinx.parcelize.Parcelize
import com.rabross.acnh.content.creature.SeaCreature as SeaCreatureEntity

@Parcelize
internal data class SeaCreatureDetail(
    val name: String = "",
    val imageUrl: String = "",
    val catchphrase: String = "",
    val speed: String = ""
) : Parcelable

internal fun SeaCreatureEntity.toSeaCreatureDetail() =
    SeaCreatureDetail(name.capitalizeWords(), imageUrl, catchphrase, speed)