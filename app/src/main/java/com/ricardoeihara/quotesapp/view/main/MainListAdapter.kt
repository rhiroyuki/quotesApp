package com.ricardoeihara.quotesapp.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ricardoeihara.quotesapp.R
import com.ricardoeihara.quotesapp.model.Quote
import kotlinx.android.synthetic.main.quote_item.view.*

class MainListAdapter(
    val context: Context,
    val quotes: List<Quote>,
    val clickLista: (Quote) -> Unit
) :
    RecyclerView.Adapter<MainListAdapter.QuoteViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): QuoteViewHolder {

        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.quote_item, p0, false)

        return QuoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onBindViewHolder(p0: QuoteViewHolder, position: Int) {
        val quote = quotes[position]
        p0.bindView(quote, clickLista)
    }


    class QuoteViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(
            quote: Quote,
            clickLista: (Quote) -> Unit
        ) = with(itemView) {
            tvMessage.text = quote.message
            tvAuthor.text = quote.author

            setOnClickListener { clickLista(quote) }
        }

    }
}