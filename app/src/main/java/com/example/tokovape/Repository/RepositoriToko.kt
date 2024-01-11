package com.example.tokovape.Repository

import com.example.tokovape.DataToko.Toko
import kotlinx.coroutines.flow.Flow

interface RepositoriToko {
    fun getAllTokoStream(): Flow<List<Toko>>
    fun getTokoStream(id: Int): Flow<Toko?>
    suspend fun insertToko(toko: Toko)
    suspend fun deleteToko(toko: Toko)
    suspend fun updateToko(toko: Toko)
}