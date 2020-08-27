package com.example.pruebatecnica.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnica.model.ArtistDB
import com.example.pruebatecnica.model.TrackDB

@Database(entities = [ArtistDB::class, TrackDB::class], version = 8, exportSchema = false)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun dao(): Dao
}