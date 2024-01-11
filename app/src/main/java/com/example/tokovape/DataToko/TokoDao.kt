package com.example.tokovape.DataToko

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TokoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (toko: Toko)

    @Update
    suspend fun update(toko: Toko)

    @Delete
    suspend fun delete(toko: Toko)

    @Query("SELECT * from tblToko WHERE id = :id")
    fun getToko(id: Int): Flow<Toko>

    @Query ("SELECT * FROM tblToko ORDER BY nama ASC")
    fun getAllToko(): Flow<List<Toko>>
}