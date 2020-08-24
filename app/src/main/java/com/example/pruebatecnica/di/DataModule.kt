package com.example.pruebatecnica.di


import androidx.lifecycle.ViewModelProvider
import com.example.pruebatecnica.repositories.Repository
import com.example.pruebatecnica.retrofit.APIService
import com.example.pruebatecnica.viewmodel.ViewModelFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://ws.audioscrobbler.com/2.0/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getGson(): Gson {
        val builder =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.setLenient().create()
    }

    @Provides
    @Singleton
    fun getAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    @Singleton
    fun getRepository(apiService: APIService): Repository {
        return Repository(apiService)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(repository: Repository): ViewModelProvider.Factory {
        return ViewModelFactory(repository)
    }
}