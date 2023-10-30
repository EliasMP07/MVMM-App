package com.devdroid.mvvm.domain

import com.devdroid.mvvm.data.QuoteRepository
import com.devdroid.mvvm.data.database.entities.toDatabase
import com.devdroid.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val respository: QuoteRepository
) {



    suspend operator fun invoke(): List<Quote> {

        val quotes = respository.getAllQuoteFromApi()
        return if (quotes.isNotEmpty()){

            respository.clearQuotes()
            respository.insertQuotes(
                quotes.map {
                    it.toDatabase()
                }

            )
            quotes
        }else{
            respository.getAllQuoteFromDatabase()
        }



    }

}