package com.example.tokovape.Repository

import com.example.tokovape.DataToko.Toko
import com.example.tokovape.DataToko.TokoDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriToko (private val tokoDao: TokoDao): RepositoriToko{
    override fun getAllTokoStream(): Flow<List<Toko>> {
        return tokoDao.getAllToko()
    }

    override fun getTokoStream(id: Int): Flow<Toko?> {
        return tokoDao.getToko(id)
    }

    override suspend fun insertToko(toko: Toko) {
        tokoDao.insert(toko)
    }

    override suspend fun deleteToko(toko: Toko) {
        tokoDao.delete(toko)
    }

    override suspend fun updateToko(toko: Toko) {
        tokoDao.update(toko)
    }
}