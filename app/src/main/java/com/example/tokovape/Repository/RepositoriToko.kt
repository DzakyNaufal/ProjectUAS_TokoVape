package com.example.tokovape.Repository

import com.example.tokovape.DataToko.Toko
import kotlinx.coroutines.flow.Flow

interface RepositoriToko {
    fun getAllTokoStream(): Flow<List<Toko>>
    fun getTokoStream(id: Int): Flow<Toko?>
    suspend fun insertToko(toko: Toko)

}