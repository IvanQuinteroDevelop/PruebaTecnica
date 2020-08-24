package com.example.pruebatecnica.retrofit

import com.example.pruebatecnica.model.Artist
import com.example.pruebatecnica.model.Topartists
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getTopArtist(): Call<Topartists>
}