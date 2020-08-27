package com.example.pruebatecnica.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnica.model.ArtistDB

@Database(entities = [ArtistDB::class], version = 7, exportSchema = false)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun dao(): Dao
}