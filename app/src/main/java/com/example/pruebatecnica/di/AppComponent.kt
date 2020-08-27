package com.example.pruebatecnica.di

import com.example.pruebatecnica.view.activities.MainActivity
import com.example.pruebatecnica.view.fragments.ArtistFragment
import com.example.pruebatecnica.view.fragments.TracksFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class, ModuleApp::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(artistFragment: ArtistFragment)
    fun inject(tracksFragment: TracksFragment)
}