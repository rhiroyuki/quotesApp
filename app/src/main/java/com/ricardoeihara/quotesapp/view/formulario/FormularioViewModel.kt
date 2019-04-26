package com.ricardoeihara.quotesapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ricardoeihara.quotesapp.model.Quote
import com.ricardoeihara.quotesapp.model.ResponseStatus
import com.ricardoeihara.quotesapp.repository.QuoteRepository

class FormularioViewModel : ViewModel() {

    val quoteRepository = QuoteRepository()
    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun salvar(
        message: String,
        author: String
    ) {
        isLoading.value = true
        val quote = Quote(message = message, author = author)
        quoteRepository.salvar(quote,
            onComplete = {
                isLoading.value = false
                responseStatus.value = ResponseStatus(
                    true,
                    "Dado gravado com sucesso"
                )
            }, onError = {
                isLoading.value = false
                responseStatus.value = ResponseStatus(
                    false,
                    it?.message!!
                )
            })

    }

}