package com.example.pruebatecnica.retrofit

import com.example.pruebatecnica.model.TopArtist
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("?method=geo.gettopartists&country=spain&format=json")
    fun getTopArtist(): Call<TopArtist>
}