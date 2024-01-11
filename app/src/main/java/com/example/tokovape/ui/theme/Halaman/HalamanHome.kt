package com.example.tokovape.ui.theme.Halaman

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tokovape.DataToko.Toko
import com.example.tokovape.Model.HomeViewModel
import com.example.tokovape.Model.PenyediaViewModel
import com.example.tokovape.R
import com.example.tokovape.navigasi.DestinasiNavigasi
import com.example.tokovape.navigasi.TokoTopAppBar

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun BodyHome(
    modifier: Modifier,
    itemToko: List<Toko>,
    onTokoClick: (Int) -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        if (itemToko.isEmpty()) {
            Text(
                text = stringResource(R.string.deskripsi_no_item),
                textAlign = TextAlign.Center, style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListToko(
                itemToko = itemToko,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                onItemClick = { onTokoClick(it.id) }
            )
        }
    }
}

@Composable
fun ListToko(
    itemToko: List<Toko>,
    modifier: Modifier = Modifier,
    onItemClick: (Toko) -> Unit
) {
    LazyColumn(modifier = Modifier) {
        items(items = itemToko, key = { it.id }) { person ->
            DataToko(
                toko = person,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onItemClick(person) }
            )
        }
    }
}

@Composable
fun DataToko(
    toko: Toko, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = toko.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Text(
                    text = toko.harga,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = toko.total,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}