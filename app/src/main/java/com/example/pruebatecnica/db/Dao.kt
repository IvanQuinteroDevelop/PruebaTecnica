package com.example.pruebatecnica.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.pruebatecnica.model.ArtistDB
import com.example.pruebatecnica.model.TrackDB

@Dao
interface Dao {

    @Insert(onConflict = REPLACE)
    fun insertArtist(artist: List<ArtistDB>)

    @Query("SELECT * FROM artists_table at ORDER BY at.name")
    fun getArtistFromDB(): List<ArtistDB>

    @Query("DELETE FROM artists_table")
    fun deleteArtists()

    @Query("SELECT * FROM artists_table a WHERE a.name LIKE '%' || :name || '%' ")
    fun searchArtists(name: String):List<ArtistDB>


    @Insert(onConflict = REPLACE)
    fun insertTracks(artist: List<TrackDB>)

    @Query("SELECT * FROM track_table at ORDER BY at.attr")
    fun getTracksFromDB(): List<TrackDB>

    @Query("DELETE FROM track_table")
    fun deleteTracks()

}