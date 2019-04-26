package com.ricardoeihara.quotesapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ricardoeihara.quotesapp.model.Quote
import com.ricardoeihara.quotesapp.repository.QuoteRepository

class MainViewModel : ViewModel() {

    val quoteRepository = QuoteRepository()

    val quotes : MutableLiveData<List<Quote>> = MutableLiveData()
    val mensagemErro : MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()


    fun buscarTodos () {
        isLoading.value = true
        quoteRepository.buscarTodos(
            onComplete = {
                isLoading.value = false
                quotes.value = it

            },
            onError = {
                isLoading.value = false
                mensagemErro.value = it?.message
            }
        )
    }

}