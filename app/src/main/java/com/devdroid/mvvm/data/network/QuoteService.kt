package com.devdroid.mvvm.data.network

import com.devdroid.mvvm.core.RetrofitHelper
import com.devdroid.mvvm.data.models.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
   private val api: QuoteApiClient
) {


    suspend fun getQuote(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuote()
            response.body() ?: emptyList()
        }

    }
}