package com.example.mobileaddictionanalystsystem.model

data class UserStats(
    val screenTime: String,
    val socialMedia: String,
    val gaming: String,
    val sleep: String,
    val riskLevel: String,
    val riskScore: Float
)