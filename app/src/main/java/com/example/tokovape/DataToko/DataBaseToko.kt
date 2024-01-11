package com.example.tokovape.DataToko

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Toko:: class], version = 1, exportSchema = false)
abstract class DatabaseToko : RoomDatabase(){

}