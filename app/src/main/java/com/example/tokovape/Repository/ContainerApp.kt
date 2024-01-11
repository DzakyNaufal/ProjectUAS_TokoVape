package com.example.tokovape.Repository

import android.content.Context
import com.example.tokovape.DataToko.DatabaseToko

interface ContainerApp{
    val repositoriToko : RepositoriToko
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoriToko: RepositoriToko by lazy {
        OfflineRepositoriToko(DatabaseToko.getDatabase(context).TokoDao())
    }
}
