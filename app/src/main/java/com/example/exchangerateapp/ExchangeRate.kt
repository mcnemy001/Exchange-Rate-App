package com.example.exchangerateapp

data class ExchangeRate(
    val country: String,
    val buyRate: Double,
    val sellRate: Double,
    val flagResId: Int
)
