package com.example.tokovape.Model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokovape.Repository.RepositoriToko
import com.example.tokovape.ui.theme.Halaman.ItemEditDestination
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriToko: RepositoriToko
) : ViewModel() {

    var tokoUiState by mutableStateOf(UIStateToko())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            tokoUiState = repositoriToko.getTokoStream(itemId)
                .filterNotNull()
                .first()
                .toUiStateToko(true)
        }
    }
    suspend fun updateToko() {
        if (validasiInput(tokoUiState.detailToko)) {
            repositoriToko.updateToko(tokoUiState.detailToko.toToko())
        }
        else {
            println("Data tidak valid")
        }
    }
    fun updateUiState(detailToko: DetailToko) {
        tokoUiState = UIStateToko(detailToko = detailToko, isEntryValid = validasiInput(detailToko))
    }
}