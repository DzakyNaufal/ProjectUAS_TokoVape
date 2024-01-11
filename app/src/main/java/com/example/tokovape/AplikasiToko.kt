package com.example.tokovape

import android.app.Application
import com.example.tokovape.Repository.ContainerApp
import com.example.tokovape.Repository.ContainerDataApp

class AplikasiToko : Application() {
    /**
     * App Container instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}