package com.example.pruebatecnica.repositories

import android.util.Log
import com.example.pruebatecnica.db.Dao
import com.example.pruebatecnica.model.ArtistDB
import com.example.pruebatecnica.model.TopArtist
import com.example.pruebatecnica.retrofit.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.collections.ArrayList


class Repository @Inject constructor(var apiService: APIService, var dao: Dao) {

    fun getLisTArtist(): List<ArtistDB> {
        refreshArtists()
        return dao.getArtistFromDB()
    }

    fun refreshArtists(){
        apiService.getTopArtist().enqueue(object : Callback<TopArtist>{
            override fun onFailure(call: Call<TopArtist>, t: Throwable) {
                Log.d("tag error", t.message!!)
            }

            override fun onResponse(call: Call<TopArtist>, response: Response<TopArtist>) {
                val listArtistDB = ArrayList<ArtistDB>()
                var images = ""
                if (response.isSuccessful) {

                    val listArtist = response.body()?.topArtists!!.artist
                    listArtist.forEach {artist->
                        artist.image.forEach {image->
                                images = image.text
                        }
                        listArtistDB.add(ArtistDB(images,
                            artist.listeners,
                            artist.mbid,
                            artist.name,
                            artist.streamable,
                            artist.url))

                    }
                    dao.deleteArtists()
                    dao.insertArtist(listArtistDB)
                }

            }

        })
    }

    fun filterArtist(name: String):List<ArtistDB>{
        return dao.searchArtists(name)
    }

}