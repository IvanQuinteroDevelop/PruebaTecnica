package com.example.pruebatecnica.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.App
import com.example.pruebatecnica.R
import com.example.pruebatecnica.model.ArtistDB
import com.example.pruebatecnica.view.adapters.ArtistAdapter
import com.example.pruebatecnica.viewmodel.ArtistViewModel
import com.example.pruebatecnica.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_artist.*
import javax.inject.Inject



class ArtistFragment : Fragment(), SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    @Inject
    lateinit var artistViewModel: ArtistViewModel
    @Inject
    lateinit var viewModelFactory : ViewModelFactory
    private lateinit var artistAdapter: ArtistAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        artistAdapter = ArtistAdapter()

        rvArtist.apply{
            layoutManager = LinearLayoutManager(view.context)
            adapter = artistAdapter
        }

        observeTopArtist()

        svArtist.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterCharacter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCharacter(newText)
                return false
            }
        })

    }

    fun observeTopArtist(){
        artistViewModel.responseTopArtist().observe(viewLifecycleOwner, Observer<List<ArtistDB>>{listArtists->
            artistAdapter.updateData(listArtists)
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ((context as AppCompatActivity).application as App).getComponent().inject(this)
        artistViewModel = ViewModelProvider(this, viewModelFactory).get(ArtistViewModel::class.java)
        artistViewModel.getListArtist()
    }

    override fun onClose(): Boolean {
        return true
    }

    private fun filterCharacter(query: String?){
        val name: String
        if (query != null && query.isNotEmpty()) {
            name = query.trim()
            artistViewModel.searchArtist(name)
        }else artistViewModel.getListArtist()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        filterCharacter(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        filterCharacter(newText)
        return false
    }
}