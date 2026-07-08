package com.example.mobileaddictionanalystsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobileaddictionanalystsystem.navigation.AppNavigation
import com.example.mobileaddictionanalystsystem.ui.theme.MobileAddictionAnalystSystemTheme
import com.example.mobileaddictionanalystsystem.theme.ThemeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val themeViewModel: ThemeViewModel = viewModel()

            MobileAddictionAnalystSystemTheme(
                darkTheme = themeViewModel.isDarkTheme
            ) {
                AppNavigation(
                    themeViewModel = themeViewModel
                )
            }
        }
    }
}