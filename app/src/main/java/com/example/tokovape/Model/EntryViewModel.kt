package com.example.tokovape.Model

import android.app.AlarmManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tokovape.DataToko.Toko
import com.example.tokovape.Repository.RepositoriToko
import java.util.NavigableMap

class EntryViewModel(private val repositoriToko: RepositoriToko): ViewModel() {
    /*
    * Berisi status toko saat ini
    */
    var  uiStateToko by mutableStateOf(UIStateToko())
        private set

    /* Fungsi untuk menvalidasi imput */
    private fun validasiInput (uiState: DetailToko = uiStateToko.detailToko) : Boolean{
        return  with(uiState) {
            nama.isNotBlank() && harga.isNotBlank() && total.isNotBlank()
        }
    }
    fun updateUiState(detailToko: DetailToko) {
        uiStateToko =
            UIStateToko(detailToko = detailToko, isEntryValid = validasiInput(detailToko))
    }

    /*Fungsi Untuk menyimpan data yang di-entry */
    suspend fun saveToko(){
        if (validasiInput()) {
            repositoriToko.insertToko(uiStateToko.detailToko.toToko())
        }
    }
}

/*
* Mewakili status Ui untuk toko
*/

data class  UIStateToko(
    val  detailToko: DetailToko = DetailToko(),
    val  isEntryValid: Boolean = false
)