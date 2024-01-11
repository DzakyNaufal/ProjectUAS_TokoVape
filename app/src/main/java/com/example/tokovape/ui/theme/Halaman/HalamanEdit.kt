package com.example.tokovape.ui.theme.Halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tokovape.Model.EditViewModel
import com.example.tokovape.Model.PenyediaViewModel
import com.example.tokovape.R
import com.example.tokovape.navigasi.DestinasiNavigasi
import com.example.tokovape.navigasi.TokoTopAppBar
import kotlinx.coroutines.launch

object ItemEditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_belanja
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"

}