package com.ricardoeihara.quotesapp.api

import com.ricardoeihara.quotesapp.model.Quote
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuoteAPI {

    @GET("/quotes")
    fun getQuotes() : Call<List<Quote>>

    @POST("/quotes")
    fun salvar(@Body quote: Quote): Call<Quote>

    /*@GET("/quote/{id}")
    fun getQuotes(@Path("id") id:String)*/
}