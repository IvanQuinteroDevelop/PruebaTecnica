package com.example.pruebatecnica.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.of
import com.example.pruebatecnica.App
import com.example.pruebatecnica.MainActivity
import com.example.pruebatecnica.R
import com.example.pruebatecnica.viewmodel.ArtistViewModel
import com.example.pruebatecnica.viewmodel.ViewModelFactory
import javax.inject.Inject

class ArtistFragment : Fragment() {

    @Inject
    lateinit var artistViewModel: ArtistViewModel
    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //artistViewModel.getArtistFromRepository()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ((context as AppCompatActivity).application as App).getComponent().inject(this)
        artistViewModel = ViewModelProvider(this, viewModelFactory).get(ArtistViewModel::class.java)
    }
}