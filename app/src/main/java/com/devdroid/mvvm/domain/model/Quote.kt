package com.devdroid.mvvm.domain.model

import com.devdroid.mvvm.data.database.entities.QuoteEntity
import com.devdroid.mvvm.data.models.QuoteModel

data class Quote(
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)
