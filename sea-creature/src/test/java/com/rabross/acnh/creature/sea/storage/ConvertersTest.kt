package com.rabross.acnh.creature.sea.storage

import org.junit.Assert.*

import org.junit.Test

class ConvertersTest {

    private val converters = Converters()

    @Test
    fun toShadow() {
        assertEquals(SeaCreature.Shadow.Smallest, converters.toShadow("\"Smallest\""))
        assertEquals(SeaCreature.Shadow.Small, converters.toShadow("\"Small\""))
        assertEquals(SeaCreature.Shadow.Medium, converters.toShadow("\"Medium\""))
        assertEquals(SeaCreature.Shadow.Large, converters.toShadow("\"Large\""))
        assertEquals(SeaCreature.Shadow.Largest, converters.toShadow("\"Largest\""))
        assertEquals(SeaCreature.Shadow.Unknown, converters.toShadow("\"Unknown\""))
    }

    @Test
    fun fromShadow() {
        assertEquals("\"Smallest\"", converters.fromShadow(SeaCreature.Shadow.Smallest))
        assertEquals("\"Small\"", converters.fromShadow(SeaCreature.Shadow.Small))
        assertEquals("\"Medium\"", converters.fromShadow(SeaCreature.Shadow.Medium))
        assertEquals("\"Large\"", converters.fromShadow(SeaCreature.Shadow.Large))
        assertEquals("\"Largest\"", converters.fromShadow(SeaCreature.Shadow.Largest))
        assertEquals("\"Unknown\"", converters.fromShadow(SeaCreature.Shadow.Unknown))
    }

    @Test
    fun toAvailability() {
        val months = SeaCreature.Availability.Months(listOf(1,2,3), listOf(4,5,6))
        val availability = SeaCreature.Availability(listOf(1,2,3), months)
        assertEquals(availability, converters.toAvailability("{\"time\":[1,2,3],\"months\":{\"northern\":[1,2,3],\"southern\":[4,5,6]}}"))
    }

    @Test
    fun fromAvailability() {
        val months = SeaCreature.Availability.Months(listOf(1,2,3), listOf(4,5,6))
        val availability = SeaCreature.Availability(listOf(1,2,3), months)
        assertEquals("{\"time\":[1,2,3],\"months\":{\"northern\":[1,2,3],\"southern\":[4,5,6]}}", converters.fromAvailability(availability))
    }
}