package com.ricardoeihara.quotesapp.repository

import com.ricardoeihara.quotesapp.api.getQuoteAPI
import com.ricardoeihara.quotesapp.model.Quote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteRepository {

    fun buscarTodos(
        onComplete:(List<Quote>?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {

        getQuoteAPI()
            .getQuotes()
            .enqueue(object : Callback<List<Quote>>{
                override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                    if(response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Error while fetching data"))
                    }
                }
            })

    }



    fun salvar(quote: Quote,
                onComplete: (Quote) -> Unit,
                onError: (Throwable?) -> Unit) {
        getQuoteAPI()
            .salvar(quote)
            .enqueue(object : Callback<Quote>{
                override fun onFailure(call: Call<Quote>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                    onComplete(response.body()!!)
                }
            })
    }





}