package com.example.mobileaddictionanalystsystem.ai

object RiskPredictor {

    fun calculateRisk(
        screenTimeHours: Float,
        socialHours: Float,
        gamingHours: Float
    ): String {

        val score =
            screenTimeHours * 0.5f +
                    socialHours * 0.3f +
                    gamingHours * 0.2f

        return when {
            score < 3 -> "🟢 Low"
            score < 6 -> "🟡 Moderate"
            else -> "🔴 High"
        }
    }
}