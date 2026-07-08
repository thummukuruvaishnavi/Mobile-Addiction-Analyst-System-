package com.example.mobileaddictionanalystsystem.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mobileaddictionanalystsystem.AnalyticsScreen
import com.example.mobileaddictionanalystsystem.DashboardScreen
import com.example.mobileaddictionanalystsystem.HistoryScreen
import com.example.mobileaddictionanalystsystem.ProfileScreen
import com.example.mobileaddictionanalystsystem.SettingsScreen
import com.example.mobileaddictionanalystsystem.theme.ThemeViewModel

@Composable
fun AppNavigation(
    themeViewModel: ThemeViewModel
) {

    var currentScreen by remember {
        mutableStateOf<Screen>(Screen.Dashboard)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNav(
                currentScreen = currentScreen,
                onScreenSelected = { screen ->
                    currentScreen = screen
                }
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when (currentScreen) {

                Screen.Dashboard -> DashboardScreen()

                Screen.Analytics -> AnalyticsScreen()

                Screen.History -> HistoryScreen()

                Screen.Profile -> ProfileScreen()

                Screen.Settings -> SettingsScreen(
                    themeViewModel = themeViewModel
                )
            }
        }
    }
}