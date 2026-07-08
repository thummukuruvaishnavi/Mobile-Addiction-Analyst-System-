package com.example.mobileaddictionanalystsystem.analyzer

import com.example.mobileaddictionanalystsystem.tracker.AppUsage

object UsageAnalyzer {

    private val socialMediaApps = listOf(
        "instagram",
        "facebook",
        "whatsapp",
        "snapchat",
        "telegram",
        "messenger",
        "x",
        "twitter"
    )

    private val gamingApps = listOf(
        "freefire",
        "pubg",
        "bgmi",
        "candycrush",
        "subwaysurf",
        "clashroyale",
        "clashofclans"
    )

    private val videoApps = listOf(
        "youtube",
        "netflix",
        "primevideo",
        "hotstar"
    )

    fun getSocialMediaTime(apps: List<AppUsage>): Long {
        return apps
            .filter { app ->
                socialMediaApps.any {
                    app.appName.lowercase().contains(it)
                }
            }
            .sumOf { it.usageTime }
    }

    fun getGamingTime(apps: List<AppUsage>): Long {
        return apps
            .filter { app ->
                gamingApps.any {
                    app.appName.lowercase().contains(it)
                }
            }
            .sumOf { it.usageTime }
    }

    fun getVideoTime(apps: List<AppUsage>): Long {
        return apps
            .filter { app ->
                videoApps.any {
                    app.appName.lowercase().contains(it)
                }
            }
            .sumOf { it.usageTime }
    }

    fun formatTime(time: Long): String {

        val hours = time / (1000 * 60 * 60)
        val minutes = (time % (1000 * 60 * 60)) / (1000 * 60)

        return "${hours}h ${minutes}m"
    }
}