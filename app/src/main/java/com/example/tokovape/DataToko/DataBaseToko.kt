package com.example.tokovape.DataToko

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Toko:: class], version = 1, exportSchema = false)
abstract class DatabaseToko : RoomDatabase(){

    abstract fun TokoDao() : TokoDao

    companion object{
        @Volatile
        private var Instance: DatabaseToko? = null

        fun getDatabase(context: Context): DatabaseToko{
            return (Instance?: synchronized(this    ){
                Room.databaseBuilder(context,
                    DatabaseToko::class.java,
                    "toko_database")
                    .build().also { Instance=it }
            })
        }
    }
}