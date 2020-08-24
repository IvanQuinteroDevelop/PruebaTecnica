package com.example.pruebatecnica.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleApp(var context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }
}