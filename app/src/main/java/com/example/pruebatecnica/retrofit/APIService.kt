package com.example.pruebatecnica.retrofit

import com.example.pruebatecnica.model.Artist
import com.example.pruebatecnica.model.TopArtist
import com.example.pruebatecnica.model.Topartists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("?method=geo.gettopartists&country=spain&format=json")
    fun getTopArtist(): Call<TopArtist>
}