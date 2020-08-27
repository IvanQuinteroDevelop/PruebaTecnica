package com.example.pruebatecnica.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.App
import com.example.pruebatecnica.R
import com.example.pruebatecnica.model.TrackDB
import com.example.pruebatecnica.view.adapters.TrackAdapter
import com.example.pruebatecnica.viewmodel.MyViewModel
import com.example.pruebatecnica.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tracks.*
import javax.inject.Inject


class TracksFragment : Fragment() {

    @Inject
    lateinit var myViewModel: MyViewModel
    @Inject
    lateinit var viewModelFactory : ViewModelFactory
    lateinit var trackAdapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tracks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trackAdapter = TrackAdapter()

        rvTrack.apply{
            layoutManager = LinearLayoutManager(view.context)
            adapter = trackAdapter
        }
        observeTopTracks()
    }

    fun observeTopTracks(){
        myViewModel.responseTopTrack().observe(viewLifecycleOwner, Observer<List<TrackDB>>{ listTrack->
            trackAdapter.updateData(listTrack)
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ((context as AppCompatActivity).application as App).getComponent().inject(this)
        myViewModel = ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)
        myViewModel.getListTrack()
    }
}