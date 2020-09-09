package com.rabross.acnh.content.creature

typealias SeaCreatures = List<SeaCreature>

data class SeaCreature(
    val id: Int,
    val name: String,
    val availability: Availability,
    val shadow: Shadow,
    val speed: String,
    val price: Int,
    val catchphrase: String,
    val museumphrase: String,
    val imageUrl: String,
    val iconUrl: String
) {
    data class Availability(val time: List<Int>, val months: Months) {

        data class Months(
            val northern: List<Int>,
            val southern: List<Int>
        )
    }

    enum class Shadow {
        Smallest,
        Small,
        Medium,
        Large,
        Largest,
        Unknown
    }
}
