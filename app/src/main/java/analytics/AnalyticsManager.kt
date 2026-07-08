package com.example.mobileaddictionanalystsystem.analytics

object AnalyticsManager {

    fun getAnalyticsData(): AnalyticsData {

        return AnalyticsData(
            dailyAverage = "5h 20m",
            weeklyAverage = "5h 45m",
            socialMedia = "2h 30m",
            gaming = "1h 10m",
            productivity = 72,
            addictionRisk = 65
        )
    }
}