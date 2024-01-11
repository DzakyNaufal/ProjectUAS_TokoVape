package com.example.tokovape.Model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokovape.Repository.RepositoriToko
import com.example.tokovape.ui.theme.Halaman.DetailDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryToko: RepositoriToko
): ViewModel(){
    private val tokoId: Int = checkNotNull(savedStateHandle[DetailDestination.tokoIdArg])
    val uiState: StateFlow<ItemDetailsUIState> =
        repositoryToko.getTokoStream(tokoId)
            .filterNotNull()
            .map {
                ItemDetailsUIState(detailToko = it.toDetailToko())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIME_MILLIS),
                initialValue = ItemDetailsUIState()
            )
    suspend fun deleteItem(){
        repositoryToko.deleteToko(uiState.value.detailToko.toToko())
    }
    companion object{
        private const val TIME_MILLIS = 5_000L
    }
}

data class ItemDetailsUIState(
    val outOfStock: Boolean = true,
    val detailToko: DetailToko = DetailToko()
)
