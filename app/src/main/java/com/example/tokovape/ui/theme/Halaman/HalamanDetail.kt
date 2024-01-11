package com.example.tokovape.ui.theme.Halaman

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tokovape.DataToko.Toko
import com.example.tokovape.Model.DetailViewModel
import com.example.tokovape.Model.ItemDetailsUIState
import com.example.tokovape.Model.PenyediaViewModel
import com.example.tokovape.Model.toToko
import com.example.tokovape.R
import com.example.tokovape.navigasi.DestinasiNavigasi
import com.example.tokovape.navigasi.TokoTopAppBar
import kotlinx.coroutines.launch

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_belanja
    const val tokoIdArg = "itemId"
    val routeWithArgs = "$route/{$tokoIdArg}"

}
