package com.example.pruebatecnica.repositories


import android.util.Log
import com.example.pruebatecnica.model.Artist
import com.example.pruebatecnica.model.Topartists
import com.example.pruebatecnica.retrofit.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(var apiService: APIService) {

    fun getArtist(): List<Artist> {
        var listArtist :List<Artist> = emptyList()
    apiService.getTopArtist().enqueue(object : Callback<Topartists>{
        override fun onFailure(call: Call<Topartists>, t: Throwable) {
            Log.d(" fail ", t.message.toString())
        }
        override fun onResponse(call: Call<Topartists>, response: Response<Topartists>) {
            listArtist = response.body()!!.artist
        }

    })
    return listArtist
    }

}