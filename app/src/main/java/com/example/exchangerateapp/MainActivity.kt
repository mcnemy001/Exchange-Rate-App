package com.example.exchangerateapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // NIM   : 10123384
    // Nama : Aziyusman Maulana
    // Kelas : Android-4
    // Tanggal : 19/05/2025

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExchangeRateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvExchange)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val exchangeRates = getExchangeRatesFromResources()
        adapter = ExchangeRateAdapter(exchangeRates)
        recyclerView.adapter = adapter
    }

    private fun getExchangeRatesFromResources(): List<ExchangeRate> {
        val countryArray = resources.getStringArray(R.array.countries)
        val buyArray = resources.getStringArray(R.array.buy_rates)
        val sellArray = resources.getStringArray(R.array.sell_rates)
        val flagArray = resources.getStringArray(R.array.flags)

        val dataList = mutableListOf<ExchangeRate>()

        for (i in countryArray.indices) {
            val country = countryArray[i]
            val buy = buyArray[i].toDoubleOrNull() ?: 0.0
            val sell = sellArray[i].toDoubleOrNull() ?: 0.0
            val flagResId = resources.getIdentifier(flagArray[i], "drawable", packageName)

            dataList.add(ExchangeRate(country, buy, sell, flagResId))
        }

        return dataList
    }
}