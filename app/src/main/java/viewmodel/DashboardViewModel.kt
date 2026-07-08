package com.example.mobileaddictionanalystsystem.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mobileaddictionanalystsystem.model.UserStats

class DashboardViewModel : ViewModel() {

    var userStats by mutableStateOf(
        UserStats(
            screenTime = "Loading...",
            socialMedia = "Loading...",
            gaming = "Loading...",
            sleep = "7h 10m",
            riskLevel = "Moderate",
            riskScore = 0.65f
        )
    )
        private set

    fun updateStats(
        screenTime: String,
        socialMedia: String,
        gaming: String,
        sleep: String,
        riskLevel: String,
        riskScore: Float
    ) {
        userStats = UserStats(
            screenTime = screenTime,
            socialMedia = socialMedia,
            gaming = gaming,
            sleep = sleep,
            riskLevel = riskLevel,
            riskScore = riskScore
        )
    }
}