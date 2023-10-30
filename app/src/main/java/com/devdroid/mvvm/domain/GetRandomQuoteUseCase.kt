package com.devdroid.mvvm.domain

import com.devdroid.mvvm.data.QuoteRepository
import com.devdroid.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): Quote?{
        val quote = repository.getAllQuoteFromDatabase()
        if (!quote.isNullOrEmpty()) {
            val randomNumber= (quote.indices).random()
            return quote[randomNumber]
        }

        return null
    }
}