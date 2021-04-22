package com.rabross.acnh.content.creature

fun seaCreature(block: SeaCreatureBuilder.() -> Unit) = SeaCreatureBuilder().apply(block).build()

class SeaCreatureBuilder {
    var id = -1
    var name = ""
    var availability: SeaCreature.Availability? = null
    var shadow = SeaCreature.Shadow.Unknown
    var price = 0
    var catchphrase = ""
    var museumphrase = ""
    var imageUrl = ""
    var iconUrl = ""
    var speed = ""

    fun availability(block: AvailabilityBuilder.() -> Unit) {
        availability = AvailabilityBuilder().apply(block).build()
    }

    fun build() = SeaCreature(
        id = id,
        name = name,
        availability = availability!!,
        shadow = shadow,
        price = 0,
        catchphrase = catchphrase,
        museumphrase = museumphrase,
        imageUrl = imageUrl,
        iconUrl = iconUrl,
        speed = speed
    )
}

class AvailabilityBuilder {

    var time = emptyList<Int>()
    var months: SeaCreature.Availability.Months? = null

    fun months(block: MonthsBuilder.() -> Unit) {
        months = MonthsBuilder().apply(block).build()
    }

    fun build() = SeaCreature.Availability(time, months!!)

}

class MonthsBuilder {

    var northern = emptyList<Int>()
    var southern = emptyList<Int>()

    fun build() = SeaCreature.Availability.Months(northern, southern)
}