package com.example.mobileaddictionanalystsystem.analytics

data class AnalyticsData(
    val dailyAverage: String,
    val weeklyAverage: String,
    val socialMedia: String,
    val gaming: String,
    val productivity: Int,
    val addictionRisk: Int
)