package com.devdroid.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdroid.mvvm.models.QuoteModel
import com.devdroid.mvvm.models.QuoteProvider

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()

        quoteModel.postValue(currentQuote)
    }
}