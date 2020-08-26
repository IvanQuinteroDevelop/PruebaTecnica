package com.example.pruebatecnica.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnica.model.TopArtist
import com.example.pruebatecnica.repositories.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

public class ArtistViewModel @Inject constructor(var repository: Repository): ViewModel() {

    private var topArtist : MutableLiveData<TopArtist> = MutableLiveData()

    fun getArtistFromRepository(){
        repository.getArtist().enqueue(object : Callback<TopArtist>{
            override fun onFailure(call: Call<TopArtist>, t: Throwable) {
                Log.d("tag error", t.message)
            }

            override fun onResponse(call: Call<TopArtist>, response: Response<TopArtist>) {
                if (response.isSuccessful)
                topArtist.postValue(response.body())
            }

        })
    }

    fun responseTopArtist(): MutableLiveData<TopArtist>{
        return topArtist
    }

}