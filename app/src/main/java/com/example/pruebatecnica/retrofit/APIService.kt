package com.example.pruebatecnica.retrofit

import com.example.pruebatecnica.model.TopArtist
import com.example.pruebatecnica.model.TopTracks
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("?method=geo.gettopartists&country=spain&format=json")
    fun getTopArtist(): Call<TopArtist>

    @GET("?method=geo.gettoptracks&country=spain&format=json")
    fun getTopTracks(): Call<TopTracks>
}