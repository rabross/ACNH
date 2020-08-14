package com.rabross.acnh.creature.sea.repository

import com.rabross.acnh.content.creature.SeaCreature
import io.reactivex.Single

interface Repo {
    fun getCreatures(): Single<List<SeaCreature>>
    fun getCreature(id: String): Single<SeaCreature>
}
