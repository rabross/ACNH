package com.rabross.acnh.creature.sea.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rabross.acnh.creature.sea.repository.local.model.SeaCreature

@Database(entities = [SeaCreature::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SeaCreatureRoomDatabase : RoomDatabase() {

    abstract fun seaCreatureDao(): SeaCreatureDao

    companion object {

        private const val DATABASE_NAME = "sea_creature_database"

        @Volatile
        private var INSTANCE: SeaCreatureRoomDatabase? = null

        fun getDatabase(context: Context): SeaCreatureRoomDatabase {
            return INSTANCE ?:
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        SeaCreatureRoomDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                    instance
                }
        }
    }
}