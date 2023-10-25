package com.devdroid.mvvm.data

import com.devdroid.mvvm.data.models.QuoteModel
import com.devdroid.mvvm.data.models.QuoteProvider
import com.devdroid.mvvm.data.network.QuoteService

class QuoteRepository {


    private val api = QuoteService()

    suspend fun getAllQuote(): List<QuoteModel>{
        val response = api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}