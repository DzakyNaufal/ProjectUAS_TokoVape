package com.example.tokovape.ui.theme.Halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tokovape.Model.DetailToko
import com.example.tokovape.Model.EntryViewModel
import com.example.tokovape.Model.PenyediaViewModel
import com.example.tokovape.Model.UIStateToko
import com.example.tokovape.R
import com.example.tokovape.navigasi.DestinasiNavigasi
import com.example.tokovape.navigasi.TokoTopAppBar
import kotlinx.coroutines.launch

object DestinasiEntry: DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.entry_produk
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputToko(
    detailToko: DetailToko,
    modifier: Modifier = Modifier,
    onValueChange: (DetailToko)-> Unit ={},
    enabled: Boolean = true
){
    Column (
        modifier = modifier,
        verticalArrangement =  Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ){
        OutlinedTextField(
            value = detailToko.nama,
            onValueChange ={onValueChange(detailToko.copy(nama=it)) },
            label = { Text(stringResource(R.string.nama)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        OutlinedTextField(
            value = detailToko.harga,
            onValueChange ={onValueChange(detailToko.copy(harga=it)) },
            label = { Text(stringResource(R.string.harga)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        OutlinedTextField(
            value = detailToko.total,
            onValueChange ={onValueChange(detailToko.copy(total=it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(stringResource(R.string.total)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        if(enabled){
            Text(
                text = stringResource(R.string.required_field),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
        Divider(
            thickness = dimensionResource(R.dimen.padding_small),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium ))
        )
    }
}
