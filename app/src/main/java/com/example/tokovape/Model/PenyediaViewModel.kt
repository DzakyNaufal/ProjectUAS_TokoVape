package com.example.tokovape.Model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tokovape.AplikasiToko

object PenyediaViewModel {
    val Factory =  viewModelFactory {

        initializer {
            HomeViewModel(aplikasiToko().container.repositoriToko)
        }
        initializer {
            EntryViewModel(aplikasiToko().container.repositoriToko)
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiToko().container.repositoriToko,
            )
        }

        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiToko().container.repositoriToko,
            )
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 *  [AplikasiToko]
 */
fun CreationExtras.aplikasiToko(): AplikasiToko =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiToko)