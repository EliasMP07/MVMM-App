package com.devdroid.mvvm.domain

import com.devdroid.mvvm.data.models.QuoteModel
import com.devdroid.mvvm.data.models.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quote = QuoteProvider.quotes
        if (!quote.isNullOrEmpty()) {
            val randomNumber= (quote.indices).random()
            return quote[randomNumber]
        }

        return null
    }
}