package com.example.pruebatecnica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnica.model.Artist
import com.example.pruebatecnica.repositories.Repository
import javax.inject.Inject

public class ArtistViewModel @Inject constructor(var repository: Repository): ViewModel() {

    var listArtist : MutableLiveData<List<Artist>> = MutableLiveData()

    fun getArtistFromRepository(){
        listArtist.postValue(repository.getArtist())
    }

}