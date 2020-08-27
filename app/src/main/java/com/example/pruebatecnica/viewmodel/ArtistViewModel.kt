package com.example.pruebatecnica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnica.model.ArtistDB
import com.example.pruebatecnica.repositories.Repository
import javax.inject.Inject

class ArtistViewModel @Inject constructor(var repository: Repository): ViewModel() {

    private var topArtist : MutableLiveData<List<ArtistDB>> = MutableLiveData()

    fun getListArtist(){
        topArtist.postValue(repository.getLisTArtist())
    }


    fun responseTopArtist(): MutableLiveData<List<ArtistDB>>{
        return topArtist
    }
    fun searchArtist(name: String){
        topArtist.postValue(repository.filterArtist(name))
    }

}