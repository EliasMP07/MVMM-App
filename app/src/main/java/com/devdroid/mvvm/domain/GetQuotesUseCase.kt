package com.devdroid.mvvm.domain

import com.devdroid.mvvm.data.QuoteRepository
import com.devdroid.mvvm.data.models.QuoteModel

class GetQuotesUseCase {

    private val respository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = respository.getAllQuote()

}