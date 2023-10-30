package com.devdroid.mvvm.data

import com.devdroid.mvvm.data.database.dao.QuoteDao
import com.devdroid.mvvm.data.database.entities.QuoteEntity
import com.devdroid.mvvm.data.network.QuoteService
import com.devdroid.mvvm.domain.model.Quote
import com.devdroid.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(

    private val api: QuoteService,
    private val quoteDao: QuoteDao

){

    suspend fun getAllQuoteFromApi(): List<Quote>{
        val response = api.getQuote()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAllQuoteFromDatabase(): List<Quote>{
        val response = quoteDao.getAllQuotes()

        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertQuotes(quote: List<QuoteEntity>){
        quoteDao.insertAll(quote)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}