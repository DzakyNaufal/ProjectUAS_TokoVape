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


data class ItemDetailsUIState(
    val outOfStock: Boolean = true,
    val detailToko: DetailToko = DetailToko()
)
