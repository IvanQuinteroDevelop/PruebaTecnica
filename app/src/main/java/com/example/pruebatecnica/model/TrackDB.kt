package com.example.pruebatecnica.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "track_table")
data class TrackDB(
    @SerializedName("artist")
    val artist: String,
    @SerializedName("@attr")
    val attr: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("url")
    val url: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}