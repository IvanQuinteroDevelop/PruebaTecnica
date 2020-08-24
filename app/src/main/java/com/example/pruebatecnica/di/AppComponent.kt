package com.example.pruebatecnica.di

import com.example.pruebatecnica.MainActivity
import com.example.pruebatecnica.view.fragments.ArtistFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class, ModuleApp::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(artistFragment: ArtistFragment)
}