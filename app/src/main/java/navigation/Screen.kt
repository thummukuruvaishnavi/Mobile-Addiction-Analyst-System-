package com.example.mobileaddictionanalystsystem.navigation

sealed class Screen(val title: String) {

    object Dashboard : Screen("Dashboard")

    object Analytics : Screen("Analytics")

    object History : Screen("History")

    object Profile : Screen("Profile")

    object Settings : Screen("Settings")
}