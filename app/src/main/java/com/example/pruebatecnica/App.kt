package com.example.pruebatecnica

import android.app.Application
import com.example.pruebatecnica.di.AppComponent
import com.example.pruebatecnica.di.DaggerAppComponent
import com.example.pruebatecnica.di.DataModule
import com.example.pruebatecnica.di.ModuleApp


class App: Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        context = this

        appComponent = DaggerAppComponent.builder()
            .dataModule(DataModule())
            .moduleApp(ModuleApp(this))
            .build()
        super.onCreate()
    }

    fun getComponent(): AppComponent {
        return appComponent
    }


    companion object {
        var context: App? = null
            private set
    }
}