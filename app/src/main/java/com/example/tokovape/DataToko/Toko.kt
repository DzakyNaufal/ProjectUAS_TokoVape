package com.example.tokovape.DataToko

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblToko")
data class Toko(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val harga : String,
    val total : String
)
