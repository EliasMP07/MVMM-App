package com.devdroid.mvvm.di

import com.devdroid.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//Alcance del modulo
object NetworkModule {

    //Retrofit
    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun providerQuoteApiClient(retrofit: Retrofit): QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }
}