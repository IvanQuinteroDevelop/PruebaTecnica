package com.example.pruebatecnica.viewmodel

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pruebatecnica.repositories.Repository
import javax.inject.Inject

 class ViewModelFactory @Inject constructor(var repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
        return ArtistViewModel(repository) as T
    }
}