package com.example.pruebatecnica.model


import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "artists_table")
data class ArtistDB(
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
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}