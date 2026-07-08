package com.example.mobileaddictionanalystsystem.tracker

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import java.util.Calendar

object UsageTracker {

    fun getTodayScreenTime(context: Context): Long {

        val usageStatsManager =
            context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

        val calendar = Calendar.getInstance()

        val endTime = calendar.timeInMillis

        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)

        val startTime = calendar.timeInMillis

        val stats: List<UsageStats> =
            usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY,
                startTime,
                endTime
            )

        var totalTime = 0L

        for (app in stats) {
            totalTime += app.totalTimeInForeground
        }

        return totalTime
    }

    fun formatTime(milliseconds: Long): String {

        val hours = milliseconds / (1000 * 60 * 60)

        val minutes = (milliseconds / (1000 * 60)) % 60

        return "${hours}h ${minutes}m"
    }
}