package com.example.tokovape.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokovape.DataToko.Toko
import com.example.tokovape.Repository.RepositoriToko
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(private val RepositoriToko: RepositoriToko): ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = RepositoriToko.getAllTokoStream().filterNotNull()

        .map { HomeUiState(listToko = it.toList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )
    data class HomeUiState(
        val listToko: List<Toko> = listOf()
    )
}