package com.example.mobileaddictionanalystsystem.tracker

import android.app.usage.UsageStatsManager
import android.content.Context

object AppUsageTracker {

    fun getTopApps(context: Context): List<AppUsage> {

        val usageStatsManager =
            context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

        val endTime = System.currentTimeMillis()
        val startTime = endTime - 24 * 60 * 60 * 1000

        val stats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startTime,
            endTime
        )

        return stats
            .filter { it.totalTimeInForeground > 0 }
            .sortedByDescending { it.totalTimeInForeground }
            .take(10)
            .map {
                AppUsage(
                    appName = it.packageName.substringAfterLast("."),
                    usageTime = it.totalTimeInForeground
                )
            }
    }

    fun formatTime(time: Long): String {

        val hours = time / (1000 * 60 * 60)
        val minutes = (time % (1000 * 60 * 60)) / (1000 * 60)

        return "${hours}h ${minutes}m"
    }
}