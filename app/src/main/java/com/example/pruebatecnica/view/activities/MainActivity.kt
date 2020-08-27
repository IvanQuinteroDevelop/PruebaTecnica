package com.example.pruebatecnica.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pruebatecnica.R
import com.example.pruebatecnica.view.fragments.ArtistFragmentDirections
import com.example.pruebatecnica.view.fragments.TracksFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickArtist(view: View) {
        val actionToArtist = TracksFragmentDirections.actionTracksFragmentToArtistFragment4()
        findNavController(R.layout.fragment_artist).navigate(actionToArtist)
    }
    fun onClickTrack(view: View) {
        val actionToTrack = ArtistFragmentDirections.actionArtistFragmentToTracksFragment2()
        findNavController(R.layout.fragment_tracks).navigate(actionToTrack)
    }
}