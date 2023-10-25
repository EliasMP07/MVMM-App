package com.devdroid.mvvm.data.network

import com.devdroid.mvvm.data.models.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuote(): Response<List<QuoteModel>>
}