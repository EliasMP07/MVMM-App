package com.devdroid.mvvm.data.network

import com.devdroid.mvvm.core.RetrofitHelper
import com.devdroid.mvvm.data.models.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuote(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuote()
            response.body() ?: emptyList()
        }

    }
}