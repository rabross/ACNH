package com.rabross.acnh.creature.sea.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SeaCreature::class], version = 1, exportSchema = false)
abstract class SeaCreatureRoomDatabase : RoomDatabase() {

    abstract fun seaCreatureDao(): SeaCreatureDao

    companion object {

        @Volatile
        private var INSTANCE: SeaCreatureRoomDatabase? = null

        fun getDatabase(context: Context): SeaCreatureRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SeaCreatureRoomDatabase::class.java,
                    "sea_creature_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}