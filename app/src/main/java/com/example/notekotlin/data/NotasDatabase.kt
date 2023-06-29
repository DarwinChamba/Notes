package com.example.notekotlin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Notas::class], version = 10, exportSchema = false)
abstract  class NotasDatabase: RoomDatabase() {
    abstract fun notasDao(): NotasDao
    companion object{
        @Volatile
        private var instance: NotasDatabase? = null
        fun getDatabase(context: Context):NotasDatabase{
            return  instance ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    NotasDatabase::class.java,
                    "notas_database"
                )

            }.fallbackToDestructiveMigration().build().also {
                instance =it
            }
        }
    }

}