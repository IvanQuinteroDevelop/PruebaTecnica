package com.example.pruebatecnica.repositories


import com.example.pruebatecnica.model.TopArtist
import com.example.pruebatecnica.retrofit.APIService
import retrofit2.Call
import java.util.*
import javax.inject.Inject


class Repository @Inject constructor(var apiService: APIService) {

    fun getArtist(): Call<TopArtist> {
        return apiService.getTopArtist()
    }

}