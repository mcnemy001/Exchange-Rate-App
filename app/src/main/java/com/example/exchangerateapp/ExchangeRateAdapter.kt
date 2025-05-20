package com.example.exchangerateapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExchangeRateAdapter(
    private val exchangeList: List<ExchangeRate>
) : RecyclerView.Adapter<ExchangeRateAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivFlag: ImageView   = itemView.findViewById(R.id.ivFlag)
        val tvCountry: TextView = itemView.findViewById(R.id.tvCountry)
        val tvBuy: TextView     = itemView.findViewById(R.id.tvBuy)
        val tvSell: TextView    = itemView.findViewById(R.id.tvSell)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_rate, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = exchangeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = exchangeList[position]
        holder.ivFlag.setImageResource(item.flagResId)
        holder.tvCountry.text = item.country
        holder.tvBuy.text     = String.format("%.3f", item.buyRate)
        holder.tvSell.text    = String.format("%.3f", item.sellRate)
    }
}
