package com.devdroid.mvvm.iu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.devdroid.mvvm.databinding.ActivityMainBinding
import com.devdroid.mvvm.iu.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuth.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}