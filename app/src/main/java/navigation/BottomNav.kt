package com.example.mobileaddictionanalystsystem.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNav(
    currentScreen: Screen,
    onScreenSelected: (Screen) -> Unit
) {

    NavigationBar {

        NavigationBarItem(
            selected = currentScreen == Screen.Dashboard,
            onClick = { onScreenSelected(Screen.Dashboard) },
            icon = { Text("🏠") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentScreen == Screen.Analytics,
            onClick = { onScreenSelected(Screen.Analytics) },
            icon = { Text("📊") },
            label = { Text("Analytics") }
        )
        NavigationBarItem(
            selected = currentScreen == Screen.History,
            onClick = { onScreenSelected(Screen.History) },
            icon = { Text("📅") },
            label = { Text("History") }
        )

        NavigationBarItem(
            selected = currentScreen == Screen.Profile,
            onClick = { onScreenSelected(Screen.Profile) },
            icon = { Text("👤") },
            label = { Text("Profile") }
        )

        NavigationBarItem(
            selected = currentScreen == Screen.Settings,
            onClick = { onScreenSelected(Screen.Settings) },
            icon = { Text("⚙️") },
            label = { Text("Settings") }
        )
    }
}