package com.example.pruebatecnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.pruebatecnica.viewmodel.ArtistViewModel
import com.example.pruebatecnica.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

   // @Inject
    lateinit var artistViewModel: ArtistViewModel
    lateinit var viewModelFactory : ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //(application as App).getComponent().inject(this)
        //artistViewModel = ViewModelProvider(this, viewModelFactory).get(ArtistViewModel::class.java)
        //Hola mundo, primer commit de prueba tecnica
    }


}